package com.keywords;

/*
 * Java 1.1 允许我们将自变量设成 final 属性，方法是在自变量列表中对它们进行适当的声明。这意味着在一
 * 个方法的内部，我们不能改变自变量句柄指向的东西
 * 
 * 注意此时仍然能为final 自变量分配一个null（空）句柄，同时编译器不会捕获它。这与我们对非 final 自 变量采取的操作是一样的。 方法f()和
 * g()向我们展示出基本类型的自变量为 final 时会发生什么情况：我们只能读取自变量，不可改变 它。
 */
public class FinalArgument {
	public void with(final Gizmo g) {
		// ! g = new Gizmo(); // Illegal -- g is final

		// g 无论如何赋值都是null 此处有错
		g.spin();
	}

	public void without(Gizmo g) {
		g = new Gizmo(); // OK -- g not final
		g.spin();
	}

	// void f(final int i) { i++; } // Can't change
	// You can only read from a final primitive:
	public int g(final int i) {
		return i + 1;
	}

	/*
	 * final 方法 之所以要使用final 方法，可能是出于对两方面理由的考虑。第一个是为方法“上锁”，防止任何继承类改
	 * 变它的本来含义。设计程序时，若希望一个方法的行为在继承期间保持不变，而且不可被覆盖或改写，就可 以采取这种做法。 采用final
	 * 方法的第二个理由是程序执行的效率。将一个方法设成 final 后，编译器就可以把对那个方法的
	 * 所有调用都置入“嵌入”调用里。
	 * 只要编译器发现一个final 方法调用，就会（根据它自己的判断）忽略为
	 * 执行方法调用机制而采取的常规代码插入方法（将自变量压入堆栈；跳至方法代码并执行它；跳回来；清除 
	 * 堆栈自变量；最后对返回值进行处理）。相反，它会用方法主体内实际代码的一个副本来替换方法调用。这
	 * 样做可避免方法调用时的系统开销。当然，若方法体积太大，那么程序也会变得雍肿，可能受到到不到嵌入
	 * 代码所带来的任何性能提升。因为任何提升都被花在方法内部的时间抵消了。Java 编译器能自动侦测这些情
	 * 况，并颇为“明智”地决定是否嵌入一个final 方法。然而，最好还是不要完全相信编译器能正确地作出所
	 * 有判断。通常，只有在方法的代码量非常少，或者想明确禁止方法被覆盖的时候，才应考虑将一个方法设为 final。
	 * 类内所有private方法都自动成为final。由于我们不能访问一个 private方法，所以它绝对不会被其他方
	 * 法覆盖（若强行这样做，编译器会给出错误提示）。
	 * 可为一个 private方法添加final 指示符，但却不能为 那个方法提供任何额外的含义
	 */
	public void FinalFunction() {

	}

	/*
	 * public static void main(String[] args) { FinalArguments bf = new
	 * FinalArguments(); bf.without(null); bf.with(null); }
	 */
}
