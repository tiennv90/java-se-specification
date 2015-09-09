package com.java.spec.tiennv.collections;

import java.util.Collections;
import java.util.Comparator;
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

		PriorityQueue<String> queue2 = new PriorityQueue<>(
				Collections.reverseOrder());

		queue2.offer("A");
		queue2.offer("B");
		queue2.offer("C");
		queue2.offer("D");

		while (queue2.size() > 0) {
			System.out.println((queue2.remove()));
		}

		PriorityQueue<String> queue3 = new PriorityQueue<String>(10,
				new StringLengthComparator());
		
		queue3.add("short");
		queue3.add("very long indeed");
		queue3.add("medium");
		
		while (queue3.size() != 0) {
			System.out.println(queue3.remove());
		}
	}

}

class StringLengthComparator implements Comparator<String> {

	@Override
	public int compare(String o1, String o2) {
		return o1.length() - o2.length();
	}

}
