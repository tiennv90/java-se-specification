package com.java.spec.tiennv.java.util;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Calendar;
import java.util.Formatter;

public class UsingFormatter {

	public static void main(String[] args) {
		Calendar calendar = Calendar.getInstance();
		String s = String.format("My birthday: %1$tA  %1$tb, %1$te, %1$tY" , calendar);
		
		System.out.println(s);
		
		s = String.format("My birthday: %1$tA  %1$t\u0042, %1$te, %1$tY" , calendar);
		
		System.out.println(s);
		
		s = String.format("Duke's Birthday: %1$tm %1$te,%1$tY", calendar);
		
		System.out.println(s);
		
		s = String.format("Duke's Birthday: %1$tm %<te,%<tY", calendar);
		
		System.out.println(s);
		
		Formatter formatter = new Formatter();
		formatter.format("%s %s %<s %<s", "a", "b", "c", "d");
		System.out.println(formatter.toString());
		formatter.close();
		
		
		
		formatter = new Formatter();
		formatter.format("%2$s %s %<s %s", "a", "b", "c", "d");
		System.out.println(formatter.toString());
		formatter.close();
		
		
		try {
			File file = new File("test.txt");
			formatter = new Formatter(file);
			formatter.format("my birthday: %1$tA  %1$tB, %1$te, %1$tY" , calendar);
			formatter.close();
			
			BufferedReader reader = new BufferedReader(new FileReader(file));
			String currentLine;
			while ((currentLine = reader.readLine())  != null) {
				System.out.println(currentLine);
			}
			
			reader.close();
		} catch (IOException e) {
			e.printStackTrace();
		} 
		
	}

}