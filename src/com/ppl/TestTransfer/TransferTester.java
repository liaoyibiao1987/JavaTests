package com.ppl.TestTransfer;

public class TransferTester {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String str = "AAA";
		testString(str);

		System.out.println(str);

		Person person = new Person();
		person.name = "���»�";
		person.age = 61;
		System.out.println(person.hashCode() + person.name + "\t\t" + person.age);
		testPerson(person);
		// person���ݸı���
		System.out.println(person.hashCode() + person.name + "\t\t" + person.age);
		testPerson2(person);
		System.out.println(person.hashCode() + person.name + "\t\t" + person.age);
	}

	public static void testString(String str) {
		str = "BBB";
	}

	public static void testPerson(Person per) {
		// 1.per������personֵ�Ŀ�����������һ�����������
		// 2.testPerson����Ӧ�������Ӧ�á�per��personָ��ͬһ���󣬸ö���ķ���������10
		// 3.testPerson����������per����ʹ�ã�personָ����Ǹ��������������10
		per.name = "�޸Ĺ���.";
		per.age = 12;
	}

	public static void testPerson2(Person person) {
		person = new Person();
		person.name = "�ٴ��޸Ĺ���.";
		person.age = 20;
		System.out.println("===" + person.hashCode() + person.name + "\t\t" + person.age);
	}

	public static class Person {
		public String name;
		public int age;
	}

	/**
	 * ��װ��
	 */
	public class PersonPack {
		public Person person;
	}
}
