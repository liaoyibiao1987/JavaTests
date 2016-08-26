package com.ppl.exceptionsTest;

class BaseballException extends Exception {
}

class Foul extends BaseballException {
}

class Strike extends BaseballException {
}

abstract class Inning {
	Inning() throws BaseballException {
	}

	void event() throws BaseballException {
		// Doesn't actually have to throw anything
	}

	abstract void atBat() throws Strike, Foul;

	void walk() {
	} // Throws nothing
}

class StormException extends Exception {
}

class RainedOut extends StormException {
}

class PopFoul extends Foul {
}

interface Storm {
	void event() throws RainedOut;

	void rainHard() throws RainedOut;
}

	/*��Inning �У����Կ������۹���������event()������ָ���Լ��ᡰ������һ��Υ����������ʵ����û����
	���������ǺϷ��ģ���Ϊ����������ǿ���û���������ڸ��ǹ���event()�汾����ӵ��κ�Υ����ͬ����
	����Ҳ������abstract ������������ atBat()��չʾ��������
	��interface Storm���ǳ���Ȥ����Ϊ���������� Incoming �ж����һ����������event()���Լ�����������
	�����һ���������������������ᡰ������һ���µ�Υ�����ͣ�RainedOut����ִ�е���StormyInning
	extends���͡�implements Storm����ʱ�򣬿��Կ���Storm �е�event()�������ܸı� Inning�е�event()
	��Υ���ӿڡ�ͬ���أ����������ʮ�ֺ���ģ�����Ļ��������ǲ���������ʱ��������޷�֪���Լ�����
	���Ƿ���ȷ�Ķ�������Ȼ������interface �ж����һ���������ڻ����������rainHard()��������Υ��
	ʱ��ûʲô���⡣
	��Υ�������Ʋ��������ڹ���������StormyInning�У����ǿɿ���һ���������ܹ�����������ϣ�����κζ�
	�������ۻ����๹������������ʲô��Ȼ�������ڱ����ְ�ĳ�ַ�ʽ���û����๹��������������Զ�
	276
	����Ĭ�Ϲ������������������๹�����������Լ���Υ���淶���������л����๹����Υ����
	StormyInning.walk()��������ԭ����������������һ��Υ������Inning.walk()ȴ���ᡰ��������������
	��������������Ϳ����Լ��Ĵ������Inning.walk()�����������ؿ����κ�Υ���������Ժ��滻��Inning
	������һ����Ķ���ʱ��Υ���ͻᡰ����������ɴ���ִ�е��жϡ�ͨ��ǿ�������෽�����ػ����෽����
	Υ���淶��������滻�ɱ��������ԡ�
	���ǹ���event()������������ʾ��һ��������������汾���Բ������κ�Υ���������������汾Ҫ����
	Υ����ͬ���أ��������Ǳ�Ҫ�ģ���Ϊ�������ж���Щ�Ѽٶ�������汾�����Υ���Ĵ��롣���ĵ���
	��������atBat()�����ᡰ������PopFoul������ Foul ����������һ��Υ������Foul Υ������ atBat()�Ļ�
	����汾�����ġ�����һ���������������Լ��Ĵ�������� Inning��ͬʱ������atBat()���ͱ��벶��Foul
	Υ�������� PopFoul�Ǵ�Foul �����ģ�����Υ����������ģ�飩Ҳ�Ჶ��PopFoul��
	���һ����Ȥ�ĵط��� main()�ڲ���������ط�������������ȷ����һ��StormyInning ���󣬱������ͻ�
	ǿ������ֻ�����ض����Ǹ����Υ���������������������͵��������ͣ��������ͻ�ǿ�����ǲ�����Ի���
	���Υ����ͨ��������Щ���ƣ�Υ�����ƴ���ġ���׳���̶Ȼ���˴���ȸ���*/

public class StormyInning extends Inning implements Storm {
	StormyInning() throws RainedOut, BaseballException {
	}

	StormyInning(String s) throws Foul, BaseballException {
	}

	// Regular methods must conform to base class:
	// ! void walk() throws PopFoul {} //Compile error
	// Interface CANNOT add exceptions to existing
	// methods from the base class:
	// ! public void event() throws RainedOut {}
	// If the method doesn't already exist in the
	// base class, the exception is OK:
	public void rainHard() throws RainedOut {
	}

	// You can choose to not throw any exceptions,
	// even if base version does:
	public void event() {
	}

	// Overridden methods can throw
	// inherited exceptions:
	void atBat() throws PopFoul {
	}

	public static void main(String[] args) {
		try {
			StormyInning si = new StormyInning();
			si.atBat();
		} catch (PopFoul e) {
		} catch (RainedOut e) {
		} catch (BaseballException e) {
		}
		// Strike not thrown in derived version.
		try {
			// What happens if you upcast?
			Inning i = new StormyInning();
			i.atBat();
			// You must catch the exceptions from the
			// base-class version of the method:
		} catch (Strike e) {
		} catch (Foul e) {
		} catch (RainedOut e) {
		} catch (BaseballException e) {
		}
	}

}
