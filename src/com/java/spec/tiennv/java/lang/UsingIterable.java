package com.java.spec.tiennv.java.lang;

import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class UsingIterable {

	public static void main(String[] args) {
		
		MyIterable myIterable = new MyIterable();
		myIterable.add(2);
		myIterable.add(4);
		myIterable.add(6);
		
		for (Integer number : myIterable) {
			System.out.println(number);
		}
	}

}

class MyIterable implements Iterable<Integer>, Iterator<Integer> {

	private List<Integer> list = new ArrayList<>();
	private int index = 0;
	public void add(Integer integer) {
		this.list.add(integer);
	}
	
	@Override
	public Iterator<Integer> iterator() {
		return this;
	}

	@Override
	public boolean hasNext() {
		if (index < list.size()) {
			return true;
		} 
		return false;
	}

	@Override
	public Integer next() {
		if (index == list.size()) {
			try {
				throw new NoSuchAlgorithmException();
			} catch (NoSuchAlgorithmException e) {
				e.printStackTrace();
			}
		} else {
			index ++;
			return list.get(index - 1);
		}
		return null;
	}
	
}
