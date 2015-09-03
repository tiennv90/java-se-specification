package com.java.spec.tiennv.binaryio;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class CopyCharacters {

	public static void main(String args[]) throws IOException {
		
		try (FileReader inputStream = new FileReader("src/com/java/spec/tiennv/binaryio/xanadu.txt"); 
				FileWriter outputStream = new FileWriter("src/com/java/spec/tiennv/binaryio/characteroutput.txt")) {
			int c;
			while ((c = inputStream.read()) != -1) {
				outputStream.write(c);
			}
		}
	}

}
