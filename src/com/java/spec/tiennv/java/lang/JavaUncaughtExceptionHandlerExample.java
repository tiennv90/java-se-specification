package com.java.spec.tiennv.java.lang;

public class JavaUncaughtExceptionHandlerExample {

	public static void main(String[] args) {
		
		Thread thread = new Thread(new MyThread());
		thread.setName("JavaUncaughtExceptionHandlerExample Thread");
		
		thread.setUncaughtExceptionHandler(new Thread.UncaughtExceptionHandler() {
			
			@Override
			public void uncaughtException(Thread t, Throwable e) {
				System.out.println(thread.getName() + " throws exception: " + e.getMessage());
			}
		});
		
		thread.start();
	}

}

class MyThread implements Runnable {

	@Override
	public void run() {
		
		throw new RuntimeException("test exception");
		
	}
	
}