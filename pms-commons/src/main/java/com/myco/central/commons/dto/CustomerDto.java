/*
 * Customer.java
 *
 * Created on Febrery 15, 2007, 12:00 PM
 * Last Modification:
 *
 */

package com.myco.central.commons.dto;

/**
 *
 * @author  Johnny Olivas
 * @version
 */
public class CustomerDto extends PersonDto {
	private static final long serialVersionUID = 1L;

	private String hotelRegistration;
    private String idCustomer;
    private String idSource;
    private String preferredHotel;
    private String preferredRoom;
    private String requests;
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
    private String updatedBy;
    private String vipStatus;

    /**
     * Creates new Customer
     */
    public CustomerDto() {
        super();

        final String SPACES = "";

        this.vipStatus = "2";
        this.idSource = SPACES;
        this.preferredRoom = SPACES;
        this.requests = SPACES;
    }

    public String getHotelRegistration() {
        return hotelRegistration;
    }

    public String getIdCustomer() {
        return idCustomer;
    }

    public String getIdSource() {
        return idSource;
    }

    public String getPreferredHotel() {
        return preferredHotel;
    }

    public String getPreferredRoom() {
        return preferredRoom;
    }

    public String getRequests() {
        return requests;
    }

    public String getUpdatedBy() {
        return updatedBy;
    }

    public String getVipStatus() {
        return vipStatus;
    }

    public void setHotelRegistration(String hotelRegistration) {
        this.hotelRegistration = hotelRegistration;
    }

    public void setIdCustomer(String idCustomer) {
        this.idCustomer = idCustomer;
    }

    public void setIdSource(String idSource) {
        this.idSource = idSource;
    }

    public void setPreferredHotel(String preferredHotel) {
        this.preferredHotel = preferredHotel;
    }

    public void setPreferredRoom(String preferredRoom) {
        this.preferredRoom = preferredRoom;
    }

    public void setRequests(String requests) {
        this.requests = requests;
    }

    public void setUpdatedBy(String updatedBy) {
        this.updatedBy = updatedBy;
    }

    public void setVipStatus(String vipStatus) {
        this.vipStatus = vipStatus;
    }

}