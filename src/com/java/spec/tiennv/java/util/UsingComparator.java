package com.java.spec.tiennv.java.util;

import java.util.Comparator;
import java.util.SortedSet;
import java.util.TreeSet;

public class UsingComparator {

	public static void main(String[] args) {
		
		SortedSet<MyNumber> myNumbers = new TreeSet<>(new MyComparator());
		myNumbers.add(new MyNumber(-2333));
		myNumbers.add(new MyNumber(4));
		myNumbers.add(new MyNumber(-221));
		myNumbers.add(new MyNumber(35));
		
		for (MyNumber number : myNumbers) {
			System.out.println(number.getNumber());
		}
	}

}

//object to be sorted
class MyNumber {
	
	int number;
	String id;
	
	public MyNumber(int number) {
		this.number = number;
	}
	public int getNumber() {
		return number;
	}
	public void setNumber(int number) {
		this.number = number;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
}

class MyComparator implements Comparator<MyNumber> {

	@Override
	public int compare(MyNumber number1, MyNumber number2) {
		return number1.getNumber() - number2.getNumber();
	}
	
	
}