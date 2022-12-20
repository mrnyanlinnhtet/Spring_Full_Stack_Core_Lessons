package com.ultron.test;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.ultron.AppConfig;
import com.ultron.dto.MessageService;

class MessageServiceJavaConfigTest {

	private static ConfigurableApplicationContext contex;
	private MessageService mService;

	@BeforeAll
	static void setUpBeforeClass() throws Exception {
		contex = new AnnotationConfigApplicationContext(AppConfig.class);

	}

	@AfterAll
	static void tearDownAfterClass() throws Exception {
		contex.registerShutdownHook();
	}

	@Test
	void test() {
		mService = contex.getBean(MessageService.class);
		Assertions.assertNotNull(mService);
		mService.setMessage("Hello Spring FrameWork !");
		Assertions.assertEquals("Hello Spring FrameWork !", mService.getMessage());
		System.out.println(mService.getMessage());

	}

}
