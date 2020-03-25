package com.tydic.ares.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: Ares
 * @date: 2019/5/31 15:11
 * @description:
 * @version: JDK 1.8
 */
@RestController
@RequestMapping("/eurekaCenter")
public class EurekaController
{
    private static final Logger logger = LoggerFactory.getLogger(EurekaController.class);

    @Autowired
    private DiscoveryClient discoveryClient;

    /**
     * 获取注册在Eureka中的服务名称
     *
     * @return
     */
    @GetMapping("/getEurekaServices")
    public List<String> getEurekaServices()
    {
        List<String> services = new ArrayList<>();
        List<String> serviceNames = discoveryClient.getServices();
        for (String serviceName : serviceNames)
        {
            List<ServiceInstance> serviceInstances = discoveryClient.getInstances(serviceName);
            for (ServiceInstance serviceInstance : serviceInstances)
            {
                services.add(String.format("%s:%s", serviceName, serviceInstance.getUri()));
            }
        }
        return services;
    }

}

