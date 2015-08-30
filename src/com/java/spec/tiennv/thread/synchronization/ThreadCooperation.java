package com.java.spec.tiennv.thread.synchronization;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class ThreadCooperation {
	
	static Account account = new Account();

	public static void main(String[] args) {
		ExecutorService executor = Executors.newFixedThreadPool(2);
		
		executor.execute(new DepositTask());
		executor.execute(new WithdrawTask());
		
		executor.shutdown();
		System.out.println("Thread 1 \t\tThread 2\t\tBalance");
	}

	public static class DepositTask implements Runnable {

		@Override
		public void run() {
			try {
				while (true) {
					account.deposit((int)(Math.random() * 10) + 1);
					Thread.sleep(1000);
				}
			} catch(InterruptedException e) {
				e.printStackTrace();
			}
		}
		
	}
	
	public static class WithdrawTask implements Runnable {

		@Override
		public void run() {
			while (true) {
				account.withdraw((int)(Math.random() * 10) + 1);
			}
		}
		
	}
	
	private static class Account {
		
		int balance = 0;
		
		static Lock lock = new ReentrantLock();
		
		static Condition newDeposit = lock.newCondition();
		
		public int getBalance() {
			return this.balance;
		}
		
		public void deposit(int ammount) {
			
			lock.lock();
			try {
				this.balance += ammount;
				System.out.println("Deposit " + ammount + " \t\t\t" + getBalance() + "(total balance)");
				newDeposit.signalAll();
			} finally {
				lock.unlock();
			}
			
		}
		
		public void withdraw(int amount) {
			
			lock.lock();
			try {
				
				while (balance < amount) {
					System.out.println("withdraw amount ("+amount+") greater than balance("+balance+"). So wait for deposit");
					newDeposit.await();
				}
				balance -= amount;
				System.out.println("Withdraw: " + amount + "\t\t" + balance + "(remaining balance)");
				
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}
