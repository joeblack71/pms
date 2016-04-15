/*
 * Period.java
 *
 * Created on July 11, 2008, 6:28 PM
 * Last Modification: 
 *
 */

package com.myco.central.reservations.domain;

/**
 *
 * @author  Johnny Olivas
 * @version
 */
public class RatePeriod {

	private String idHotel;
	private String idPeriod;
	private String startDate;
	private String enDate;
	private String description;
	private String periodClass;
	private String madeBy;
	private String madeOn;
	private String updatedBy;
	private String lastUpdated;

    /** Creates new RatePeriod */
    public RatePeriod() {
    }

	public String getIdHotel() {
		return idHotel;
	}

	public void setIdHotel(String idHotel) {
		this.idHotel = idHotel;
	}

	public String getIdPeriod() {
		return idPeriod;
	}

	public void setIdPeriod(String idPeriod) {
		this.idPeriod = idPeriod;
	}

	public String getStartDate() {
		return startDate;
	}

	public void setStartDate(String startDate) {
		this.startDate = startDate;
	}

	public String getEnDate() {
		return enDate;
	}

	public void setEnDate(String enDate) {
		this.enDate = enDate;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getPeriodClass() {
		return periodClass;
	}

	public void setPeriodClass(String periodClass) {
		this.periodClass = periodClass;
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

	public String getLastUpdated() {
		return lastUpdated;
	}

	public void setLastUpdated(String lastUpdated) {
		this.lastUpdated = lastUpdated;
	}

}
