package com.abstractOrInterface;

/*
 * �ڴ�Ӧ�ó����У������ʺ�ʹ�ýӿڻ�����ͬ�������ͬ�������õĹ����У�ʹ�ó����ģ��ģʽ���ʺϡ�
 * ���ʹ�ýӿڣ�Ҫô�����е�����ÿ�ζ�ȥʵ����Щ�ӿڣ��ܱ�֤��������ʵ������Щ���������Ǵ������ظ����ࡣ����run()��ÿ�������ж�������ͬ�ķ���ʵ��һ��
 * 				Ҫô������һ��������һ��base���ͣ������ֲ��ܱ�֤���е�����ȥʵ���Լ����е��߼����ܿ��ܵ���������©��
 */
public class CakeBase implements ICake, IEat {
	protected boolean mShouldApply = false;
	//protected abstract boolean mShouldApply = false; //abstract���������ڲ����Ա���
	//public abstract float Price { get; } //C#�������ó������ԣ��������Ա����ǹ��еġ����ǲ������ó������
	
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
