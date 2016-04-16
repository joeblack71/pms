package com.myco.central.booking.dto;

import java.time.LocalDate;

import com.myco.central.commons.dto.BaseDto;

public class OccupationDto extends BaseDto {
	private static final long serialVersionUID = 1L;

	private Long hotelId;
	private Long roomTypeId;
	private Long roomId;
	private LocalDate startDate;
	private LocalDate endDate;

	public OccupationDto(Long hotelId) {
		this.hotelId = hotelId;
	}

	public OccupationDto(Long hotelId, Long roomTypeId, Long roomId, LocalDate startDate, LocalDate endDate) {
		this.hotelId = hotelId;
		this.roomTypeId = roomTypeId;
		this.roomId = roomId;
		this.startDate = startDate;
		this.endDate = endDate;
	}

	public LocalDate getEndDate() {
		return endDate;
	}

	public Long getHotelId() {
		return hotelId;
	}

	public Long getRoomId() {
		return roomId;
	}

	public Long getRoomTypeId() {
		return roomTypeId;
	}

	public LocalDate getStartDate() {
		return startDate;
	}

	public void setEndDate(LocalDate endDate) {
		this.endDate = endDate;
	}

	public void setHotelId(Long hotelId) {
		this.hotelId = hotelId;
	}

	public void setRoomId(Long roomId) {
		this.roomId = roomId;
	}

	public void setRoomTypeId(Long roomTypeId) {
		this.roomTypeId = roomTypeId;
	}

	public void setStartDate(LocalDate startDate) {
		this.startDate = startDate;
	}
}
