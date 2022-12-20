package com.ultron.test;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.ultron.custom.MyCustomObject;

class CustomeScopeTest {

	@Test
	void test() {

		try (var context = new AnnotationConfigApplicationContext()) {

			context.scan("com.ultron");
			context.refresh();

			Assertions.assertNotNull(context.getBean(MyCustomObject.class));
			Assertions.assertNotNull(context.getBean(MyCustomObject.class));
		}
	}

}
