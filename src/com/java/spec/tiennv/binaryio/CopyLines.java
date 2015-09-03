package com.java.spec.tiennv.binaryio;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class CopyLines {

	public static void main(String[] args) throws IOException {
		
		try (BufferedReader br = new BufferedReader(new FileReader("src/com/java/spec/tiennv/binaryio/xanadu.txt"));
				PrintWriter outputStream = new PrintWriter(new FileWriter("src/com/java/spec/tiennv/binaryio/characteroutput.txt"))) {
			String line;
			while ((line = br.readLine()) != null) {
				outputStream.println(line);
			}
		}
		
	}

}
