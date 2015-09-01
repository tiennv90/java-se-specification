package com.java.spec.tiennv.java.lang;

import java.io.File;
import java.io.IOException;
import java.lang.ProcessBuilder.Redirect;
import java.util.Map;

public class ProcessBuilderExmple {
	public static void main(String args[]) throws IOException {
		ProcessBuilder processBuilder = new ProcessBuilder("myCommand", "myArg1", "myArg2");
		
		Map<String, String> env = processBuilder.environment();
		
		 env.put("VAR1", "myValue");
		 env.remove("OTHERVAR");
		 env.put("VAR2", env.get("VAR1") + "suffix");
		 
		 processBuilder.directory(new File("text.txt"));
		 
		 File log = new File("log");
		 processBuilder.redirectErrorStream(true);
		 processBuilder.redirectOutput(log);
		 
		 Process p = processBuilder.start();
		 
		 assert processBuilder.redirectInput() == Redirect.PIPE;
		 assert processBuilder.redirectOutput().file() == log;
		 assert p.getInputStream().read() == -1;
		 
	}
}
