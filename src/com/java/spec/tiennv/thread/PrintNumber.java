package com.java.spec.tiennv.thread;

public class PrintNumber implements Runnable {

	int b;
	
	public PrintNumber(int b) {
		this.b = b;
	}
	@Override
	public void run() {
		
		Thread subThread = new Thread(new PrintChar('c', 3));
		subThread.start();
		try {
			for (int i = 0; i < b; i++) {
				System.out.print(i+ " ");
				if (i == 5) {
					subThread.join();
				}
			}
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println();
	}
	
	

}
