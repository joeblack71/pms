/*
 * Entity.java
 *
 * Created on October 26, 2006, 9:08 AM
 */

package beans;

/**
 *
 * @author  Johnny Olivas
 * @version
 */
public class Entity {

    private short  entityId;
    private String entityName;
    private String entityDoc;
    private String address1;
    private String address2;
    private String district;
    private String city;
    private String country;
    private String zipCode;
    private String phone1;
    private String phone2;
    private String fax;
    private String entityType; // Commerce, Goverment, Other
    private String webPage;
    private String contact;

    /** Creates new Entity */
    public Entity() {
        String SPACES = "";

        this.entityName = SPACES;
        this.entityDoc  = SPACES;
        this.address1   = SPACES;
        this.address2   = SPACES;
        this.district   = SPACES;
        this.city       = SPACES;
        this.country    = SPACES;
        this.zipCode    = SPACES;
        this.phone1     = SPACES;
        this.phone2     = SPACES;
        this.fax        = SPACES;
        this.setEntityType(SPACES);
        this.webPage    = SPACES;
        this.contact    = SPACES;
    }

    public short getEntityId() {
        return entityId;
    }
    public void setEntityId(short entityId) {
        this.entityId = entityId;
    }

    public String getEntityName() {
        return entityName;
    }
    public void setEntityName(String entityName) {
        this.entityName = entityName;
    }

    public String getEntityDoc() {
        return entityDoc;
    }
    public void setEntityDoc(String entityDoc) {
        this.entityDoc = entityDoc;
    }

    public String getAddress1() {
        return address1;
    }
    public void setAddress1(String address1) {
        this.address1 = address1;
    }

    public String getAddress2() {
        return address2;
    }
    public void setAddress2(String address2) {
        this.address2 = address2;
    }

    public String getDistrict() {
        return district;
    }
    public void setDistrict(String district) {
        this.district = district;
    }

    public String getCity() {
        return city;
    }
    public void setCity(String city) {
        this.city = city;
    }

    public String getCountry() {
        return country;
    }
    public void setCountry(String country) {
        this.country = country;
    }

    public String getZipCode() {
        return zipCode;
    }
    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }

    public String getPhone1() {
        return phone1;
    }
    public void setPhone1(String phone1) {
        this.phone1 = phone1;
    }

    public String getPhone2() {
        return phone2;
    }
    public void setPhone2(String phone2) {
        this.phone2 = phone2;
    }

    public String getFax() {
        return fax;
    }
    public void setFax(String fax) {
        this.fax = fax;
    }

    public String getEntityType() {
        return entityType;
    }
    public void setEntityType(String entityType) {
        this.entityType = entityType;
    }

    public String getWebPage() {
        return webPage;
    }
    public void setWebPage(String webPage) {
        this.webPage = webPage;
    }

    public String getContact() {
        return contact;
    }
    public void setContact(String contact) {
        this.contact = contact;
    }

}
