package com.ppl.javaIO;

import java.io.*;

public class IOBug {

	/*
	 * ���Ǳ�ǿ��ʹ�����е���ʽ����������ΪDataOutputStream�� DataInputStreamҪ���õ����ǣ�����û�пɹ��滻�Ķ�
	 * ����Ȼ���������ڼ䲻������κΡ����ԡ���Ϣ�������޳�һ����������ͨ�����������Ĺ�����������һ��
	 * ������Ϣ����ֹ����ʹ�������ࡣ����DataInputStream������£�ֻ��readLine()�ǲ��޳�ʹ�õģ���Ϊ �������Ϊ
	 * readLine()ʹ��һ�� BufferedReader����Ϊ�������и�ʽ�����붼ʹ��һ��DataInputStream��
	 */

	//*************************************@SuppressWarnings("DataInputStream readLine()�ǲ��޳�ʹ�õ�")*************************************/
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
	
	/*�������������ڶ�һ�� writeBytes()�ĵ���֮��д����κζ����������ܹ��ָ��ġ�����һ��ʮ�����޵Ĵ�
	��ϣ��������������ʱ���ѻ�ø�����Ϊ����Ƿ����������������������û�еõ�һ��Υ��������
	ֵ������ȷ��ӡ�������ͱ����Ѿ�������*/

}
