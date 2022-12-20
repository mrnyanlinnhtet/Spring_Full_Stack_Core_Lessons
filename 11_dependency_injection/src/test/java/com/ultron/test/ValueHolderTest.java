package com.ultron.test;

import java.util.Arrays;

import org.junit.jupiter.api.Test;
import org.springframework.context.support.GenericXmlApplicationContext;

import com.ultron.holder.ArrayHolder;
import com.ultron.holder.ListHolder;
import com.ultron.holder.MapHolder;
import com.ultron.holder.SetHolder;

class ValueHolderTest {

	@Test
	void test() {

		try (var context = new GenericXmlApplicationContext()) {

			context.load("classpath:/array_beans.xml");
			context.refresh();

			var bean = context.getBean(ArrayHolder.class);
			var subject = Arrays.toString(bean.getSubjects());
			System.out.println(subject);
			
			var set = context.getBean(SetHolder.class);
			var numbers = set.getNumber();
			System.out.println(numbers);
			
			var list = context.getBean(ListHolder.class);
			var days = list.getOpen();
			System.out.println(days);
			
			var map = context.getBean(MapHolder.class);
			var date = map.getDate();
			System.out.println(date);

		}
	}

}
