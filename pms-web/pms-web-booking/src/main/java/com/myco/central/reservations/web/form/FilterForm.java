package com.myco.central.reservations.web.form;

import java.util.List;

public class FilterForm {
	private static final long serialVersionUID = 1L;

	private String userName;
	private String password;
	private String idHotel;
	private String idRoomType;
	private String startDate;
	private String endDate;
	
	private List<String> hotels;
	private List<String> roomTypes;
	private List<String> periods;

	public FilterForm() {
	}
	
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	public String getIdHotel() {
		return idHotel;
	}
	public void setIdHotel(String hotelId) {
		this.idHotel = hotelId;
	}

	public String getIdRoomType() {
		return idRoomType;
	}

	public void setIdRoomType(String idRoomType) {
		this.idRoomType = idRoomType;
	}

	public String getStartDate() {
		return startDate;
	}

	public void setStartDate(String startDate) {
		this.startDate = startDate;
	}

	public String getEndDate() {
		return endDate;
	}

	public void setEndDate(String endDate) {
		this.endDate = endDate;
	}

	public List<String> getHotels() {
		return hotels;
	}

	public void setHotels(List<String> hotels) {
		this.hotels = hotels;
	}

	public List<String> getRoomTypes() {
		return roomTypes;
	}

	public void setRoomTypes(List<String> roomTypes) {
		this.roomTypes = roomTypes;
	}

	public List<String> getPeriods() {
		return periods;
	}

	public void setPeriods(List<String> periods) {
		this.periods = periods;
	}

}
