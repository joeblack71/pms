package com.myco.central.model;

import javax.persistence.Entity;

@Entity
public class Hotel extends BaseAuditable {

	private static final long serialVersionUID = 1L;

	private String code;
	private String description;
	private int totalRooms;
	private int availableRooms;
	private int blockedRooms;
	private int maintenanceRooms;
	private String category;
	private String location;
	private String city;
	private String country;

	public Hotel() {
	}

	public String getCode() {
		return code;
	}

	public String getDescription() {
		return description;
	}

	public int getTotalRooms() {
		return totalRooms;
	}

	public int getAvailableRooms() {
		return availableRooms;
	}

	public int getBlockedRooms() {
		return blockedRooms;
	}

	public int getMaintenanceRooms() {
		return maintenanceRooms;
	}

	public String getCategory() {
		return category;
	}

	public String getLocation() {
		return location;
	}

	public String getCity() {
		return city;
	}

	public String getCountry() {
		return country;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public void setTotalRooms(int totalRooms) {
		this.totalRooms = totalRooms;
	}

	public void setAvailableRooms(int availableRooms) {
		this.availableRooms = availableRooms;
	}

	public void setBlockedRooms(int blockedRooms) {
		this.blockedRooms = blockedRooms;
	}

	public void setMaintenanceRooms(int maintenanceRooms) {
		this.maintenanceRooms = maintenanceRooms;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public void setCountry(String country) {
		this.country = country;
	}

}
