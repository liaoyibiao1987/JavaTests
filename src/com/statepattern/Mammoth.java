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
	 * 生气状态
	 */
	public class AngryState implements State {

		private Mammoth mammoth;

		public AngryState(Mammoth mammoth) {
			this.mammoth = mammoth;
		}

		@Override
		public void observe() {
			System.out.printf("%s 处于暴躁状态!\n", mammoth);
		}

		@Override
		public void onEnterState() {
			System.out.printf("%s 开始生气了!\n", mammoth);
		}
	}

	/**
	 * 平静状态
	 */
	public class PeacefulState implements State {

		private Mammoth mammoth;

		public PeacefulState(Mammoth mammoth) {
			this.mammoth = mammoth;
		}

		@Override
		public void observe() {
			System.out.printf("%s 现在很平静.\n", mammoth);
		}

		@Override
		public void onEnterState() {
			System.out.printf("%s 开始冷静下来了.\n", mammoth);
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
		return "猛犸大象";
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
					System.out.println(" >>x == " + x + "，结束inner循环，继续迭代执行outer循环了！");
					continue outer;
				}
				if (x == 1) {
					System.out.println(" >>x == 1，跳出并结束整个outer和inner循环！");
					break outer;
				}
			}
		}
		System.out.println("------>>>所有循环执行完毕！");

		Mammoth mammoth = new Mammoth();
		// 看看大象现在是什么状态
		mammoth.observe();

		// 过了一会儿
		mammoth.timePasses();

		// 看看大象现在是什么状态
		mammoth.observe();

		// 过了一会儿
		mammoth.timePasses();

		// 看看大象现在是什么状态
		mammoth.observe();
		for (int i = 0; i < 200000; i++) {
			CircularReferenceA a = new CircularReferenceA();
			CircularReferenceB b = new CircularReferenceB();
			//java 对非根上的循环引用，会回收
			a.setReference(b);
			b.setReference(a);
			System.out.println("------>>>循环执行！");
		}
		/*
		 * for (int i = 0; i < 200000; i++) { Mammoth mammoth = new Mammoth();
		 * // 看看大象现在是什么状态 mammoth.observe();
		 * 
		 * // 过了一会儿 mammoth.timePasses();
		 * 
		 * // 看看大象现在是什么状态 mammoth.observe();
		 * 
		 * // 过了一会儿 mammoth.timePasses();
		 * 
		 * // 看看大象现在是什么状态 mammoth.observe();
		 * 
		 * }
		 */
	}
	
	
}
