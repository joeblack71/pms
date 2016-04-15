/*
 * Customer.java
 *
 * Created on Febrery 15, 2007, 12:00 PM
 * Last Modification:
 *
 */

package com.myco.central.commons.model;



/**
 *
 * @author  Johnny Olivas
 * @version
 */
public class Customer extends Person {

    private String idCustomer;
    private String idSource;
    private String vipStatus;
    private String preferredHotel;
    private String preferredRoom;
    private String requests;
    private String hotelRegistration;
    /*private String  creditCardCo;      // Visa, Masterd Card, etc.
    private long    creditCardNumber;
    private Date    creditCardExpiration;
    private String  maritalStatus;
    private boolean futureReservation; // more than one
    private String nextReservation;
    private String nextReservationStatus;
    private String nextArrival;
    private String nextLengthStay;
    private String resHotelId;*/
    private String status;
	private String madeBy;
    private String madeOn;
    private String updatedBy;
    private String lastUpdate;

    public String getUpdatedBy() {
		return updatedBy;
	}

	public void setUpdatedBy(String updatedBy) {
		this.updatedBy = updatedBy;
	}

	public String getLastUpdate() {
		return lastUpdate;
	}

	public void setLastUpdate(String lastUpdate) {
		this.lastUpdate = lastUpdate;
	}

	/**
     * Creates new Customer
     */
    public Customer() {
        super();

        final String SPACES = "";

        this.vipStatus     = "2";
        this.idSource        = SPACES;
        this.preferredRoom = SPACES;
        this.requests      = SPACES;
    }

	public String getIdCustomer() {
		return idCustomer;
	}

	public void setIdCustomer(String idCustomer) {
		this.idCustomer = idCustomer;
	}

	public String getIdSource() {
		return idSource;
	}

	public void setIdSource(String idSource) {
		this.idSource = idSource;
	}

	public String getVipStatus() {
		return vipStatus;
	}

	public void setVipStatus(String vipStatus) {
		this.vipStatus = vipStatus;
	}

	public String getPreferredHotel() {
		return preferredHotel;
	}

	public void setPreferredHotel(String preferredHotel) {
		this.preferredHotel = preferredHotel;
	}

	public String getPreferredRoom() {
		return preferredRoom;
	}

	public void setPreferredRoom(String preferredRoom) {
		this.preferredRoom = preferredRoom;
	}

	public String getRequests() {
		return requests;
	}

	public void setRequests(String requests) {
		this.requests = requests;
	}

	public String getMadeBy() {
		return madeBy;
	}

	public void setMadeBy(String madeBy) {
		this.madeBy = madeBy;
	}

	public String getMadeOn() {
		return madeOn;
	}

	public void setMadeOn(String madeOn) {
		this.madeOn = madeOn;
	}

	public String getHotelRegistration() {
		return hotelRegistration;
	}

	public void setHotelRegistration(String hotelRegistration) {
		this.hotelRegistration = hotelRegistration;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

}