package com.java.spec.tiennv.thread.synchronization;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;


public class AccountWithSyncUsingLock {

	
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
		static Lock lock = new ReentrantLock();
		
		public int getBalance() {
			return this.balance;
		}
		
		public void deposit(int ammount) {
			
			lock.lock();
			int newBalance = this.balance + ammount;
			
			try {
				Thread.sleep(5);
				this.balance = newBalance;
			} catch (InterruptedException e) {
				e.printStackTrace();
			} finally {
				lock.unlock();
			}
			
		}
	}

}
