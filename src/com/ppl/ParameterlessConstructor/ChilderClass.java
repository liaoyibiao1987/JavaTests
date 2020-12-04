package com.ppl.ParameterlessConstructor;

public class ChilderClass extends BaseClass {

	/*
	 * 父类没有不带参数的构造器(或者为private)，并且在子类的构造器中又没有显式地调用父类的构造器，则java编译器将报告错误
	 */
	public ChilderClass() {
		// 编译器规定,使用super调用父类构造器的语句必须是子类构造器的第一条语句.
		super("ChilderClass");
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("ChilderClass");
	}

}
