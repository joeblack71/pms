/*
 * Room.java
 *
 * Created on 31 de julio de 2007, 11:54 AM
 */

package com.myco.central.model;

import javax.persistence.Entity;

/**
 * @author Johnny Olivas
 */
@Entity
public class Room extends BaseAuditable {

	private static final long serialVersionUID = 1L;

	private Long hotelId;
	private Long roomTypeId;
    private String roomNumber;
    private String description;
    private String location;
    /** How many beds can be put in the room */
	private int bedsCapacity;
	private Double roomRate;
    /** Reservation that is holding locked the room */
	private Long reservationId;
    /** A room that has connection with this room */
    private String connectedRoom;
    /** House keeping status */
    private String hkStatus;
    /** Vacant, Occupied, Blocked, etc. */
    private String roomStatus;

	public Room() {
	}

	public int getBedsCapacity() {
		return bedsCapacity;
	}

	public String getConnectedRoom() {
		return connectedRoom;
	}

	public String getDescription() {
		return description;
	}

	public String getHkStatus() {
		return hkStatus;
	}

	public Long getHotelId() {
		return hotelId;
	}

	public String getLocation() {
		return location;
	}

	public Long getReservationId() {
		return reservationId;
	}

	public String getRoomNumber() {
		return roomNumber;
	}

	public Double getRoomRate() {
		return roomRate;
	}

	public String getRoomStatus() {
		return roomStatus;
	}

	public Long getRoomTypeId() {
		return roomTypeId;
	}

	public void setBedsCapacity(int bedsCapacity) {
		this.bedsCapacity = bedsCapacity;
	}

	public void setConnectedRoom(String connectedRoom) {
		this.connectedRoom = connectedRoom;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public void setHkStatus(String hkStatus) {
		this.hkStatus = hkStatus;
	}

	public void setHotelId(Long hotelId) {
		this.hotelId = hotelId;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public void setReservationId(Long reservationId) {
		this.reservationId = reservationId;
	}

	public void setRoomNumber(String roomNumber) {
		this.roomNumber = roomNumber;
	}

	public void setRoomRate(Double roomRate) {
		this.roomRate = roomRate;
	}

	public void setRoomStatus(String roomStatus) {
		this.roomStatus = roomStatus;
	}

	public void setRoomTypeId(Long roomTypeId) {
		this.roomTypeId = roomTypeId;
	}

}