package com.java.spec.tiennv.collections;

import java.util.Iterator;

public class MyArrayList<E> extends MyAbstractList<E> {
	public static final int INITIAL_CAPACITY = 16;
	private E[] data = (E[]) new Object[INITIAL_CAPACITY];
	
	public MyArrayList() {
	}

	public MyArrayList(E[] objects) {
		for (int i = 0; i < objects.length; i++) {
			add(objects[i]);
		}
	}
	@Override
	public void add(int index, E e) {
		
	}

	@Override
	public void clear() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean contains(E e) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public E get(int index) {
		return null;
	}

	@Override
	public int indexOf(E e) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int lastIndexOf(E e) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public E remove(int index) {
		return null;
	}

	@Override
	public Object set(int index, E e) {
		return null;
	}

	@Override
	public int size() {
		return 0;
	}

	@Override
	public Iterator<E> iterator() {
		return null;
	}
	
	

}
