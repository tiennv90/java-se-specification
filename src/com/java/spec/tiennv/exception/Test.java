package com.java.spec.tiennv.exception;

public class Test {
	public static void main(String[] args) {
		try {
			method();
			System.out.println("After the method call");
		} catch (RuntimeException ex) {
			System.out.println("RuntimeException in main");
		} catch (Exception ex) {
			System.out.println("Exception in main");
		}
	}

	static void method() throws Exception {
		try {
			CircleWithException c1 = new CircleWithException(1);
			c1.setRadius(-1);
			System.out.println(c1.getRadius());
		} catch (RuntimeException ex) {
			System.out.println("RuntimeException in method()");
		} catch (Exception ex) {
			System.out.println("Exception in method()");
			throw ex;
		}
	}
}
