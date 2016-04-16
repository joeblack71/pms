/*
 * Reservation.java
 *
 * Created on December 8, 2007, 15:10 PM
 */

package com.myco.central.booking.dto;

import java.time.LocalDate;
import java.util.List;

import com.myco.central.booking.model.Guest;

/**
 *
 * @author Johnny Olivas
 * @version
 */
public class ReservationDto {

	private String hotelId;
	private String reservationId;
	private String type;
	private LocalDate arrival;
	private LocalDate departure;
	private String nights;
	private String flight;
	private String adults;
	private String children;
	private String roomType;
	private String packageId;
	private String quantity;
	private String roomNumber;
	private String vipCode;
	private String voucher;

	private String roomRate;
	private String total;
	private String paymentDue;
	private String paymentType;
	private List<Guest> guests; // testing
	private String sourceId;
	private String sourceName;
	private String contactName;
	private String hotelInstructions;
	private String guestInstructions;
	private String madeBy;
	private String madeOn;
	private String updatedBy;
	private String updatedOn;
	private String status;

	public ReservationDto() {}

	public String getAdults() {
		return adults;
	}

	public LocalDate getArrival() {
		return arrival;
	}

	public String getChildren() {
		return children;
	}


	public String getContactName() {
		return contactName;
	}

	public LocalDate getDeparture() {
		return departure;
	}

	public String getFlight() {
		return flight;
	}

	public String getGuestInstructions() {
		return guestInstructions;
	}

	public List<Guest> getGuests() {
		return guests;
	}

	public String getHotelId() {
		return hotelId;
	}

	public String getHotelInstructions() {
		return hotelInstructions;
	}

	public String getMadeBy() {
		return madeBy;
	}

	public String getMadeOn() {
		return madeOn;
	}

	public String getNights() {
		return nights;
	}

	public String getPackageId() {
		return packageId;
	}

	public String getPaymentDue() {
		return paymentDue;
	}

	public String getPaymentType() {
		return paymentType;
	}

	public String getQuantity() {
		return quantity;
	}

	public String getReservationId() {
		return reservationId;
	}

	public String getRoomNumber() {
		return roomNumber;
	}

	public String getRoomRate() {
		return roomRate;
	}

	public String getRoomType() {
		return roomType;
	}

	public String getSourceId() {
		return sourceId;
	}

	public String getSourceName() {
		return sourceName;
	}

	public String getStatus() {
		return status;
	}

	public String getTotal() {
		return total;
	}

	public String getType() {
		return type;
	}

	public String getUpdatedBy() {
		return updatedBy;
	}

	public String getUpdatedOn() {
		return updatedOn;
	}

	public String getVipCode() {
		return vipCode;
	}


	public String getVoucher() {
		return voucher;
	}

	public void setAdults(String adults) {
		this.adults = adults;
	}

	public void setArrival(LocalDate arrival) {
		this.arrival = arrival;
	}

	public void setChildren(String children) {
		this.children = children;
	}

	public void setContactName(String contactName) {
		this.contactName = contactName;
	}

	public void setDeparture(LocalDate departure) {
		this.departure = departure;
	}

	public void setFlight(String flight) {
		this.flight = flight;
	}

	public void setGuestInstructions(String guestInstructions) {
		this.guestInstructions = guestInstructions;
	}

	public void setGuests(List<Guest> guests) {
		this.guests = guests;
	}

	public void setHotelId(String hotelId) {
		this.hotelId = hotelId;
	}

	public void setHotelInstructions(String hotelInstructions) {
		this.hotelInstructions = hotelInstructions;
	}

	public void setMadeBy(String madeBy) {
		this.madeBy = madeBy;
	}

	public void setMadeOn(String madeOn) {
		this.madeOn = madeOn;
	}

	public void setNights(String nights) {
		this.nights = nights;
	}

	public void setPackageId(String packageId) {
		this.packageId = packageId;
	}

	public void setPaymentDue(String paymentDue) {
		this.paymentDue = paymentDue;
	}

	public void setPaymentType(String paymentType) {
		this.paymentType = paymentType;
	}

	public void setQuantity(String quantity) {
		this.quantity = quantity;
	}

	public void setReservationId(String reservationId) {
		this.reservationId = reservationId;
	}

	public void setRoomNumber(String roomNumber) {
		this.roomNumber = roomNumber;
	}

	public void setRoomRate(String roomRate) {
		this.roomRate = roomRate;
	}

	public void setRoomType(String roomType) {
		this.roomType = roomType;
	}

	public void setSourceId(String sourceId) {
		this.sourceId = sourceId;
	}

	public void setSourceName(String sourceName) {
		this.sourceName = sourceName;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public void setTotal(String total) {
		this.total = total;
	}

	public void setType(String type) {
		this.type = type;
	}

	public void setUpdatedBy(String updatedBy) {
		this.updatedBy = updatedBy;
	}

	public void setUpdatedOn(String updatedOn) {
		this.updatedOn = updatedOn;
	}

	public void setVipCode(String vipCode) {
		this.vipCode = vipCode;
	}

	public void setVoucher(String voucher) {
		this.voucher = voucher;
	}

}
