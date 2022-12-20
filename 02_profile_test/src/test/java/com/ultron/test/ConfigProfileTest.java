package com.ultron.test;

import org.junit.jupiter.api.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.ultron.ReleaseConfig;
import com.ultron.TestConfig;
import com.ultron.dto.Message;
import com.ultron.services.Resources;

class ConfigProfileTest {

	@Test
	void test() {

		System.setProperty("spring.profiles.active", "release");
		try (AnnotationConfigApplicationContext contex = new AnnotationConfigApplicationContext(TestConfig.class,
				ReleaseConfig.class)) {

			Message mes = contex.getBean(Message.class);
			System.out.println(mes.getSms());

			Resources res = contex.getBean(Resources.class);
			System.out.println(res.data());

		}
	}

}
