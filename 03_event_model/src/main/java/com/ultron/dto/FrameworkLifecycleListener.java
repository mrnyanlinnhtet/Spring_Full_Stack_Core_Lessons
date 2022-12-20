package com.ultron.dto;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.context.ApplicationEvent;
import org.springframework.context.event.EventListener;

//@Component
public class FrameworkLifecycleListener{
	
	

//	@Override(implement applicationListener interface)
//	public void onApplicationEvent(ApplicationEvent event) {
//
//		Date date = new Date(event.getTimestamp());
//		String stringDate = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss SS").format(date);
//		System.out.println("Event is Occcured at  %s".formatted(stringDate));
//	}

	@EventListener(ApplicationEvent.class)
	public void onApplicationEvent(ApplicationEvent event) {

		Date date = new Date(event.getTimestamp());
		String stringDate = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss SS").format(date);
		System.out.println("Event is Occcured at  %s".formatted(stringDate));
	}

}
