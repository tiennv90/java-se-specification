package com.java.spec.tiennv.thread.synchronization;

import java.util.LinkedList;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class ConsumerProducer {
	
	static Buffer buffer = new Buffer();

	public static void main(String[] args) {
		
		ExecutorService executor = Executors.newFixedThreadPool(2);
		
		executor.execute(new ProducerTask());
		executor.execute(new ConsumerTask());
		
		executor.shutdown();
	}

	private static class ProducerTask implements Runnable {

		
		@Override
		public void run() {
			
			int number = 0;
			try {
				while (true) {
					System.out.println("Producer write: " + number);
					buffer.write(number++);
					Thread.sleep((int)(Math.random() * 10000));
				}
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		
	}
	
	private static class ConsumerTask implements Runnable {
		
		@Override
		public void run() {
			try {
				while (true) {
					System.out.println("\t\t\tConsumer read: " + buffer.read());
					Thread.sleep((int)(Math.random() * 10000));
				}
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
	
	private static class Buffer {

		static int CAPACITY = 1;

		LinkedList<Integer> queue = new LinkedList<Integer>();

		static Lock lock = new ReentrantLock();

		static Condition notEmpty = lock.newCondition();

		static Condition notFull = lock.newCondition();

		public void write(int number) {
			lock.lock();
			try {
				while (queue.size() == CAPACITY) {
					System.out.println("wait for not full condition");
					notFull.await();
				}
				queue.offer(number);
				notEmpty.signal();
			} catch (InterruptedException e) {
				e.printStackTrace();
			} finally {
				lock.unlock();
			}
		}

		public int read() {
			int value = 0;
			lock.lock();
			try {
				while (queue.isEmpty()) {
					System.out.println("\t\t\twait for no empty condition");
					notEmpty.await();
				}
				value = queue.remove();
				notFull.signal();
			} catch (InterruptedException e) {
				e.printStackTrace();
			} finally {
				lock.unlock();
			}
			return value;
		}
	}
}
