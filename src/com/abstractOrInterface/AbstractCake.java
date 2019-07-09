package com.abstractOrInterface;

public abstract class AbstractCake {
	protected boolean shouldApply() {
		return true;
	}

	/*
	 * 不带钩子方法的模板都是耍流氓
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
