package com.springboot.item;

import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;




@EnableEurekaClient
@EnableFeignClients
@SpringBootApplication
public class ModelsApplication {

	public static void main(String[] args) {
		SpringApplication.run(ModelsApplication.class, args);
	}



}
