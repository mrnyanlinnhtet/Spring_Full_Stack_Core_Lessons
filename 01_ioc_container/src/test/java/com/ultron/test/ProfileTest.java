package com.ultron.test;

import java.util.Arrays;

import org.junit.jupiter.api.Test;
import org.springframework.context.support.GenericXmlApplicationContext;
import org.springframework.core.env.ConfigurableEnvironment;

import com.ultron.dto.MessageProfile;

class ProfileTest {

	GenericXmlApplicationContext contex;

	@Test
	void test() {
		System.setProperty("spring.profiles.active", "publish");
		contex = new GenericXmlApplicationContext();
		ConfigurableEnvironment env = contex.getEnvironment();
//		env.setActiveProfiles("publish");
		contex.load("classpath:/app-config.xml");
		contex.refresh();
		contex.registerShutdownHook();

		System.out.println(Arrays.toString(env.getActiveProfiles()));
		System.out.println(Arrays.toString(env.getDefaultProfiles()));

		MessageProfile mes = contex.getBean(MessageProfile.class);
		System.out.println("Active Profile : " + mes.getValue());

	}

}
