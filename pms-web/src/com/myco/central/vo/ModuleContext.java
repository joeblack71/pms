
package com.myco.central.vo;

import java.util.List;

import javax.swing.text.Segment;
import javax.xml.transform.Source;

public class ModuleContext {

    private String hotelId;

    private List<ReservationStatus> reservationStatusList;
    private List<PaymentType> paymentTypeList;
    private List<Country> countryList;
    private List<City> cityList;
    private List<Segment> segmentList;
    private List<Source> sourceList;
    private List<SpecialRate> specialRateList;
    private List<DocumentType> documentTypeList;
    private List<RoomType> roomTypeList;

    /** Creates new AppUser */
    public ModuleContext() {
    }

	public String getHotelId() {
		return hotelId;
	}

	public void setHotelId(String hotelId) {
		this.hotelId = hotelId;
	}

	public List<ReservationStatus> getReservationStatusList() {
		return reservationStatusList;
	}

	public void setReservationStatusList(
			List<ReservationStatus> reservationStatusList) {
		this.reservationStatusList = reservationStatusList;
	}

	public List<PaymentType> getPaymentTypeList() {
		return paymentTypeList;
	}

	public void setPaymentTypeList(List<PaymentType> paymentTypeList) {
		this.paymentTypeList = paymentTypeList;
	}

	public List<Country> getCountryList() {
		return countryList;
	}

	public void setCountryList(List<Country> countryList) {
		this.countryList = countryList;
	}

	public List<City> getCityList() {
		return cityList;
	}

	public void setCityList(List<City> cityList) {
		this.cityList = cityList;
	}

	public List<Segment> getSegmentList() {
		return segmentList;
	}

	public void setSegmentList(List<Segment> segmentList) {
		this.segmentList = segmentList;
	}

	public List<Source> getSourceList() {
		return sourceList;
	}

	public void setSourceList(List<Source> sourceList) {
		this.sourceList = sourceList;
	}

	public List<SpecialRate> getSpecialRateList() {
		return specialRateList;
	}

	public void setSpecialRateList(List<SpecialRate> specialRateList) {
		this.specialRateList = specialRateList;
	}

	public List<DocumentType> getDocumentTypeList() {
		return documentTypeList;
	}

	public void setDocumentTypeList(List<DocumentType> documentTypeList) {
		this.documentTypeList = documentTypeList;
	}

	public List<RoomType> getRoomTypeList() {
		return roomTypeList;
	}

	public void setRoomTypeList(List<RoomType> roomTypeList) {
		this.roomTypeList = roomTypeList;
	}

}