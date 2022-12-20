package com.ultron.test;

import org.junit.jupiter.api.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.ultron.dto.Message;

class EventTest {

	@SuppressWarnings("unused")
	private static final String XMLCONFIG = "classpath:/beans.xml";
	private static final String ANNOCONFIG = "com.ultron";

	@Test
	void test() {

		try (var contex = new AnnotationConfigApplicationContext()) {

			contex.scan(ANNOCONFIG);
			contex.refresh();
			contex.start();
			contex.stop();

//			var message = new PayloadApplicationEvent<String>(contex, "Hello Payload Subscriber !");
			
			var message = new Message("Hello Custom Event subscriber !");
			contex.publishEvent(message);

		}
	}

}
