package com.ultron;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.ultron.beans.JavaConfigBaseBean;

@Configuration
public class BeanConfiguration {
	
	@Bean
	 JavaConfigBaseBean javaConfigBaseBean() {
		 return new JavaConfigBaseBean();
	 }

	}
