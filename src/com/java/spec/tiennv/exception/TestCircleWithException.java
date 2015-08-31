package com.java.spec.tiennv.exception;

public class TestCircleWithException {

	public static void main(String[] args) {
		try {
			CircleWithException circle1 = new CircleWithException(5);
			CircleWithException circle2 = new CircleWithException(-1);
			CircleWithException circle3 = new CircleWithException(11);
		} catch (IllegalArgumentException ex) {
			System.out.println(ex);
		}
		
		System.out.println("Object created: " + CircleWithException.numberOfObjects);
	}

}
