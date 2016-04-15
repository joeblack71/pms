package com.myco.central.commons.service;

import java.util.List;
import java.util.Map;

import com.myco.central.reservations.domain.HotelAccount;

public interface CommonsService {

	public List<Map<String, Object>> getHotels() throws Exception;

	public List<Map<String, Object>> getRoomTypes(String idHotel) throws Exception;

	public List<Map<String, Object>> getRoomNumbers(String idHotel, String roomType)
		throws Exception;

	public List<Map<String, Object>> getPeriodTypes() throws Exception;

	public List<Map<String, Object>> getPaymentTypes(List<HotelAccount> paymentTypes) 
		throws Exception;

}