/*
 * ForeignCustomer.java
 *
 * Created on Febrery 15, 2007, 12:10 PM
 * Last Modification:
 *
 */

package com.mycom.booking.beans;

import java.io.Serializable;

/**
 *
 * @author  Johnny Olivas
 * @version
 */
public class ForeignCustomer extends Customer {

    private String passport;
    private String dateIssued;
    private String placeIssued;
    private String visaNumber;
    private String comingFrom;
    private String goingTo;

    /**
     * Creates new ForeignCustomer
     */
    public ForeignCustomer() {
    }

    public String getPassport() {
        return passport;
    }
    public void setPassport(String _passport) {
        this.passport = _passport;
    }

    public String getDateIssued() {
        return dateIssued;
    }
    public void setDateIssued(String _dateIssued) {
        this.dateIssued = _dateIssued;
    }

    public String getPlaceIssued() {
        return placeIssued;
    }
    public void setPlaceIssued(String _placeIssued) {
        this.placeIssued = _placeIssued;
    }

    public String getVisaNumber() {
        return visaNumber;
    }
    public void setVisaNumber(String _visaNumber) {
        this.visaNumber = _visaNumber;
    }

    public String getComingFrom() {
        return comingFrom;
    }
    public void setComingFrom(String _comingFrom) {
        this.comingFrom = _comingFrom;
    }

    public String getGoingTo() {
        return goingTo;
    }
    public void setGoingTo(String _goingTo) {
        this.goingTo = _goingTo;
    }

}