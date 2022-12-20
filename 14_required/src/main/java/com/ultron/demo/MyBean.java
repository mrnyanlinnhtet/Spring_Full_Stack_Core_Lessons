package com.ultron.demo;

public class MyBean implements Worker {

	private String value;

	public MyBean(String value) {
		this.value = value;
	}

	@Override
	public void work(String data) {

		System.out.println(String.format("%s - %s%n", value, data));

	}

}
