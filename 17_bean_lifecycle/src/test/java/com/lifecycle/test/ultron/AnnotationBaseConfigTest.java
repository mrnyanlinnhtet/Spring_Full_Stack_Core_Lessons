package com.lifecycle.test.ultron;

import org.junit.jupiter.api.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

class AnnotationBaseConfigTest {

	@Test
	void test() {
	   try(var context = new AnnotationConfigApplicationContext("com.ultron.lifcycle")){
		   
	   }
	}

}
