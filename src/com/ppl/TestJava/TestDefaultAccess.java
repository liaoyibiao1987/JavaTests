/**
 * 
 */
/**
 * @author Administrator
 *
 */
package com.ppl.TestJava;

/*
 * 如果根本不指定访问指示符，就象本章之前的所有例子那样，这时会出现什么情况呢？默认的访问没有关键
字，但它通常称为“友好”（Friendly）访问。
这意味着当前包内的其他所有类都能访问“友好的”成员，
但对包外的所有类来说，这些成员却是“私有”（Private）的，外界不得访问。由于一个编译单元（一个文
件）只能从属于单个包，
所以单个编译单元内的所有类相互间都是自动“友好”的。因此，我们也说友好元素拥有“包访问”权限。
*/
public class TestDefaultAccess {
	void TestDefualt() {
		System.out.println("访问权限控制");
	}
}