/*
 * Reservation.java
 *
 * Created on December 8, 2007, 15:10 PM
 */

package com.myco.central.booking.model;

import java.util.Date;
import java.util.List;

import javax.persistence.Entity;

import com.myco.central.model.BaseAuditable;

@Entity
public class Reservation extends BaseAuditable {

	private static final long serialVersionUID = 1L;

	private Long hotelId;
	private Long reservationId;
	private String type;
	private Date arrival;
	private Date departure;
	private int nights;
	private String flight;
	private int adults;
	private int children;
	private Long roomTypeId;
	private Long packageId;
	private int quantity;
	private String roomNumber;
	private String vipCode;
	private String voucher;

	private Double roomRate;
	private Double total;
	private Date paymentDue;
	private String paymentType;
	private List<Guest> guests; // testing
	private Long sourceId;
	private String sourceName;
	private String contactName;
	private String hotelInstructions;
	private String guestInstructions;
	private String status;

	public Reservation() {}

	public Long getHotelId() {
		return hotelId;
	}

	public Long getReservationId() {
		return reservationId;
	}

	public String getType() {
		return type;
	}

	public Date getArrival() {
		return arrival;
	}

	public Date getDeparture() {
		return departure;
	}

	public int getNights() {
		return nights;
	}

	public String getFlight() {
		return flight;
	}

	public int getAdults() {
		return adults;
	}

	public int getChildren() {
		return children;
	}

	public Long getRoomTypeId() {
		return roomTypeId;
	}

	public Long getPackageId() {
		return packageId;
	}

	public int getQuantity() {
		return quantity;
	}

	public String getRoomNumber() {
		return roomNumber;
	}

	public String getVipCode() {
		return vipCode;
	}

	public String getVoucher() {
		return voucher;
	}

	public Double getRoomRate() {
		return roomRate;
	}

	public Double getTotal() {
		return total;
	}

	public Date getPaymentDue() {
		return paymentDue;
	}

	public String getPaymentType() {
		return paymentType;
	}

	public List<Guest> getGuests() {
		return guests;
	}

	public Long getSourceId() {
		return sourceId;
	}

	public String getSourceName() {
		return sourceName;
	}

	public String getContactName() {
		return contactName;
	}

	public String getHotelInstructions() {
		return hotelInstructions;
	}

	public String getGuestInstructions() {
		return guestInstructions;
	}

	public String getStatus() {
		return status;
	}

	public void setHotelId(Long hotelId) {
		this.hotelId = hotelId;
	}

	public void setReservationId(Long reservationId) {
		this.reservationId = reservationId;
	}

	public void setType(String type) {
		this.type = type;
	}

	public void setArrival(Date arrival) {
		this.arrival = arrival;
	}

	public void setDeparture(Date departure) {
		this.departure = departure;
	}

	public void setNights(int nights) {
		this.nights = nights;
	}

	public void setFlight(String flight) {
		this.flight = flight;
	}

	public void setAdults(int adults) {
		this.adults = adults;
	}

	public void setChildren(int children) {
		this.children = children;
	}

	public void setRoomTypeId(Long roomTypeId) {
		this.roomTypeId = roomTypeId;
	}

	public void setPackageId(Long packageId) {
		this.packageId = packageId;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public void setRoomNumber(String roomNumber) {
		this.roomNumber = roomNumber;
	}

	public void setVipCode(String vipCode) {
		this.vipCode = vipCode;
	}

	public void setVoucher(String voucher) {
		this.voucher = voucher;
	}

	public void setRoomRate(Double roomRate) {
		this.roomRate = roomRate;
	}

	public void setTotal(Double total) {
		this.total = total;
	}

	public void setPaymentDue(Date paymentDue) {
		this.paymentDue = paymentDue;
	}

	public void setPaymentType(String paymentType) {
		this.paymentType = paymentType;
	}

	public void setGuests(List<Guest> guests) {
		this.guests = guests;
	}

	public void setSourceId(Long sourceId) {
		this.sourceId = sourceId;
	}

	public void setSourceName(String sourceName) {
		this.sourceName = sourceName;
	}

	public void setContactName(String contactName) {
		this.contactName = contactName;
	}

	public void setHotelInstructions(String hotelInstructions) {
		this.hotelInstructions = hotelInstructions;
	}

	public void setGuestInstructions(String guestInstructions) {
		this.guestInstructions = guestInstructions;
	}

	public void setStatus(String status) {
		this.status = status;
	}

}
