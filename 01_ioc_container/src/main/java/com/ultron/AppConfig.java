package com.ultron;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.ultron.dto.MessageService;

@Configuration
public class AppConfig {

	@Bean
	public MessageService service() {
		return new MessageService();
	}

}
