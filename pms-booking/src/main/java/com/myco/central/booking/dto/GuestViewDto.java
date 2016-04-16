package com.myco.central.booking.dto;

/**
 * Store information regarding the current guest shown in reservation
 * 
 * @author Developer
 *
 */
public class GuestViewDto {
	
	private String idGuest;
	private String guestNames;
	private String nationality;
	private String idCompany;
	private String phoneNumber;
	private String contactName;
	private String guestInstructions;

	public GuestViewDto() {
		this.guestNames = "";
		this.idGuest = "";
		this.nationality = "";
		this.idCompany = "";
		this.phoneNumber = "";
		this.contactName = "";
		this.guestInstructions = "";
	}
	
	public String getGuestNames() {
		return guestNames;
	}

	public void setGuestNames(String guestNames) {
		this.guestNames = guestNames;
	}
	
	public String getIdGuest() {
		return idGuest;
	}

	public void setIdGuest(String idGuest) {
		this.idGuest = idGuest;
	}

	public String getNationality() {
		return nationality;
	}
	
	public void setNationality(String nationality) {
		this.nationality = nationality;
	}
	
	public String getIdCompany() {
		return idCompany;
	}

	public void setIdCompany(String idCompany) {
		this.idCompany = idCompany;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}
	
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	
	public String getContactName() {
		return contactName;
	}
	
	public void setContactName(String contactName) {
		this.contactName = contactName;
	}
	
	public String getGuestInstructions() {
		return guestInstructions;
	}
	
	public void setGuestInstructions(String guestInstructions) {
		this.guestInstructions = guestInstructions;
	}

}
