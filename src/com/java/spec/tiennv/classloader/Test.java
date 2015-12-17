package com.java.spec.tiennv.classloader;

public class Test {
	public static void main(String args[]) {
		System.out.println(((Util)Factory.getInstanceUntyped()).sayHello());
	}
}
