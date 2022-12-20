package com.ultron;

import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@Component
public class Service {

	public Service() {
		System.out.println("Service is Created !");
	}

	@EventListener(String.class)
	public void catchMessage(String message) {
		System.out.println("Catch Message From Listener !");
		System.out.println(message);
	}

}
