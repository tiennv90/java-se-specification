package com.java8.lambda;

import java.util.Comparator;

public class RunnableLambda {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		
		Runnable runnableLambda = () -> {
			for  (int i = 0; i < 3; i++) {
				System.out.println("Hello world, thread name: " + Thread.currentThread().getName());
			}
		};
		
		Thread thread = new Thread(runnableLambda);
		thread.start();
		thread.join();
		
		Comparator<String> com = (String s1, String s2) -> 
			Integer.compare(s1.length(), s2.length());
		

	}

}
