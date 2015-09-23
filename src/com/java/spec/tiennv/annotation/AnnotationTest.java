package com.java.spec.tiennv.annotation;

import java.lang.annotation.Annotation;

public class AnnotationTest {

	public static void main(String[] args) {

		Annotation[] annotations = MyClass.class.getAnnotations();

		for(Annotation annotation : annotations){
		    if(annotation instanceof MyAnnotation){
		        MyAnnotation myAnnotation = (MyAnnotation) annotation;
		        System.out.println("name: " + myAnnotation.name());
		        System.out.println("value: " + myAnnotation.value());
		        System.out.println("age:" + myAnnotation.age());
		    }
		}
			
	}

}
