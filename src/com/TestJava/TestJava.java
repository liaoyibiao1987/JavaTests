package com.TestJava;

import java.net.URL;

public class TestJava {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("程序开始... ...");
		// TestJVM();
		// CustomClassTest.TestLoader();
	}

	// 无法访问TestDefualt，默认为包内可以见
	public static void name() {
		// com.ppl.TestJava.TestDefaultAccess td = new
		// com.ppl.TestJava.TestDefaultAccess();
		// td.TestDefualt();
		
		//TestDefualtDelimiter tdd = new TestDefualtDelimiter();
	}

	public static void TestJVM() {
		ClassLoader cl = Thread.currentThread().getContextClassLoader();
		URL[] urls = sun.misc.Launcher.getBootstrapClassPath().getURLs();
		for (int i = 0; i < urls.length; i++) {
			System.out.println(urls[i].toExternalForm());
		}
	}
}
