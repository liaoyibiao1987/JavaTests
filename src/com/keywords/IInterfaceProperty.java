package com.keywords;

//��������һ���ӿڵ������ֶζ��Զ�����static ��final ���ԣ����Խӿ��ǶԳ���ֵ���з����һ���ù��ߣ���������C ��C++��enum �ǳ����Ƶ�Ч��

public interface IInterfaceProperty {
	int
	JANUARY = 1, FEBRUARY = 2, MARCH = 3,
	APRIL = 4, MAY = 5, JUNE = 6, JULY = 7,
	AUGUST = 8, SEPTEMBER = 9, OCTOBER = 10,
	NOVEMBER = 11, DECEMBER = 12;
	
	//���ǲ����ǡ��հ� final�������ɳ�ʼ���ɷǳ������ʽ
	int rint = (int)(Math.random() * 10);
	long rlong = (long)(Math.random() * 10);
	float rfloat = (float)(Math.random() * 10);
	double rdouble = Math.random() * 10;
}
/*********************��Ȼ���ֶβ����ǽӿڵ�һ���֣����Ǳ������Ǹ��ӿڵ� static�洢������***************************/