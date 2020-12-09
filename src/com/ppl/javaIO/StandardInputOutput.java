package com.ppl.javaIO;

import java.io.*;
import java.util.Arrays;


public class StandardInputOutput {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Ir();
	}

	public static void Ir() {
		char[] buff = new char[5];
		InputStreamReader ir = new InputStreamReader(System.in);
		System.out.println("Unix系统: ctrl-d 或 ctrl-c 退出" + "\nWindows系统: ctrl-z 退出");
		try {
			// 读一行数据，并标准输出至显示器
			int x = ir.read(buff);
			// readLine()方法运行时若发生I/O错误，将抛出IOException异常
			while (true) {
				//buff.toString() == getClass().getName() + '@' + Integer.toHexString(hashCode())
				System.out.println(buff.getClass().getName()+ "$$" + Integer.toHexString(buff.hashCode()));
				System.out.println("Read 1:  " + buff);
				System.out.println("Read 2:  " + Arrays.toString(buff));
				CharSequence delimiter = new CharSequence() {
					
					@Override
					public CharSequence subSequence(int start, int end) {
						// TODO Auto-generated method stub
						return null;
					}
					
					@Override
					public int length() {
						// TODO Auto-generated method stub
						return 0;
					}
					
					@Override
					public char charAt(int index) {
						// TODO Auto-generated method stub
						return 0;
					}
				};
				//System.out.println("Read 2:  " + String.join(delimiter, null));
				System.out.println("Read 3: " + String.valueOf(buff));
				 x = ir.read(buff);
			}
			// 关闭缓冲阅读器
			//ir.close();
		} catch (IOException e) { // Catch any IO exceptions.
			e.printStackTrace();
		}
	}

	public static void In() {
		String s;
		InputStreamReader ir = new InputStreamReader(System.in);
		BufferedReader in = new BufferedReader(ir);
		System.out.println("Unix系统: ctrl-d 或 ctrl-c 退出" + "\nWindows系统: ctrl-z 退出");
		try {
			// 读一行数据，并标准输出至显示器
			s = in.readLine();
			// readLine()方法运行时若发生I/O错误，将抛出IOException异常
			while (s != null) {
				System.out.println("Read: " + s);
				s = in.readLine();
			}
			// 关闭缓冲阅读器
			in.close();
		} catch (IOException e) { // Catch any IO exceptions.
			e.printStackTrace();
		}
	}
}
