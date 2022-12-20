package com.ultron.DaoTest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

import com.ultron.product.model.dao.CategoryDao;
import com.ultron.product.model.dao.ProductDao;
import com.ultron.product.model.dto.Product;

@SpringJUnitConfig(locations = "/beans.xml")
//@SpringJUnitConfig(classes = ApplicationConfig.class)
@TestMethodOrder(OrderAnnotation.class)
public class ProductDaoTest {

	@Autowired
	private CategoryDao categories;

	@Autowired
	private ProductDao productDao;

	@Test
	@Order(1)
	@DisplayName("1. Create Product Test")
	@Sql(statements = { "INSERT INTO categories (name) VALUES ('Drinks')",
			"INSERT INTO categories (name) VALUES ('Foods')" })
	void test1() {

		var category = categories.findByid(1);

		Product p = new Product();
		p.setCategory(category);
		p.setName("Corona Beer");
		p.setPrice(2800);

		var product = productDao.createProduct(p);

		assertEquals(1, product);
	}

	@Test
	@Order(2)
	@DisplayName("2. Find Product By Id")
	void test2() {

		Product product = productDao.findById(1);

		assertNotNull(product);

		assertEquals("Corona Beer", product.getName());
		assertEquals("Drinks", product.getCategory().getName());
		assertEquals(2800, product.getPrice());

		assertNull(productDao.findById(2));
	}
	
	
	@Test
	@Order(3)
	@DisplayName("3. Find Product By Category")
	void test3() {
		
		 List<Product> product = productDao.findByCategory(1);
		 
		 assertEquals(1, product.size());
		 assertTrue(productDao.findByCategory(2).isEmpty());
		  
	}
	
	
	@Test
	@Order(4)
	@DisplayName("4. Search Product By Category")
	void test4() {
		
		 assertEquals(1, productDao.search("Drinks").size());
		 assertEquals(1, productDao.search("Corona Beer").size());
	 
	}
	
	
	@Test
	@Order(5)
	@DisplayName("5. Update Product By Id")
	 void test5() {
		
		 var product = productDao.findById(1);
		 product.setId(1);
		 product.setName("Tiger");
		 product.setPrice(1800);
		 int count = productDao.update(product);
		 
		  assertEquals(1, count);
		  assertEquals("Tiger", productDao.findById(1).getName());
		  assertEquals(1800,productDao.findById(1).getPrice());
	 }
	
	
	@Test
	@Order(6)
	@DisplayName("6. Delete Product By Id")
	void test6() {
		
		int count = productDao.delete(1);
		
		assertEquals(1, count);
		
		assertNull(productDao.findById(1));
	}

}
