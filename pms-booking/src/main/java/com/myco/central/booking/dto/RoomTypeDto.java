/*
 * RoomType.java
 *
 * Created on 18 de marzo de 2005, 02:54 PM
 */

package com.myco.central.booking.dto;

import java.io.Serializable;

/**
 * @author Johnny Olivas
 */
public class RoomTypeDto implements Serializable {

    //private PropertyChangeSupport propertySupport;
	private static final long serialVersionUID = 1L;
	
	private String idHotel;
	private String idRoomType;
    private String roomType;
    private String description;
    private String totalRooms;
    private String availableRooms;
    private String blockedRooms;
    private String rackRate;
    private String status;
    private String madeOn;
    private String madeBy;
    private String updatedBy;
    private String lastUpdate;

    public RoomTypeDto() {
    }

    public String getIdHotel() {
		return idHotel;
	}

	public void setIdHotel(String idHotel) {
		this.idHotel = idHotel;
	}

    public String getIdRoomType() {
		return idRoomType;
	}

	public void setIdRoomType(String idRoomType) {
		this.idRoomType = idRoomType;
	}

	public String getRoomType() {
        return this.roomType;
    }
    public void setRoomType(String roomType) {
        this.roomType = roomType;
    }

    public String getDescription() {
        return this.description;
    }
    public void setDescription(String description) {
        this.description = description;
    }

	public String getTotalRooms() {
		return totalRooms;
	}

	public void setTotalRooms(String totalRooms) {
		this.totalRooms = totalRooms;
	}

	public String getAvailableRooms() {
		return availableRooms;
	}

	public void setAvailableRooms(String availableRooms) {
		this.availableRooms = availableRooms;
	}

	public String getBlockedRooms() {
		return blockedRooms;
	}

	public void setBlockedRooms(String blockedRooms) {
		this.blockedRooms = blockedRooms;
	}

	public String getRackRate() {
		return rackRate;
	}

	public void setRackRate(String rackRate) {
		this.rackRate = rackRate;
	}

	public String getStatus() {
        return this.status;
    }
    public void setStatus(String status) {
        this.status = status;
    }

	public String getMadeOn() {
		return madeOn;
	}

	public void setMadeOn(String madeOn) {
		this.madeOn = madeOn;
	}

	public String getMadeBy() {
		return madeBy;
	}

	public void setMadeBy(String madeBy) {
		this.madeBy = madeBy;
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

}