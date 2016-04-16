/*
 * Period.java
 *
 * Created on July 11, 2008, 6:28 PM
 * Last Modification: 
 *
 */

package com.myco.central.booking.model;

import java.util.Date;

import javax.persistence.Entity;

import com.myco.central.model.BaseAuditable;

@Entity
public class RatePeriod extends BaseAuditable {

	private static final long serialVersionUID = 1L;

	private Long hotelId;
	private Long periodId;
	private Date startDate;

	public Long getHotelId() {
		return hotelId;
	}

	public Long getPeriodId() {
		return periodId;
	}

	public Date getStartDate() {
		return startDate;
	}

	public Date getEnDate() {
		return enDate;
	}

	public String getDescription() {
		return description;
	}

	public String getPeriodClass() {
		return periodClass;
	}

	public void setHotelId(Long hotelId) {
		this.hotelId = hotelId;
	}

	public void setPeriodId(Long periodId) {
		this.periodId = periodId;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	public void setEnDate(Date enDate) {
		this.enDate = enDate;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public void setPeriodClass(String periodClass) {
		this.periodClass = periodClass;
	}

	private Date enDate;
	private String description;
	private String periodClass;

	/** Creates new RatePeriod */
	public RatePeriod() {
	}

}
