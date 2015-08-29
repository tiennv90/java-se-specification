package com.java.spec.tiennv.thread;

public class PrintChar implements Runnable {

	char a;
	int count;
	public PrintChar(char a,int count) {
		this.a = a;
		this.count = count;
	}
	
	@Override
	public void run() {
		
		for (int i = 0; i < count;i++) {
			System.out.print(a + " ");
		}
		System.out.println();
	}

}
