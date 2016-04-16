/*
 * Availability.java
 *
 * Created on December 23, 2006, 11:44 AM
 */

package com.myco.central.booking.model;

import java.util.Date;

import javax.persistence.Entity;

import com.myco.central.model.BaseAuditable;

@Entity
public class Availability extends BaseAuditable {

	private static final long serialVersionUID = 1L;

	private Long hotelId;
	private String roomType;
	private Date startDate;
	private Date endDate;
	private Date oldArrival;
	private Date oldDeparture;
	private String period;
	private int quantity;
	private int reservationRooms;
    private String roomNumber;
	private int roomTypeAvailability;
	private String status;

	public Availability() {
	}

    public Date getEndDate() {
        return endDate;
    }

    public Long getHotelId() {
        return hotelId;
    }

    public Date getOldArrival() {
        return oldArrival;
    }

    public Date getOldDeparture() {
        return oldDeparture;
    }

    public String getPeriod() {
        return period;
    }

	public int getQuantity() {
		return quantity;
	}

	public int getReservationRooms() {
		return reservationRooms;
	}

    public String getRoomNumber() {
        return roomNumber;
    }

    public String getRoomType() {
        return roomType;
    }

	public int getRoomTypeAvailability() {
        return roomTypeAvailability;
    }

    public Date getStartDate() {
        return startDate;
    }

    public String getStatus() {
        return status;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public void setHotelId(Long hotelId) {
        this.hotelId = hotelId;
    }

    public void setOldArrival(Date oldArrival) {
        this.oldArrival = oldArrival;
    }

    public void setOldDeparture(Date oldDeparture) {
        this.oldDeparture = oldDeparture;
    }

    public void setPeriod(String period) {
        this.period = period;
    }

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

    public void setQuantity(short quantity) {
        this.quantity = quantity;
    }

	public void setReservationRooms(int reservationRooms) {
		this.reservationRooms = reservationRooms;
	}

    public void setRoomNumber(String roomNumber) {
        this.roomNumber = roomNumber;
    }

    public void setRoomType(String roomType) {
        this.roomType = roomType;
    }

    public void setRoomTypeAvailability(short roomTypeAvailability) {
        this.roomTypeAvailability = roomTypeAvailability;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public void setStatus(String status) {
        this.status = status;
    }

}