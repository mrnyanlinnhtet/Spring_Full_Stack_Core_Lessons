package com.scope.test;

import org.junit.jupiter.api.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.ultron.scope.StatefulBean;

class StatefulTest {

	@Test
	void test() {
		
		try (var context = new AnnotationConfigApplicationContext()) {

			context.scan("com.ultron");
			context.refresh();


			var stateful1 = context.getBean(StatefulBean.class);
			System.out.println("Prototype Object1 : " + stateful1);
			stateful1.showCount();

			System.out.println();

			var stateful2 = context.getBean(StatefulBean.class);
			System.out.println("Prototype Object2 : " + stateful2);
			stateful2.showCount();

			
		}

	}

	}


