package com.java.spec.tiennv.collections;

import java.util.LinkedList;
import java.util.Queue;

public class TestQueue {
	public static void main(String args[]) {
		Queue<String> queue = new LinkedList<>();
		queue.offer("A");
		queue.offer("B");
		queue.offer("C");
		queue.offer("D");
		
		while (queue.size() > 0) {
			System.out.println(queue.remove());
		}
	}
}
