package com.ultron.test;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.ultron.dto.MessageService;

class MessageServiceTest {

	private MessageService service;
	private static ClassPathXmlApplicationContext contex;

	@BeforeAll
	static void start() {
		contex = new ClassPathXmlApplicationContext("classpath:/app-config.xml");
	}

	@AfterAll
	static void end() {
		contex.registerShutdownHook();
	}

	@Test
	void test() {

		service = contex.getBean("service", MessageService.class);
		Assertions.assertNotNull(service);
		Assertions.assertEquals(service.getMessage(), "Hello IOC Container");
 	}

}
