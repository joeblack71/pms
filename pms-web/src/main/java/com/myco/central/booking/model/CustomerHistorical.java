/*
 * CustomerHistorical.java
 *
 * Created on Febrery 15, 2007, 11:55 AM
 * Last Modification:
 *
 */

package com.mycom.booking.beans;

/**
 *
 * @author  Johnny Olivas
 * @version
 */
public class CustomerHistorical implements java.io.Serializable {

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

    /*public String getSource() {
        return firstNames;
    }
    public void setSource(String _source) {
        this.source = _source;
    }*/

}