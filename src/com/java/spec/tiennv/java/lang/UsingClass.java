package com.java.spec.tiennv.java.lang;

public class UsingClass {
	
	public static void main(String args[]) throws ClassNotFoundException {
		Class clazz = Class.forName("com.java.spec.tiennv.java.lang.UsingClassLoeader");
		System.out.println(clazz.getName());
	}
	
}
