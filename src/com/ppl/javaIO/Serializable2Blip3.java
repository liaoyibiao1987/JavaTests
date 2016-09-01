package com.ppl.javaIO;

import java.io.*;
import java.util.*;

class Blip3 implements Externalizable {
	int i;
	String s; // No initialization

	public Blip3() {
		System.out.println("Blip3 Constructor");
		// s, i not initialized
	}

	public Blip3(String x, int a) {
		System.out.println("Blip3(String x, int a)");
		s = x;
		i = a;
		// s & i initialized only in non-default
		// constructor.
	}

	public String toString() {
		return s + i;
	}

	public void writeExternal(ObjectOutput out) throws IOException {
		System.out.println("Blip3.writeExternal");
		// You must do this:
		out.writeObject(s);
		out.writeInt(i);
	}

	public void readExternal(ObjectInput in) throws IOException, ClassNotFoundException {
		System.out.println("Blip3.readExternal");
		// You must do this:
		s = (String) in.readObject();
		/* �����ִ�У���i�ٱ�read��ʱ��ͱ��0�� */
		//i = in.readInt();
	}

}

/*
 * �ֶ� s�� i ֻ�ڵڶ����������г�ʼ��������Ĭ�Ϲ��������¡�����ζ�ż��粻��readExternal�г� ʼ��s
 * ��i�����Ǿͻ��Ϊnull����Ϊ�ڶ��󴴽��ĵ�һ�����ѽ�����Ĵ洢�ռ����Ϊ 1������ע�͵��� ���ڡ�You must do
 * this����������д��룬�����г��򣬾ͻᷢ�ֵ�����ָ��Ժ�s ��null����i ���㡣 ����һ��Externalizable
 * ����̳У�ͨ����Ҫ����writeExternal()�� readExternal()�Ļ�����汾���Ա� ��ȷ�ر���ͻָ������������
 */
public class Serializable2Blip3 {
	public static void main(String[] args) {
		System.out.println("Constructing objects:");
		Blip3 b3 = new Blip3("A String ", 47);
		System.out.println(b3.toString());
		try {
			ObjectOutputStream o = new ObjectOutputStream(new FileOutputStream("Blip3.out"));
			System.out.println("Saving object:");
			o.writeObject(b3);
			o.close();
			// Now get it back:
			ObjectInputStream in = new ObjectInputStream(new FileInputStream("Blip3.out"));
			System.out.println("Recovering b3:");
			b3 = (Blip3) in.readObject();
			System.out.println(b3.toString());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
