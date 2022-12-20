package com.ultron.events;

import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

import com.ultron.events.event.MyAppEvent;

@Component
public class BeanListener implements ApplicationListener<MyAppEvent> {

	@Override
	public void onApplicationEvent(MyAppEvent event) {

		System.out.println("Bean Listener : " + event.getMessage());
	}

}
