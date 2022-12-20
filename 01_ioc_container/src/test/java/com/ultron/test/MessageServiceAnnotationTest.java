package com.ultron.test;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.ultron.dto.MessageService;

class MessageServiceAnnotationTest {

	private MessageService service;
	private static AnnotationConfigApplicationContext contex;
	private static final String BASE_PACKAGE = "com.ultron";

	@BeforeAll
	static void setUpBeforeClass() {
		contex = new AnnotationConfigApplicationContext(BASE_PACKAGE);
	}

	@AfterAll
	static void tearDownAfterClass() throws Exception {
		contex.registerShutdownHook();
	}

	@Test
	void test() {
		service = contex.getBean(MessageService.class);
		service.setMessage("Hello Spring Framework !");
		Assertions.assertNotNull(service);
		Assertions.assertEquals("Hello Spring Framework !", service.getMessage());
	}

}
