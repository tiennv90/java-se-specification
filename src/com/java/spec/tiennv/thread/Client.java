package com.java.spec.tiennv.thread;

public class Client {

	public static void main(String[] args) {
		Runnable printA = new PrintChar('a', 10);
		Runnable printB = new PrintChar('b', 10);
		Runnable printNum = new PrintNumber(20);
		
		Thread thread1 = new Thread(printA);
		Thread thread2 = new Thread(printB);
		Thread thread3 = new Thread(printNum);		
		
		thread1.start();
		thread2.start();
		thread3.start();
	}

}
