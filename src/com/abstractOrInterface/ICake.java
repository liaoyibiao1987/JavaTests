package com.abstractOrInterface;

public interface ICake {
	boolean shouldApply();

	void shape();

	void apply();

	void brake();

	public default void run() {
		this.shape();
		if (this.shouldApply()) {
			this.apply();
		}
		this.brake();
	}
}
