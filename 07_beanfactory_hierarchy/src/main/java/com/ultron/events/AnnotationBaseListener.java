package com.ultron.events;

import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

import com.ultron.events.event.MyEvent;

@Component
public class AnnotationBaseListener {

	@EventListener(classes = MyEvent.class)
	public void handle(MyEvent event) {
		System.out.println("AnnotationBaseListener : " + event.getMessage());
	}

}
