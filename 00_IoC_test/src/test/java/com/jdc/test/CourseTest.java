package com.jdc.test;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.jdc.dao.InsertCourse;
import com.jdc.dto.Course;

class CourseTest {

	static private ClassPathXmlApplicationContext contex;

	@BeforeAll
	static void initialized() {
		contex = new ClassPathXmlApplicationContext("classpath:/bean.xml");
	}

	@AfterAll
	static void close() {
		contex.registerShutdownHook();
	}

	@Test
	void testInsertProcess() {

		Course c = new Course();
		c.setName("JavaEE Course");
		c.setFees(200000);
		c.setDuration(5);

		InsertCourse insert = contex.getBean("insert", InsertCourse.class);
		insert.insertProcess(c);
	}

}
