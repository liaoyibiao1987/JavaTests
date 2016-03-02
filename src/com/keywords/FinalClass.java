package com.keywords;

/*final 类
如果说整个类都是final（在它的定义前冠以 final关键字），就表明自己不希望从这个类继承，或者不允
许其他任何人采取这种操作。换言之，出于这样或那样的原因，我们的类肯定不需要进行任何改变；或者出
于安全方面的理由，我们不希望进行子类化（子类处理）。
除此以外，我们或许还考虑到执行效率的问题，并想确保涉及这个类各对象的所有行动都要尽可能地有效。
如下所示：*/
//: Jurassic.java
// Making an entire class final
class SmallBrain {
}

final class FinalClass {
	int i = 7;
	int j = 1;
	SmallBrain x = new SmallBrain();

	void f() {
	}

	/*
	 * 注意数据成员既可以是 final，也可以不是，取决于我们具体选择。应用于final 的规则同样适用于数据成
	 * 员，无论类是否被定义成final。将类定义成 final后，结果只是禁止进行继承——没有更多的限制。然 而，由于它禁止了继承，所以一个
	 * final类中的所有方法都默认为 final。因为此时再也无法覆盖它们。所 以与我们将一个方法明确声明为final
	 * 一样，编译器此时有相同的效率选择。 可为final 类内的一个方法添加final 指示符，但这样做没有任何意义。
	 */
	// public static void main(String[] args) {
	// Dinosaur n = new Dinosaur();
	// n.f();
	// n.i = 40;
	// n.j++;
	// }
} /// :~
