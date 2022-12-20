package com.ultron.test;

import org.junit.jupiter.api.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.ultron.events.StaticListener;
import com.ultron.events.event.MyAppEvent;
import com.ultron.events.event.MyEvent;

class EventListenerTest {

	@Test
	void eventListenerTest() {

		try (var contex = new AnnotationConfigApplicationContext()) {

			contex.addBeanFactoryPostProcessor(factory -> {
				contex.publishEvent(new MyAppEvent(contex, "My Application Event is Publishing ...."));
			});
			contex.addApplicationListener(new StaticListener());

			contex.scan("com.ultron.events");
			contex.refresh();

			contex.publishEvent(new MyEvent("My Event is Publishing ..."));

		}
	}

}
