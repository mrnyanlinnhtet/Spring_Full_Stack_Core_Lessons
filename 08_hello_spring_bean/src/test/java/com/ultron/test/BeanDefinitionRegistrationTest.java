package com.ultron.test;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.support.GenericBeanDefinition;
import org.springframework.context.support.GenericApplicationContext;

import com.ultron.beans.XmlBaseBean;

class BeanDefinitionRegistrationTest {

	@Test
	void test() {

		try (var context = new GenericApplicationContext()) {

			//Control Overriding Bean Definition ..
//			context.setAllowBeanDefinitionOverriding(false);

			// create bean definition
			var definition = new GenericBeanDefinition();
			definition.setBeanClass(XmlBaseBean.class);

			var definition1 = new GenericBeanDefinition();
			definition1.setBeanClass(String.class);

			// Bean Definition Registration into context
			context.registerBeanDefinition("myBean", definition);
			context.registerBeanDefinition("myBean", definition1);

			// Refresh Context
			context.refresh();// Bean is ready to use

//			XmlBaseBean bean = context.getBean(XmlBaseBean.class);
			var bean = context.getBean(String.class);
			assertNotNull(bean);
//			assertEquals("Spring bean is created.... !", bean.getMessage());
//			System.out.println(bean.getMessage());

		}
	}

}
