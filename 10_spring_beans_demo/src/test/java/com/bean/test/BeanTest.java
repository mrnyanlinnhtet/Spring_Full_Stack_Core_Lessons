package com.bean.test;

import org.junit.jupiter.api.Test;
import org.springframework.context.support.GenericXmlApplicationContext;
import org.springframework.core.io.ClassPathResource;

class BeanTest {

	@Test
	void test() {

		try (var context = new GenericXmlApplicationContext()) {

			var RESOURCE = new ClassPathResource("beans.xml");
			context.load(RESOURCE);
			context.refresh();
			
			System.out.println("Spring Bean Definition Count : "+ context.getBeanDefinitionCount());

		}
	}

}
