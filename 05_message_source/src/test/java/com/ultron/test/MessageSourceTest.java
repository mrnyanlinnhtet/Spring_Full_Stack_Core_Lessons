package com.ultron.test;

import java.util.Locale;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

@SpringJUnitConfig(locations = "classpath:/beans.xml")
class MessageSourceTest {

	@Autowired
	ApplicationContext messageSource;

	@Test
	void test() {
		String english = messageSource.getMessage("title", new Object[] { "Nyan Linn Htet" }, Locale.getDefault());
		System.out.println(english);

		String myanmar = messageSource.getMessage("title", new Object[] { "အေးမြတ်မွန်" }, new Locale("my"));
		System.out.println(myanmar);
	}

}
