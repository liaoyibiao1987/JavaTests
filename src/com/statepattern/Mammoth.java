package com.statepattern;

import sun.misc.GC;

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

	public static void main(String[] args) {
		for (int i = 0; i < 200000; i++) {
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
		}
		
	}
}
