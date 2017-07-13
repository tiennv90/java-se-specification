package com.java8.lambda;

import java.util.Collections;
import java.util.List;
import java.util.function.Function;

public class MethodReferenceTest {
	
	public static void main(String[] args) {
		Passenger passenger = new Passenger(); 
		
		List<Train> trains = Collections.singletonList(Train.create(Train::new));
		trains.forEach(Train::repair);
		trains.forEach(Train::painBlue);
		trains.forEach(passenger::inboard);
	}

	public static class Train {
		
		public Train(String s) {
			System.out.println(s);
		}
		public static Train create(Function<String, Train> supplier) {
			return supplier.apply("aa");
		}
		
		public static void painBlue(Train train) {
			System.out.println("Painter blue " + train);
		}
		
		public void repair() {
			System.out.println("Repaired " + this);
		}
		
		public boolean isBlue() {
			return true;
		}
	}
	
	public static class Passenger {
		public void inboard(Train train) {
			System.out.println("Inboard " + train);
		}
	}

}
