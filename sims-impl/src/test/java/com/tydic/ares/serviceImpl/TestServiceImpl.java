package com.tydic.ares.serviceImpl;

import com.tydic.ares.mapper.TestMapper;
import com.tydic.ares.remote.TestProviderService;
import com.tydic.ares.remote.TestService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author: Ares
 * @date: 2020/3/24 10:06
 * @description: 测试业务层实现, 用来测试多数据源功能以及其它功能
 * @version: JDK 1.8
 */
@Service
public class TestServiceImpl implements TestService
{
    private static final Logger LOGGER = LoggerFactory.getLogger(TestServiceImpl.class);

    @Autowired
    private TestMapper testMapper;

    @Autowired
    private TestProviderService testProviderService;

    @Override
    public void testDynamicDataSource()
    {

    }

    /**
     * @author: Ares
     * @description: 测试插入
     * 从查询结论可知还需调用新的服务中的方法X,且需要修改隔离级别
     * 如果是NOT_SUPPORTED就会看到当前所操作的数据数据库查不到, 但X所在的slave库已经可以看到一部分, 哪怕最后失败了, slave的数据也以全部写入不能回滚
     * 如果是REQUIRES_NEW或者NESTED则都会回滚, 两个数据库都不会写入数据
     * 如果不想内部的事务影响外部的事务, 在调用的地方try-catch即可
     * 分布式事务是数据库层面提供的, 只需要在数据库操作前调用即可
     * @date: 2020/3/26 10:15
     * @param: [value] 请求参数
     * @return: int 响应参数
     */
    @Override
    @Transactional(propagation = Propagation.REQUIRED, transactionManager = "default")
    public void testInsertPaymentA()
    {
        for (int i = 0; i < 100; i++)
        {
            testMapper.testInsertPayment("payment_202004", i);
        }

        //        DynamicDataSourceUtil.changeDataSource("datasourceOne");
        //        for (int i = 0; i < 100; i++)
        //        {
        //            testMapper.testInsertPayment(i);
        //        }

        testProviderService.testInsertPaymentB();
        //        throw new RuntimeException();

        //                try
        //                {
        //                    testProvider.testInsertPayment();
        //                } catch (Exception e)
        //                {
        //                    e.printStackTrace();
        //                }
    }

    @Override
    public void testDynamicDataSourceTransactional()
    {

    }

    @Override
    public void testDynamicDataSourceTransactionalUseMethod()
    {

    }
}
