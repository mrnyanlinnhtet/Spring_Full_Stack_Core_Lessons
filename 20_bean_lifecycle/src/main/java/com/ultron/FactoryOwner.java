package com.ultron;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.BeanFactoryAware;
import org.springframework.stereotype.Component;

@Component
public class FactoryOwner implements BeanFactoryAware {

	@Override
	public void setBeanFactory(BeanFactory beanFactory) throws BeansException {
		System.out.println("Bean Factory is Set !");

		if (beanFactory == null) {
			System.out.println("Bean Factroy is Null !");
		} else {
			System.out.println("Bean Factory is Not Null !");
		}

	}

}
