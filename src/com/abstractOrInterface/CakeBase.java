package com.abstractOrInterface;

/*
 * 在此应用场景中，并不适合使用接口化。对同事物的有同样的作用的过程中，使用抽象的模板模式更适合。
 * 如果使用接口，要么让所有的子类每次都去实现那些接口，能保证所有子类实现了那些方法，但是代码有重复多余。比如run()在每个子类中都得用相同的方法实现一次
 * 				要么和这里一样，定义一个base类型，但是又不能保证所有的子类去实现自己特有的逻辑，很可能导致子类遗漏。
 */
public class CakeBase implements ICake, IEat {
	protected boolean mShouldApply = false;
	//protected abstract boolean mShouldApply = false; //abstract不能用于内部属性变量
	//public abstract float Price { get; } //C#可以设置抽象属性，抽象属性必须是公有的。但是不能设置抽象变量
	
	public boolean shouldApply() {
		return mShouldApply;
	}

	public final void run() {
		this.shape();
		if (this.shouldApply()) {
			this.apply();
		}
		this.brake();
	}

	@Override
	public void shape() {
		// TODO Auto-generated method stub

	}

	@Override
	public void apply() {
		// TODO Auto-generated method stub

	}

	@Override
	public void brake() {
		// TODO Auto-generated method stub

	}

	@Override
	public void shaokao() {
		// TODO Auto-generated method stub

	}

	@Override
	public void youzha() {
		// TODO Auto-generated method stub

	}

}
