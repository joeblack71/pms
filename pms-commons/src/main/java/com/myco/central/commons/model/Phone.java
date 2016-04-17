package com.myco.central.commons.model;

import javax.persistence.Entity;

@Entity
public class Phone extends BaseEntity {

	private static final long serialVersionUID = 1L;

	private String internationalCode;
	private String cityCode;
	private String number;

	public Phone(String cityCode, String number) {
		this.cityCode = cityCode;
		this.number = number;
	}

	public String getCityCode() {
		return cityCode;
	}

	public String getInternationalCode() {
		return internationalCode;
	}

	public String getNumber() {
		return number;
	}

	public void setCityCode(String cityCode) {
		this.cityCode = cityCode;
	}

	public void setInternationalCode(String internationalCode) {
		this.internationalCode = internationalCode;
	}

	public void setNumber(String number) {
		this.number = number;
	}

}
