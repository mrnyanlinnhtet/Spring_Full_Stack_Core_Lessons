package com.ultron.annotation;

import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.ElementType.PARAMETER;
import static java.lang.annotation.ElementType.TYPE;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
@Qualifier
@Retention(RUNTIME)
@Target({ TYPE, FIELD, PARAMETER })
public @interface AppServices {

	public enum Type {
		ONE, TWO
	}

	Type value() default Type.ONE;
}
