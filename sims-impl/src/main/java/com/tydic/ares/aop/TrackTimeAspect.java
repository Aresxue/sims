package com.tydic.ares.aop;

import com.tydic.ares.annotation.TrackTime;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

/**
 * @Author Ares
 * @Date 2018/12/7 15:04
 * @Description: 实现打印执行时间注解的行为
 * @Version JDK 1.8
 */
@Aspect
@Component
public class TrackTimeAspect
{
    private static final Logger LOGGER = LoggerFactory.getLogger(TrackTimeAspect.class);

    /**
     * @Author: Ares
     * @Description: 这里的trackTime是注解的引用的名称，是下面的方法的引用
     * @Date: 2019/8/13 15:16
     * @Param: 请求参数
     * @Return: 响应参数
     */
    @Around("@annotation(trackTime)")
    public Object around(ProceedingJoinPoint thisJoinPoint, TrackTime trackTime) throws Throwable
    {
        long startTime = System.currentTimeMillis();
        Object result = thisJoinPoint.proceed();
        long timeTaken = System.currentTimeMillis() - startTime;
        LOGGER.info("方法{}执行时间为{}ms", thisJoinPoint.getSignature().getName(), timeTaken);
        //        LOGGER.info("注解中的值: {}", trackTime.param());
        return result;
    }
}
