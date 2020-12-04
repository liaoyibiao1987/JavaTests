package com.ppl.exceptionsTest;

class BaseballException extends Exception {
}

class StormException extends Exception {
}

class RainedOut extends StormException {
}

class Foul extends BaseballException {
}

class PopFoul extends Foul {
}

class Strike extends BaseballException {
}

class IEventException extends BaseballException {
}

class EventException extends BaseballException {
}

abstract class Inning {
	Inning() throws BaseballException {
	}

	void event() throws EventException {
		// Doesn't actually have to throw anything
	}

	abstract void atBat() throws Strike, Foul;

	void walk() {
	} // Throws nothing
}

interface Storm {
	void event() throws IEventException;

	void rainHard() throws RainedOut;
}

/*
 * 在Inning 中，可以看到无论构建器还是event()方法都指出自己会“掷”出一个违例，但它们实际上没有那
 * 样做。这是合法的，因为它允许我们强迫用户捕获可能在覆盖过的event()版本里添加的任何违例。同样的 道理也适用于abstract 方法，就象在
 * atBat()里展示的那样。 “interface Storm”非常有趣，因为它包含了在 Inning 中定义的一个方法——event()，以及不是在其中
 * 定义的一个方法。这两个方法都会“掷”出一个新的违例类型：RainedOut。当执行到“StormyInning extends”和“implements
 * Storm”的时候，可以看到Storm 中的event()方法不能改变 Inning中的event()
 * 的违例接口。同样地，这种设计是十分合理的；否则的话，当我们操作基础类时，便根本无法知道自己捕获 的是否正确的东西。
 * 
 * 当然，假如interface中定义的一个方法不在基础类里，比如rainHard()，它产生违例 时就没什么问题。
 * 对违例的限制并不适用于构建器。在StormyInning中，我们可看到一个构建器能够“掷”出它希望的任何东西，
 * 无论基础类构建器“掷”出什么。然而，由于必须坚持按某种方式调用基础类构建器（在这里，会自动调用默认构建器），
 * 所以衍生类构建器必须在自己的违例规范中声明所有基础类构建器违例。
 * StormyInning.walk()不会编译的原因是它“掷”出了一个违例，而Inning.walk()却不会“掷”出。若允许
 * 这种情况发生，就可让自己的代码调用Inning.walk()，而且它不必控制任何违例。但在以后替换从Inning
 * 衍生的一个类的对象时，违例就会“掷”出，造成代码执行的中断。通过强迫衍生类方法遵守基础类方法的 违例规范，对象的替换可保持连贯性。
 * 覆盖过的event()方法向我们显示出一个方法的衍生类版本可以不产生任何违例——即便基础类版本要产生
 * 违例。同样地，这样做是必要的，因为它不会中断那些已假定基础类版本会产生违例的代码。差不多的道理 亦适用于atBat()，它会“掷”出PopFoul——从
 * Foul 衍生出来的一个违例，而Foul 违例是由 atBat()的基 础类版本产生的。这样一来，假如有人在自己的代码里操作
 * Inning，同时调用了atBat()，就必须捕获Foul 违例。由于 PopFoul是从Foul 衍生的，所以违例控制器（模块）也会捕获PopFoul。
 * 最后一个有趣的地方在 main()内部。在这个地方，假如我们明确操作一个StormyInning 对象，编译器就会 强迫我们只捕获特定于那个类的违例。
 * 但假如我们上溯造型到基础类型，编译器就会强迫我们捕获针对基础类的违例。(好像这个1.8版本的java这句话是错的)
 * 通过所有这些限制，违例控制代码的“健壮”程度获得了大幅度改善
 */

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
		System.out.println("```````````");
		// StormyInning si1 = new StormyInning();
		try {
			StormyInning si = new StormyInning();
			si.atBat();
			si.event();
		} catch (PopFoul e) {
		} catch (RainedOut e) {
		} catch (BaseballException e) {
		}
		// Strike not thrown in derived version.
		// Inning ix = new StormyInning();
		try {
			// What happens if you upcast?
			Inning i = new StormyInning();
			i.atBat();// Strike / Foul是给Inning这个基础方法使用的.
			i.event();//event不是继承的。 只会用到StormyInning里的
			// You must catch the exceptions from the
			// base-class version of the method:
		} catch (Strike e) {
		} catch (Foul e) {
		} catch (RainedOut e) {
		} catch (BaseballException e) {
		}
		System.out.println("...........");
	}

}
