package com.ultron.test;

import java.util.Arrays;

import org.junit.jupiter.api.Test;
import org.springframework.context.support.GenericXmlApplicationContext;
import org.springframework.core.env.ConfigurableEnvironment;

import com.ultron.dto.Message;
import com.ultron.services.Resources;

class ProfileTest {

	@Test
	void test() {

		try (GenericXmlApplicationContext contex = new GenericXmlApplicationContext()) {

			ConfigurableEnvironment env = contex.getEnvironment();
			env.setActiveProfiles("toBoss");
			contex.load("classpath:/beans.xml");
			contex.refresh();

			System.out.println(Arrays.toString(env.getActiveProfiles()));
			System.out.println(Arrays.toString(env.getDefaultProfiles()));

			Message mes = contex.getBean(Message.class);
			System.out.println(mes.getSms());

			Resources rec = contex.getBean(Resources.class);
			System.out.println(rec.data());

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
