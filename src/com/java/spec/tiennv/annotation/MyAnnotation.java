package com.java.spec.tiennv.annotation;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Retention(RetentionPolicy.RUNTIME)
@interface MyAnnotation {
	String value();
	String name();
	int age();
	String[] newNames();
}
