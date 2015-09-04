package com.java.spec.tiennv.nio;

import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class FileOperationExample {
	public static void main(String args[]) {
		
		Charset charset = Charset.forName("US-ASCII");
		
		Path file = Paths.get("src/com/java/spec/tiennv/nio/output.txt");
		String s = "This is an example about\nHow to use java nio package";
		
		try (BufferedWriter writer = Files.newBufferedWriter(file, charset)) {
			writer.write(s, 0, s.length());
		} catch (IOException e) {
			e.printStackTrace();
		}
				
	}
} 
