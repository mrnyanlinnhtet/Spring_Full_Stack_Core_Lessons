package com.ultron.test;

import org.junit.jupiter.api.Test;
import org.springframework.context.support.GenericXmlApplicationContext;

import com.ultron.post.CustomMessage;

class MyFactoryPostProcessorTest {

	private static final String CONFIG = "classpath:/bean-factory.xml";

	@Test
	void test() {
		try (var contex = new GenericXmlApplicationContext(CONFIG)) {

			var bean = contex.getBean(CustomMessage.class);
			System.out.println(bean.getValue());

		}
	}

}
