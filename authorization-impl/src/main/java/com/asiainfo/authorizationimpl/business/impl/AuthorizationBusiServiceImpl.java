package com.asiainfo.authorizationimpl.business.impl;

import com.asiainfo.ares.business.AuthorizationBusiService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

/**
 * @Author: Ares
 * @Date: 2019/6/1 13:52
 * @Description:
 * @Version: JDK 1.8
 */
@Service
public class AuthorizationBusiServiceImpl implements AuthorizationBusiService
{
    private static final Logger logger = LoggerFactory.getLogger(AuthorizationBusiServiceImpl.class);

    @Override
    public void authorization()
    {
        logger.info("执行业务方法");
    }
}
