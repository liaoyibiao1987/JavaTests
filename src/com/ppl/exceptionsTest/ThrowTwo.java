package com.ppl.exceptionsTest;

import com.sun.management.jmx.Trace;
import com.sun.org.apache.xml.internal.resolver.helpers.Debug;

public class ThrowTwo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub   
		String x = null;
		TestNull(x);
	}

	public static void TestNull(String x) {
		try {
			byte[] xy = x.getBytes();
		} catch (Exception se) {
			se.printStackTrace();
			System.out.println(se + "ÀÏÂÞËµµÄ¡£");
		}
	}
}
