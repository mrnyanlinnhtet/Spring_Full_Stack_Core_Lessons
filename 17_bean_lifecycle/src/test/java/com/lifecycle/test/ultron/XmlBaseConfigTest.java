package com.lifecycle.test.ultron;

import org.junit.jupiter.api.Test;
import org.springframework.context.support.GenericXmlApplicationContext;

class XmlBaseConfigTest {

	@Test
	void test() {

		try (var context = new GenericXmlApplicationContext()) {
			 context.load("classpath:/beans.xml");
			 context.refresh();

			
		}
	}

}
