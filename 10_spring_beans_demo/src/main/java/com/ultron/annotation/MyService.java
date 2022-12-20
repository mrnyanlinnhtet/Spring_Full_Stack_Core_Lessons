package com.ultron.annotation;

import org.springframework.stereotype.Component;

@Component
public class MyService {
	
	public MyService() {
	System.out.println("Default Constructor !");
	}
	
	public MyService(int num) {
		System.out.println("Argument With Constructor !");
	}

}
