package com.guo.pojo;

public enum WeekDay {
	MONDAY(1),
	TUESDAY(2),
	WEDNESDAY(3),
	THURSDAY(4),
	FRIDAY(5),
	SATURDAY(6),
	SUNDAY(7);

	private final int code;

	WeekDay (int code) {
		this.code = code;
	}

	public int getCode() {
		return code;
	}
}
