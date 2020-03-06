package com.ppl.TestTransfer;

public class TransferTester {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String str = "AAA";
		testString(str);

		System.out.println(str);

		Person person = new Person();
		person.name = "刘德华";
		person.age = 61;
		System.out.println(person.hashCode() + person.name + "\t\t" + person.age);
		testPerson(person);
		// person内容改变了
		System.out.println(person.hashCode() + person.name + "\t\t" + person.age);
		testPerson2(person);
		System.out.println(person.hashCode() + person.name + "\t\t" + person.age);
	}

	public static void testString(String str) {
		str = "BBB";
	}

	public static void testPerson(Person per) {
		// 1.per被赋予person值的拷贝，这里是一个对象的引用
		// 2.testPerson方法应用于这个应用。per和person指向同一对象，该对象的分数增加了10
		// 3.testPerson方法结束后，per不再使用，person指向的那个对象分数增加了10
		per.name = "修改过的.";
		per.age = 12;
	}

	public static void testPerson2(Person person) {
		person = new Person();
		person.name = "再次修改过的.";
		person.age = 20;
		System.out.println("===" + person.hashCode() + person.name + "\t\t" + person.age);
	}

	public static class Person {
		public String name;
		public int age;
	}

	/**
	 * 包装器
	 */
	public class PersonPack {
		public Person person;
	}
}
