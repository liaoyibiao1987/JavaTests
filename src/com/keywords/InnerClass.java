package com.keywords;

/*为何要用内部类？

1. 内部类一般只为其外部类使用；

2. 内部类提供了某种进入外部类的窗户；

3. 也是最吸引人的原因，每个内部类都能独立地继承一个接口，而无论外部类是否已经继承了某个接口。因此，内部类使多重继承的解决方案变得更加完整。
*/
public class InnerClass {
	public class Contents {
		private int i = 11;

		public int value() {
			return i;
		}
	}

	public class Destination {
		private String label;

		Destination(String whereTo) {
			label = whereTo;
		}

		String readLabel() {
			return label;
		}
	}

	public Destination to(String s) {
		return new Destination(s);
	}

	public Contents cont() {
		return new Contents();
	}

	public void ship(String dest) {
		Contents c = cont();
		Destination d = to(dest);
	}

	/*public static void main(String[] args) {
		InnerClass p = new InnerClass();
		p.ship("Tanzania");
		InnerClass q = new InnerClass();
		// Defining handles to inner classes:
		InnerClass.Contents c = q.cont();
		InnerClass.Destination d = q.to("Borneo");
	}*/
}
