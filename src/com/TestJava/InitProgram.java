package com.TestJava;

import java.net.URL;
import com.keywords.FinalArgument;
import com.keywords.*;

public class InitProgram {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		System.out.println("����ʼ... ...");
		TestFinal();
		// TestJVM();
		// CustomClassTest.TestLoader();
	}

	// �޷�����TestDefualt��Ĭ��Ϊ���ڿ��Լ�
	public static void name() {
		// com.ppl.TestJava.TestDefaultAccess td = new
		// com.ppl.TestJava.TestDefaultAccess();
		// td.TestDefualt();

		// TestDefualtDelimiter tdd = new TestDefualtDelimiter();
	}

	public static void TestJVM() {
		ClassLoader cl = Thread.currentThread().getContextClassLoader();
		URL[] urls = sun.misc.Launcher.getBootstrapClassPath().getURLs();
		for (int i = 0; i < urls.length; i++) {
			System.out.println(urls[i].toExternalForm());
		}
	}

	public static void TestFinal() {
		FinalArgument fArgument = new FinalArgument();
		// g ������θ�ֵ����null �˴��д�
		// fArgument.without(new Gizmo());
		// fArgument.with(null);
		fArgument.with(new Gizmo());
		System.out.println("���� ��������" + fArgument.g(100));
	}

	public static void TestInnerClass() {
		InnerClass p = new InnerClass();
		p.ship("Tanzania");
		InnerClass q = new InnerClass();
		// Defining handles to inner classes:
		InnerClass.Contents c = q.cont();
		/* �޷������ڲ��� */
		// InnerClass.Contents cc = new InnerClass.Contents();
		InnerClass.Destination d = q.to("Borneo");
	}

	public static void TestInterface() {
		int i = IInterfaceProperty.JANUARY;
	}
}
