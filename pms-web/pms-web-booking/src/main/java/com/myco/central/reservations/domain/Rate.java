/*
 * RoomType.java
 *
 * Created on 18 de marzo de 2005, 02:54 PM
 */

package com.myco.central.reservations.domain;

import java.io.Serializable;

/**
 * @author Johnny Olivas
 */
public class Rate implements Serializable {

    //private PropertyChangeSupport propertySupport;
	private static final long serialVersionUID = 1L;
	
	private String idHotel;
    private String idSpecialRate;
    private String idRoomType;
    private String idPeriod;
    private String roomValue;
    private String madeBy;
    private String madeOn;
    private String updatedBy;
    private String lastUpdate;
    private String status;
    
    public Rate() {
    }

	public String getIdHotel() {
		return idHotel;
	}

	public void setIdHotel(String idHotel) {
		this.idHotel = idHotel;
	}

	public String getIdSpecialRate() {
		return idSpecialRate;
	}

	public void setIdSpecialRate(String idSpecialRate) {
		this.idSpecialRate = idSpecialRate;
	}

	public String getIdRoomType() {
		return idRoomType;
	}

	public void setIdRoomType(String idRoomType) {
		this.idRoomType = idRoomType;
	}

	public String getIdPeriod() {
		return idPeriod;
	}

	public void setIdPeriod(String idPeriod) {
		this.idPeriod = idPeriod;
	}

	public String getRoomValue() {
		return roomValue;
	}

	public void setRoomValue(String roomValue) {
		this.roomValue = roomValue;
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