package com.myco.central.commons.model;

public class Segment {

	private String idHotel;
	private String idSource;
	private String idSegment;
	private String description;
	private String madeBy;
	private String madeOn;
	private String updatedBy;
	private String lastUpdate;
	private String status;

	public String getIdHotel() {
		return idHotel;
	}
	public void setIdHotel(String idHotel) {
		this.idHotel = idHotel;
	}
	public String getIdSource() {
		return idSource;
	}
	public void setIdSource(String idSource) {
		this.idSource = idSource;
	}

	public String getIdSegment() {
		return idSegment;
	}
	public void setIdSegment(String idSegment) {
		this.idSegment = idSegment;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getMadeBy() {
		return madeBy;
	}
	public void setMadeBy(String madeBy) {
		this.madeBy = madeBy;
	}
	public String getMadeOn() {
		return madeOn;
	}
	public void setMadeOn(String madeOn) {
		this.madeOn = madeOn;
	}
	public String getUpdatedBy() {
		return updatedBy;
	}
	public void setUpdatedBy(String updatedBy) {
		this.updatedBy = updatedBy;
	}
	public String getLastUpdate() {
		return lastUpdate;
	}
	public void setLastUpdate(String lastUpdate) {
		this.lastUpdate = lastUpdate;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
}
