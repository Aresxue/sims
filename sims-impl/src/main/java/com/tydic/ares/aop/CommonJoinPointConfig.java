package com.tydic.ares.aop;

import org.aspectj.lang.annotation.Pointcut;

/**
 * @Author Ares
 * @Date 2018/12/5 17:33
 * @Description: 切点管理公共类
 * 集中管理切点定义
 * @Version JDK 1.8
 */
public class CommonJoinPointConfig
{
    //将函数入参出参统一Json化打印到控制台
    @Pointcut("execution(* com.tydic.ares.serviceImpl.*.*(..))")
    public void printParamByJson()
    {
    }
}
