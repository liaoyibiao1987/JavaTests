package com.keywords;

/*C#�о�̬���java�о�̬���ǲ�ͬ��


java
	��̬���staticֻ�ܳ����ھ�̬�ڲ��࣬��ͨ����û��static�ؼ������εģ�ֱ�ӿ��Ե���̬��ʹ�ã�
	��̬�ڲ�����Լ̳л���ʵ�ֽӿ�
	static�����ھ�̬�ڲ���֮�󣬾�ֻ�ܷ����ⲿ��ľ�̬��Ա
	java�ľ�̬�ڲ���----����-----ʵ����
	
C#
	
	��̬���ǲ���ʵ�����ģ�����ֱ��ʹ�����������뷽��
	��̬��Ĭ�ϼ̳���System.Object���࣬������ʽָ���κ��������ࡣҲ���ܱ��̳С�C#������������ӿڰ�����̬��Ա��
	��̬���е����г�Ա�����Ǿ�̬�ġ���̬������о�̬���캯������̬���캯�����ɼ̳С�
	��̬���캯���������ھ�̬�࣬Ҳ�����ڷǾ�̬�ࡣ
	��̬���캯���޷������η����޲�����ֻ��һ�� static ��־��
	��̬���캯�����ɱ�ֱ�ӵ��ã���������ʵ���������κξ�̬��Ա֮ǰ����̬���캯�����Զ�ִ�У�����ִֻ��һ�Ρ�
*/

//static�ؼ���ֻ�ܳ������ڲ����У���ͨ���������Ϊ����һ����̬��
public class StaticClass {
	public static void TestStatic() {
		System.out.println("xxxx");
	}

	public class HotDog extends UnnamedInnerClass.Dog {
		// ! HotDog() {} // ���ܱ���
		HotDog(UnnamedInnerClass wi) {
			//wi.super();
		}
	}

	public static void main(String[] arg) {
		UnnamedInnerClass cl = new UnnamedInnerClass();
		UnnamedInnerClass.Fox fox = cl.new Fox(); // ��ͨ�ڲ���
		fox.beFriendly();

		UnnamedInnerClass.Dog dog = new UnnamedInnerClass.Dog(); // ��̬�ڲ���
		dog.beFriendly();
	}
}
