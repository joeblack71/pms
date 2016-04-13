/*
 * Customer.java
 *
 * Created on Febrery 15, 2007, 12:00 PM
 * Last Modification:
 *
 */

package com.mycom.booking.beans;

import java.sql.Date;

/**
 *
 * @author  Johnny Olivas
 * @version
 */
public class Customer extends Person {

    private short   hotelId;
    private short   customerId;
    private String  source;
    private boolean contact;
    private short   vipStatus;
    private short   preferredHotel;
    private String  preferredRoom;
    private String  requests;
    private short   operatorId;         // who registered guest
    private String  madeBy;
    private Date    madeOn;
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

    /**
     * Creates new Customer
     */
    public Customer() {
        super();
        String SPACES = "";
        source        = SPACES;
        preferredRoom = SPACES;
        requests      = SPACES;
    }

    public short getHotelId() {
        return hotelId;
    }
    public void setHotelId(short hotelId) {
        this.hotelId = hotelId;
    }

    public short getCustomerId() {
        return customerId;
    }
    public void setCustomerId(short customerId) {
        this.customerId = customerId;
    }

    public String getSource() {
        return source;
    }
    public void setSource(String source) {
        this.source = source;
    }

    public boolean getContact() {
        return contact;
    }
    public void setContact(boolean contact) {
        this.contact = contact;
    }

    public short getVipStatus() {
        return vipStatus;
    }
    public void setVipStatus(short vipStatus) {
        this.vipStatus = vipStatus;
    }

    public short getPreferredHotel() {
        return preferredHotel;
    }
    public void setPreferredHotel(short preferredHotel) {
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

    public Date getMadeOn() {
        return madeOn;
    }

    public void setMadeOn(Date madeOn) {
        this.madeOn = madeOn;
    }

    public String getMadeBy() {
        return madeBy;
    }
    public void setMadeBy(String madeBy) {
        this.madeBy = madeBy;
    }

}