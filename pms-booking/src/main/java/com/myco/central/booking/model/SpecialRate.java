/*
 * RoomType.java
 *
 * Created on 18 de marzo de 2005, 02:54 PM
 */

package com.myco.central.booking.model;

import java.util.List;

import javax.persistence.Entity;

import com.myco.central.model.BaseAuditable;

@Entity
public class SpecialRate extends BaseAuditable {

	private static final long serialVersionUID = 1L;

	private Long hotelId;
	private Long specialRateId;
	private String description;
	private String status;
	private List<Rate> rates;

	public SpecialRate() {
	}

	public Long getHotelId() {
		return hotelId;
	}

	public Long getSpecialRateId() {
		return specialRateId;
	}

	public String getDescription() {
		return description;
	}

	public String getStatus() {
		return status;
	}

	public List<Rate> getRates() {
		return rates;
	}

	public void setHotelId(Long hotelId) {
		this.hotelId = hotelId;
	}

	public void setSpecialRateId(Long specialRateId) {
		this.specialRateId = specialRateId;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public void setRates(List<Rate> rates) {
		this.rates = rates;
	}

}