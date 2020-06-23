package com.ppl.Lists;

import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Set;

public class Safes {
	static class TempClass {

		public TempClass(String name, int age) {
			super();
			this.name = name;
			this.age = age;
		}

		private String name;

		private int age;

		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}

		public int getAge() {
			return age;
		}

		public void setAge(int age) {
			this.age = age;
		}

		@Override
		public String toString() {
			// TODO Auto-generated method stub
			return "Name: " + name + " age:" + age;
		}

	}

	public static HashSet<TempClass> listTemps;

	public static void main(String[] args) {
		listTemps = new LinkedHashSet();
		listTemps.add(new TempClass("AAA", 12));
		listTemps.add(new TempClass("BBB", 22));

		Iterator<TempClass> iterator = listTemps.iterator();
		boolean isUpdate = false;
		// while (listTemps.iterator().hasNext()) {
		while (iterator.hasNext()) {
			TempClass tmp = iterator.next();
			if (tmp.getName().equalsIgnoreCase("BBB")) {
				tmp.setAge(32);
				isUpdate = true;
			}
		}

		Iterator<TempClass> iterator2 = listTemps.iterator();
		while (iterator2.hasNext()) {
			System.out.println(iterator2.next().toString());
		}
		/*
		 * (01) 函数接口不同
				Enumeration只有2个函数接口。通过Enumeration，我们只能读取集合的数据，而不能对数据进行修改。
				Iterator只有3个函数接口。Iterator除了能读取集合的数据之外，也能数据进行删除操作。
			(02) Iterator支持fail-fast机制，而Enumeration不支持。*/
		Iterator<TempClass> iterator4 = listTemps.iterator();
		while (iterator4.hasNext()) {
			TempClass remoteDevice = iterator4.next();
			if (remoteDevice.getName().equals("AAA")) {
				iterator4.remove();
			}
		}
		System.out.println("===============");

		Iterator<TempClass> iterator3 = listTemps.iterator();
		while (iterator3.hasNext()) {
			System.out.println(iterator3.next().toString());
		}
	}
}
