package com.bean.test;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.config.ConstructorArgumentValues;
import org.springframework.beans.factory.support.GenericBeanDefinition;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.ultron.annotation.MyService;

class AnnotationBeanTest {

	@Test
	void test() {

		try (var context = new AnnotationConfigApplicationContext()) {

			context.scan("com.ultron.annotation");
			context.registerBeanDefinition("myNumber", getMyNumberDefinition());
			context.refresh();

			var bean = context.getBean("defaultService",MyService.class);
			Assertions.assertNotNull(bean);

		}
	}

	private BeanDefinition getMyNumberDefinition() {
		var myNumber = new GenericBeanDefinition();
		myNumber.setBeanClass(Integer.class);
		myNumber.setFactoryMethodName("parseInt");
		var arg = new ConstructorArgumentValues();
		 arg.addGenericArgumentValue("100");
		 myNumber.setConstructorArgumentValues(arg);
		return myNumber;
	}

}
