package com.myco.central.booking.model;

import java.util.Date;

import javax.persistence.Entity;

@Entity
public class RoomTypeStatus {
	private Long id;
	private Long hotelId;
	private Long roomTypeId;
	private Date statusDay;
	private int occupiedRooms;
	private int tentativeRooms;
	private int confirmedRooms;
	private int blockedRooms;
	private int maintenanceRooms;
	private String reservationType;
	private Date lastUpdate;

	public Long getId() {
		return id;
	}

	public Long getHotelId() {
		return hotelId;
	}

	public Long getRoomTypeId() {
		return roomTypeId;
	}

	public Date getStatusDay() {
		return statusDay;
	}

	public int getOccupiedRooms() {
		return occupiedRooms;
	}

	public int getTentativeRooms() {
		return tentativeRooms;
	}

	public int getConfirmedRooms() {
		return confirmedRooms;
	}

	public int getBlockedRooms() {
		return blockedRooms;
	}

	public int getMaintenanceRooms() {
		return maintenanceRooms;
	}

	public String getReservationType() {
		return reservationType;
	}

	public Date getLastUpdate() {
		return lastUpdate;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public void setHotelId(Long hotelId) {
		this.hotelId = hotelId;
	}

	public void setRoomTypeId(Long roomTypeId) {
		this.roomTypeId = roomTypeId;
	}

	public void setStatusDay(Date statusDay) {
		this.statusDay = statusDay;
	}

	public void setOccupiedRooms(int occupiedRooms) {
		this.occupiedRooms = occupiedRooms;
	}

	public void setTentativeRooms(int tentativeRooms) {
		this.tentativeRooms = tentativeRooms;
	}

	public void setConfirmedRooms(int confirmedRooms) {
		this.confirmedRooms = confirmedRooms;
	}

	public void setBlockedRooms(int blockedRooms) {
		this.blockedRooms = blockedRooms;
	}

	public void setMaintenanceRooms(int maintenanceRooms) {
		this.maintenanceRooms = maintenanceRooms;
	}

	public void setReservationType(String reservationType) {
		this.reservationType = reservationType;
	}

	public void setLastUpdate(Date lastUpdate) {
		this.lastUpdate = lastUpdate;
	}

	@Override
	public String toString() {
		return "RoomTypeStatus [id=" + id + ", hotelId=" + hotelId + ", roomTypeId=" + roomTypeId + ", statusDay="
				+ statusDay + ", occupiedRooms=" + occupiedRooms + ", tentativeRooms=" + tentativeRooms
				+ ", confirmedRooms=" + confirmedRooms + ", blockedRooms=" + blockedRooms + ", maintenanceRooms="
				+ maintenanceRooms + ", reservationType=" + reservationType + ", lastUpdate=" + lastUpdate + "]";
	}

}
