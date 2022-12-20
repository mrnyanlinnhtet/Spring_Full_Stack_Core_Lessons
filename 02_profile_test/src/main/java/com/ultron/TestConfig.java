package com.ultron;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.ultron.dto.Message;
import com.ultron.dto.TestResource;
import com.ultron.services.Resources;

@Configuration
@Profile("test")
public class TestConfig {

	@Bean
	public Message toEmployee() {
		return new Message("Send SMS To Employees !");
	}
	
	@Bean
	public Resources testResouce() {
		return new TestResource();
	}
	  
}
