package com.esoft.coursework.enumeration;

public enum SizeEnum {
	SMALL("S", "SMALL"),
	MEDIUM("M", "MEDIUM"),
	LARGE("L", "LARGE"),
	EXTRA_LARGE("XL", "EXTRA_LARGE"),
	DOUBLE_EXTRA_LARGE("XXL", "DOUBLE_EXTRA_LARGE");
	
	
	private final String code;
    private final String description;
	
    private SizeEnum(String code, String description) {
		this.code = code;
		this.description = description;
	}

	public String getCode() {
		return code;
	}

	public String getDescription() {
		return description;
	}
}
