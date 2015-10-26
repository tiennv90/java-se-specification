package com.java.spec.tiennv.exception;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.SQLException;

public class ChildClassWithMethodThrowsException extends ParentClassWithMethodThrowsException {

	/**
	 * Runtime Exception like IllegalArgumentException can be thrown on subclass
	 * whereas the parent class does not throws the Exception.
	 */
	@Override
	public void read(String text) throws IllegalArgumentException {

	}

	@Override
	public void readAndThrowsException() {
	}

	@Override
	public void readWithInputAndThrowException(String text) {
	}

	/**
	 * This does not allowed SQLException does not extend IOException
	 */
//	@Override
//	public void readAbstract() throws SQLException {
//		
//	}
	
	/**
	 * This allowed FileNotFoundException extends IOException
	 */
//	@Override
//	public void readAbstract() throws FileNotFoundException {
//		
//	}
	
	/**
	 * This allowed because they are RuntimeException
	 */
	@Override
	public void readAbstract() throws ArrayStoreException, IllegalArgumentException {
	}
}
