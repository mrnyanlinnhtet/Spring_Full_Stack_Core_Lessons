package com.required.test;

import org.junit.jupiter.api.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.ultron.AppConfig;
import com.ultron.demo.MyClient;

class RequiredTest {

	@Test
	void test() {

		try (var context = new AnnotationConfigApplicationContext()) {

			context.register(AppConfig.class);
			context.refresh();

			var bean = context.getBean(MyClient.class);
			bean.work();
		}
	}

}
