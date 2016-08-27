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

	public Pet TestUnnamedInner2(final String dest, final float price) {
		return new Pet() {

			private String label = dest;

			public String readLabel() {
				return label;
			}

			private int cost;

			// Instance initialization for each object:
			// ʵ��������
			{
				// ��������
				cost = Math.round(price);
				if (cost > 100)
					System.out.println("Over budget!");
			}

			@Override
			public void beFriendly() {
				System.out.println("�����^_^");
			}

			@Override
			public void play() {
				System.out.println("�ѷ��̵���㣬����ѷ��̶���ȥ��Ȼ�����ټ������������ӣ�����500��^_^");
			}
			// �e�`�ķ���
			/*
			 * public String TestRead() { return desc; }
			 */
		};
	}

	public Pet TestUnnamedInner3() {

		// �ڲ�����Ҫ�����ⲿ�ࣨ�������ı��������������Ϊfinal
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
			// ʵ��������
			{
				// ��������
				cost = Math.round(price);
				if (cost > 100)
					System.out.println("Over budget!");
			}

			@Override
			public void beFriendly() {
				System.out.println("�����^_^");
			}

			@Override
			public void play() {
				System.out.println("�ѷ��̵���㣬����ѷ��̶���ȥ��Ȼ�����ټ������������ӣ�����500��^_^");
			}
			// �e�`�ķ���
			/*
			 * public String TestRead() { return desc; }
			 */
		};
	}

	public static class Dog implements Pet {
		@Override
		public void beFriendly() {
			System.out.println("�����^_^");
		}

		@Override
		public void play() {
			System.out.println("�ѷ��̵���㣬����ѷ��̶���ȥ��Ȼ�����ټ������������ӣ�����500��^_^");
		}
	}

	public class Fox implements Pet {
		@Override
		public void beFriendly() {
			System.out.println("���Ǻ���^_^");
		}

		@Override
		public void play() {
			System.out.println("���Ǻ���ǵĹھ�������500��^_^");
		}
	}

	public static void main(String[] args) {
		Dog dog = new Dog();
		dog.beFriendly();
	}
}
