package com.java.spec.tiennv.keywords;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * The volatile keyword is used to say to the jvm "Warning,
 * this variable may be modified in an other Thread". 
 * Without this keyword the JVM is free to make some optimizations,
 * like never refreshing those local copies in some threads
 * 
 * https://dzone.com/articles/java-volatile-keyword-0
 * @author tien.nv
 *
 */
public class VolatileTest {

	private static volatile int MY_INT = 0;
	
	public static void main(String[] args) {
		
		ExecutorService executorService = Executors.newFixedThreadPool(2);
		executorService.execute(new ChangeListener());
		executorService.execute(new ChangeMaker());
		
		executorService.shutdown();
	}

	static class ChangeListener implements Runnable {

		@Override
		public void run() {
			int localValue = MY_INT;
			while (localValue < 5) {
				if (localValue != MY_INT) {
					System.out.println("Change for MY_INT: " + MY_INT);
					localValue = MY_INT;
				}
			}
		}
		
	}
	
	static class ChangeMaker implements Runnable {

		@Override
		public void run() {
			int localValue = MY_INT;
			while (MY_INT < 5) {
				System.out.println("Incrementing MY_INT to " + (localValue + 1));
				MY_INT = ++localValue;
				try {
					Thread.sleep(500);
				} catch (InterruptedException e ) {
					e.printStackTrace();
				}
			}
		}
		
	}
}
