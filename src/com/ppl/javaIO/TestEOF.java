package com.ppl.javaIO;

import java.io.*;

public class TestEOF {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			DataInputStream in = new DataInputStream(new BufferedInputStream(new FileInputStream("C://Python27//README.txt")));
			while (in.available() != 0)
				System.out.print((char) in.readByte());
		} catch (IOException e) {
			System.err.println("IOException");
		}
	}

}
