package com.TestJava;

public class Printer implements IPrinter {
	@Override
	public void print() {
		System.out.println("彪悍的人生不需要解释是谁说的？");
	}

	@Override
	public void print2(String x) {
		System.out.println(x + "老罗说的。");
	}
}
