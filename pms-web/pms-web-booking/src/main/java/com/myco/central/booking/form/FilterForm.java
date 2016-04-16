package com.myco.central.web.form;

import java.util.List;

public class FilterForm {
    private String endDate;
    private List<String> hotels;
    private String idHotel;
    private String idRoomType;
    private String password;
    private List<String> periods;

    private List<String> roomTypes;
    private String startDate;
    private String userName;

    public FilterForm() {
    }

    public String getEndDate() {
        return endDate;
    }
    public List<String> getHotels() {
        return hotels;
    }

    public String getIdHotel() {
        return idHotel;
    }
    public String getIdRoomType() {
        return idRoomType;
    }

    public String getPassword() {
        return password;
    }
    public List<String> getPeriods() {
        return periods;
    }

    public List<String> getRoomTypes() {
        return roomTypes;
    }

    public String getStartDate() {
        return startDate;
    }

    public String getUserName() {
        return userName;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }

    public void setHotels(List<String> hotels) {
        this.hotels = hotels;
    }

    public void setIdHotel(String hotelId) {
        this.idHotel = hotelId;
    }

    public void setIdRoomType(String idRoomType) {
        this.idRoomType = idRoomType;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setPeriods(List<String> periods) {
        this.periods = periods;
    }

    public void setRoomTypes(List<String> roomTypes) {
        this.roomTypes = roomTypes;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

}
