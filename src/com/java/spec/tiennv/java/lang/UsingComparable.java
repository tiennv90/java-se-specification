package com.java.spec.tiennv.java.lang;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;


public class UsingComparable {
	
	public static void main(String[] args) {
		
		IntegerComparableImpl n1 = new IntegerComparableImpl(111);
		IntegerComparableImpl n2 = new IntegerComparableImpl(13);
		IntegerComparableImpl n3 = new IntegerComparableImpl(-211);
		
		List<IntegerComparableImpl> list = Arrays.asList(n2, n3, n1);	
		
		Collections.sort(list);
		
		for (IntegerComparableImpl number : list) {
			System.out.println(number.number);
		}
	}

	
}

class IntegerComparableImpl implements Comparable<IntegerComparableImpl> {

	Integer number;
	
	public IntegerComparableImpl(Integer number) {
		this.number = number;
	}
	
	@Override
	public int compareTo(IntegerComparableImpl o) {
		
		if (this.number.equals(o.number)) {
			return 0;
		} else if (this.number > o.number) {
			return -1;
		} 
		return 1;
	}
	
}
