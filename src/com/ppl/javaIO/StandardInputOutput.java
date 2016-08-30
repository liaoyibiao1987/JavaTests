package com.ppl.javaIO;

import java.io.*;
import java.util.Arrays;

import com.sun.xml.internal.bind.v2.runtime.unmarshaller.XsiNilLoader.Array;

public class StandardInputOutput {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Ir();
	}

	public static void Ir() {
		char[] buff = new char[5];
		InputStreamReader ir = new InputStreamReader(System.in);
		System.out.println("Unixϵͳ: ctrl-d �� ctrl-c �˳�" + "\nWindowsϵͳ: ctrl-z �˳�");
		try {
			// ��һ�����ݣ�����׼�������ʾ��
			int x = ir.read(buff);
			// readLine()��������ʱ������I/O���󣬽��׳�IOException�쳣
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
			// �رջ����Ķ���
			//ir.close();
		} catch (IOException e) { // Catch any IO exceptions.
			e.printStackTrace();
		}
	}

	public static void In() {
		String s;
		InputStreamReader ir = new InputStreamReader(System.in);
		BufferedReader in = new BufferedReader(ir);
		System.out.println("Unixϵͳ: ctrl-d �� ctrl-c �˳�" + "\nWindowsϵͳ: ctrl-z �˳�");
		try {
			// ��һ�����ݣ�����׼�������ʾ��
			s = in.readLine();
			// readLine()��������ʱ������I/O���󣬽��׳�IOException�쳣
			while (s != null) {
				System.out.println("Read: " + s);
				s = in.readLine();
			}
			// �رջ����Ķ���
			in.close();
		} catch (IOException e) { // Catch any IO exceptions.
			e.printStackTrace();
		}
	}
}
