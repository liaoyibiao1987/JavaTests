package com.statepattern;

public class Context {
	public interface State {
		public void doAction(Context context);
	}

	static class DeductState implements State {

		public void doAction(Context context) {
			System.out.println("商品卖出，准备减库存");
			context.setState(this);

			// ... 执行减库存的具体操作
		}

		public String toString() {
			return "Deduct State";
		}
	}

	static class RevertState implements State {

		private int count;

		public int getCount() {
			return count;
		}

		public RevertState(int count) {
			this.count = count;
			// TODO Auto-generated constructor stub
		}

		public void doAction(Context context) {
			System.out.println("给此商品补库存");
			context.setState(this);

			// ... 执行加库存的具体操作
		}

		public String toString() {
			return "Revert State";
		}
	}

	private State state;
	private String name;

	public Context(String name) {
		this.name = name;
	}

	public void setState(State state) {
		this.state = state;
	}

	public State getState() {
		return this.state;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// 我们需要操作的是 iPhone X
		Context context = new Context("iPhone X");

		// 看看怎么进行补库存操作
		State revertState = new RevertState(2);
		revertState.doAction(context);

		// 同样的，减库存操作也非常简单
		State deductState = new DeductState();
		deductState.doAction(context);

		// 如果需要我们可以获取当前的状态
		// context.getState().toString();
	}

}
