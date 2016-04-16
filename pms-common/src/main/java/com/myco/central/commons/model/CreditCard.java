package com.myco.central.commons.model;

import java.util.Date;

import javax.persistence.Entity;

@Entity
public class CreditCard extends BaseEntity {
	private static final long serialVersionUID = 1L;

	private String company; // Visa, Masterd Card, etc.
	private Long creditCardNumber;
	private Date creditCardExpiration;

	public String getCompany() {
		return company;
	}

	public Long getCreditCardNumber() {
		return creditCardNumber;
	}

	public Date getCreditCardExpiration() {
		return creditCardExpiration;
	}

	public void setCompany(String company) {
		this.company = company;
	}

	public void setCreditCardNumber(Long creditCardNumber) {
		this.creditCardNumber = creditCardNumber;
	}

	public void setCreditCardExpiration(Date creditCardExpiration) {
		this.creditCardExpiration = creditCardExpiration;
	}
}
