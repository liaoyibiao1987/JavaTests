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

	//所有的原理和解释，只对基本类型有效
	public static void test2() {
		//自动装箱规范要求boolean, byte, char<=127,-128-127之间的int和short被包装到固定的对象中
		//两个包装类型比较，X/Y的值相等并在-128-127之间，被包装到了固定对象中
		Integer x = 0;
		Integer y = 0;
		System.out.println(x == y);
		
	
		//==运算,在两边是数值类型时，比较两数值是否相等
		int x0 = 123;
		int y0 = 123;
		System.out.println(x0 == y0);		
		
		///==运算，在两边是引用类型时比较两引用是否指向同一对象
		Integer x1 = 433;
		Integer y1 = 433;
		System.out.println(x1 == y1);
		
		//当一边是包装类型另一边是基本类型时，包装类型会自动解包成基本类型来比较
		Integer x2 = 432;
		int y2 = 432;
		System.out.println(x2 == y2);
	}
}
