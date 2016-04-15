package com.myco.central.commons.model;

public class Phone {

	private String internationalCode;
	private String cityCode;
	private String number;

	public Phone() {}
	
	public Phone(String cityCode, String number) {
		this.cityCode = cityCode;
		this.number = number;
	}
	
	public String getInternationalCode() {
		return internationalCode;
	}
	public void setInternationalCode(String internationalCode) {
		this.internationalCode = internationalCode;
	}
	public String getCityCode() {
		return cityCode;
	}
	public void setCityCode(String cityCode) {
		this.cityCode = cityCode;
	}
	public String getNumber() {
		return number;
	}
	public void setNumber(String number) {
		this.number = number;
	}

}
