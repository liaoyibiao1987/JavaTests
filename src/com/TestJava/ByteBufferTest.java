package com.TestJava;

import java.nio.ByteBuffer;

public class ByteBufferTest {

	private static ByteBuffer bf1;
	private static ByteBuffer bf2;

	static void TestBuffer() {
		byte[] b1 = new byte[] { 1, 2, 3 };
		byte[] b2 = new byte[] { 4, 5, 6 };
		bf1 = ByteBuffer.wrap(b1);
		bf2 = ByteBuffer.wrap(b2);

		bf1.put(b2);
		while (true) {
			System.err.println("@@@@@@@@@" + bf1.get());
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TestBuffer();
	}

}
