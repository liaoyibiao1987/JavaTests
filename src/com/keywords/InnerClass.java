package com.keywords;

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
