package com.ultron.test;

import org.junit.jupiter.api.Test;
import org.springframework.context.support.GenericXmlApplicationContext;

class BeanTest {

	private final String RESOURCE = "classpath:/bean.xml";

	@Test
	void test() {

		try (var contex = new GenericXmlApplicationContext(RESOURCE)) {

//			var bean = contex.getBean(XmlBaseBean.class);
//			System.out.println(bean.getMessage());
//			assertNotNull(bean);
//			assertEquals("Spring bean is created.... !", bean.getMessage());

			for (var name : contex.getBeanDefinitionNames()) {

				if (name.startsWith("org.springframework.")) {
					continue;
				}

				var definition = contex.getBeanDefinition(name);

				System.out.printf("""
					=>	Bean Name: %s
					=>	Bean Class: %s
					=>	Definition: %s
					--------------------------------------
						""", name, definition.getBeanClassName(), definition.getClass().getSimpleName());
			}
		}
	}

}
