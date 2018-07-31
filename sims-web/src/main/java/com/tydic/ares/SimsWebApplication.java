package com.tydic.ares;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.feign.EnableFeignClients;

@SpringBootApplication
//选用的注册中心是eureka，那么就推荐@EnableEurekaClient，
// 如果是其他的注册中心，那么推荐使用@EnableDiscoveryClient，两者功能差不多
@EnableEurekaClient
@EnableFeignClients
public class SimsWebApplication
{

    public static void main(String[] args)
    {
        SpringApplication.run(SimsWebApplication.class, args);
    }
}
