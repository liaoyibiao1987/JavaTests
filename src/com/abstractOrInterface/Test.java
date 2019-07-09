package com.abstractOrInterface;

public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		AbstractCake cake = new SmallCake();
		cake.run();

		ICake cake2 = new MarisCake();
		cake2.run();
	}

}
