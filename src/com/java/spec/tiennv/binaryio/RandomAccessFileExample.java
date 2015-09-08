package com.java.spec.tiennv.binaryio;

import java.io.IOException;
import java.io.RandomAccessFile;

public class RandomAccessFileExample {

	public static void main(String[] args) throws IOException {
		
		RandomAccessFile inout = new RandomAccessFile("src/com/java/spec/tiennv/binaryio/inout.dat", "rw");
		inout.setLength(0);
		
		for (int i = 0; i < 200; i++) {
			inout.writeInt(i);
		}
		
		//print the length of file (byte)
		System.out.println("Current file length is: " + inout.length());
		
		//move file pointer to first position
		inout.seek(0);
		//read the first number and move file pointer to second number
		System.out.println("The first number is: " + inout.readInt());

		//move file pointer to 4th position
		inout.seek(1 * 4);
		//read the second number and move file pointer to 3rd number
		System.out.println("The second number is: " + inout.readInt());
		
		//move file pointer to 36th position
		inout.seek(9 * 4);
		//read 10th number and move file pointer to 11th number
		System.out.println("The tenth number is: " + inout.readInt());
		
		//write 555 as 11th number
		inout.writeInt(555);
		
		//move to file pointer to the end of file
		inout.seek(inout.length());
		//write 999 to the end of file, length of file is increased by 4
		inout.writeInt(999);
		
		//print the new file length
		System.out.println("The new length is: " + inout.length());
		
		//move file pointer to 11th number
		inout.seek(10 * 4);
		//print 11th number and move file pointer 12th number 
		System.out.println("The eleventh number is: " + inout.readInt());
		
		inout.close();
	}

	
}
