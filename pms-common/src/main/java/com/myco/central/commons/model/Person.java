/*
 * Person.java
 *
 * Created on October 26, 2006, 9:08 AM
 * Last Modification: 15/02/07 11:50 AM
 *
 */

package com.myco.central.commons.model;

import java.util.List;

import javax.persistence.*;

/**
 *
 * @author  Johnny Olivas
 * @version
 */
@Entity
@Table(name = "Person")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "rolePerson", discriminatorType = DiscriminatorType.STRING, length = 20)
public class Person /*extends Party*/{
    private Long id;
    private String firstName;
    private String midleName;
    private String lastName;
    private String secondLastName;
    private String title; // Mr., Ms., Miss, etc.
    private String documentType; // Passport, DNI, Carnet, etc. // TODO This should an entity by its own
    private String documentNumber;
    private String birthDate;
    private String nationality;
    private String occupation;
    private Address address;
    private List<String> emails;
    private List<Phone> phones;

    public Person() {}

    @OneToOne(cascade = CascadeType.ALL)
    public Address getAddress() {
        return address;
    }

    public String getBirthDate() {
        return this.birthDate;
    }

    public String getDocumentNumber() {
        return this.documentNumber;
    }

    public String getDocumentType() {
        return this.documentType;
    }

    public String getFirstName() {
        return this.firstName;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public Long getId() {
        return id;
    }

    public String getLastName() {
        return this.lastName;
    }

    public String getNationality() {
        return this.nationality;
    }

    public String getOccupation() {
        return this.occupation;
    }

    public String getSecondLastName() {
        return secondLastName;
    }

    //    @OneToMany(mappedBy = "person")
    //    public List<Phone> getPhones() {
    //        return phones;
    //    }

    public String getTitle() {
        return title;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public void setBirthDate(String birthDate) {
        this.birthDate = birthDate;
    }

    public void setDocumentNumber(String documentNumber) {
        this.documentNumber = documentNumber;
    }

    public void setDocumentType(String documentType) {
        this.documentType = documentType;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setNationality(String nationality) {
        this.nationality = nationality;
    }

    public void setOccupation(String occupation) {
        this.occupation = occupation;
    }

    public void setSecondLastName(String secondLastName) {
        this.secondLastName = secondLastName;
    }

    public void setTitle(String title) {
        this.title = title;
    }

	public List<Phone> getPhones() {
		return phones;
	}

	public void setPhones(List<Phone> phones) {
		this.phones = phones;
	}

	public String getMidleName() {
		return midleName;
	}

	public void setMidleName(String midleName) {
		this.midleName = midleName;
	}

	public void setEmails(List<String> emails) {
		this.emails = emails;
	}

	public List<String> getEmails() {
		return emails;
	}

}