package com.ultron.post;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.beans.factory.support.GenericBeanDefinition;
import org.springframework.core.PriorityOrdered;

public class MyFactryPostProcessor1 implements BeanFactoryPostProcessor, PriorityOrdered {

	@Override
	public void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory) throws BeansException {
		System.out.println("Second Bean Factory Post Processor is Running..... !");

		//Add Bean Definition at Runtime
		var customMessage = new GenericBeanDefinition();
		customMessage.setBeanClass(CustomMessage.class);
		customMessage.getPropertyValues().add("value", "Hello I am Custom Runtime Bean !");

		if (beanFactory instanceof DefaultListableBeanFactory bf) {

			bf.registerBeanDefinition("customMessage", customMessage);
		}

	}

	@Override
	public int getOrder() {
		return 10;
	}

}
