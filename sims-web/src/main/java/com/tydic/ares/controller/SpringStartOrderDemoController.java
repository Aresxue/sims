package com.tydic.ares.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.beans.factory.support.BeanDefinitionRegistryPostProcessor;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import java.lang.reflect.Field;

/**
 * @author: Ares
 * @date: 2019/9/2 16:52
 * @description: Spring启动各种hook顺序测试
 * 启动时: postProcessBeanDefinitionRegistry(这一步是构造bean)>构造器>自动注入>postProcessBeforeInitialization>PostConstruct>InitializingBean>init
 * 关闭时: PreDestroy>DisposableBean>destroy
 * @version: JDK 1.8
 */
public class SpringStartOrderDemoController implements InitializingBean, DisposableBean, BeanPostProcessor
{
    private static final Logger LOGGER = LoggerFactory.getLogger(SpringStartOrderDemoController.class);

    @Autowired
    private RestTemplate restTemplate;

    public SpringStartOrderDemoController()
    {
        LOGGER.info("构造器启动, 此时属性为{}", restTemplate);
    }

    @Override
    public void destroy() throws Exception
    {
        LOGGER.info("指定destroy方法, 此时属性为{}", restTemplate);
    }

    @Override
    public void afterPropertiesSet() throws Exception
    {
        LOGGER.info("执行afterPropertiesSet, 此时属性为{}", restTemplate);
    }

    @PostConstruct
    public void postConstruct()
    {
        LOGGER.info("执行postConstruct, 此时属性为{}", restTemplate);
    }

    @PreDestroy
    public void preDestroy()
    {
        LOGGER.info("执行preDestroy, 此时属性为{}", restTemplate);
    }

    public void init()
    {
        LOGGER.info("执行init方法, 此时属性为{}", restTemplate);
    }

    public void cleanUp()
    {
        LOGGER.info("执行cleanUp方法, 此时属性为{}", restTemplate);
    }
}

@Component
class MyBeanPostProcessor implements BeanPostProcessor, BeanDefinitionRegistryPostProcessor
{
    private static final Logger LOGGER = LoggerFactory.getLogger(MyBeanPostProcessor.class);

    @Bean(initMethod = "init",destroyMethod = "cleanUp")
    SpringStartOrderDemoController springStartOrderDemoController(){
        return new SpringStartOrderDemoController();
    }

    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException
    {
        if (bean instanceof SpringStartOrderDemoController)
        {
            LOGGER.info("BeanPostProcessor:postProcessBeforeInitialization执行");
            Field field = null;
            try
            {
                field = bean.getClass().getDeclaredField("restTemplate");
                field.setAccessible(true);
            } catch (NoSuchFieldException e)
            {
                e.printStackTrace();
            }
            try
            {
                Object o = field.get(bean);
                LOGGER.info("此时属性为：{}", o);
            } catch (IllegalAccessException e)
            {
                e.printStackTrace();
            }
        }
        return bean;
    }

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException
    {
        if (bean instanceof SpringStartOrderDemoController)
        {
            LOGGER.info("BeanPostProcessor:postProcessAfterInitialization执行");
            Field field = null;
            try
            {
                field = bean.getClass().getDeclaredField("restTemplate");
                field.setAccessible(true);
            } catch (NoSuchFieldException e)
            {
                e.printStackTrace();
            }
            try
            {
                Object o = field.get(bean);
                LOGGER.info("此时属性为：{}", o);
            } catch (IllegalAccessException e)
            {
                e.printStackTrace();
            }
        }
        return bean;
    }

    @Override
    public void postProcessBeanDefinitionRegistry(BeanDefinitionRegistry beanDefinitionRegistry) throws BeansException
    {

    }

    @Override
    public void postProcessBeanFactory(ConfigurableListableBeanFactory configurableListableBeanFactory) throws BeansException
    {

    }

  /*  @Override
    public void postProcessBeanDefinitionRegistry(BeanDefinitionRegistry beanDefinitionRegistry) throws BeansException
    {
        LOGGER.info("postProcessBeanDefinitionRegistry执行");
        BeanDefinitionBuilder builder = BeanDefinitionBuilder.genericBeanDefinition(SpringStartOrderDemoController.class);
        GenericBeanDefinition definition = (GenericBeanDefinition) builder.getRawBeanDefinition();

        beanDefinitionRegistry.registerBeanDefinition("springStartOrderDemoController",definition);
    }

    @Override
    public void postProcessBeanFactory(ConfigurableListableBeanFactory configurableListableBeanFactory) throws BeansException
    {
        LOGGER.info("postProcessBeanFactory执行");
    }*/
}