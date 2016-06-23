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
				System.out.println("蹭蹭你^_^");
			}

			@Override
			public void play() {
				System.out.println("把飞盘叼给你，逼你把飞盘丢出去，然后它再捡回来让你继续扔，连续500次^_^");
			}
		};
		dog.beFriendly();
	}
}
