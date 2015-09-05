package com.java.spec.tiennv.collections;

import java.util.Iterator;

public class MyArrayList<E> extends MyAbstractList<E> {
	public static final int INITIAL_CAPACITY = 16;
	@SuppressWarnings("unchecked")
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
		ensureCapacity();
		
		for (int i = size - 1; i >= index; i--) {
			data[i + 1] = data[i];
		}
		
		data[index] = e;
		
		size++;
	}

	@SuppressWarnings("unchecked")
	@Override
	public void clear() {
		data = (E[]) new Object[INITIAL_CAPACITY];
		size = 0;
	}

	@Override
	public boolean contains(E e) {
		for (int i = 0; i < data.length; i++) {
			if (data[i].equals(e)) {
				return true;
			}
		}
		return false;
	}

	@Override
	public E get(int index) {
		checkIndex(index);
		return data[index];
	}

	@Override
	public int indexOf(E e) {
		for (int i = 0; i < size; i++) {
			if (e.equals(data[i])) {
				return i;
			}
		}
		return -1;
	}

	@Override
	public int lastIndexOf(E e) {
		for (int i = size - 1; i >= 0; i--) {
			if (e.equals(data[i])) {
				return i;
			}
		}
		return -1;
	}

	@Override
	public E remove(int index) {
		
		checkIndex(index);
		
		for (int i = index; i < size - 1; i++) {
			data[i] = data[i + 1];
		}
		
		data[size - 1] = null;
		
		size--;
		
		return null;
	}

	@Override
	public Object set(int index, E e) {
		checkIndex(index);
		
		E old = data[index];
		data[index] = e;
		
		return old;
	}

	@Override
	public int size() {
		return 0;
	}

	@Override
	public Iterator<E> iterator() {
		return null;
	}
	
	private void checkIndex(int index) {
		if (index < 0 || index >= size) {
			throw new IndexOutOfBoundsException("index" + index + " out of bounds");
		}
	}
	
	private void ensureCapacity() {
		if (size >= data.length) {
			E[] newData = (E[]) (new Object[size * 2 - 1]);
			System.arraycopy(data, 0, newData, 0, size);
		}
	}
	
	@SuppressWarnings("unused")
	private class ArrayListIterator<E> implements Iterator<E> {

		private int current = 0;
		
		@Override
		public boolean hasNext() {
			return current == size;
		}

		@Override
		public E next() {
			return (E) data[current++];
		}
		
		@Override
		public void remove() {
			MyArrayList.this.remove(current);
		}
		
	}

}
