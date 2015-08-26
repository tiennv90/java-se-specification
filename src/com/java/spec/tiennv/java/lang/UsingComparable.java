package com.java.spec.tiennv.java.lang;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.TreeMap;


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
		
		Map<IntegerComparableImpl, String> sortedMap = new TreeMap<>();
		sortedMap.put(n1, "value 1");
		sortedMap.put(n3, "value 3");
		sortedMap.put(n2, "value 2");
		
		for (Entry<IntegerComparableImpl, String> entry : sortedMap.entrySet()) {
			System.out.println(entry.getValue());
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
