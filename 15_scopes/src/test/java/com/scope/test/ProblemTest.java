package com.scope.test;

import org.junit.jupiter.api.Test;
import org.springframework.context.support.GenericXmlApplicationContext;

import com.ultron.problem.CommandManager;

public class ProblemTest {

	@Test
	void test() {

		try (var context = new GenericXmlApplicationContext()) {

			context.load("classpath:/beans.xml");
			context.refresh();

			for (int i = 0; i < 3; i++) {
				var bean = context.getBean(CommandManager.class);
				bean.execute();

			}
		}

	}
}
