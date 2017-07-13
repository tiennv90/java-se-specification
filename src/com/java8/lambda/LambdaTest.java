package com.java8.lambda;

import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Supplier;

public class LambdaTest {

	public static void main(String[] args) {
		print(() -> "Henri", (String name) -> {
			String s = "Mr " + name;
			return s;
		});

		doSomething(name -> System.out.println(name));
	}
	
	private static void print(Supplier<String> nameSupplier, Function<String, String> decorator) {
		System.out.println("Hello " + decorator.apply(nameSupplier.get()));
	}
	
	private static void doSomething(Consumer<String> consumner) {
		consumner.accept("Henri");
	}

	private interface NameSupplier {
		String get();
	}
}
