package com.cognizant;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class CmsClaimsServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(CmsClaimsServiceApplication.class, args);
	}

}
