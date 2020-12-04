package com.keywords;

//由于置入一个接口的所有字段都自动具有static 和final 属性，所以接口是对常数值进行分组的一个好工具，它具有与C 或C++的enum 非常相似的效果

public interface IInterfaceProperty {
	int
	JANUARY = 1, FEBRUARY = 2, MARCH = 3,
	APRIL = 4, MAY = 5, JUNE = 6, JULY = 7,
	AUGUST = 8, SEPTEMBER = 9, OCTOBER = 10,
	NOVEMBER = 11, DECEMBER = 12;
	
	//它们不能是“空白 final”，但可初始化成非常数表达式
	int rint = (int)(Math.random() * 10);
	long rlong = (long)(Math.random() * 10);
	float rfloat = (float)(Math.random() * 10);
	double rdouble = Math.random() * 10;
}
/*********************当然，字段并不是接口的一部分，而是保存于那个接口的 static存储区域中***************************/