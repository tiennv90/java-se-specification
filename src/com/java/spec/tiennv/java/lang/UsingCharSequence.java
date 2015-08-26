package com.java.spec.tiennv.java.lang;

public class UsingCharSequence implements CharSequence {

	private StringBuilder string;
	
	public UsingCharSequence() {
		string = new StringBuilder();
	}
	@Override
	public int length() {
		return string.length();
	}

	@Override
	public char charAt(int index) {
		return string.charAt(index);
	}

	@Override
	public CharSequence subSequence(int start, int end) {
		return string.subSequence(start, end);
	}

	//getter and setter method for string go here
}
