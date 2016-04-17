package com.myco.central.commons.enums;

public enum FrequencyEnum {
	DAILY("Daily"),
	WEEKLY("Weekly"),
	MONTHLY("Monthly"),
	QUARTERLY("Quarterly"),
	SEMESTER("Semester"),
	ANNUAL("Annual");
	
	private String label;
	
	FrequencyEnum(String label) {
		this.label = label;
	}
	
	String label() {
		return label;
	}
}
