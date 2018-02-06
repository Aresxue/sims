package com.tydic.simscloud;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class SimsWebApplication
{

    public static void main(String[] args)
    {
        SpringApplication.run(SimsWebApplication.class, args);
    }
}
