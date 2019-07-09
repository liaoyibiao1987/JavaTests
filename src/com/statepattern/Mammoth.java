package com.statepattern;

import java.util.Random;

/*import sun.misc.GC;
import sun.net.www.content.audio.x_aiff;*/

public class Mammoth {

	public interface State {
		void onEnterState();

		void observe();
	}

	/**
	 * ����״̬
	 */
	public class AngryState implements State {

		private Mammoth mammoth;

		public AngryState(Mammoth mammoth) {
			this.mammoth = mammoth;
		}

		@Override
		public void observe() {
			System.out.printf("%s ���ڱ���״̬!\n", mammoth);
		}

		@Override
		public void onEnterState() {
			System.out.printf("%s ��ʼ������!\n", mammoth);
		}
	}

	/**
	 * ƽ��״̬
	 */
	public class PeacefulState implements State {

		private Mammoth mammoth;

		public PeacefulState(Mammoth mammoth) {
			this.mammoth = mammoth;
		}

		@Override
		public void observe() {
			System.out.printf("%s ���ں�ƽ��.\n", mammoth);
		}

		@Override
		public void onEnterState() {
			System.out.printf("%s ��ʼ�侲������.\n", mammoth);
		}
	}

	private State mState;

	public Mammoth() {
		mState = new PeacefulState(this);
	}

	public void timePasses() {
		if (mState.getClass().equals(PeacefulState.class)) {
			changeStateTo(new AngryState(this));
		} else {
			changeStateTo(new PeacefulState(this));
		}
	}

	private void changeStateTo(State newState) {
		this.mState = newState;
		this.mState.onEnterState();
	}

	public void observe() {
		this.mState.observe();
	}

	@Override
	public String toString() {
		return "�������";
	}

	private static class CircularReferenceA {
		private byte[] data;
		private CircularReferenceB reference;

		public void setReference(CircularReferenceB c) {
			reference = c;
			data = new byte[2000];
		}
	}
	private static class CircularReferenceB {
		private byte[] data;
		private CircularReferenceA reference;

		public void setReference(CircularReferenceA c) {
			reference = c;
			data = new byte[2000];
		}
	}
	public static void main(String[] args) {
		outer: for (int i = 0; i < 10; i++) {
			System.out.println("outer_loop:" + i);
			inner: for (int k = 0; i < 10; k++) {
				System.out.print(k + " ");
				int x = new Random().nextInt(10);
				if (x > 7) {
					System.out.println(" >>x == " + x + "������innerѭ������������ִ��outerѭ���ˣ�");
					continue outer;
				}
				if (x == 1) {
					System.out.println(" >>x == 1����������������outer��innerѭ����");
					break outer;
				}
			}
		}
		System.out.println("------>>>����ѭ��ִ����ϣ�");

		Mammoth mammoth = new Mammoth();
		// ��������������ʲô״̬
		mammoth.observe();

		// ����һ���
		mammoth.timePasses();

		// ��������������ʲô״̬
		mammoth.observe();

		// ����һ���
		mammoth.timePasses();

		// ��������������ʲô״̬
		mammoth.observe();
		for (int i = 0; i < 200000; i++) {
			CircularReferenceA a = new CircularReferenceA();
			CircularReferenceB b = new CircularReferenceB();
			//java �ԷǸ��ϵ�ѭ�����ã������
			a.setReference(b);
			b.setReference(a);
			System.out.println("------>>>ѭ��ִ�У�");
		}
		/*
		 * for (int i = 0; i < 200000; i++) { Mammoth mammoth = new Mammoth();
		 * // ��������������ʲô״̬ mammoth.observe();
		 * 
		 * // ����һ��� mammoth.timePasses();
		 * 
		 * // ��������������ʲô״̬ mammoth.observe();
		 * 
		 * // ����һ��� mammoth.timePasses();
		 * 
		 * // ��������������ʲô״̬ mammoth.observe();
		 * 
		 * }
		 */
	}
	
	
}
