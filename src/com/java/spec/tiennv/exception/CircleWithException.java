package com.java.spec.tiennv.exception;

public class CircleWithException {
	
	private int radius;
	public static int numberOfObjects;
	
	public CircleWithException(int radius) {
		setRadius(radius);
		numberOfObjects++;
	}

	public int getRadius() {
		return radius;
	}

	public void setRadius(int radius) {
		
		if (radius < 0) {
			throw new IllegalArgumentException("Radius can not be negative");
		}
		
		this.radius = radius;
	}
	
}
