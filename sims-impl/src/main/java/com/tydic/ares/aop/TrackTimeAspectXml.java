package com.tydic.ares.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @Author Ares
 * @Date 2018/12/7 20:01
 * @Description: 实现打印执行时间注解的行为(xml配置方式)
 * @Version JDK 1.8
 */
public class TrackTimeAspectXml
{
    private static final Logger LOGGER = LoggerFactory.getLogger(TrackTimeAspectXml.class);

    public void printParamByJson(ProceedingJoinPoint thisJoinPoint) throws Throwable
    {
        LOGGER.info("我是一个xml配置的aop切面");
        thisJoinPoint.proceed();
    }
}
