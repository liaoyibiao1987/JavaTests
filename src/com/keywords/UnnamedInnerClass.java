package com.keywords;

public class UnnamedInnerClass {
	public interface Pet {

		public void beFriendly();

		public void play();

	}

	public void TestUnnamedInner() {
		Pet dog = new Pet() {

			@Override
			public void beFriendly() {
				System.out.println("�����^_^");
			}

			@Override
			public void play() {
				System.out.println("�ѷ��̵���㣬����ѷ��̶���ȥ��Ȼ�����ټ������������ӣ�����500��^_^");
			}
		};
		dog.beFriendly();
	}
}
