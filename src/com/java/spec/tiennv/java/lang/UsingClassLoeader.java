package com.java.spec.tiennv.java.lang;

public class UsingClassLoeader {

	static {
		System.out.println("Hello World");
	}
	
	public static void main(String[] args) {
		ClassLoader classLoader = ClassLoader.getSystemClassLoader();
		try {
			Class<?> clazz = classLoader.loadClass(UsingClassLoeader.class.getName());
			System.out.println(clazz.getName());
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		
	}

}

