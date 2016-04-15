package com.myco.central.reservations.web.form;

import java.util.List;

import org.apache.commons.beanutils.DynaBean;

import com.myco.central.reservations.domain.Guest;
import com.myco.central.reservations.domain.Reservation;

public class ReservationForm {
	private static final long serialVersionUID = 1L;

	private Reservation item;

	private String sourceName;
	private String sourcePhone;

	// contiene informacion del huesped en pantalla
	private Guest guestView;
	private String testing;
	// Indica el tipo de operacion a efectuar en la reserva (Insert, Update, ..)
	private String operationExpected;

	private List<DynaBean> reservationStatusList;
	//private List<RoomType> roomTypeList;
	private List<DynaBean> roomTypeList;
	private List<DynaBean> roomNumberList;
	private List<DynaBean> paymentTypeList;

	public ReservationForm() {
		this.item = new Reservation();
		this.guestView = new Guest();
	}
	
	public Reservation getItem() {
		return item;
	}

	public void setItem(Reservation item) {
		this.item = item;
	}
	
	public Guest getGuestView() {
		return guestView;
	}

	public void setGuestView(Guest guestView) {
		this.guestView = guestView;
	}

	public String getOperationExpected() {
		return operationExpected;
	}

	public void setOperationExpected(String operationExpected) {
		this.operationExpected = operationExpected;
	}

	public List<DynaBean> getRoomTypeList() {
		return roomTypeList;
	}

	public void setRoomTypeList(List<DynaBean> roomTypeList) {
		this.roomTypeList = roomTypeList;
	}

	public List<DynaBean> getRoomNumberList() {
		return roomNumberList;
	}

	public void setRoomNumberList(List<DynaBean> roomNumberList) {
		this.roomNumberList = roomNumberList;
	}

	public List<DynaBean> getReservationStatusList() {
		return reservationStatusList;
	}

	public void setReservationStatusList(List<DynaBean> reservationStatusList) {
		this.reservationStatusList = reservationStatusList;
	}

	public List<DynaBean> getPaymentTypeList() {
		return paymentTypeList;
	}

	public void setPaymentTypeList(List<DynaBean> paymentTypeList) {
		this.paymentTypeList = paymentTypeList;
	}

	public String getTesting() {
		return testing;
	}

	public void setTesting(String testing) {
		this.testing = testing;
	}

	public String getSourceName() {
		return sourceName;
	}

	public void setSourceName(String sourceName) {
		this.sourceName = sourceName;
	}

	public String getSourcePhone() {
		return sourcePhone;
	}

	public void setSourcePhone(String sourcePhone) {
		this.sourcePhone = sourcePhone;
	}

}
