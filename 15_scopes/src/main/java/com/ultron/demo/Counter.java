package com.ultron.demo;

public class Counter {

	private int count;

	public Counter() {
		System.out.println("Counter Constructor Called !");
	}

	public int getCount() {
		return ++count;
	}

}
