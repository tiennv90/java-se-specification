package com.java8.lambda;

import java.io.File;
import java.io.FileFilter;

public class Solutions {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		//classical way
		FileFilter filter = new FileFilter() {
			
			@Override
			public boolean accept(File arg0) {
				// TODO Auto-generated method stub
				return false;
			}
		};
		
		System.out.println(filter.getClass().toString());
		
		
		//lambda way
		FileFilter lambdaFilter = (File file) -> file.getName().endsWith(".lambda");
		
		System.out.println(lambdaFilter.getClass().toString());

	}

}
