package com.ultron.test;

import org.junit.jupiter.api.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.ultron.dto.User;
import com.ultron.services.UserRegistrationService;

class SubscriberTest {

	@Test
	void test() {

		String base = "com.ultron";

		try (var contex = new AnnotationConfigApplicationContext()) {

			contex.scan(base);
			contex.refresh();
			User user = new User();
			user.setName("Aye Myat Mon");
			user.setEmail("ayemyatmon.sandi@gmail.com");
         
			 var reg = contex.getBean(UserRegistrationService.class);
			 reg.registrator(user);
			   
		}
	}

}
