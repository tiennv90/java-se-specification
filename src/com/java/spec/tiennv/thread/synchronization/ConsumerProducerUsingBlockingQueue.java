package com.java.spec.tiennv.thread.synchronization;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ConsumerProducerUsingBlockingQueue {

	static ArrayBlockingQueue<Integer> buffer = new ArrayBlockingQueue<Integer>(2);

	public static void main(String args[]) {
		
		ExecutorService executor = Executors.newFixedThreadPool(2);
		
		executor.execute(new ProducerTask());
		executor.execute(new ConsumerTask());
		
		executor.shutdown();
	}

	private static class ProducerTask implements Runnable {

		@Override
		public void run() {

			int i = 1;

			try {
				while (true) {
					
					System.out.println("Pruducer write: " + i);

					buffer.put(i++);
					
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
					System.out.println("\t\t\tConsumer read: " + buffer.take());
					Thread.sleep((int)(Math.random() * 10000));
				}
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			
		}
		
	}
}
