package com.abstractOrInterface;

public class CreamCake extends AbstractCake {
	@Override
	protected void shape() {
		System.out.println("���͵�������");
	}

	@Override
	protected void apply() {
		System.out.println("���͵���ͿĨ");
	}

	@Override
	protected void brake() {
		System.out.println("���͵���決");
	}
}
