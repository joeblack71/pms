/*
 * Guest.java
 *
 * Created on May 07, 2007, 7:42 PM
 */

package com.myco.central.reservations.domain;

/**
 *
 * @author  Johnny Olivas
 * @version 1.0
 */
public class Guest {

    private String idHotel;
    private String idReservation;
    private String roomNumber;
    private String idCustomer;
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

	public String getIdHotel() {
		return idHotel;
	}

	public void setIdHotel(String idHotel) {
		this.idHotel = idHotel;
	}

	public String getIdReservation() {
		return idReservation;
	}

	public void setIdReservation(String idReservation) {
		this.idReservation = idReservation;
	}

	public String getIdCustomer() {
		return idCustomer;
	}

	public void setIdCustomer(String idCustomer) {
		this.idCustomer = idCustomer;
	}

}
