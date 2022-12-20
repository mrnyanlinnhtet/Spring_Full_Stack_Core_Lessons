package com.ultron.test;

import org.junit.jupiter.api.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.ultron.AppConfig;
import com.ultron.service.ClientService;

class AutowiredOptionTest {

	@Test
	void test() {

		try (var context = new AnnotationConfigApplicationContext(AppConfig.class)) {

			var bean = context.getBean(ClientService.class);
			System.out.println(bean.getService().getClass());

		}
	}

}
