package com.ultron.problem;

import java.lang.reflect.Method;

import org.springframework.beans.factory.support.MethodReplacer;

public class Command implements MethodReplacer {
	
	public Command() {
		System.out.println("Command is Created !");
	}
	
	public void action() {
		System.out.println("Command is Done !");
	}

	@Override
	public Object reimplement(Object obj, Method method, Object[] args) throws Throwable {
		action();
		return null;
	}    

}
