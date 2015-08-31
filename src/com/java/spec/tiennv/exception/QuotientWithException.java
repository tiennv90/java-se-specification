package com.java.spec.tiennv.exception;

import java.util.Scanner;

public class QuotientWithException {
	
	

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		
		int number1 = scanner.nextInt();
		int number2 = scanner.nextInt();
		
		try {
			System.out.println(quotient(number1, number2));
		} catch (ArithmeticException e) {
			System.out.println("can not be divided by zero");
		}
		
		System.out.println("continue to work");
		
	}
	
	public static int quotient(int number1, int number2) {
		 if (number2 == 0) {
			 throw new ArithmeticException("divisor can not be zero");
		 }
		 return number1 / number2;
	}

}
