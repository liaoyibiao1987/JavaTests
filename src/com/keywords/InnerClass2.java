package com.keywords;

abstract class Contents {
	public abstract int value();
}

interface Destination {
	String readLabel();
}

public class InnerClass2 {
	// 内部类PContents 被设为 private，所以除了Parcel3 之外，其他任何东西都不能访问它。

	private class PContents extends Contents {
		private int i = 11;

		public int value() {
			return i;
		}
	}

	// PDestination被设为 protected，所以除了 Parcel3，Parcel3包内的类（因为protected
	// 也为包赋予了访问权；也就是说，protected 也是“友好的”）
	protected class PDestination implements Destination {
		private String label;

		private PDestination(String whereTo) {
			label = whereTo;
		}

		public String readLabel() {
			return label;
		}
	}

	public Destination dest(String s) {
		return new PDestination(s);
	}

	// 若试图定义一个匿名内部类，并想使用在匿名内部类外部定义的一个对象，则编译器要求外部对象为final 属性。
	// 这正是我们将dest()的自变量设为final 的原因。如果忘记这样做，就会得到一条编译期出错提示。
	// Destination为接口，java
	public Destination dest2(final String dest, final float price) {
		return new Destination() {

			private String label = dest;

			public String readLabel() {
				return label;
			}

			private int cost;

			// Instance initialization for each object:
			//实例化方法
			{
				//四舍五入
				cost = Math.round(price);
				if (cost > 100)
					System.out.println("Over budget!");
			}
		};
	}

	public Contents cont() {
		return new PContents();
	}

	public static void TestInner2() {
		InnerClass2 p = new InnerClass2();
		Contents c = p.cont();
		Destination d = p.dest("Tanzania");
		// Illegal -- can't access private class:
		// ! Parcel3.PContents c = p.new PContents();

		Destination e = p.dest2("Tanzania", 101.99f);
	}
}
