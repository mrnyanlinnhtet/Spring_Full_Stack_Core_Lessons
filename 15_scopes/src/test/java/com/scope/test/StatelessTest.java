package com.scope.test;

import org.junit.jupiter.api.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.ultron.scope.StatelessBean;

class StatelessTest {

	@Test
	void test() {

		try (var context = new AnnotationConfigApplicationContext()) {

			context.scan("com.ultron");
			context.refresh();

			var stateless1 = context.getBean(StatelessBean.class);
			System.out.println("Singleton Object1 : " + stateless1);
			stateless1.showCount();

			System.out.println();

			var stateless2 = context.getBean(StatelessBean.class);
			System.out.println("Singleton Object2 : " + stateless2);
			stateless2.showCount();
			
		}

	}

}
