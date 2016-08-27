package com.TestJava;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
//�εεεεε�///
public class CustomClassTest {
	public static void TestLoader() {
		String name = "com.TestJava.Printer";
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		IPrinter printer = null;
		while (true) {
			System.out.println("���������ַ������ȼ��أ�ֱ���ûس����˳�����");
			try {
				String line = reader.readLine();
				if (line != null && line.length() > 0) {
					MyClassLoader loader = new MyClassLoader(Thread.currentThread().getContextClassLoader(), name);
					Class<?> clazz = loader.loadClass();
					/**
					 * ���Ӽ��������ص���ӵ�б������������ص���Ŀɼ��� Printer�����Զ�������������صģ�
					 * �����ĸ���IPrinter����ϵͳ����������صģ� ���IPrinter����Printer���пɼ��ԣ�
					 * ���ת�ͳɹ�����������Ϊ���������ͬ����ClassCastException�쳣     
					 */
					printer = (IPrinter) clazz.newInstance();
					/** �����Ƿ��ȼ��سɹ��� **/
					printer.print();
				} else {
					break;
				}
			} catch (IOException e) {
				e.printStackTrace();
			} catch (InstantiationException e) {
				e.printStackTrace();
			} catch (IllegalAccessException e) {
				e.printStackTrace();
			}
		}
	}
}
