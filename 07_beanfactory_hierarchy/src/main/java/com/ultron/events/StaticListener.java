package com.ultron.events;

import org.springframework.context.ApplicationListener;

import com.ultron.events.event.MyAppEvent;

public class StaticListener implements ApplicationListener<MyAppEvent> {

	@Override
	public void onApplicationEvent(MyAppEvent event) {
		System.out.println("Static Listener : " + event.getMessage());

	}

}
