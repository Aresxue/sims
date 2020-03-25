package com.asiainfo.authorizationimpl.function.impl;

import com.asiainfo.ares.business.AuthorizationBusiService;
import com.asiainfo.ares.function.AuthorizationFuncService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author: Ares
 * @date: 2019/6/1 13:53
 * @description:
 * @version: JDK 1.8
 */
@Service
public class AuthorizationFuncServiceImpl implements AuthorizationFuncService
{
    private static final Logger logger = LoggerFactory.getLogger(AuthorizationFuncServiceImpl.class);

    @Autowired
    AuthorizationBusiService authorizationBusiService;

    @Override
    public void authorization()
    {
        logger.info("开始执行功能方法");
        authorizationBusiService.authorization();
        logger.info("执行功能方法完毕");
    }
}
