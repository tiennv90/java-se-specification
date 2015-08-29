package com.java.spec.tiennv.thread;

public class Test implements Runnable {

	public Test() {
		//Test task = new Test();
		
		Thread t = new Thread(this);
		t.start();
		Thread t2 = new Thread(this);
		t2.start();
	}
	@Override
	public void run() {
		System.out.println("test");
	}
	
	
	public static void main(String args[]) {
		new Test();
	}
}
