package com.ultron.test;

import org.junit.jupiter.api.Test;
import org.springframework.context.support.GenericXmlApplicationContext;

import com.ultron.beans.Employee;
import com.ultron.beans.EmployeeService;

class XmlBaseTest {

	@Test
	void test() {

		try (var context = new GenericXmlApplicationContext("classpath:/beans.xml")) {

			var service = context.getBean(EmployeeService.class);

			Employee e = new Employee();
			e.setId(1);
			e.setName("Aye Myat Mon");
			e.setPhone("09444849894");

			service.create(e);

		}
	}

}
