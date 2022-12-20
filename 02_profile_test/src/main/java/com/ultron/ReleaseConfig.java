package com.ultron;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.ultron.dto.Message;
import com.ultron.dto.ReleaseResource;
import com.ultron.services.Resources;

@Configuration
@Profile("release")
public class ReleaseConfig {

	@Bean
	public Message toBoss() {
		return new Message("Send SMS To Boss !");
	}

	@Bean
	public Resources releaseResource() {
		return new ReleaseResource();
	}
}
