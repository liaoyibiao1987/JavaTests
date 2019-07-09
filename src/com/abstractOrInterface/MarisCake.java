package com.abstractOrInterface;

public class MarisCake extends CakeBase {

	public MarisCake() {
		// TODO Auto-generated constructor stub
		mShouldApply = true;
	}

	@Override
	public void shape() {
		// TODO Auto-generated method stub
		System.out.println("»ğĞÇµ°¸âÔìĞÍ");
	}

	@Override
	public void apply() {
		// TODO Auto-generated method stub
		System.out.println("»ğĞÇµ°¸âÍ¿Ä¨");
	}

	@Override
	public void brake() {
		// TODO Auto-generated method stub
		System.out.println("»ğĞÇµ°¸âºæÅà");
	}

}
