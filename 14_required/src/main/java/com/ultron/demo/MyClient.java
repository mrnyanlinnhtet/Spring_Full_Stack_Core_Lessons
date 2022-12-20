package com.ultron.demo;

import org.springframework.beans.factory.ObjectProvider;
import org.springframework.beans.factory.annotation.Autowired;

public class MyClient {
	@Autowired
	private ObjectProvider<Worker> workers;

	private String state = "My Client";

	public void work() {
		workers.stream().forEach(worker -> worker.work(state));
	}

}
