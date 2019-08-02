package com.tydic.ares.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

/**
 * @Author: Ares
 * @Date: 2019/8/1 17:40
 * @Description: 测试Nacos的配置
 * @Version: JDK 1.8
 */
@RestController
@RequestMapping(value = "/nacos")
@RefreshScope
public class NacosConfigController
{
    private static final Logger logger = LoggerFactory.getLogger(NacosConfigController.class);

    @Value("${nacos:null}")
    private String value;

    @Value("${nacos2:love}")
    private String value2;

    @Value("${nacos3:me}")
    private String value3;

    @RequestMapping(value = "/config")
    public String testNacos(HttpServletRequest request)
    {
        return value + "," + value2 + "," + value3;
    }
}
