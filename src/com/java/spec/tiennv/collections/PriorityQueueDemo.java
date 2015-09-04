package com.java.spec.tiennv.collections;

import java.util.Collections;
import java.util.PriorityQueue;

public class PriorityQueueDemo {

	public static void main(String[] args) {
		
		PriorityQueue<String> queue1 = new PriorityQueue<>();
		queue1.offer("A");
		queue1.offer("B");
		queue1.offer("C");
		queue1.offer("D");
		
		while (queue1.size() > 0) {
			System.out.println(queue1.remove());
		}
		
		PriorityQueue<String> queue2 = new PriorityQueue<>(Collections.reverseOrder());
		
		queue2.offer("A");
		queue2.offer("B");
		queue2.offer("C");
		queue2.offer("D");
		
		while (queue2.size() > 0) {
			System.out.println((queue2.remove()));
		}
	}

}
