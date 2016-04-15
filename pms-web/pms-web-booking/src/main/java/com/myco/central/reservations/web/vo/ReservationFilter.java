
package com.myco.central.reservations.web.vo;

import com.myco.central.util.DateUtils;

public class ReservationFilter {

    private String idHotel;
    private String guestName;
    private String arrivalDate;
    private String departureDate;
    private String status;

    public ReservationFilter() {
    	this.arrivalDate = DateUtils.getStringCurrentDate();
    	this.departureDate = this.arrivalDate;
    }

	public String getIdHotel() {
		return idHotel;
	}

	public void setIdHotel(String idHotel) {
		this.idHotel = idHotel;
	}

	public String getGuestName() {
		return guestName;
	}

	public void setGuestName(String guestName) {
		this.guestName = guestName;
	}

	public String getArrivalDate() {
		return arrivalDate;
	}

	public void setArrivalDate(String arrivalDate) {
		this.arrivalDate = arrivalDate;
	}

	public String getDepartureDate() {
		return departureDate;
	}

	public void setDepartureDate(String departureDate) {
		this.departureDate = departureDate;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

}