package com.tydic.ares.aop;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;

import java.util.StringJoiner;

/**
 * @Author Ares
 * @Date 2018/12/5 17:39
 * @Description: 将入参出参Json化打印
 * @Version JDK 1.8
 */

@Aspect
@Configuration
public class PrintParamByJson
{
    private static final Logger LOGGER = LoggerFactory.getLogger(PrintParamByJson.class);

    /**
     * @Author: Ares
     * @Description: 环绕通知, 环绕增强, 相当于MethodInterceptor
     * @Date: 2019/6/6 13:54
     * @Param: [thisJoinPoint] 请求参数
     * @return: java.lang.Object 响应参数
     **/
    @Around("com.tydic.ares.aop.CommonJoinPointConfig.printParamByJson()")
    public Object around(ProceedingJoinPoint thisJoinPoint) throws Throwable
    {
        Object result = null;

        ObjectMapper mapper = new ObjectMapper();
        StringJoiner stringJoiner = null;
        Signature signature = thisJoinPoint.getSignature();
        Object[] args = thisJoinPoint.getArgs();
        for (Object o : args)
        {
            if (null != o)
            {
                stringJoiner = new StringJoiner(",");
                stringJoiner.add(o.getClass().getSimpleName() + ":" + mapper.writeValueAsString(o));
            }
        }

        LOGGER.info("方法{}入参为: {}", signature.getName(), stringJoiner);
        result = thisJoinPoint.proceed();
        LOGGER.info("方法{}出参为: {}", signature.getName(), mapper.writeValueAsString(result));

        return result;
    }

}
