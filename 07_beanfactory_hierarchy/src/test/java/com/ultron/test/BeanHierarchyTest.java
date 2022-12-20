package com.ultron.test;

import java.util.Arrays;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.BeansException;
import org.springframework.context.support.GenericXmlApplicationContext;

import com.ultron.services.BeanService;

class BeanHierarchyTest {

	@Test
	void test() {

		try (var parent = new GenericXmlApplicationContext()) {
			parent.load("classpath:/Parent.xml");
			parent.refresh();
			// Parent Resource is End !

			try (var child = new GenericXmlApplicationContext()) {
				child.setParent(parent);
				child.load("classpath:/Child.xml");
				child.refresh();

				var service = child.getBean("child", BeanService.class);
				System.out.println(service.handle());

				Assertions.assertTrue(child.containsLocalBean("child"));
				Assertions.assertFalse(child.containsLocalBean("parent"));
				Assertions.assertTrue(child.containsBean("parent"));

				// List-able Bean Factory (To Get bean info)
				System.out.println("Bean Difination Count : " + child.getBeanDefinitionCount());
				System.out.println("Bean Difination Name : " + Arrays.toString(child.getBeanDefinitionNames()));

			}

		} catch (BeansException | IllegalStateException e) {
			e.printStackTrace();
		}
	}

}
