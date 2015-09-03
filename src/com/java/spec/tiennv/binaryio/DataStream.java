package com.java.spec.tiennv.binaryio;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class DataStream {

	/**
	 * 
	 * Data streams support binary I/O of primitive data type values 
	 * (boolean, char, byte, short, int, long, float, and double) as 
	 * well as String values
	 * 
	 * https://docs.oracle.com/javase/tutorial/essential/io/datastreams.html
	 */
	

	static final double[] prices = { 19.99, 9.99, 15.99, 3.99, 4.99 };
	static final int[] units = { 12, 8, 13, 29, 50 };
	static final String[] descs = {
	    "Java T-shirt",
	    "Java Mug",
	    "Duke Juggling Dolls",
	    "Java Pin",
	    "Java Key Chain"
	};
	
	public static void main(String[] args) {
		
		//write binary file
		try (
			DataOutputStream dataOutPutStream = new DataOutputStream
					(new BufferedOutputStream(
							new FileOutputStream("src/com/java/spec/tiennv/binaryio/output1.dat")))) {
			
			for (int i = 0; i < prices.length; i++) {
				dataOutPutStream.writeDouble(prices[i]);
				dataOutPutStream.writeInt(units[i]);
				dataOutPutStream.writeUTF(descs[i]);
			}
			
		} catch(IOException e) {
			e.printStackTrace();
		}
		
		//read binary file
		double price;
		int unit;
		String desc;
		
		try (DataInputStream dataInputStream = new DataInputStream(
				new BufferedInputStream(new FileInputStream("src/com/java/spec/tiennv/binaryio/output1.dat")))) {
			while(true) {
				price = dataInputStream.readDouble();
				unit = dataInputStream.readInt();
				desc = dataInputStream.readUTF();
				System.out.format("Your ordered %d" + " units of %s at $%.2f%n", unit, desc, price);
			}
			
		} catch (EOFException e) {
			System.out.println("your file was read sucessfully!");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
