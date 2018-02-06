package com.tydic.simscloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class SimsDiscoveryServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(SimsDiscoveryServerApplication.class, args);
	}
}
