package com.mediatorpattern;

public enum ActionEnum {

	HUNT("做好了饭", "来吃饭"), TABLE("开始讲故事了", "来听故事"), FOND("发现了花朵", "来赏花");

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
