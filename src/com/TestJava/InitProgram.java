package com.TestJava;

import java.net.URL;
import com.keywords.FinalArgument;
import com.ppl.grammars.*;
import com.keywords.*;

public class InitProgram {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		InnerClass2.TestInner2();
		System.out.println("程序开始... ...");
		TestFinal();
		TestInnerClass2();
		// TestJVM();
		// CustomClassTest.TestLoader();
	}

	// 无法访问TestDefualt，默认为包内可以见
	public static void name() {
		// com.ppl.TestJava.TestDefaultAccess td = new
		// com.ppl.TestJava.TestDefaultAccess();
		// td.TestDefualt();

		// TestDefualtDelimiter tdd = new TestDefualtDelimiter();
	}

	public static void TestJVM() {
		/*ClassLoader cl = Thread.currentThread().getContextClassLoader();
		URL[] urls = sun.misc.Launcher.getBootstrapClassPath().getURLs();
		for (int i = 0; i < urls.length; i++) {
			System.out.println(urls[i].toExternalForm());
		}*/
	}

	public static void TestFinal() {
		FinalArgument fArgument = new FinalArgument();
		// g 无论如何赋值都是null 此处有错
		// fArgument.without(new Gizmo());
		// fArgument.with(null);
		fArgument.with(new Gizmo());
		System.out.println("测试 计算结果：" + fArgument.g(100));
	}

	public static void TestInnerClass() {
		InnerClass p = new InnerClass();
		p.ship("Tanzania");
		InnerClass q = new InnerClass();
		// Defining handles to inner classes:
		InnerClass.Contents c = q.cont();
		/* 无法访问内部类 */
		// InnerClass.Contents cc = new InnerClass.Contents();
		InnerClass.Destination d = q.to("Borneo");
	}

	/*
	 * public Destination dest(final String dest, final float price) { return
	 * new Destination() { private int cost;
	 * 
	 * // Instance initialization for each object: { cost = Math.round(price);
	 * if (cost > 100) System.out.println("Over budget!"); }
	 * 
	 * private String label = dest;
	 * 
	 * public String readLabel() { return label; } }; }
	 */

	public static void TestInterface() {
		int i = IInterfaceProperty.JANUARY;
	}

	public static void TestInnerClass2() {
		Sequence s = new Sequence(10);
		for (int i = 0; i < 10; i++)
			s.add(Integer.toString(i));
		Selector sl = s.getSelector();
		while (!sl.end()) {
			System.out.println((String) sl.current());
			sl.next();
		}
	}

}
