package com.TestJava;

public class Printer implements IPrinter {
	@Override
	public void print() {
		System.out.println("�뺷����������Ҫ������˭˵�ģ�");
	}

	@Override
	public void print2(String x) {
		System.out.println(x + "����˵�ġ�");
	}
}
