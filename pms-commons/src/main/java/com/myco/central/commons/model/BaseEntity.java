/**
 *
 */
package com.myco.central.commons.model;

import java.io.Serializable;
import java.time.LocalDateTime;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

@MappedSuperclass
public abstract class BaseEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private LocalDateTime created;
	private String createdBy;
	private LocalDateTime lastUpdate;
	private String updatedBy;
	private String status;

	public LocalDateTime getCreated() {
		return this.created;
	}
	public String getCreatedBy() {
		return createdBy;
	}
	public Long getId() {
		return id;
	}

	public LocalDateTime getLastUpdate() {
		return this.lastUpdate;
	}

	public String getStatus() {
		return status;
	}

	public String getUpdatedBy() {
		return updatedBy;
	}

	public void setCreated(LocalDateTime created) {
		this.created = created;
	}

	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public void setLastUpdate(LocalDateTime lastUpdate) {
		this.lastUpdate = lastUpdate;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public void setUpdatedBy(String updatedBy) {
		this.updatedBy = updatedBy;
	}

}