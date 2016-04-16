package com.myco.central.commons.dto;

public class ContactDto extends BaseDto {
	private static final long serialVersionUID = 1L;

	private String idContact;
	private String lastName1;
	private String lastName2;
	private String firstNames;
	private String birthdate;
	private String emails;
	private String comments;
	private PhoneDto  phone1;

	public ContactDto() {
        this.phone1 = new PhoneDto();
	}

	public String getIdContact() {
		return idContact;
	}
	public void setIdContact(String idContact) {
		this.idContact = idContact;
	}
	public String getLastName1() {
		return lastName1;
	}
	public void setLastName1(String lastName1) {
		this.lastName1 = lastName1;
	}
	public String getLastName2() {
		return lastName2;
	}
	public void setLastName2(String lastName2) {
		this.lastName2 = lastName2;
	}
	public String getFirstNames() {
		return firstNames;
	}
	public void setFirstNames(String firstNames) {
		this.firstNames = firstNames;
	}
	public String getBirthdate() {
		return birthdate;
	}
	public void setBirthdate(String birthdate) {
		this.birthdate = birthdate;
	}
	public String getEmails() {
		return emails;
	}
	public void setEmails(String emails) {
		this.emails = emails;
	}
	public String getComments() {
		return comments;
	}
	public void setComments(String comments) {
		this.comments = comments;
	}
	public PhoneDto getPhone1() {
		return phone1;
	}
	public void setPhone1(PhoneDto phone1) {
		this.phone1 = phone1;
	}

}
