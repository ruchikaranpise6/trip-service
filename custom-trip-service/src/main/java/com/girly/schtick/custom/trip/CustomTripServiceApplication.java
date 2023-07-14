package com.girly.schtick.custom.trip;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class CustomTripServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(CustomTripServiceApplication.class, args);
	}

}
