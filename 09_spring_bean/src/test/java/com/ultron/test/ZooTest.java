package com.ultron.test;

import org.junit.jupiter.api.Test;
import org.springframework.context.support.GenericXmlApplicationContext;

import com.ultron.zoo.Zoo;
import com.ultron.zoo.ZooAbstract;
import com.ultron.zoo.ZooInterface;

class ZooTest {

	private final String RESOURCE = "classpath:/beans.xml";

	@Test
	void test() {

		try (var context = new GenericXmlApplicationContext()) {
			context.load(RESOURCE);
			context.refresh();

			var bean1 = context.getBean(ZooInterface.class);
			var bean2 = context.getBean(ZooAbstract.class);
			var bean3 = context.getBean(Zoo.class);
			
			System.out.println(bean1);
			System.out.println(bean2);
			System.out.println(bean3);
		}
	}

}
