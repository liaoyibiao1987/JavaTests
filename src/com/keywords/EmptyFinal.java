package com.keywords;

/*
 * �������Ǵ������հ�final������������һЩ������ֶΡ����ܱ������� final����ȴδ�õ�һ��
��ʼֵ����������������£��հ� final��������ʵ��ʹ��ǰ�õ���ȷ�ĳ�ʼ�������ұ�������������֤��
һ�涨���Թ᳹��Ȼ��������final�ؼ��ֵĸ���Ӧ�ã��հ� final������������ԡ��ٸ�������˵��λ
�����ڲ���һ��final �ֶ����ڶ� " ÿ������ " ������������ͬ��ͬʱ��Ȼ�����䡰���䡱�ı��ʡ�
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
