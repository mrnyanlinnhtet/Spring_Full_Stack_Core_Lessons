package com.ultron.lifecycle;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;


public class MyClient{

	@Autowired
	private MyService myService;

	@PostConstruct
	void customPostConstruct() {
		myService.prepareData();
	}

}
