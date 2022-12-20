package com.ultron.scope;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope("singleton")
public class StatelessBean {

	private int value;

	public StatelessBean() {
		System.out.println("Stateless Bean Constructor Called !");
	}

	public void showCount() {
		System.out.printf("Stateless Bean Count : %d", ++value);
	}
}
