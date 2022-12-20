package com.ultron.DaoTest;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

import com.ultron.product.config.ApplicationConfig;
import com.ultron.product.model.dao.CategoryDao;
import com.ultron.product.model.dto.Category;

@TestMethodOrder(OrderAnnotation.class)
@SpringJUnitConfig(classes = ApplicationConfig.class)
public class CategoryDaoTest {

	@Autowired
	private CategoryDao dao;

	@Test
	@Order(1)
	@DisplayName("1.Create Category")
	void test1() {

		var c = new Category();
		c.setName("Foods");
		int id = dao.createCategory(c);

//		System.out.println(id);
		assertEquals(1, id);
	}

	
	
	@Test
	@Order(2)
	@DisplayName("2. Update Category")
	void test2() {

		var c = new Category();
		c.setId(1);
		c.setName("Drink");;
		int count = dao.update(c);

		assertEquals(1, count);

	}
	
	
	@Test
	@Order(3)
	@DisplayName("3. Find Category By ID")
	 void test3() {
		
		  Category c = dao.findByid(1);
		  assertEquals("Drink", c.getName());
	 }
	
	
	@Test
	@Order(4)
	@DisplayName("4. Find Category By Name")
	void test4() {
		
		Category c = dao.findByName("Drink");
		assertEquals("Drink", c.getName());
	}
	
	
	@Test
	@Order(5)
	@DisplayName("5. Find Count By Name")
	void test5() {
		
		List<Category> count = dao.findByNameCount("Drink");
		 assertEquals(1, count.size());
	}
	
	
	@Test
	@Order(6)
	@DisplayName("5. Delete Category By Id")
	void test6() {
	
		int count = dao.deleteById(1);
		assertEquals(1, count);
	}

}
