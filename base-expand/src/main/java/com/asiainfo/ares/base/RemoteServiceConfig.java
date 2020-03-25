package com.asiainfo.ares.base;

import com.asiainfo.ares.utils.DynamicProxyUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Configuration;
import org.springframework.util.ClassUtils;

import javax.annotation.PostConstruct;
import java.beans.Introspector;
import java.lang.reflect.Field;
import java.util.Map;
import java.util.Set;

/**
 * @author: Ares
 * @date: 2019/6/1 14:18
 * @description: 云服务调用扩展配置类
 * @version: JDK 1.8
 */
@Configuration
public class RemoteServiceConfig
{
    private static final Logger logger = LoggerFactory.getLogger(RemoteServiceConfig.class);

    @Autowired
    private ApplicationContext applicationContext;

    /**
     * @author: Ares
     * @description: 初始化方法
     * @date: 2019/6/1 14:19
     * @param: [] 请求参数
     * @return: void 响应参数
     **/
    @PostConstruct
    public void init()
    {
        Set<Map.Entry<String, Object>> beanSet = applicationContext.getBeansOfType(Object.class).entrySet();
        for (Map.Entry<String, Object> beanEntry : beanSet)
        {
            Object bean = beanEntry.getValue();
            if (null == bean)
            {
                continue;
            }

            // 获取真实对象
            try
            {
                bean = DynamicProxyUtil.getTarget(bean);
            } catch (Exception e)
            {
                logger.error("获取真实对象时失败: ", e);
            }
            Class<?> beanClass = bean.getClass();

            Field[] fields = beanClass.getDeclaredFields();
            for (Field field : fields)
            {
                RemoteRef remoteRef = field.getType().getAnnotation(RemoteRef.class);
                if (null == remoteRef)
                {
                    continue;
                }
                field.setAccessible(true);
                String beanName = Introspector.decapitalize(ClassUtils.getShortName(field.getType().getName()));

                Object object = null;
                try
                {
                    try
                    {
                        object = applicationContext.getBean(beanName);
                    } catch (Exception e)
                    {
                        object = applicationContext.getBean(field.getType());
                    }
                    bean = DynamicProxyUtil.getTarget(bean);
                    field.set(bean, object);
                } catch (Throwable e)
                {
                    throw new RuntimeException("init bean{beanName:" + beanName + ", beanClass:" + bean.getClass().getName() + "} cloud ref error: ", e);
                }
            }
        }
    }
}
