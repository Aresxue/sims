package com.tydic.ares;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class SimsImplApplication {

	public static void main(String[] args) {
		SpringApplication.run(SimsImplApplication.class, args);
	}
}
