package com.keywords;


public class NewProperty extends BaseProperty {
	/*
	 * java������͸�������ͬ�ĳ�Ա���� ������ȡֵ����
	 * 
	 * 	1�����࣬���ຬ����ͬ�ĳ�Ա��������ֵ�������ͱ����������࣬�����
		2��������з����ı��Ա����ֵ����ı���Ǹ����е�����
		3���������ظ��෽�������õ�������ķ������ı������������
		4������ڶ�̬����Parent c = new Child(),�������ظ��෽������c.����( ) ���õ�������ķ������ı������������ݣ�c.���� ��ʾ���Ǹ������ݣ�����δ�ı�ġ�
	 */
	protected String name = "NewProperty";

	@Override
	public void BaseFunction() {
		//java�в���ǿ��override������� super�� ����android��SDK��IDEΪ�˸��õı����ʹ�ã�����ĳЩ��������Ҫǿ�Ƽ���super������ super.onStart()
		//super.BaseFunction();		
		System.out.println("NewProperty BaseFunction.");
	};

	public static void main(String[] args) {
		NewProperty newProperty = new NewProperty();
		BaseProperty baseProperty = new NewProperty();
		
		System.out.println(newProperty.getName());
		System.out.println(newProperty.name);
		System.out.println(baseProperty.name);
		
		newProperty.BaseFunction();
	}
}
