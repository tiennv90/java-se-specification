package com.java.spec.tiennv.binaryio;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.math.BigDecimal;

public class ObjectStreamExample {

	/**
	 * object streams support I/O of objects
	 */
	static final BigDecimal[] prices = { 
			new BigDecimal(19.99), 
			new BigDecimal( 9.99), 
			new BigDecimal(15.99), 
			new BigDecimal(3.99), 
			new BigDecimal(4.99) 
		};
	static final int[] units = { 12, 8, 13, 29, 50 };
	static final String[] descs = {
	    "Java T-shirt",
	    "Java Mug",
	    "Duke Juggling Dolls",
	    "Java Pin",
	    "Java Key Chain"
	};
	
	public static void main(String[] args) {
		//write binary file with BigDecimal object
		try (
			ObjectOutputStream objectOutputStream = new ObjectOutputStream
					(new BufferedOutputStream(
							new FileOutputStream("src/com/java/spec/tiennv/binaryio/output2.dat")))) {
			
			for (int i = 0; i < prices.length; i++) {
				objectOutputStream.writeObject(prices[i]);
				objectOutputStream.writeInt(units[i]);
				objectOutputStream.writeUTF(descs[i]);
			}
			
		} catch(IOException e) {
			e.printStackTrace();
		}
		
		//read binary file with BigDecimal object
		BigDecimal price;
		int unit;
		String desc;
		
		try (ObjectInputStream objectInputStream = new ObjectInputStream(
				new BufferedInputStream(new FileInputStream("src/com/java/spec/tiennv/binaryio/output2.dat")))) {
			while(true) {
				price = (BigDecimal) objectInputStream.readObject();
				unit = objectInputStream.readInt();
				desc = objectInputStream.readUTF();
				System.out.format("Your ordered %d" + " units of %s at $%.2f%n", unit, desc, price);
			}
			
		} catch (EOFException e) {
			System.out.println("your file was read sucessfully!");
		} catch (IOException | ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

}
