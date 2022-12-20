package com.ultron.test;

import org.junit.jupiter.api.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.ultron.services.Resources;

class AnnotationProfileTest {

	@Test
	void test() {
		System.setProperty("spring.profiles.active", "test");
		try (AnnotationConfigApplicationContext contex = new AnnotationConfigApplicationContext("com.ultron")) {

			Resources rec = contex.getBean(Resources.class);
			System.out.println(rec.data());
		}
	}

}
