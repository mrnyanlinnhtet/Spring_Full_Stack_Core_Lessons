package com.ultron.services;

import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

import com.ultron.dto.User;

@Component
public class EmailService {

	@EventListener(User.class)
	public void sendMail(User user) {
     System.out.println("Email send to :" + user.getEmail() + " is successfully !");
	}
}
