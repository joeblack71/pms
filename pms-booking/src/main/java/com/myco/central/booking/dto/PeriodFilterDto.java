package com.myco.central.booking.dto;

import java.time.LocalDate;
import java.time.Period;

public class PeriodFilterDto {
	private Long hotelId;
	private String roomTypeCode;
	private Period period;
	private LocalDate startDate;
	private LocalDate endDate;
	
	public PeriodFilterDto(Long hotelId, Period period, LocalDate startDate, LocalDate endDate) {
		this.hotelId = hotelId;
		this.period = period;
		this.startDate = startDate;
		this.endDate = endDate;
	}

	public Long getHotelId() {
		return hotelId;
	}

	public String getRoomTypeCode() {
		return roomTypeCode;
	}

	public Period getPeriod() {
		return period;
	}

	public LocalDate getStartDate() {
		return startDate;
	}

	public LocalDate getEndDate() {
		return endDate;
	}

	public void setHotelId(Long hotelId) {
		this.hotelId = hotelId;
	}

	public void setRoomTypeCode(String roomTypeCode) {
		this.roomTypeCode = roomTypeCode;
	}

	public void setPeriod(Period period) {
		this.period = period;
	}

	public void setStartDate(LocalDate startDate) {
		this.startDate = startDate;
	}

	public void setEndDate(LocalDate endDate) {
		this.endDate = endDate;
	}

}
