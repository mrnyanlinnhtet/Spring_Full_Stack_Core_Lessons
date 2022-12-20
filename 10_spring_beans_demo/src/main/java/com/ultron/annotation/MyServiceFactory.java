package com.ultron.annotation;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MyServiceFactory {
	
	@Bean
	 public MyService defaultService(int count) {
		 return new MyService(count);
	 }

}
