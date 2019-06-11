package com.tydic.ares.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @Author Ares
 * @Date 2018/12/7 20:01
 * @Description:
 * @Version JDK 1.8
 */
public class TrackTimeAspectXml
{
    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    public void printParamByJson(ProceedingJoinPoint thisJoinPoint) throws Throwable
    {
        logger.info("我是一个xml配置的aop切面");
        thisJoinPoint.proceed();
    }
}
