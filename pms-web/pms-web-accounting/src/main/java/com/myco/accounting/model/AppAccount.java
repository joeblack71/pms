/*
 * Item.java
 *
 * Created on March 02, 2007, 2:29 PM
 */

package beans;

/**
 *
 * @author  Johnny Olivas
 * @version
 */
public class AppAccount implements java.io.Serializable{

    private short  itemId;
    private String description;
    private String abbreviation;
    private String accountType; // C=Credito, D=Debito

    /** Creates new Item */
    public AppAccount() {
    }

    public short getItemId() {
        return itemId;
    }
    public void setItemId(short _itemId) {
        this.itemId = _itemId;
    }

    public String getDescription() {
        return description;
    }
    public void setDescription(String _description) {
        this.description = _description;
    }

    public String getAbbreviation() {
        return abbreviation;
    }
    public void setAbbreviation(String _abbreviation) {
        this.abbreviation = _abbreviation;
    }

    public String getAccountType() {
        return accountType;
    }
    public void setAccountType(String _accountType) {
        this.accountType = _accountType;
    }

}