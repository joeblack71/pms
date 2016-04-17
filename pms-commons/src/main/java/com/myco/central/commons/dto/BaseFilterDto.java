
package com.myco.central.commons.dto;

import java.io.Serializable;

public class BaseFilterDto implements Serializable {
	private static final long serialVersionUID = 1L;

	private Long hotelId;
    private String pattern;

	public BaseFilterDto() {
	}

	public BaseFilterDto(Long hotelId) {
		this(hotelId, "");
	}

	public BaseFilterDto(Long hotelId, String pattern) {
		this.hotelId = hotelId;
		this.pattern = pattern;
    }

	public Long getHotelId() {
		return hotelId;
	}

	public String getPattern() {
		return pattern;
	}

	public void setHotelId(Long hotelId) {
		this.hotelId = hotelId;
	}

	public void setPattern(String pattern) {
		this.pattern = pattern;
	}

}