package com.tydic.ares;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;

@EnableZuulProxy
@SpringBootApplication
public class SimsZuulApplication
{

	public static void main(String[] args) {
		SpringApplication.run(SimsZuulApplication.class, args);
	}
}
