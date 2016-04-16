
package com.myco.central.booking.dto;

import java.time.LocalDate;
import java.time.Period;

import com.myco.central.commons.dto.BaseFilterDto;
import com.myco.central.commons.enums.Status;

public class AvailabilityFilterDto extends BaseFilterDto {
	private static final long serialVersionUID = 1L;

	private String roomType;
	private LocalDate startDate;
	private LocalDate endDate;
	private Period period;
	private Status status;

	public AvailabilityFilterDto() {
		this.startDate = LocalDate.now();
		this.period = Period.ofWeeks(1);
    }

	public AvailabilityFilterDto(Long hotelId) {
		super(hotelId);
	}

	public AvailabilityFilterDto(Long hotelId, String pattern) {
		super(hotelId, pattern);
	}

	public AvailabilityFilterDto(Long hotelId, LocalDate startDate, LocalDate endDate) {
		super(hotelId);
		this.startDate = startDate;
		this.endDate = endDate;
	}

	public AvailabilityFilterDto(Long hotelId, LocalDate startDate, Period period) {
		super(hotelId);
		this.startDate = startDate;
		this.period = period;
	}

	public LocalDate getEndDate() {
		return this.endDate;
	}

	public Period getPeriod() {
		return period;
	}


	public String getRoomType() {
		return roomType;
	}

	public LocalDate getStartDate() {
		return this.startDate;
	}

	public Status getStatus() {
		return status;
	}

	public void setEndDate(LocalDate endDate) {
		this.endDate = endDate;
	}


	public void setPeriod(Period period) {
		this.period = period;
	}



	public void setRoomType(String roomType) {
		this.roomType = roomType;
	}

	public void setStartDate(LocalDate startDate) {
		this.startDate = startDate;
	}

	public void setStatus(Status status) {
		this.status = status;
	}

}