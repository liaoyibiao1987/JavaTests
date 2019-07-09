package com.abstractOrInterface;

public class SmallCake extends AbstractCake {

	private boolean flag = false;

	public void setFlag(boolean shouldApply) {
		flag = shouldApply;
	}

	@Override
	protected boolean shouldApply() {
		return this.flag;
	}

	@Override
	protected void shape() {
		System.out.println("С��������");
	}

	@Override
	protected void apply() {
		System.out.println("С����ͿĨ");
	}

	@Override
	protected void brake() {
		System.out.println("С����決");
	}

}
