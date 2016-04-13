/*
 * RoomType.java
 *
 * Created on 18 de marzo de 2005, 02:54 PM
 */

package com.myco.central.vo;

import java.io.Serializable;

/**
 * @author Johnny Olivas
 */
public class RoomType implements Serializable {

    //private PropertyChangeSupport propertySupport;
	private static final long serialVersionUID = 1L;
	
	private short  hotelId;
    private String roomType;
    private String description;
    private short  totalRooms;
    private short  availableRooms;
    private short  blockedRooms;
    private float  rackRate;
    private String status;

    public RoomType() {
        //propertySupport = new PropertyChangeSupport(this);
    }

    public short getHotelId() {
        return this.hotelId;
    }
    public void setHotelId(short hotel) {
        this.hotelId = hotel;
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

    public short getTotalRooms() {
        return this.totalRooms;
    }
    public void setTotalRooms(short totalRooms) {
        this.totalRooms = totalRooms;
    }

    public short getAvailableRooms() {
        return this.availableRooms;
    }
    public void setAvailableRooms(short availableRooms) {
        this.availableRooms = availableRooms;
    }

    public short getBlockedRooms() {
        return this.blockedRooms;
    }
    public void setBlockedRooms(short blockedRooms) {
        this.blockedRooms = blockedRooms;
    }

    public float getRackRate() {
        return this.rackRate;
    }
    public void setRackRate(float rackRate) {
        this.rackRate = rackRate;
    }

    public String getStatus() {
        return this.status;
    }
    public void setStatus(String status) {
        this.status = status;
    }

}