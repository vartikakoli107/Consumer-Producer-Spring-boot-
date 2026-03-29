package com.example.OrderSystem.config;

import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

import java.util.concurrent.Executor;


@Configuration
public class AsynConfig {
	
	@Bean(name = "taskExecutor")
	public Executor taskExecutor() {
		ThreadPoolTaskExecutor Executor = new ThreadPoolTaskExecutor();
		Executor.setCorePoolSize(3);
		Executor.setMaxPoolSize(5);
		Executor.setQueueCapacity(10);
		Executor.setThreadNamePrefix("Order-Thread-");
		return Executor;
	}
	
}
