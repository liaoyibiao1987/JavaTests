package com.keywords;

/*Ϊ��Ҫ���ڲ��ࣿ

1. �ڲ���һ��ֻΪ���ⲿ��ʹ�ã�

2. �ڲ����ṩ��ĳ�ֽ����ⲿ��Ĵ�����

3. Ҳ���������˵�ԭ��ÿ���ڲ��඼�ܶ����ؼ̳�һ���ӿڣ��������ⲿ���Ƿ��Ѿ��̳���ĳ���ӿڡ���ˣ��ڲ���ʹ���ؼ̳еĽ��������ø���������
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
