package com.mediatorpattern;

public enum ActionEnum {

	HUNT("�����˷�", "���Է�"), TABLE("��ʼ��������", "��������"), FOND("�����˻���", "���ͻ�");

	private String title;
	private String description;

	ActionEnum(String title, String description) {
		// TODO Auto-generated constructor stub
		this.title = title;
		this.description = description;
	}

	public String getDescription() {
		return description;
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return String.format(" %s , %s", title, description);
	}
}
