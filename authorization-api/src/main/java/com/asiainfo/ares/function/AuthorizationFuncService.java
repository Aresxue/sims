package com.asiainfo.ares.function;

import com.asiainfo.ares.base.RemoteRef;
import org.springframework.stereotype.Component;

/**
 * @Author: Ares
 * @Date: 2019/6/1 9:20
 * @Description: 测试功能服务接口
 * @Version: JDK 1.8
 */
@RemoteRef
public interface AuthorizationFuncService
{
    /**
     * @Author: Ares
     * @Description: 测试方法
     * @Date: 2019/6/1 9:21
     * @Param: [] 请求参数
     * @return: void 响应参数
     **/
    void authorization();
}
