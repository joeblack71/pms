/*
 * Customer.java
 *
 * Created on Febrery 15, 2007, 12:00 PM
 * Last Modification:
 *
 */

package com.myco.central.commons.model;

import javax.persistence.Entity;

import com.myco.central.commons.enums.VipStatus;

/**
 *
 * @author  Johnny Olivas
 * @version
 */
@Entity
public class Customer extends Person {
    private Long hotelId;
    private Long customerId;
    private Long sourceId;
    private Long preferredHotelId;
    private String preferredRoom;
    private String requests;
    private CreditCard creditCard;
    private String  maritalStatus;
    private boolean futureReservation; // more than one
    private String nextReservation;
    private String nextReservationStatus;
    private String nextArrival;
    private String nextLengthStay;
    private String resHotelId;
    private String updatedBy;
    private VipStatus vipStatus;

    /**
     * Creates new Customer
     */
    public Customer() {
        super();

        final String blanks = "";

        this.vipStatus = VipStatus.VIP_3;
        this.sourceId = 1l;
        this.preferredRoom = blanks;
        this.requests = blanks;
        
        this.creditCard = new CreditCard();
    }

	public Long getHotelId() {
		return hotelId;
	}

	public Long getCustomerId() {
		return customerId;
	}

	public Long getSourceId() {
		return sourceId;
	}

	public Long getPreferredHotelId() {
		return preferredHotelId;
	}

	public String getPreferredRoom() {
		return preferredRoom;
	}

	public String getRequests() {
		return requests;
	}

	public CreditCard getCreditCard() {
		return creditCard;
	}

	public String getMaritalStatus() {
		return maritalStatus;
	}

	public boolean isFutureReservation() {
		return futureReservation;
	}

	public String getNextReservation() {
		return nextReservation;
	}

	public String getNextReservationStatus() {
		return nextReservationStatus;
	}

	public String getNextArrival() {
		return nextArrival;
	}

	public String getNextLengthStay() {
		return nextLengthStay;
	}

	public String getResHotelId() {
		return resHotelId;
	}

	public String getUpdatedBy() {
		return updatedBy;
	}

	public VipStatus getVipStatus() {
		return vipStatus;
	}

	public void setHotelId(Long hotelId) {
		this.hotelId = hotelId;
	}

	public void setCustomerId(Long customerId) {
		this.customerId = customerId;
	}

	public void setSourceId(Long sourceId) {
		this.sourceId = sourceId;
	}

	public void setPreferredHotelId(Long preferredHotelId) {
		this.preferredHotelId = preferredHotelId;
	}

	public void setPreferredRoom(String preferredRoom) {
		this.preferredRoom = preferredRoom;
	}

	public void setRequests(String requests) {
		this.requests = requests;
	}

	public void setCreditCard(CreditCard creditCard) {
		this.creditCard = creditCard;
	}

	public void setMaritalStatus(String maritalStatus) {
		this.maritalStatus = maritalStatus;
	}

	public void setFutureReservation(boolean futureReservation) {
		this.futureReservation = futureReservation;
	}

	public void setNextReservation(String nextReservation) {
		this.nextReservation = nextReservation;
	}

	public void setNextReservationStatus(String nextReservationStatus) {
		this.nextReservationStatus = nextReservationStatus;
	}

	public void setNextArrival(String nextArrival) {
		this.nextArrival = nextArrival;
	}

	public void setNextLengthStay(String nextLengthStay) {
		this.nextLengthStay = nextLengthStay;
	}

	public void setResHotelId(String resHotelId) {
		this.resHotelId = resHotelId;
	}

	public void setUpdatedBy(String updatedBy) {
		this.updatedBy = updatedBy;
	}

	public void setVipStatus(VipStatus vipStatus) {
		this.vipStatus = vipStatus;
	}

}