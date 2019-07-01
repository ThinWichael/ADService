package com.michael.enums;

public enum Status {
	SUCCESS(0, "OK"),

	AUTHURIZATION_INVALIDATE(02, "login fail"),
	
	PWD_INVALIDATE(03, "pwd invalidated"),

	INPUT_ILLEGAL(05, "input_invalidate"),
	
	NO_AD(03, "No Ad in the pool"),

	UNKNOWN_ERROR(9999, "unknown error");

	private int code;
	private String description;

	public String getDescription() {
		return description;
	}

	Status(int code, String des) {
		this.code = code;
		this.description = des;
	}

	Status(int code) {
		this.code = code;
	}

	public int getCode() {
		return code;
	}
}
