package com.ppl.java.TransOrRentrun;

public class Alias2 {
	int i;

	Alias2(int ii) {
		i = ii;
	}

	static void f(Alias2 handle) {
		handle.i++;
	}
	
	/*Java 中的所有自变量或参数传递都是通过传递句柄进行的。也就是说，当我们传递“一个对
	象”时，实际传递的只是指向位于方法外部的那个对象的“一个句柄”。所以一旦要对那个句柄进行任何修
	改，便相当于修改外部对象。此外：
	■参数传递过程中会自动产生别名问题
	■不存在本地对象，只有本地句柄
	■句柄有自己的作用域，而对象没有
	■对象的“存在时间”在Java 里不是个问题
	■没有语言上的支持（如常量）可防止对象被修改（以避免别名的副作用）
	若只是从对象中读取信息，而不修改它，传递句柄便是自变量传递中最有效的一种形式。这种做非常恰当；
	默认的方法一般也是最有效的方法。然而，有时仍需将对象当作“本地的”对待，使我们作出的改变只影响
	一个本地副本，不会对外面的对象造成影响。许多程序设计语言都支持在方法内自动生成外部对象的一个本
	地副本*/

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Alias2 x = new Alias2(7);
		System.out.println("x: " + x.i);
		System.out.println("Calling f(x)");
		f(x);
		System.out.println("x: " + x.i);
	}

}
