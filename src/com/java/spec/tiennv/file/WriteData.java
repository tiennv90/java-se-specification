package com.java.spec.tiennv.file;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;

public class WriteData {
	public static void main(String args[]) throws FileNotFoundException {
		File file = new File("score.txt");
		if (file.exists()) {
			System.out.println("File already exists");
			System.exit(1);
		}
		
		PrintWriter writer = new PrintWriter(file);
		
		writer.print("John Smith ");
		writer.println("90");
		writer.print("Eric John ");
		writer.println("100");
		
		writer.close();
	}
}
