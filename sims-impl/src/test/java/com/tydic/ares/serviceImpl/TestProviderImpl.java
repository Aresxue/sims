package com.tydic.ares.serviceImpl;

import com.tydic.ares.mapper.TestMapper;
import com.tydic.ares.remote.TestProvider;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author: Ares
 * @date: 2020/3/26 14:44
 * @description: 提供接口被TestService调用
 * @version: JDK 1.8
 */
@Service
public class TestProviderImpl implements TestProvider
{
    private static final Logger LOGGER = LoggerFactory.getLogger(TestProviderImpl.class);

    @Autowired
    private TestMapper testMapper;

    @Override
    public void selectPaymentId(String datasourceId)
    {

    }

    @Override
    @Transactional(propagation = Propagation.SUPPORTS)
    public void testInsertPaymentB()
    {
        for (int i = 0; i < 100; i++)
        {
            testMapper.testInsertPayment("payment_202005", i);
        }
        //                throw new RuntimeException();
    }
}
