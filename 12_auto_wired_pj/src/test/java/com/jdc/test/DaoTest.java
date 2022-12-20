package com.jdc.test;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

import com.ultron.config.AppConfig;
import com.ultron.dao.CourseDao;
import com.ultron.dto.Course;
import com.ultron.dto.Course.Level;
import com.ultron.util.ConnectionManager;

@SpringJUnitConfig(classes = AppConfig.class)
@TestMethodOrder(value = OrderAnnotation.class)
class DaoTest {
	@Autowired
	private CourseDao dao;

	@BeforeAll
	static void init() {
		final String TRUNCATE_SQL = "TRUNCATE TABLE courses";

		try (var con = ConnectionManager.getConnection(); var stm = con.prepareStatement(TRUNCATE_SQL)) {
 
			stm.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Test
	@Order(1)
	void insert_test() {
		Course course = getJavaBasicCourse();

		int courseId = dao.insertCourse(course);

		Assertions.assertEquals(1, courseId);
	}

	@Test
	@Order(2)
	void findById_test() {

		Course c = dao.findById(1);
		Course exceptValue = getJavaBasicCourse();
		exceptValue.setId(1);

		Assertions.assertEquals(exceptValue, c);

	}

	private Course getJavaBasicCourse() {

		var c = new Course();
		c.setName("Java Basic");
		c.setLevel(Level.BASIC);
		c.setMonth(3);
		c.setFees(200000);

		return c;
	}

}
