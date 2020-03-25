package com.asiainfo.ares.base;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

/**
 * @author: Ares
 * @date: 2019/5/31 16:40
 * @description: 公共请求入口
 * @version: JDK 1.8
 */
@RestController
@RequestMapping(value = "/common")
public class CommonController
{
    private static final Logger logger = LoggerFactory.getLogger(CommonController.class);

    private static final Map<String, RemoteProxyService> INNER_SERVICE_MAP = new HashMap<>();

    /**
     * @author: Ares
     * @description: 统一调用地址
     * @date: 2019/6/10 20:21
     * @param: [request] 请求参数
     * @return: java.lang.Object 响应参数
     **/
    @RequestMapping(value = "/invoke")
    public Object invoke(HttpServletRequest request)
    {
        logger.info(request.getParameter("serviceId"));
        return null;
    }

    /**
     * @author: Ares
     * @description: 内部实例互相调用
     * @date: 2019/6/10 20:22
     * @param: [request] 请求参数
     * @return: java.lang.Object 响应参数
     **/
    @RequestMapping(value = "/innerInvoke")
    public Object innerInvoke(HttpServletRequest request)
    {
        logger.info(request.getParameter("serviceId"));
        return null;
    }
}
