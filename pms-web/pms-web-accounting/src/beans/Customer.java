/*
 * Customer.java
 *
 * Created on October 26, 2006, 9:08 AM
 */

package beans;

/**
 *
 * @author  Johnny Olivas
 * @version
 */
public class Customer {

    private int    hotel;
    private String document;
    private String lastname;
    private String middlename;
    private String firstname;
    private String address;
    private String country;
    private String phone;
    private String fax;
    private String contact;

    /** Creates new Empresa */
    public Customer() {
    }

    public int getHotel() {
        return hotel;
    }
    public void setHotel(int hotel) {
        this.hotel = hotel;
    }

    public String getDocument() {
        return document;
    }
    public void setDocument(String document) {
        this.document = document;
    }

    public String getLastname() {
        return lastname;
    }
    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getMiddlename() {
        return middlename;
    }
    public void setMiddlename(String middlename) {
        this.middlename = middlename;
    }

    public String getFirstname() {
        return firstname;
    }
    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getAddress() {
        return address;
    }
    public void setAddress(String address) {
        this.address = address;
    }

    public String getCountry() {
        return country;
    }
    public void setCountry(String country) {
        this.country = country;
    }

    public String getPhone() {
        return phone;
    }
    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getFax() {
        return fax;
    }
    public void setFax(String fax) {
        this.fax = fax;
    }

    public String getContact() {
        return contact;
    }
    public void setContact(String contact) {
        this.contact = contact;
    }

}
