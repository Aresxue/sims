package com.tydic.ares.remote;

/**
 * @author: Ares
 * @date: 2020/3/26 14:44
 * @description: 提供接口被TestService调用
 * @version: JDK 1.8
 */
public interface TestProviderService
{
    void selectPaymentId(String datasourceId);

    void testInsertPaymentB();
}
