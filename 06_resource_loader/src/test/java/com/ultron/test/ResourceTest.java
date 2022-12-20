package com.ultron.test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.core.io.support.ResourcePatternResolver;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

import com.ultron.config.AppConfig;

@SpringJUnitConfig(classes = AppConfig.class)
class ResourceTest {

	@Autowired
	ResourcePatternResolver resource;

	@Test
	void test() {
		var sql = resource.getResource("classpath:/insert.sql");

		Assertions.assertNotNull(sql);
		Assertions.assertTrue(sql.exists());

		try (var reader = new BufferedReader(new InputStreamReader(sql.getInputStream()))) {
			String line = null;

			while (null != (line = reader.readLine())) {
				System.out.println(line);
			}

		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	@Test
	void testResourcePattern() {

		try {

			Resource[] list = resource.getResources("classpath*:/**/*.sql");
			System.out.println(list.length);

		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}
