package com.myco.central.commons.model;

public class SourceType {
	private String idSourceType;
	private String description;
	private String abbreviation;
	private String status;
	private String madeBy;
	private String madeOn;
	private String updatedBy;
	private String lastUodate;

	public String getIdSourceType() {
		return idSourceType;
	}
	public void setIdSourceType(String idSourceType) {
		this.idSourceType = idSourceType;
	}

	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}

	public String getAbbreviation() {
		return abbreviation;
	}
	public void setAbbreviation(String abbreviation) {
		this.abbreviation = abbreviation;
	}

	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
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

	public String getLastUodate() {
		return lastUodate;
	}
	public void setLastUodate(String lastUodate) {
		this.lastUodate = lastUodate;
	}
	
}
