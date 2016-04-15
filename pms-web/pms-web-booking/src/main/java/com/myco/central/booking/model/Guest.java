/*
 * Guest.java
 *
 * Created on May 07, 2007, 7:42 PM
 */

package com.myco.central.vo;

/**
 *
 * @author  Johnny Olivas
 * @version 1.0
 */
public class Guest {

    private String hotelId;
    private String reservationNumber;
    private String roomNumber;
    private String customerId;
    private String customerDocument;
    private String customerNames;
    /**
     * Se utiliza para controlar si un cliente registrado en una reserva
     * debe o no ser grabado en la tabla 'reservation_guest'. Con esto
     * evitamos el intentar grabar registros que ya existen en la tabla.
     * TODO probar eliminando todos los huespedes registrados y adicionar
     * solo los que estan en la lista que contiene los huespedes de la reserva
     */
    private String status;

    /** Creates new Guest */
    public Guest() {
    }

	public String getHotelId() {
		return hotelId;
	}

	public void setHotelId(String hotelId) {
		this.hotelId = hotelId;
	}

	public String getReservationNumber() {
		return reservationNumber;
	}

	public void setReservationNumber(String reservationNumber) {
		this.reservationNumber = reservationNumber;
	}

	public String getRoomNumber() {
		return roomNumber;
	}

	public void setRoomNumber(String roomNumber) {
		this.roomNumber = roomNumber;
	}

	public String getCustomerId() {
		return customerId;
	}

	public void setCustomerId(String customerId) {
		this.customerId = customerId;
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

}
