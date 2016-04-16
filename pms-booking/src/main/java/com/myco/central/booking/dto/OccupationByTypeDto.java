
package com.myco.central.booking.dto;

import java.sql.Date;

/**
 *
 * @author Johnny Olivas
 * @version
 */
public class OccupationByTypeDto {

	private int hotelId;
	private String roomType;
	private Date occupationDate;
	private int occupationRooms;
	private String status;

	public int getHotelId() {
		return hotelId;
	}

	public String getRoomType() {
		return roomType;
	}

	public Date getOccupationDate() {
		return occupationDate;
	}

	public int getOccupationRooms() {
		return occupationRooms;
	}

	public String getStatus() {
		return status;
	}

	public void setHotelId(int hotelId) {
		this.hotelId = hotelId;
	}

	public void setRoomType(String roomType) {
		this.roomType = roomType;
	}

	public void setOccupationDate(Date occupationDate) {
		this.occupationDate = occupationDate;
	}

	public void setOccupationRooms(int occupationRooms) {
		this.occupationRooms = occupationRooms;
	}

	public void setStatus(String status) {
		this.status = status;
	}

}
