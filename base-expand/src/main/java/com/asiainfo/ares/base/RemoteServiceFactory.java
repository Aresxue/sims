package com.asiainfo.ares.base;

import org.springframework.beans.factory.FactoryBean;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @author: Ares
 * @date: 2019/6/1 17:38
 * @description: 代理bean的生产工厂
 * @version: JDK 1.8
 */
public class RemoteServiceFactory implements FactoryBean
{
    /**
     * 远程服务
     */
    private Class<?> remoteService;
    /**
     * 调用的内部服务节点名
     */
    private String serviceCenter;

    @Autowired
    RemoteInvokeHandler remoteInvokeHandler;

    public Class<?> getRemoteService()
    {
        return remoteService;
    }

    public void setRemoteService(Class<?> remoteService)
    {
        this.remoteService = remoteService;
    }

    public String getServiceCenter()
    {
        return serviceCenter;
    }

    public void setServiceCenter(String serviceCenter)
    {
        this.serviceCenter = serviceCenter;
    }

    @Override
    public Object getObject() throws Exception
    {
        if (null == remoteInvokeHandler)
        {
            remoteInvokeHandler = new RemoteInvokeHandler();
        }
        return remoteInvokeHandler.remoteInvoke(remoteService, serviceCenter);
    }

    @Override
    public Class<?> getObjectType()
    {
        return remoteService;
    }

    @Override
    public boolean isSingleton()
    {
        return true;
    }

}
