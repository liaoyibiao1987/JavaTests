package com.TestJava;

import java.io.Console;

public class Daikuan {
	private static final double RAT = 0.04557f / 12;
	private static final double Principal = 670000;
	private static final double Month = 360;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("每月还款 : " + getRepayment());
	}

	private static double getRepayment() {
		double x = Math.pow((1 + RAT), Month);
		double y = x - 1;

		double result = Principal * RAT * x / y;
		return result;
	}

}
