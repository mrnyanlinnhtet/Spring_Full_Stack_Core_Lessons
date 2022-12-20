package com.ultron.beans;

import org.springframework.stereotype.Component;

@Component
public class AnnotationBaseBean {

	private String message;

	public AnnotationBaseBean() {
		this.message = "Annotation Base Bean Created";
	}

	public String getMessage() {
		return message;
	}
}
