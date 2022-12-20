package com.ultron;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

import com.ultron.demo.Counter;
import com.ultron.demo.CounterClient;

@Configuration
public class AppConfig {

	@Bean
	@Scope("prototype")
	public Counter counter() {
		return new Counter();
	}

	@Bean
	@Scope("prototype")
	public CounterClient client(Counter counter) {
		return new CounterClient(counter, "Singleton Counter");
	}
}
