/*
 * Person.java
 *
 * Created on October 26, 2006, 9:08 AM
 * Last Modification: 15/02/07 11:50 AM
 *
 */

package beans;

import java.io.Serializable;

/**
 *
 * @author  Johnny Olivas
 * @version
 */
public class Person implements Serializable {

    private String firstNames;
    private String lastName1;
    private String lastName2;
    private String documentType;   // Passport, DNI, Carnet, etc.
    private String documentNumber;
    private String title;          // Sr., Sra., Dr., Etc.
    private String birthDate;
    private String nationality;
    private String occupation;
    private String address1;
    private String address2;
    private String district;
    private String city;
    private String country;        // Residence country
    private String zipCode;        // ZIP code
    private String phone1;
    private String phone2;
    private String email;

    /** Creates new Person */
    public Person() {
    }

    public String getFirstNames() {
        return firstNames;
    }
    public void setFirstNames(String _firstNames) {
        this.firstNames = _firstNames;
    }

    public String getLastName1() {
        return lastName1;
    }
    public void setLastName1(String _lastName1) {
        this.lastName1 = _lastName1;
    }

    public String getLastName2() {
        return lastName2;
    }
    public void setLastName2(String _lastName2) {
        this.lastName2 = _lastName2;
    }

    public String getDocumentType() {
        return documentType;
    }
    public void setDocumentType(String _documentType) {
        this.documentType = _documentType;
    }

    public String getDocumentNumber() {
        return documentNumber;
    }
    public void setDocumentNumber(String _documentNumber) {
        this.documentNumber = _documentNumber;
    }

    public String getTitle() {
        return title;
    }
    public void setTitle(String _title) {
        this.title = _title;
    }

    public String getBirthDate() {
        return birthDate;
    }
    public void setBirthDate(String _birthDate) {
        this.birthDate = _birthDate;
    }

    public String getNationality() {
        return nationality;
    }
    public void setNationality(String _nationality) {
        this.nationality = _nationality;
    }

    public String getOccupation() {
        return occupation;
    }
    public void setOccupation(String _occupation) {
        this.occupation = _occupation;
    }

    public String getAddress1() {
        return address1;
    }
    public void setAddress1(String _address1) {
        this.address1 = _address1;
    }

    public String getAddress2() {
        return address2;
    }
    public void setAddress2(String _address2) {
        this.address2 = _address2;
    }

    public String getDistrict() {
        return district;
    }
    public void setDistrict(String _district) {
        this.district = _district;
    }

    public String getCity() {
        return city;
    }
    public void setCity(String _city) {
        this.city = _city;
    }

    public String getCountry() {
        return country;
    }
    public void setCountry(String _country) {
        this.country = _country;
    }

    public String getZipCode() {
        return zipCode;
    }
    public void setZipCode(String _zipCode) {
        this.zipCode = _zipCode;
    }

    public String getPhone1() {
        return phone1;
    }
    public void setPhone1(String _phone1) {
        this.phone1 = _phone1;
    }

    public String getPhone2() {
        return phone2;
    }
    public void setPhone2(String _phone2) {
        this.phone2 = _phone2;
    }

    public String getEmail() {
        return email;
    }
    public void setEmail(String _email) {
        this.email = _email;
    }

}
