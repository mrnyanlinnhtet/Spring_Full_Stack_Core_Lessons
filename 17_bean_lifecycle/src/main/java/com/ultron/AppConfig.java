package com.ultron;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.ultron.lifecycle.MyClient;
import com.ultron.lifecycle.MyService;

@Configuration
public class AppConfig {

	@Bean
	MyService myService() {
		return new MyService();
	}
	
	
	@Bean
	MyClient myClient() {
		return new MyClient();
	}

}
