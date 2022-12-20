package com.ultron.test;

import java.util.Locale;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

import com.ultron.config.MessageSourceConfig;

@SpringJUnitConfig(classes = MessageSourceConfig.class)
class MessageSourceConfigTest {

	@Autowired
	private ApplicationContext messageSource;

	@Test
	void test() {

		var english = messageSource.getMessage("title", new Object[] { "Nyan Linn Htet" }, Locale.getDefault());
		System.out.println(english);
		var myanmar = messageSource.getMessage("title", new Object[] {"အေးမြတ်မွန်"}, new Locale("my"));
		System.out.println(myanmar);

	}

}
