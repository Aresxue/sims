package com.tydic.ares;

import com.tydic.ares.remote.TestService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @author: Ares
 * @date: 2020/3/23 14:28
 * @description: 动态数据源测试类
 * @version: JDK 1.8
 */
@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.NONE, classes = SimsImplApplication.class)
public class DynamicDataSourceTest
{
    @Autowired
    private TestService testService;

    //    @Test
    //    public void testDynamicDataSource()
    //    {
    //        testService.testDynamicDataSource();
    //    }

    //    @Test
    //    public void testDynamicDataSourceTransactional()
    //    {
    //        testService.testDynamicDataSourceTransactional();
    //    }

    //    @Test
    //    public void testDynamicDataSourceTransactionalUseMethod()
    //    {
    //        testService.testDynamicDataSourceTransactionalUseMethod();
    //    }


    /**
     * @author: Ares
     * @description: 测试数据源切换时事务是否自动提交
     * @date: 2020/3/26 12:01
     * @param: [] 请求参数
     * @return: void 响应参数
     */
    @Test
    public void testInsertPayment()
    {
        testService.testInsertPaymentA();
    }
}

