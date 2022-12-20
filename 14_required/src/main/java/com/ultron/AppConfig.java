package com.ultron;

import org.springframework.context.annotation.Bean;

import com.ultron.demo.MyBean;
import com.ultron.demo.MyClient;

public class AppConfig {

	@Bean
	public MyClient client() {
		return new MyClient();
	}

	@Bean
	public MyBean bean1() {
		return new MyBean("This is Bean 1");
	}

	@Bean
	public MyBean bean2() {
		return new MyBean("This is Bean 2");
	}

	@Bean
	public MyBean bean3() {
		return new MyBean("This is Bean 3");
	}

}
