
package com.myco.central.web.util;

import java.util.List;
import java.util.Map;

import com.myco.central.commons.dto.CountryDto;
import com.myco.central.web.ui.dto.HotelDto;
import com.myco.central.web.ui.dto.SourceTypeDto;

public class ContextAttributes {

    private String hotelId;

    //CENTRAL DE RESERVAS
    private List<HotelDto> hotels;

    private List<Map<String, Object>> reservationStatusList;
    private List<Map<String, Object>> titles; // Mr. Mrs. Miss Ms.
    private List<CountryDto> countries;
    private List<Map<String, Object>> cities;
    private List<Map<String, Object>> streetTypes;
    private List<Map<String, Object>> documentTypes;
    //private List<Map<String, Object>> customerTitles;
    private List<Map<String, Object>> vipStatusList;
    private List<Map<String, Object>> months;
    private List<Map<String, Object>> amountSales;
    private List<Map<String, Object>> categories;
    private List<SourceTypeDto> sourceTypes;
    private List<Map<String, Object>> segments;
    private List<Map<String, Object>> specialRates;

	public String getHotelId() {
		return hotelId;
	}

	public void setHotelId(String hotelId) {
		this.hotelId = hotelId;
	}

	public List<HotelDto> getHotels() {
		return hotels;
	}

	public void setHotels(List<HotelDto> hotels) {
		this.hotels = hotels;
	}

	public List<Map<String, Object>> getReservationStatusselect() {
		return reservationStatusList;
	}

	public void setReservationStatusselect(List<Map<String, Object>> reservationStatusList) {
		this.reservationStatusList = reservationStatusList;
	}

	public List<Map<String, Object>> getTitles() {
		return titles;
	}

	public void setTitles(List<Map<String, Object>> titles) {
		this.titles = titles;
	}

	public List<Map<String, Object>> getCities() {
		return cities;
	}

	public void setCities(List<Map<String, Object>> cities) {
		this.cities = cities;
	}

	public List<Map<String, Object>> getStreetTypes() {
		return streetTypes;
	}

	public void setStreetTypes(List<Map<String, Object>> streetTypes) {
		this.streetTypes = streetTypes;
	}

	public List<Map<String, Object>> getDocumentTypes() {
		return documentTypes;
	}

	public void setDocumentTypes(List<Map<String, Object>> documentTypes) {
		this.documentTypes = documentTypes;
	}

	public List<Map<String, Object>> getVipStatusselect() {
		return vipStatusList;
	}

	public void setVipStatusselect(List<Map<String, Object>> vipStatusList) {
		this.vipStatusList = vipStatusList;
	}

	public List<Map<String, Object>> getMonths() {
		return months;
	}

	public void setMonths(List<Map<String, Object>> months) {
		this.months = months;
	}

	public List<Map<String, Object>> getAmountSales() {
		return amountSales;
	}

	public void setAmountSales(List<Map<String, Object>> amountSales) {
		this.amountSales = amountSales;
	}

    public List<Map<String, Object>> getCategories() {
		return categories;
	}

	public void setCategories(List<Map<String, Object>> categories) {
		this.categories = categories;
	}

	public List<SourceTypeDto> getSourceTypes() {
		return sourceTypes;
	}

	public void setSourceTypes(List<SourceTypeDto> sourceTypes) {
		this.sourceTypes = sourceTypes;
	}

	public List<Map<String, Object>> getSegments() {
		return segments;
	}

	public void setSegments(List<Map<String, Object>> segments) {
		this.segments = segments;
	}

	public List<Map<String, Object>> getSpecialRates() {
		return specialRates;
	}

	public void setSpecialRates(List<Map<String, Object>> specialRates) {
		this.specialRates = specialRates;
	}

	public List<CountryDto> getCountries() {
		return countries;
	}

	public void setCountries(List<CountryDto> countries) {
		this.countries = countries;
	}

}