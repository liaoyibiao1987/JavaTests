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
		System.out.println("–°µ∞∏‚‘Ï–Õ");
	}

	@Override
	protected void apply() {
		System.out.println("–°µ∞∏‚Õøƒ®");
	}

	@Override
	protected void brake() {
		System.out.println("–°µ∞∏‚∫Ê±∫");
	}

}
