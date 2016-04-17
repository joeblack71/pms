package com.myco.central.commons.enums;

public enum AccountingType {
	CREDIT_ACCOUNT("C"),
	DEBIT_ACCOUNT("D");
	
	private String code;

	AccountingType(String code) {
		this.code = code;
	}

	public String code() {
		return this.code;
	}
}
