/*
 * RoomType.java
 *
 * Created on 18 de marzo de 2005, 02:54 PM
 */

package com.myco.central.reservations.domain;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

/**
 * @author Johnny Olivas
 */
public class SpecialRate implements Serializable {

	// private PropertyChangeSupport propertySupport;
	private static final long serialVersionUID = 1L;

	private String idHotel;
	private String idSpecialRate;
	private String description;
	private String status;

	private List<Map<String, Object>> rates;

	public SpecialRate() {
	}

	public String getIdHotel() {
		return idHotel;
	}

	public void setIdHotel(String idHotel) {
		this.idHotel = idHotel;
	}

	public String getIdSpecialRate() {
		return idSpecialRate;
	}

	public void setIdSpecialRate(String idSpecialRate) {
		this.idSpecialRate = idSpecialRate;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public List<Map<String, Object>> getRates() {
		return rates;
	}

	public void setRates(List<Map<String, Object>> rates) {
		this.rates = rates;
	}

}