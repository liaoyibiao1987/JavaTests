package com.ppl.exceptionsTest;


/*
	Java中抛出RuntimeException为什么不用显示声明

	我们知道Java的异常类型体系结构如下：
	
	        	Throwable
	         	/      	\
	 		Exception   Error
	     	/       		\
	      RuntimeException
	
	我们可以看到RuntimeException的继承体系是Exception子类。而Exception还有其它类型的异常，我们统一称为非Runtime异常。RuntimeException的特点是非受检异常，也就是Java系统中允许可以不被catch，在运行时抛出。而其它定非运行时异常如果抛出的话必须显示的catch，否则编译不过。
	
	
	
	那么为什么RuntimeException可以允许不被catch呢？
	
	首先我们可以看看RuntimeException都有哪些子类型：
	
	1 NullPointerException，这个不用多说了。
	
	2 NumberFormatException，字符串转化成数字时。
	
	3 ArrayIndexOutOfBoundsException， 数组越界时。
	
	4 StringIndexOutOfBoundsException， 字符串越界时。
	
	5 ClassCastException，类型转换时。
	
	6 UnsupportedOperationException，该操作不支持，一般子类不实现父类的某些方法时。
	
	7 ArithmeticException，零作为除数等。
	
	8 IllegalArgumentException，表明传递了一个不合法或不正确的参数
	
	
	
	可以看到大多数错误并不是由于程序本身有问题，而是运行时输入在某些case下导致的，有更多的不确定性。而且Java开始的时候并没有异常处理机制，所以从兼容性到实现代价来讲就设计成这个样子了。
*/
public class ThrowTwo {

	public static void f() throws Exception {
		System.out.println("originating the exception in f()");
		throw new Exception("thrown from f()");
	}

	public static void g(String xs) {
		try {
			System.out.println(xs.length());
		} catch (Exception ex) {
			System.out.println("发生错误，没有实例化的对象被使用.");
			// throw new Exception("\n Exception 显示声明.");
			throw new NullPointerException("\n RuntimeException 不用显示声明.");
		}

	}

	public static void main(String[] args) {
		String xs = null;
		g(xs);
		try {
			f();
		} catch (Exception e) {
			System.out.println("Caught in main, e.printStackTrace()");
			e.printStackTrace();
			throw new NullPointerException("\n来自于");
		}
	}
}
