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

	public Pet TestUnnamedInner2(final String dest, final float price) {
		return new Pet() {

			private String label = dest;

			public String readLabel() {
				return label;
			}

			private int cost;

			// Instance initialization for each object:
			// 实例化方法
			{
				// 四舍五入
				cost = Math.round(price);
				if (cost > 100)
					System.out.println("Over budget!");
			}

			@Override
			public void beFriendly() {
				System.out.println("蹭蹭你^_^");
			}

			@Override
			public void play() {
				System.out.println("把飞盘叼给你，逼你把飞盘丢出去，然后它再捡回来让你继续扔，连续500次^_^");
			}
			// 錯誤的方法
			/*
			 * public String TestRead() { return desc; }
			 */
		};
	}

	public Pet TestUnnamedInner3() {

		// 内部类想要访问外部类（方法）的变量，则变量必须为final
		// String dest = "dest";
		// float dest = 25;

		final String dest = "dest";
		final float price = 25f;

		return new Pet() {

			private String label = dest;

			public String readLabel() {
				return label;
			}

			private int cost;

			// Instance initialization for each object:
			// 实例化方法
			{
				// 四舍五入
				cost = Math.round(price);
				if (cost > 100)
					System.out.println("Over budget!");
			}

			@Override
			public void beFriendly() {
				System.out.println("蹭蹭你^_^");
			}

			@Override
			public void play() {
				System.out.println("把飞盘叼给你，逼你把飞盘丢出去，然后它再捡回来让你继续扔，连续500次^_^");
			}
			// 錯誤的方法
			/*
			 * public String TestRead() { return desc; }
			 */
		};
	}

	public static class Dog implements Pet {
		@Override
		public void beFriendly() {
			System.out.println("蹭蹭你^_^");
		}

		@Override
		public void play() {
			System.out.println("把飞盘叼给你，逼你把飞盘丢出去，然后它再捡回来让你继续扔，连续500次^_^");
		}
	}

	public class Fox implements Pet {
		@Override
		public void beFriendly() {
			System.out.println("我是狐狸^_^");
		}

		@Override
		public void play() {
			System.out.println("我是狐狸城的冠军，连续500次^_^");
		}
	}

	public static void main(String[] args) {
		Dog dog = new Dog();
		dog.beFriendly();
	}
}
