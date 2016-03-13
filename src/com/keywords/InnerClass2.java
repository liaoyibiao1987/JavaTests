package com.keywords;

abstract class Contents {
	public abstract int value();
}

interface Destination {
	String readLabel();
}

public class InnerClass2 {
	// �ڲ���PContents ����Ϊ private�����Գ���Parcel3 ֮�⣬�����κζ��������ܷ�������

	private class PContents extends Contents {
		private int i = 11;

		public int value() {
			return i;
		}
	}

	// PDestination����Ϊ protected�����Գ��� Parcel3��Parcel3���ڵ��ࣨ��Ϊprotected
	// ҲΪ�������˷���Ȩ��Ҳ����˵��protected Ҳ�ǡ��Ѻõġ���
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

	// ����ͼ����һ�������ڲ��࣬����ʹ���������ڲ����ⲿ�����һ�������������Ҫ���ⲿ����Ϊfinal ���ԡ�
	// ���������ǽ�dest()���Ա�����Ϊfinal ��ԭ������������������ͻ�õ�һ�������ڳ�����ʾ��
	// DestinationΪ�ӿڣ�java
	public Destination dest2(final String dest, final float price) {
		return new Destination() {

			private String label = dest;

			public String readLabel() {
				return label;
			}

			private int cost;

			// Instance initialization for each object:
			//ʵ��������
			{
				//��������
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
