package com.ultron;

import org.springframework.beans.factory.config.CustomScopeConfigurer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.ultron.custom.CustomScope;

@Configuration
public class AppConfig {

	@Bean
	public CustomScopeConfigurer customScopeConfigurer(CustomScope scope) {
		var config = new CustomScopeConfigurer();
		config.addScope("custom", scope);
		return config;
	}

}
