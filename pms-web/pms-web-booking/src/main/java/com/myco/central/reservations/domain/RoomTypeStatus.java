package com.myco.central.reservations.domain;

public class RoomTypeStatus {
	private long id;
	private String idHotel;
	private String idRoomType;
	private String statusDay;
	private String totalRooms;
	private String availableRooms;
	private String tentativeRooms;
	private String confirmedRooms;
	private String lockedRooms;
	private String maintenanceRooms;
	private String reservationType;
	private String lastUpdate;

	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
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
	public String getStatusDay() {
		return statusDay;
	}
	public void setStatusDay(String statusDay) {
		this.statusDay = statusDay;
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
	public String getTentativeRooms() {
		return tentativeRooms;
	}
	public void setTentativeRooms(String tentativeRooms) {
		this.tentativeRooms = tentativeRooms;
	}
	public String getConfirmedRooms() {
		return confirmedRooms;
	}
	public void setConfirmedRooms(String confirmedRooms) {
		this.confirmedRooms = confirmedRooms;
	}
	public String getLockedRooms() {
		return lockedRooms;
	}
	public void setLockedRooms(String lockedRooms) {
		this.lockedRooms = lockedRooms;
	}
	public String getMaintenanceRooms() {
		return maintenanceRooms;
	}
	public void setMaintenanceRooms(String maintenanceRooms) {
		this.maintenanceRooms = maintenanceRooms;
	}
	public String getReservationType() {
		return reservationType;
	}
	public void setReservationType(String reservationType) {
		this.reservationType = reservationType;
	}
	public String getLastUpdate() {
		return lastUpdate;
	}
	public void setLastUpdate(String lastUpdate) {
		this.lastUpdate = lastUpdate;
	}

	public String toString() {
		String cadena = null; 
		StringBuffer buffer = new StringBuffer(); 

		buffer.append("statusDay: " + statusDay + ", ");
		buffer.append("totalRooms: " + totalRooms);

		cadena = buffer.toString();

		return cadena;
	}
}
