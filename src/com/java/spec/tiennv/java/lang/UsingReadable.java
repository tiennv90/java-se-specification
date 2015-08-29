package com.java.spec.tiennv.java.lang;

import java.io.IOException;
import java.nio.CharBuffer;

public class UsingReadable {

}

class MyReadable implements Readable {

	@Override
	public int read(CharBuffer cb) throws IOException {
		return 0;
	}
	
}