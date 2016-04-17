/*
 * Person.java
 *
 * Created on October 26, 2006, 9:08 AM
 * Last Modification: 15/02/07 11:50 AM
 *
 */

package com.myco.central.commons.dto;

/**
 *
 * @author  Johnny Olivas
 * @version
 */
public class PersonDto extends BaseDto {
	private static final long serialVersionUID = 1L;

	private String firstName;
    private String lastName1;
    private String lastName2;
    private String documentType;   // Passport, DNI, Carnet, etc.
    private String documentNumber;
    private String title;          // Mr., Ms., Miss, etc.
    private String birthDate;
    private String nationality;
    private String occupation;
    private String emails;
    private AddressDto address;
    private PhoneDto	phone1;
    private PhoneDto	phone2;
    private PhoneDto	phone3;

    /** Creates new Person */
    public PersonDto() {
        birthDate  = "0000-00-00";
        
        this.address = new AddressDto();
        this.phone1 = new PhoneDto();
        this.phone2 = new PhoneDto();
        this.phone3 = new PhoneDto();
    }

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
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

	public String getDocumentType() {
		return documentType;
	}

	public void setDocumentType(String documentType) {
		this.documentType = documentType;
	}

	public String getDocumentNumber() {
		return documentNumber;
	}

	public void setDocumentNumber(String documentNumber) {
		this.documentNumber = documentNumber;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getBirthDate() {
		return birthDate;
	}

	public void setBirthDate(String birthDate) {
		this.birthDate = birthDate;
	}

	public String getNationality() {
		return nationality;
	}

	public void setNationality(String nationality) {
		this.nationality = nationality;
	}

	public String getOccupation() {
		return occupation;
	}

	public void setOccupation(String occupation) {
		this.occupation = occupation;
	}

	public AddressDto getAddress() {
		return address;
	}

	public void setAddress(AddressDto address) {
		this.address = address;
	}

	public PhoneDto getPhone1() {
		return phone1;
	}

	public void setPhone1(PhoneDto phone1) {
		this.phone1 = phone1;
	}

	public PhoneDto getPhone2() {
		return phone2;
	}

	public void setPhone2(PhoneDto phone2) {
		this.phone2 = phone2;
	}

	public PhoneDto getPhone3() {
		return phone3;
	}

	public void setPhone3(PhoneDto phone3) {
		this.phone3 = phone3;
	}

	public String getEmails() {
		return emails;
	}

	public void setEmails(String emails) {
		this.emails = emails;
	}

}