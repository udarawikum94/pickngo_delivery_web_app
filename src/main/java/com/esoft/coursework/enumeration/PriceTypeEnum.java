package com.esoft.coursework.enumeration;

public enum PriceTypeEnum {
	BUYING("B", "BUYING"),
	SELLING("S", "SELLING");
	
	
	private final String status;
    private final String description;
	
    private PriceTypeEnum(String status, String description) {
		this.status = status;
		this.description = description;
	}

	public String getStatus() {
		return status;
	}

	public String getDescription() {
		return description;
	}
}
