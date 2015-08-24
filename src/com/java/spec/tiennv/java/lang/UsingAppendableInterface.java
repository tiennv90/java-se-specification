package com.java.spec.tiennv.java.lang;

import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;

public class UsingAppendableInterface {

	public static void main(String[] args) throws IOException {

		Expr e1 = new Cst("s1");
		Expr e2 = new Cst("s2");
		Expr expr = new Add(e1, e2);

		expr.output(System.out);
		System.out.println();

		StringBuilder sb = new StringBuilder();
		expr.output(sb);

		String s = sb.toString();
		System.out.println(s);

		Writer wr = new FileWriter("expr.txt");
		expr.output(wr);
		wr.append("\n");

	}

}


abstract class Expr {
	public abstract Appendable output(Appendable sink) throws IOException;
}

class Cst extends Expr {

	String s;

	public Cst(String s) {
		this.s = s;
	}

	@Override
	public Appendable output(Appendable sink) throws IOException {
		sink.append('e');
		return sink;
	}
}

class Add extends Expr {
	Expr e1, e2;

	public Add(Expr e1, Expr e2) {
		this.e1 = e1;
		this.e2 = e2;
	}

	public Appendable output(Appendable sink) throws IOException {
		sink.append('(');
		e1.output(sink);
		sink.append('+');
		e2.output(sink);
		sink.append(')');
		return sink;
	}
}
