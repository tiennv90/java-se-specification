package com.java.spec.tiennv.thread.synchronization;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class AccountWithoutSync {

	static Account account = new Account();
	
	public static void main(String[] args) {
		
		ExecutorService executor = Executors.newCachedThreadPool();
		for (int i = 0; i < 100; i++) {
			executor.execute(new AddAPennyTask());
		}
		
		executor.shutdown();
		
		while (!executor.isTerminated()) {
		}
		
		System.out.println("Balance: " + account.getBalance());
	}

	private static class AddAPennyTask implements Runnable {

		@Override
		public void run() {
			account.deposit(1);
		}
		
	}
	
	private static class Account {
		
		int balance = 0;
		
		public int getBalance() {
			return this.balance;
		}
		
		public void deposit(int ammount) {
			int newBalance = this.balance + ammount;
			
			try {
				Thread.sleep(5);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			
			this.balance = newBalance;
		}
	}	
}
