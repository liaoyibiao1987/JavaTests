package com.keywords;

/*C#中静态类和java中静态类是不同的


java
	静态类的static只能出现在静态内部类，普通类是没有static关键字修饰的（直接可以当静态类使用）
	静态内部类可以继承或者实现接口
	static出现在静态内部类之后，就只能访问外部类的静态成员
	java的静态内部类----可以-----实例化
	
C#
	
	静态类是不能实例化的，我们直接使用它的属性与方法
	静态类默认继承自System.Object根类，不能显式指定任何其他基类。也不能被继承。C#编译器不允许接口包括静态成员！
	静态类中的所有成员必须是静态的。静态类可以有静态构造函数，静态构造函数不可继承。
	静态构造函数可以用于静态类，也可用于非静态类。
	静态构造函数无访问修饰符、无参数，只有一个 static 标志。
	静态构造函数不可被直接调用，当创建类实例或引用任何静态成员之前，静态构造函数被自动执行，并且只执行一次。
*/

//static关键字只能出现在内部类中，普通的类可以认为就是一个静态类
public class StaticClass {
	public static void TestStatic() {
		System.out.println("xxxx");
	}

	public class HotDog extends UnnamedInnerClass.Dog {
		// ! HotDog() {} // 不能编译
		HotDog(UnnamedInnerClass wi) {
			//wi.super();
		}
	}

	public static void main(String[] arg) {
		UnnamedInnerClass cl = new UnnamedInnerClass();
		UnnamedInnerClass.Fox fox = cl.new Fox(); // 普通内部类
		fox.beFriendly();

		UnnamedInnerClass.Dog dog = new UnnamedInnerClass.Dog(); // 静态内部类
		dog.beFriendly();
	}
}
