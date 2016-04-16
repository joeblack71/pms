/*
 * RoomType.java
 *
 * Created on 18 de marzo de 2005, 02:54 PM
 */

package com.myco.central.model;

import javax.persistence.Entity;

/**
 * @author Johnny Olivas
 */
@Entity
public class RoomType extends BaseAuditable {

	private static final long serialVersionUID = 1L;

	private Long hotelId;
	private String code;
    private String description;
	private int totalRooms;
	private int availableRooms;
	private int blockedRooms;
	private Double rackRate;
    private String status;

	public RoomType() {
	}

	public int getAvailableRooms() {
		return availableRooms;
	}

	public int getBlockedRooms() {
		return blockedRooms;
	}

	public String getCode() {
		return code;
	}

	public String getDescription() {
		return description;
	}

	public Long getHotelId() {
		return hotelId;
	}

	public Double getRackRate() {
		return rackRate;
	}

	public String getStatus() {
		return status;
	}

	public int getTotalRooms() {
		return totalRooms;
	}

	public void setAvailableRooms(int availableRooms) {
		this.availableRooms = availableRooms;
	}

	public void setBlockedRooms(int blockedRooms) {
		this.blockedRooms = blockedRooms;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public void setHotelId(Long hotelId) {
		this.hotelId = hotelId;
	}

	public void setRackRate(Double rackRate) {
		this.rackRate = rackRate;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public void setTotalRooms(int totalRooms) {
		this.totalRooms = totalRooms;
	}

}