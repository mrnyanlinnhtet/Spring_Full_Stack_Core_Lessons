package com.ultron.test;

import org.junit.jupiter.api.Test;
import org.springframework.context.support.GenericXmlApplicationContext;

public class DestructionTest {
	
	@Test
	void test() {
		
		 try(var context = new GenericXmlApplicationContext()){
			 context.load("classpath:/beans.xml");
			 context.refresh();
			 
			
			 
		 }
		 
	}

}
