package com.java8.lambda;

import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.function.Consumer;

public class UnderTheHood {

	public static void main(String[] args) {
		
//		Arrays.asList(UnderTheHood.class.getDeclaredMethods()).forEach(new Consumer<Method>() {
//			@Override
//			public void accept(Method method) {
//				System.out.println(method.getName());
//			}
//		});
		
		// in below example compiled inner class (.class file) was gone away, 
		// the code appear as lambda expression will be delegated the actual 
		// construction to the language runtime.
		
		Arrays.asList(UnderTheHood.class.getDeclaredMethods())
			.forEach(method -> System.out.println(method.getName()));		
	}
	

}
