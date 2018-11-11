package com.commons.enums;

/**
 * @notes:  状态枚举类
 * @author: At
 */
public enum StatusEnum {

	AVAILABLE(0,"可用"),
	NOT_AVAILABLE(1,"不可用");

	private int code;

	private String name;

	StatusEnum(int code, String name) {
		this.code = code;
		this.name = name;
	}

	public int getCode() {
		return code;
	}
	public String getName() {
		return name;
	}
}
