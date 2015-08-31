package com.java.spec.tiennv.exception;

public class ChainedExceptionDemo {
	
	public static void main(String args[]) {
		
		try {
			method1();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
	public static void method1() throws Exception {
		try {
			method2();
		} catch (Exception e) {
			throw new Exception("New info from method1", e);
		}
	}
	
	public static void method2() throws Exception {
		throw new Exception("New info from method2");
	}
}
