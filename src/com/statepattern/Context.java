package com.statepattern;

public class Context {
	public interface State {
		public void doAction(Context context);
	}

	static class DeductState implements State {

		public void doAction(Context context) {
			System.out.println("��Ʒ������׼�������");
			context.setState(this);

			// ... ִ�м����ľ������
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
			System.out.println("������Ʒ�����");
			context.setState(this);

			// ... ִ�мӿ��ľ������
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
		// ������Ҫ�������� iPhone X
		Context context = new Context("iPhone X");

		// ������ô���в�������
		State revertState = new RevertState(2);
		revertState.doAction(context);

		// ͬ���ģ���������Ҳ�ǳ���
		State deductState = new DeductState();
		deductState.doAction(context);

		// �����Ҫ���ǿ��Ի�ȡ��ǰ��״̬
		// context.getState().toString();
	}

}
