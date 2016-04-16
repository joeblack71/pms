/*
 * CustomerHistorical.java
 *
 * Created on Febrery 15, 2007, 11:55 AM
 * Last Modification:
 *
 */

package com.myco.central.booking.model;

import javax.persistence.Entity;

@Entity
public class CustomerHistorical implements java.io.Serializable {

	private static final long serialVersionUID = 1L;
	
	private String documentType;   // for validate before save or show information
    private String documentNumber; // Idem
    private String firstNames;     // Idem
    private String lastName;       // Idem
    private String hotelId;
    private String roomType;
    private String roomNumber;
    private String roomRate;
    private String reservationNumber;
    private String folioNumber;
    private String totalBillStay;
    private String totalDaysStay;
    private String travelAgent;
    private String company;
    private String arrival;
    private String lengthStay;
    private String comments;
    private String preferredRoom;

    /** Creates new Guest */
    public CustomerHistorical() {
    }

	public String getDocumentType() {
		return documentType;
	}

	public void setDocumentType(String documentType) {
		this.documentType = documentType;
	}

	public String getDocumentNumber() {
		return documentNumber;
	}

	public void setDocumentNumber(String documentNumber) {
		this.documentNumber = documentNumber;
	}

	public String getFirstNames() {
		return firstNames;
	}

	public void setFirstNames(String firstNames) {
		this.firstNames = firstNames;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getHotelId() {
		return hotelId;
	}

	public void setHotelId(String hotelId) {
		this.hotelId = hotelId;
	}

	public String getRoomType() {
		return roomType;
	}

	public void setRoomType(String roomType) {
		this.roomType = roomType;
	}

	public String getRoomNumber() {
		return roomNumber;
	}

	public void setRoomNumber(String roomNumber) {
		this.roomNumber = roomNumber;
	}

	public String getRoomRate() {
		return roomRate;
	}

	public void setRoomRate(String roomRate) {
		this.roomRate = roomRate;
	}

	public String getReservationNumber() {
		return reservationNumber;
	}

	public void setReservationNumber(String reservationNumber) {
		this.reservationNumber = reservationNumber;
	}

	public String getFolioNumber() {
		return folioNumber;
	}

	public void setFolioNumber(String folioNumber) {
		this.folioNumber = folioNumber;
	}

	public String getTotalBillStay() {
		return totalBillStay;
	}

	public void setTotalBillStay(String totalBillStay) {
		this.totalBillStay = totalBillStay;
	}

	public String getTotalDaysStay() {
		return totalDaysStay;
	}

	public void setTotalDaysStay(String totalDaysStay) {
		this.totalDaysStay = totalDaysStay;
	}

	public String getTravelAgent() {
		return travelAgent;
	}

	public void setTravelAgent(String travelAgent) {
		this.travelAgent = travelAgent;
	}

	public String getCompany() {
		return company;
	}

	public void setCompany(String company) {
		this.company = company;
	}

	public String getArrival() {
		return arrival;
	}

	public void setArrival(String arrival) {
		this.arrival = arrival;
	}

	public String getLengthStay() {
		return lengthStay;
	}

	public void setLengthStay(String lengthStay) {
		this.lengthStay = lengthStay;
	}

	public String getComments() {
		return comments;
	}

	public void setComments(String comments) {
		this.comments = comments;
	}

	public String getPreferredRoom() {
		return preferredRoom;
	}

	public void setPreferredRoom(String preferredRoom) {
		this.preferredRoom = preferredRoom;
	}

    /*public String getSource() {
        return firstNames;
    }
    public void setSource(String _source) {
        this.source = _source;
    }*/

}