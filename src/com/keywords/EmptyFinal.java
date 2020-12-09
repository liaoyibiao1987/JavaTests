package com.keywords;

/*
 * 允许我们创建“空白final”，它们属于一些特殊的字段。尽管被声明成 final，但却未得到一个
初始值。无论在哪种情况下，空白 final都必须在实际使用前得到正确的初始化。而且编译器会主动保证这
一规定得以贯彻。然而，对于final关键字的各种应用，空白 final具有最大的灵活性。举个例子来说，位
于类内部的一个final 字段现在对 " 每个对象 " 都可以有所不同，同时依然保持其“不变”的本质。
*/
class Poppet {
}

public class EmptyFinal {
	final int i = 0; // Initialized final
	final int j; // Blank final
	final Poppet p; // Blank final handle
	// Blank finals MUST be initialized
	// in the constructor:

	EmptyFinal() {
		j = 1; // Initialize blank final
		p = new Poppet();
	}

	EmptyFinal(int x) {
		j = x; // Initialize blank final
		p = new Poppet();
	}
}
