package com.ppl.javaIO;

import java.io.*;

public class IOBug {

	/*
	 * 我们被强迫使用所有的老式数据流，因为DataOutputStream和 DataInputStream要求用到它们，而且没有可供替换的东
	 * 西。然而，编译期间不会产生任何“反对”信息。若不赞成一种数据流，通常是由于它的构建器产生了一条
	 * 反对消息，禁止我们使用整个类。但在DataInputStream的情况下，只有readLine()是不赞成使用的，因为 我们最好为
	 * readLine()使用一个 BufferedReader（但为其他所有格式化输入都使用一个DataInputStream）
	 */

	//*************************************@SuppressWarnings("DataInputStream readLine()是不赞成使用的")*************************************/
	public static void main(String[] args) throws Exception {
		DataOutputStream out = new DataOutputStream(new BufferedOutputStream(new FileOutputStream("Data.txt")));
		out.writeDouble(3.14159);
		out.writeBytes("That was the value of pi\n");
		out.writeBytes("This is pi/2:\n");
		out.writeDouble(3.14159 / 2);
		out.close();
		DataInputStream in = new DataInputStream(new BufferedInputStream(new FileInputStream("Data.txt")));
		/*************************************in.readLine();*************************************/
		BufferedReader inbr = new BufferedReader(new InputStreamReader(in));
		// The doubles written BEFORE the line of text
		// read back correctly:
		System.out.println(in.readDouble());
		// Read the lines of text:
		System.out.println(inbr.readLine());
		System.out.println(inbr.readLine());
		// Trying to read the doubles after the line
		// produces an end-of-file exception:
		System.out.println(in.readDouble());
	}
	
	/*看起来，我们在对一个 writeBytes()的调用之后写入的任何东西都不是能够恢复的。这是一个十分有限的错
	误，希望在你读到本书的时候已获得改正。为检测是否改正，请运行上述程序。若没有得到一个违例，而且
	值都能正确打印出来，就表明已经改正。*/

}
