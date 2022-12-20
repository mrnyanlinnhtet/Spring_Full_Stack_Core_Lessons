package com.ultron.config;

import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.stereotype.Component;

@Component

public class MessageSourceConfig {

	@Bean
	public MessageSource messageSource() {
		var ms = new ResourceBundleMessageSource();
		ms.setBasename("greeting");
		return ms;
	}
}
