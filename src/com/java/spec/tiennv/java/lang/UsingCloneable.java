package com.java.spec.tiennv.java.lang;

public class UsingCloneable implements Cloneable {
	
	private String name;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	public static void main(String[] args) {
		UsingCloneable u = new UsingCloneable();
		u.setName("My Name");
		
		try {
			UsingCloneable cloneObject = (UsingCloneable) u.clone();
			System.out.println(cloneObject.getName());
		} catch (CloneNotSupportedException e) {
			//if this class does not implement Cloneable interface CloneNotSupportedException will be raised
			e.printStackTrace();
		}
	}
	
}
