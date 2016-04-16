package com.myco.central.model;

import javax.persistence.Entity;

@Entity
public class Segment extends BaseAuditable {

	private static final long serialVersionUID = 1L;

	private Long hotelId;
	private Long sourceId;
	private Long segmentId;
	private String description;
	private String status;

	public Segment() {
	}

	public Long getHotelId() {
		return hotelId;
	}

	public Long getSourceId() {
		return sourceId;
	}

	public Long getSegmentId() {
		return segmentId;
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

	public void setSourceId(Long sourceId) {
		this.sourceId = sourceId;
	}

	public void setSegmentId(Long segmentId) {
		this.segmentId = segmentId;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public void setStatus(String status) {
		this.status = status;
	}

}
