package com.ultron.demo;

public class CounterClient {

	private Counter counter;
	private String name;

	public CounterClient(Counter counter, String name) {
		super();
		this.counter = counter;
		this.name = name;
		System.out.println("Client Constructor Called !");
	}

	public void countUp() {
		System.out.println("""
				%s Count is %d
				""".formatted(name, counter.getCount()));
	}

}
