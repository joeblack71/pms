/*
 * Guest.java
 *
 * Created on May 07, 2007, 7:42 PM
 */

package com.myco.central.booking.model;

import javax.persistence.Entity;

import com.myco.central.model.BaseAuditable;

@Entity
public class Guest extends BaseAuditable {

	private static final long serialVersionUID = 1L;

	private Long hotelId;
    private Long reservationId;
    private String roomNumber;
    private Long customerId;
    private String customerDocument;
    private String customerNames;
    private String nationality;
    private String instructions;
    private String status;

    /** Creates new Guest */
    public Guest() {
    }

	public String getRoomNumber() {
		return roomNumber;
	}

	public void setRoomNumber(String roomNumber) {
		this.roomNumber = roomNumber;
	}

	public String getCustomerDocument() {
		return customerDocument;
	}

	public void setCustomerDocument(String customerDocument) {
		this.customerDocument = customerDocument;
	}

	public String getCustomerNames() {
		return customerNames;
	}

	public void setCustomerNames(String customerNames) {
		this.customerNames = customerNames;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getNationality() {
		return nationality;
	}

	public void setNationality(String nationality) {
		this.nationality = nationality;
	}

	public String getInstructions() {
		return instructions;
	}

	public void setInstructions(String instructions) {
		this.instructions = instructions;
	}

	public Long getHotelId() {
		return hotelId;
	}

	public Long getReservationId() {
		return reservationId;
	}

	public Long getCustomerId() {
		return customerId;
	}

	public void setHotelId(Long hotelId) {
		this.hotelId = hotelId;
	}

	public void setReservationId(Long reservationId) {
		this.reservationId = reservationId;
	}

	public void setCustomerId(Long customerId) {
		this.customerId = customerId;
	}

}
