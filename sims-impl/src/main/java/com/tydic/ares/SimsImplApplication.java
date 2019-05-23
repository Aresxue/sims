package com.tydic.ares;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.context.annotation.ImportResource;

@SpringBootApplication
@EnableEurekaClient
@EnableAspectJAutoProxy
//以下两个注解用以启用xml配置文件
//@Configuration
//@ImportResource(locations = {"classpath:application-aop.xml"})
public class SimsImplApplication {

	public static void main(String[] args) {
		SpringApplication.run(SimsImplApplication.class, args);
	}
}
