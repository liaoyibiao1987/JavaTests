package com.ppl.exceptionsTest;

import java.util.jar.JarException;

import com.sun.management.jmx.Trace;
import com.sun.org.apache.xml.internal.resolver.helpers.Debug;

/*
	Java���׳�RuntimeExceptionΪʲô������ʾ����

	����֪��Java���쳣������ϵ�ṹ���£�
	
	        	Throwable
	         	/      	\
	 		Exception   Error
	     	/       		\
	      RuntimeException
	
	���ǿ��Կ���RuntimeException�ļ̳���ϵ��Exception���ࡣ��Exception�����������͵��쳣������ͳһ��Ϊ��Runtime�쳣��RuntimeException���ص��Ƿ��ܼ��쳣��Ҳ����Javaϵͳ��������Բ���catch��������ʱ�׳�����������������ʱ�쳣����׳��Ļ�������ʾ��catch��������벻����
	
	
	
	��ôΪʲôRuntimeException����������catch�أ�
	
	�������ǿ��Կ���RuntimeException������Щ�����ͣ�
	
	1 NullPointerException��������ö�˵�ˡ�
	
	2 NumberFormatException���ַ���ת��������ʱ��
	
	3 ArrayIndexOutOfBoundsException�� ����Խ��ʱ��
	
	4 StringIndexOutOfBoundsException�� �ַ���Խ��ʱ��
	
	5 ClassCastException������ת��ʱ��
	
	6 UnsupportedOperationException���ò�����֧�֣�һ�����಻ʵ�ָ����ĳЩ����ʱ��
	
	7 ArithmeticException������Ϊ�����ȡ�
	
	8 IllegalArgumentException������������һ�����Ϸ�����ȷ�Ĳ���
	
	
	
	���Կ�����������󲢲������ڳ����������⣬��������ʱ������ĳЩcase�µ��µģ��и���Ĳ�ȷ���ԡ�����Java��ʼ��ʱ��û���쳣������ƣ����ԴӼ����Ե�ʵ�ִ�����������Ƴ���������ˡ�
*/
public class ThrowTwo {

	public static void f() throws Exception {
		System.out.println("originating the exception in f()");
		throw new Exception("thrown from f()");
	}

	public static void g(String xs) {
		try {
			System.out.println(xs.length());
		} catch (Exception ex) {
			System.out.println("��������û��ʵ�����Ķ���ʹ��.");
			// throw new Exception("\n Exception ��ʾ����.");
			throw new NullPointerException("\n RuntimeException ������ʾ����.");
		}

	}

	public static void main(String[] args) {
		String xs = null;
		g(xs);
		try {
			f();
		} catch (Exception e) {
			System.out.println("Caught in main, e.printStackTrace()");
			e.printStackTrace();
			throw new NullPointerException("\n������");
		}
	}
}
