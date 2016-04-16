package com.myco.central.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

@MappedSuperclass
public abstract class BaseAuditable implements Serializable {

	private static final long serialVersionUID = 1L;

	private Long id;
	private Date created;
	private String createdBy;
	private Date lastUpdate;

	private String updatedBy;

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public Date getCreated() {
		return created;
	}

	public String getCreatedBy() {
		return createdBy;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	public Long getId() {
		return id;
	}

	public Date getLastUpdate() {
		return lastUpdate;
	}

	public String getUpdatedBy() {
		return updatedBy;
	}

	public void setCreated(Date created) {
		this.created = created;
	}

	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public void setLastUpdate(Date lastUpdate) {
		this.lastUpdate = lastUpdate;
	}

	public void setUpdatedBy(String updatedBy) {
		this.updatedBy = updatedBy;
	}

}