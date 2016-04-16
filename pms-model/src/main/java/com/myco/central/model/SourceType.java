package com.myco.central.model;

import javax.persistence.Entity;

@Entity
public class SourceType extends BaseAuditable {
	private static final long serialVersionUID = 1L;

	private Long sourceTypeId;
	private String description;
	private String abbreviation;
	private String status;

	public SourceType() {
	}

	public Long getSourceTypeId() {
		return sourceTypeId;
	}

	public String getDescription() {
		return description;
	}

	public String getAbbreviation() {
		return abbreviation;
	}

	public String getStatus() {
		return status;
	}

	public void setSourceTypeId(Long sourceTypeId) {
		this.sourceTypeId = sourceTypeId;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public void setAbbreviation(String abbreviation) {
		this.abbreviation = abbreviation;
	}

	public void setStatus(String status) {
		this.status = status;
	}

}
