package com.ppl.javaIO;

import java.io.*;
import java.util.*;

/*�����ҿ�����������Ĭ�ϵ����л����Ʋ����Ѳ��ݡ�Ȼ��������������Ҫ���ָ���ô���أ����ǿ�������
��İ�ȫ���⣬��ϣ�������ĳһ�������л�������ĳһ���Ӷ�����ȫ�������л�����Ϊ����ָ��Ժ���
һ������Ҫ���´�����*/

class Blip1 implements Externalizable {
	public Blip1() {
		System.out.println("Blip1 Constructor");
	}

	public void writeExternal(ObjectOutput out) throws IOException {
		System.out.println("Blip1.writeExternal");
	}

	public void readExternal(ObjectInput in) throws IOException, ClassNotFoundException {
		System.out.println("Blip1.readExternal");
	}
}

// Blip1 �Ĺ������ǡ������ġ���public����Blip2 �Ĺ�������Ȼ����������ڻָ�ʱ���Υ����
class Blip2 implements Externalizable {
	Blip2() {
		System.out.println("Blip2 Constructor");
	}

	public void writeExternal(ObjectOutput out) throws IOException {
		System.out.println("Blip2.writeExternal");
	}

	public void readExternal(ObjectInput in) throws IOException, ClassNotFoundException {
		System.out.println("Blip2.readExternal");
	}
}

/*
 * �ָ�b1�󣬻���� Blip1 Ĭ�Ϲ�����������ָ�һ��Serializable�������л�������ͬ���ں��ߵ����
 * �£�������ȫ�������������Ķ�����λΪ�����ָ��������ڹ��������á�����һ��Externalizable ������
 * ����ͨ��Ĭ�Ϲ�����Ϊ���ᷢ�����������ֶζ���ʱ�ĳ�ʼ���������һ����readExternal()������ע����
 * һ��ʵ�����ر�ע������Ĭ�ϵĹ�����Ϊ������С�������������Լ��� Externalizable �����в�����ȷ�� ��Ϊ
 */
public class Serializable2Blip {
	public static void main(String[] args) {
		System.out.println("Constructing objects:");
		Blip1 b1 = new Blip1();
		Blip2 b2 = new Blip2();
		try {
			ObjectOutputStream o = new ObjectOutputStream(new FileOutputStream("Blips.out"));
			System.out.println("Saving objects:");
			o.writeObject(b1);
			o.writeObject(b2);
			o.close();
			// Now get them back:
			ObjectInputStream in = new ObjectInputStream(new FileInputStream("Blips.out"));
			System.out.println("Recovering b1:");
			b1 = (Blip1) in.readObject();
			// OOPS! Throws an exception:
			// ! System.out.println("Recovering b2:");
			// ! b2 = (Blip2)in.readObject();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
