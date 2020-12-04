package com.ppl.exceptionsTest;


public class ThrowOne {

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
			System.out.println(se + "老罗说的。");
		}
	}
}
