package com.java.spec.tiennv.exception;

import java.util.InputMismatchException;
import java.util.Scanner;

public class InputMismatchExceptionDemo {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		boolean continueInput = true;
		
		do {
			try {
				System.out.println("Enter Integer:");
				int number = input.nextInt();
				continueInput = false;
			} catch (InputMismatchException e) {
				System.out.println("Incorrect Input: require integer");
				input.nextLine();
			}
			
		} while (continueInput);
	}

}
