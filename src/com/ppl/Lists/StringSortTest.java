package com.ppl.Lists;

import java.util.Enumeration;

/*内部类是“静态”（Static）的，因为它毋需连接一个外部类即可工作。
大家可以看到，一旦设置好框架，就可以非常方便地重复使用象这样的一个设计——只需简单地写一个类，
将“需要发生变化”的东西封装进去，然后将一个对象传给SortVector 即可。
比较时将字串强制为小写形式，所以大写A 会排列于小写 a的旁边，而不会移动一个完全不同的地方

该例也显示了这种方法的一个不足，因为上述测试代码按照出现顺序排列同一个字母的大写和小写形
式：A a b B c C d D。但这通常不是一个大问题，因为经常处理的都是更长的字串，所以上述效果不会显露
出来（Java 1.2 的集合提供了排序功能，已解决了这个问题）。
继承（extends）在这儿用于创建一种新类型的Vector——也就是说，SortVector 属于一种Vector，并带有
一些附加的功能。继承在这里可发挥很大的作用，但了带来了问题。它使一些方法具有了final 属性（已在
第7 章讲述），所以不能覆盖它们。如果想创建一个排好序的 Vector，令其只接收和生成 String对象，就
会遇到麻烦。因为addElement()和elementAt()都具有 final属性，而且它们都是我们必须覆盖的方法，否
则便无法实现只能接收和产生String 对象。
但在另一方面，请考虑采用“合成”方法：将一个对象置入一个新类的内部。此时，不是改写上述代码来达
到这个目的，而是在新类里简单地使用一个SortVector。在这种情况下，用于实现Compare接口的内部类就
可以“匿名”地创建。*/


public class StringSortTest {
	static class StringCompare implements Compare {
		
		//因为addElement()和elementAt()都具有 final属性，而且它们都是我们必须覆盖的方法，否则便无法实现只能接收和产生String 对象
		public boolean lessThan(Object l, Object r) {
			return ((String) l).toLowerCase().compareTo(((String) r).toLowerCase()) < 0;
		}

		public boolean lessThanOrEqual(Object l, Object r) {
			return ((String) l).toLowerCase().compareTo(((String) r).toLowerCase()) <= 0;
		}
	}

	public static void main(String[] args) {
		SortVector sv = new SortVector(new StringCompare());
		sv.addElement("d");
		sv.addElement("A");
		sv.addElement("C");
		sv.addElement("c");
		sv.addElement("b");
		sv.addElement("B");
		sv.addElement("D");
		sv.addElement("a");
		sv.sort();
		Enumeration e = sv.elements();
		while (e.hasMoreElements())
			System.out.println(e.nextElement());
	}
}
