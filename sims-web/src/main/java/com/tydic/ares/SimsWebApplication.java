package com.tydic.ares;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.autoconfigure.orm.jpa.HibernateJpaAutoConfiguration;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.feign.EnableFeignClients;

//因为web项目依赖api，而api中有jpa的jar包，所以会自动注入数据源，这里要把它手动排除
@SpringBootApplication(exclude={DataSourceAutoConfiguration.class,HibernateJpaAutoConfiguration.class})
@EnableEurekaClient
@EnableFeignClients
public class SimsWebApplication
{

    public static void main(String[] args)
    {
        SpringApplication.run(SimsWebApplication.class, args);
    }
}
