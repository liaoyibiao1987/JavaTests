package com.ppl.inherits;

public abstract class A {

	public Class<? extends A> className;	

	public void name(A sA) {
		this.className = sA.getClass();
	}
}
