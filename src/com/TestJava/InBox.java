package com.TestJava;

public class InBox {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		test2();
	}

	public static void add(Byte b) {
		b = b++;
	}

	public static void test() {
		Byte a = 127;
		Byte b = 127;
		add(++a);
		System.out.print(a + " ");
		add(b);
		System.out.print(b + "");
	}

	//���е�ԭ��ͽ��ͣ�ֻ�Ի���������Ч
	public static void test2() {
		//�Զ�װ��淶Ҫ��boolean, byte, char<=127,-128-127֮���int��short����װ���̶��Ķ�����
		//������װ���ͱȽϣ�X/Y��ֵ��Ȳ���-128-127֮�䣬����װ���˹̶�������
		Integer x = 0;
		Integer y = 0;
		System.out.println(x == y);
		
	
		//==����,����������ֵ����ʱ���Ƚ�����ֵ�Ƿ����
		int x0 = 123;
		int y0 = 123;
		System.out.println(x0 == y0);		
		
		///==���㣬����������������ʱ�Ƚ��������Ƿ�ָ��ͬһ����
		Integer x1 = 433;
		Integer y1 = 433;
		System.out.println(x1 == y1);
		
		//��һ���ǰ�װ������һ���ǻ�������ʱ����װ���ͻ��Զ�����ɻ����������Ƚ�
		Integer x2 = 432;
		int y2 = 432;
		System.out.println(x2 == y2);
	}
}
