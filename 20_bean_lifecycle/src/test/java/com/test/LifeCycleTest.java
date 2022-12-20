package com.test;

import org.junit.jupiter.api.Test;
import org.springframework.context.support.GenericXmlApplicationContext;

import com.ultron.MessagePublisher;

public class LifeCycleTest {
	
	@Test
	void test() {
		
		try(var context = new GenericXmlApplicationContext()){
			context.load("classpath:/beans.xml");
			context.refresh();
			
			var publisher = context.getBean(MessagePublisher.class);
			
			 publisher.fire("Hello Event Publisher !");
		}
		
	}

}
