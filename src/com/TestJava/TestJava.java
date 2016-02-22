package com.TestJava;

import java.net.URL;

public class TestJava {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("1111");
		//TestJVM();
		//CustomClassTest.TestLoader();
	}

	public static void TestJVM() {
		ClassLoader cl = Thread.currentThread().getContextClassLoader();
		URL[] urls = sun.misc.Launcher.getBootstrapClassPath().getURLs();
		for (int i = 0; i < urls.length; i++) {
			System.out.println(urls[i].toExternalForm());
		}
	}
}
