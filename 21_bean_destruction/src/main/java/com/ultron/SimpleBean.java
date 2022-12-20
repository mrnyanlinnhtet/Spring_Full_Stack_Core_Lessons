package com.ultron;

import javax.annotation.PreDestroy;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.stereotype.Component;

@Component
public class SimpleBean implements DisposableBean {

	 void release() {
		 System.out.println("Release Method For Configuration !");
	 }

	@Override
	public void destroy() throws Exception {
		System.out.println("The Process of Disposable . . . !");
	}
	
	@PreDestroy 
	public void preDestroy() {
		System.out.println("The Process of preDestroy . . . !");
	}
}
