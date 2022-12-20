package com.lifecycle.test.ultron;

import org.junit.jupiter.api.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.ultron.AppConfig;

class JavaBaseConfigTest {

	@Test
	void test() {

		try (var context = new AnnotationConfigApplicationContext(AppConfig.class)) {

		}
	}

}
