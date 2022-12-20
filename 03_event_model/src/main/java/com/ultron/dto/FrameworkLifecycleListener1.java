package com.ultron.dto;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.context.event.ContextClosedEvent;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.context.event.ContextStartedEvent;
import org.springframework.context.event.ContextStoppedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@Component
public class FrameworkLifecycleListener1 {

	
	@EventListener(ContextStartedEvent.class)
	public void onStarted(ContextStartedEvent event) {

		Date date = new Date(event.getTimestamp());
		String stringDate = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss SS").format(date);
		System.out.println("IoC is started at  %s".formatted(stringDate));
	}
	
	@EventListener(ContextStoppedEvent.class)
	public void onStopped(ContextStoppedEvent event) {

		Date date = new Date(event.getTimestamp());
		String stringDate = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss SS").format(date);
		System.out.println("IoC is stopped at  %s".formatted(stringDate));
	}
	
	
	@EventListener(ContextRefreshedEvent.class)
	public void onRefreshed(ContextRefreshedEvent event) {

		Date date = new Date(event.getTimestamp());
		String stringDate = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss SS").format(date);
		System.out.println("IoC is refreshed at  %s".formatted(stringDate));
	}
	
	@EventListener(ContextClosedEvent.class)
	public void onClosed(ContextClosedEvent event) {

		Date date = new Date(event.getTimestamp());
		String stringDate = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss SS").format(date);
		System.out.println("IoC is closed at  %s".formatted(stringDate));
	}
	
}
