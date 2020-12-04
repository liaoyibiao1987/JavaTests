package com.ppl.javaIO;

import java.io.BufferedInputStream;
import java.io.DataInputStream;
import java.io.IOException;

public class Echo {

	public static void main(String[] args) {
		// TODO 自动生成的方法存根
		DataInputStream in = new DataInputStream(new BufferedInputStream(System.in));
		String s;
		try {
			while ((s = in.readLine()).length() != 0)
				System.out.println(s);
			// An empty line terminates the program
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
