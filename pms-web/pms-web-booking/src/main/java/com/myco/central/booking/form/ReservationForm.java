package com.myco.central.web.booking.form;

import com.myco.central.booking.model.Guest;
import com.myco.central.booking.model.Reservation;

import java.util.List;
import java.util.Map;

public class ReservationForm {
    // contiene informacion del huesped en pantalla
    private Guest guestView;

    private Reservation item;
    // Indica el tipo de operacion a efectuar en la reserva (Insert, Update, ..)
    private String operationExpected;

    private List<Map<String,String>> paymentTypeList;
    private List<Map<String,String>> reservationStatusList;
    private List<Map<String,String>> roomNumberList;

    //private List<RoomType> roomTypeList;
    private List<Map<String,String>> roomTypeList;
    private String sourceName;
    private String sourcePhone;
    private String testing;

    public ReservationForm() {
        this.item = new Reservation();
        this.guestView = new Guest();
    }

    public Guest getGuestView() {
        return guestView;
    }

    public Reservation getItem() {
        return item;
    }

    public String getOperationExpected() {
        return operationExpected;
    }

    public List<Map<String,String>> getPaymentTypeList() {
        return paymentTypeList;
    }

    public List<Map<String,String>> getReservationStatusList() {
        return reservationStatusList;
    }

    public List<Map<String,String>> getRoomNumberList() {
        return roomNumberList;
    }

    public List<Map<String,String>> getRoomTypeList() {
        return roomTypeList;
    }

    public String getSourceName() {
        return sourceName;
    }

    public String getSourcePhone() {
        return sourcePhone;
    }

    public String getTesting() {
        return testing;
    }

    public void setGuestView(Guest guestView) {
        this.guestView = guestView;
    }

    public void setItem(Reservation item) {
        this.item = item;
    }

    public void setOperationExpected(String operationExpected) {
        this.operationExpected = operationExpected;
    }

    public void setPaymentTypeList(List<Map<String,String>> paymentTypeList) {
        this.paymentTypeList = paymentTypeList;
    }

    public void setReservationStatusList(List<Map<String,String>> reservationStatusList) {
        this.reservationStatusList = reservationStatusList;
    }

    public void setRoomNumberList(List<Map<String,String>> roomNumberList) {
        this.roomNumberList = roomNumberList;
    }

    public void setRoomTypeList(List<Map<String,String>> roomTypeList) {
        this.roomTypeList = roomTypeList;
    }

    public void setSourceName(String sourceName) {
        this.sourceName = sourceName;
    }

    public void setSourcePhone(String sourcePhone) {
        this.sourcePhone = sourcePhone;
    }

    public void setTesting(String testing) {
        this.testing = testing;
    }

}
