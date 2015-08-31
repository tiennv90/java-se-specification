package com.java.spec.tiennv.file;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

//https://www3.ntu.edu.sg/home/ehchua/programming/java/J9c_PackageClasspath.html

public class ReplacingText {

	public static void main(String args[]) throws FileNotFoundException {
		if (args.length != 4) {
			System.out.println("Usage: java ReplaceText sourceFile targetFile oldStr newStr");
			System.exit(1);
		}
		
		File sourceFile = new File(args[0]);
		if (!sourceFile.exists()) {
			System.out.println("source file " + args[0] + " does not exist");
			System.exit(2);
		}
		
		File targetFile = new File(args[1]);
		if (targetFile.exists()) {
			System.out.println("target file already exists");
			System.exit(3);
		}
		
		Scanner input = new Scanner(sourceFile);
		PrintWriter output = new PrintWriter(targetFile);
		
		while (input.hasNext()) {
			String s1 = input.nextLine();
			String s2 = s1.replace(args[2], args[3]);
			output.println(s2);
		}
		
		input.close();
		output.close();
	}
	
	

}
