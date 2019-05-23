package com.tydic.ares.aop;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import jdk.nashorn.internal.scripts.JO;
import org.apache.commons.lang.exception.ExceptionUtils;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;

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
    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    //环绕通知,环绕增强，相当于MethodInterceptor
    @Around("CommonJoinPointConfig.printParamByJson()")
    public Object arround(ProceedingJoinPoint thisJoinPoint)
    {
        Object result = null;

        ObjectMapper mapper = new ObjectMapper();
        StringJoiner stringJoiner = new StringJoiner(",");
        Signature signature = thisJoinPoint.getSignature();
        Object[] args = thisJoinPoint.getArgs();
        try
        {
            for (Object o : args)
            {
                stringJoiner.add(o.getClass().getSimpleName() + ":" + mapper.writeValueAsString(o));
            }
        } catch (JsonProcessingException e)
        {
            logger.error(ExceptionUtils.getStackTrace(e));
        }

        logger.info("方法{}入参为: {}", signature.getName(), stringJoiner);
        try
        {
            result = thisJoinPoint.proceed();
            logger.info("方法{}出参为: {}", signature.getName(), mapper.writeValueAsString(result));
        } catch (Throwable e)
        {
            logger.error(ExceptionUtils.getStackTrace(e));
        }
        return result;
    }
}
