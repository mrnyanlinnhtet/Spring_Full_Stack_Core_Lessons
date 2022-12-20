package com.ultron.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Component;

import com.ultron.dto.User;

@Component
public class UserRegistrationService {

	@Autowired
	private ApplicationEventPublisher publisher;

	public void registrator(User user) {
		System.out.println(user.getName() + " is Registrated Successful !");
		publisher.publishEvent(user);
	}

}
