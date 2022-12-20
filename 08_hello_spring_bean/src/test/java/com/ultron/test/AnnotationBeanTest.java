package com.ultron.test;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.ultron.AppConfig;
import com.ultron.beans.AnnotationBaseBean;

class AnnotationBeanTest {

	@Test
	void test() {
		
		 try(var contex = new AnnotationConfigApplicationContext(AppConfig.class)){
			 
			  var bean = contex.getBean(AnnotationBaseBean.class);
			  System.out.println("Annotation Base Spring Bean  Message : " + bean.getMessage());
			  assertNotNull(bean);
			  assertEquals("Annotation Base Bean Created", bean.getMessage());
			  
			 
		 }
	}

}
