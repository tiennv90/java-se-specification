package com.java.spec.tiennv.java.util;

import java.util.Formatter;
import java.util.Locale;

public class UsingFormatter {

	public static void main(String args[]) {
		
		StringBuilder sb = new StringBuilder();
		
		Formatter formatter = new Formatter(sb, Locale.US);
		
		formatter.format("%4$2s %3$2s %2$2s %1$2s", "a", "b", "c", "d");
		
		System.out.println(sb.toString());
		
		formatter.format(Locale.FRANCE, "e = %+10.4f", Math.E);
		
		System.out.println(sb.toString());
	}
}
