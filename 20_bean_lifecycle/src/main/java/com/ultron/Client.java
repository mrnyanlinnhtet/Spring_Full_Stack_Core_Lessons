package com.ultron;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Client {
	
	
	private Service service;
	
	public Client() {
		System.out.println("Client is Created !");
		
	}
	
	@Autowired
	public void setService(Service service) {
		System.out.println("Set Service Process.... !");
		this.service = service;
	}

}
