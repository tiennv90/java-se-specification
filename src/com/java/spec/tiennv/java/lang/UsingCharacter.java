package com.java.spec.tiennv.java.lang;

public class UsingCharacter {

	public static void main(String[] args) {
		
		char chars[] = {'a', 'L', 'c', 'c', ' '};
		int codePoint = Character.codePointAt(chars, 3);
		
		System.out.println(codePoint);
		
		System.out.println(Character.isWhitespace(chars[4]));
		
		System.out.println(Character.getType(chars[1]));
	}

}
