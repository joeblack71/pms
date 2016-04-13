/*
 * ReservationGuest.java
 *
 * Created on May 07, 2007, 7:42 PM
 */

package com.mycom.booking.beans;

/**
 *
 * @author  Johnny Olivas
 * @version 1.0
 */
public class ReservationGuest {

    private short  hotelId;
    private int    reservationNumber;
    private short  customerId;
    private String customerDocument;
    private String customerName;
    private char   status;

    /** Creates new ReservationGuest */
    public ReservationGuest() {
    }

    public short getHotelId() {
        return hotelId;
    }

    public void setHotelId(short hotelId) {
        this.hotelId = hotelId;
    }

    public int getReservationNumber() {
        return reservationNumber;
    }

    public void setReservationNumber(int reservationNumber) {
        this.reservationNumber = reservationNumber;
    }

    public short getCustomerId() {
        return customerId;
    }

    public void setCustomerId(short customerId) {
        this.customerId = customerId;
    }

    public String getCustomerDocument() {
        return customerDocument;
    }

    public void setCustomerDocument(String customerDocument) {
        this.customerDocument = customerDocument;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public char getStatus() {
        return this.status;
    }

    /**
     * Se utiliza para controlar si un cliente registrado en una reserva
     * debe o no ser grabado en la tabla 'reservation_guest'. Con esto
     * evitamos el intentar grabar registros que ya existen en la tabla.
     */
    public void setStatus(char status) {
        this.status = status;
    }

}
