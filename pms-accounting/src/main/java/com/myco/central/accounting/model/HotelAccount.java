/*
 * Country.java
 *
 * Created on December 11, 2002, 7:42 PM
 */

package com.myco.central.accounting.model;

import com.myco.central.model.BaseAuditable;

public class HotelAccount extends BaseAuditable {

	private static final long serialVersionUID = 1L;
	
	private Long hotelId;
	private Long accountId;
    private String accountType;
    private String description;
    private String status;

    /** Creates new HotelAccount */
	public HotelAccount() {
	}

	public Long getHotelId() {
		return hotelId;
	}

	public Long getAccountId() {
		return accountId;
	}

	public String getAccountType() {
		return accountType;
	}

	public String getDescription() {
		return description;
	}

	public String getStatus() {
		return status;
	}

	public void setHotelId(Long hotelId) {
		this.hotelId = hotelId;
	}

	public void setAccountId(Long accountId) {
		this.accountId = accountId;
	}

	public void setAccountType(String accountType) {
		this.accountType = accountType;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public void setStatus(String status) {
		this.status = status;
	}

}