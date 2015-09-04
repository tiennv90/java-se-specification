package com.java.spec.tiennv.collections;

public abstract class MyAbstractList<E> implements MyList<E> {
	
	private int size;
	
	protected MyAbstractList() {
	}
	
	protected MyAbstractList(E[] objects) {
		for (int i = 0; i < objects.length; i++) {
			add(objects[i]);
		}
	}
	@Override
	public boolean isEmpty() {
		return (size == 0);
	}
	
	@Override
	public void add(E e) {
		this.add(size, e);
	}
	
	@Override
	public boolean remove(E e) {
		
		if (indexOf(e) > 0) {
			remove(indexOf(e));
			return true;
		}
		return false;
		
	}
}
