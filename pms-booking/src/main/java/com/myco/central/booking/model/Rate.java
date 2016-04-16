/*
 * RoomType.java
 *
 * Created on 18 de marzo de 2005, 02:54 PM
 */

package com.myco.central.booking.model;

import javax.persistence.Entity;

import com.myco.central.model.BaseAuditable;

@Entity
public class Rate extends BaseAuditable {

	private static final long serialVersionUID = 1L;
	
	private Long hotelId;
	private Long specialRateId;
	private Long roomTypeId;
	private Long periodId;
	private Double roomValue;
    private String status;
    
	public Rate() {
	}

	public Long getHotelId() {
		return hotelId;
	}

	public Long getSpecialRateId() {
		return specialRateId;
	}

	public Long getRoomTypeId() {
		return roomTypeId;
	}

	public Long getPeriodId() {
		return periodId;
	}

	public Double getRoomValue() {
		return roomValue;
	}

	public String getStatus() {
		return status;
	}

	public void setHotelId(Long hotelId) {
		this.hotelId = hotelId;
	}

	public void setSpecialRateId(Long specialRateId) {
		this.specialRateId = specialRateId;
	}

	public void setRoomTypeId(Long roomTypeId) {
		this.roomTypeId = roomTypeId;
	}

	public void setPeriodId(Long periodId) {
		this.periodId = periodId;
	}

	public void setRoomValue(Double roomValue) {
		this.roomValue = roomValue;
	}

	public void setStatus(String status) {
		this.status = status;
	}

}