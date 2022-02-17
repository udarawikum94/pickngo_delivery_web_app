package com.esoft.coursework.enumeration;

public enum RecordStatusEnum {
	ACTIVE("A", "ACTIVE"),
	INACTIVE("I", "INACTIVE");
	
	
	private final String status;
    private final String description;
	
    private RecordStatusEnum(String status, String description) {
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
