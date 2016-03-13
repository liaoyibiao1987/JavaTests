package com.keywords;

//如确实不想放弃额外的类型安全性,又想实现接口的简便性
public class Month2 {
	private String name;

	private Month2(String nm) {
		name = nm;
	}

	public String toString() {
		return name;
	}

	public final static Month2 JAN = new Month2("January"), FEB = new Month2("February"), MAR = new Month2("March"),
			APR = new Month2("April"), MAY = new Month2("May"), JUN = new Month2("June"), JUL = new Month2("July"),
			AUG = new Month2("August"), SEP = new Month2("September"), OCT = new Month2("October"),
			NOV = new Month2("November"), DEC = new Month2("December");
	public final static Month2[] month = { JAN, JAN, FEB, MAR, APR, MAY, JUN, JUL, AUG, SEP, OCT, NOV, DEC };

	enum MONTH {
		January, FebruarY, March, April, May, June, July, August, September, October, November, December
	}

}
