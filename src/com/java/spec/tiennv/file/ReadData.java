package com.java.spec.tiennv.file;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class ReadData {

	public static void main(String[] args) throws FileNotFoundException {
		File file = new File("score.txt");
		Scanner input = new Scanner(file);
		while (input.hasNext()) {
			String firstName = input.next();
			String lastName = input.next();
			int score = input.nextInt();
			System.out.println(firstName + " " + lastName + " " + score);
		}
		input.close();
	}

}
