package com.example.OrderSystem;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableAsync;

@SpringBootApplication
@EnableAsync
public class OrderSystemApplication {

	public static void main(String[] args) {
		
		SpringApplication.run(OrderSystemApplication.class, args);
	}

}
