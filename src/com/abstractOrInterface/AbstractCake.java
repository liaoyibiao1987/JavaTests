package com.abstractOrInterface;

public abstract class AbstractCake {
	protected boolean shouldApply() {
		return true;
	}

	/*
	 * �������ӷ�����ģ�嶼��ˣ��å
	 */
	public final void run() {
		this.shape();
		if (this.shouldApply()) {
			this.apply();
		}
		this.brake();
	}

	protected abstract void shape();

	protected abstract void apply();

	protected abstract void brake();
}
