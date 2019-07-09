package com.abstractOrInterface;

public class CreamCake extends AbstractCake {
	@Override
	protected void shape() {
		System.out.println("ÄÌÓÍµ°¸âÔìĞÍ");
	}

	@Override
	protected void apply() {
		System.out.println("ÄÌÓÍµ°¸âÍ¿Ä¨");
	}

	@Override
	protected void brake() {
		System.out.println("ÄÌÓÍµ°¸âºæ±º");
	}
}
