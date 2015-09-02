package com.java.spec.tiennv.java.lang;

import java.io.IOException;
import java.io.InputStream;

public class ProcessExample {

	//http://www.java-tips.org/java-se-tips-100019/88888889-java-util/426-from-runtimeexec-to-processbuilder.html
	public static void main(String[] args) {
		
		try {
			System.out.println("Creating process");
			Process p = Runtime.getRuntime().exec("sudo service tomcat7 stops");
			
			InputStream inputStream = p.getInputStream();
			for (int i = 0; i < inputStream.available(); i ++) {
				System.out.println("" + inputStream.read());
			}
			
			Thread.sleep(10000);
			
			p.destroy();
		} catch (IOException | InterruptedException e) {
			e.printStackTrace();
		}
	}

}
