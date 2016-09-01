package com.ppl.javaIO;

import java.io.*;

class Data implements Serializable {
	private int i;

	Data(int x) {
		i = x;
	}

	public String toString() {
		return Integer.toString(i);
	}
}
/*
 * ������������Ӷ����һ����Worm������棩��ÿ��������Worm �е���һ���� �ӣ�ͬʱ�������ڲ�ͬ�ࣨData���Ķ�������������
 * ����Ȥ���ǣ�Worm �ڵ�Data ������������������ֳ�ʼ���ģ������㲻�û��ɱ�����������ĳ��ԭʼ�� Ϣ����ÿ�� Worm �ζ���һ�� Char
 * ��ǡ����Char �����ظ��������ӵ� Worm �б�ʱ�Զ������ġ�����һ�� Worm
 * ʱ������߹�����ϣ�����ж೤��Ϊ������һ�������next�����������ü�ȥ 1 �ĳ���������Worm �����������һ��next
 * ����򱣳�Ϊnull���գ�����ʾ�ѵִ� Worm ��β���� ��������в�������Ϊ�˼�������ĸ��ӳ̶ȣ��Ӵ�������л����Ѷȡ�Ȼ�������������л�����ȴ�Ƿǳ�
 * �򵥵ġ�һ��������ĳ�����ﴴ����ObjectOutputStream��writeObject()�ͻ����л�����ע��Ҳ����Ϊ һ��String����
 * writeObject()�����ʹ����DataOutputStream ��ͬ�ķ���д�����л����������ͣ����� ����ͬ�Ľӿڣ���
 * ������������try�鿴���������Ƶġ���һ����д�����ļ�������һ����д����һ�� ByteArray���ֽ��� �飩�������ö��κ�DataInputStream
 * ����DataOutputStream�����л�����д�ض��Ķ��������ڹ������� ����һ�»ὲ������������Щ���������������硣
 */

/*
 * ���Կ�����װ���ԭ״�Ķ���ȷʵ������ԭ���Ǹ�������������������ӡ�
 * ע���ڶ�һ��Serializable�������л��������������װ��Ĺ����У�
 * 
 * ��������κι�����������Ĭ�Ϲ���������
 * 
 * ����������ͨ����InputStream��ȡ�����ݻָ��ġ� ��ΪJava 1.1���Ե�һ�֣�����ע�⵽��������л����������µ� Reader��
 * Writer��νṹ��һ���֣��� ��������ʽ��InputStream ��OutputStream �ṹ��������һЩ����ĳ����£����ò����ʹ���������͵Ĳ�
 * �νṹ��
 */

public class SerializableWorm implements Serializable {
	private static int r() {
		return (int) (Math.random() * 10);
	}

	private Data[] d = { new Data(r()), new Data(r()), new Data(r()) };
	private SerializableWorm next;
	private char c;

	// Value of i == number of segments
	SerializableWorm(int i, char x) {
		System.out.println(" Worm constructor: " + i);
		c = x;
		if (--i > 0)
			next = new SerializableWorm(i, (char) (x + 1));
	}

	SerializableWorm() {
		System.out.println("Default constructor");
	}

	public String toString() {
		String s = ":" + c + "(";
		for (int i = 0; i < d.length; i++)
			s += d[i].toString();
		s += ")";
		if (next != null)
			s += next.toString();
		return s;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SerializableWorm w = new SerializableWorm(6, 'a');
		System.out.println("w = " + w);
		try {
			ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("worm.txt"));
			out.writeObject("Worm storage");
			out.writeObject(w);
			out.close(); // Also flushes output
			ObjectInputStream in = new ObjectInputStream(new FileInputStream("worm.txt"));
			String s = (String) in.readObject();
			SerializableWorm w2 = (SerializableWorm) in.readObject();
			System.out.println(s + ", w2 = " + w2);
		} catch (Exception e) {
			e.printStackTrace();
		}
		try {
			ByteArrayOutputStream bout = new ByteArrayOutputStream();
			ObjectOutputStream out = new ObjectOutputStream(bout);
			out.writeObject("Worm storage");
			out.writeObject(w);
			out.flush();
			ObjectInputStream in = new ObjectInputStream(new ByteArrayInputStream(bout.toByteArray()));
			String s = (String) in.readObject();
			SerializableWorm w3 = (SerializableWorm) in.readObject();
			System.out.println(s + ", w3 = " + w3);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
