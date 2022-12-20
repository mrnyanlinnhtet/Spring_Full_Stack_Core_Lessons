package com.ultron.dto;

import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@Component
public class MessageSubscriber {

	// Using Pay load Object
//	@EventListener(PayloadApplicationEvent.class)
//	public void onEvent(PayloadApplicationEvent<String> payload) {
//		System.out.println(payload.getPayload());
//	}

	@EventListener(Message.class)
	public void onEvent(Message message) {
		System.out.println(message.getData());
	}
}
