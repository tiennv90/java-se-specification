package com.java.spec.tiennv.exception;

import java.io.FileNotFoundException;
import java.io.IOException;

public abstract class ParentClassWithMethodThrowsException {
	
	public void read(String text) {
		
	}
	
	public void readAndThrowsException() throws FileNotFoundException {
		
	}
	
	public void readWithInputAndThrowException(String text) throws Exception {
		
	}
	

	public void readAbstract() throws IOException {
		
	}
}
