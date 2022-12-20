package com.ultron.post;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.core.PriorityOrdered;

public class MyFactoryPostProcessor implements BeanFactoryPostProcessor,PriorityOrdered {

	@Override
	public void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory) throws BeansException {
		  System.out.println("My Factory Post Processor is Running.... !");
	}

	@Override
	public int getOrder() {
		return 20;
	}

}
