package com.ultron.scope;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope("prototype")
public class StatefulBean {

	private int value;

	public StatefulBean() {
		System.out.println("Stateful Bean Constructor Called !");
	}

	public void showCount() {
		System.out.printf("Stateful Bean Count : %d", ++value);
	}

}
