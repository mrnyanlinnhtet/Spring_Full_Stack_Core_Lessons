package com.ultron.test;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.ultron.BeanConfiguration;
import com.ultron.beans.JavaConfigBaseBean;

class JavaConfigBeanTest {

	@Test
	void test() {

		try (var contex = new AnnotationConfigApplicationContext(BeanConfiguration.class)) {

			var bean = contex.getBean(JavaConfigBaseBean.class);
			System.out.println(bean.getMessage());
			assertNotNull(bean);
			assertEquals("Java Config Spring Bean is invoked", bean.getMessage());
		}
	}

}
