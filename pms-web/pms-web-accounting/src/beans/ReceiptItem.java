/*
 * ReceiptItem.java
 *
 * Created on March 02, 2007, 12:05 PM
 */

package beans;

import java.io.Serializable;

/**
 *
 * @author  Johnny Olivas
 * @version
 */
public class ReceiptItem implements Serializable{

    private short  hotelId;
    private short  receiptType;
    private short  receiptSerial;
    private int    correlative;
    private String chargeDate;     // date
    private int    itemId;
    private short  quantity;
    private double price;
    private double totalCharge;
    private String status;
    private String operatorInitials; // who mades this charge

    /**
   * Creates new ReceiptItem
   */
    public ReceiptItem() {
        String SPACES = "";
        this.chargeDate        = SPACES;
        this.operatorInitials = SPACES;
    }

    public short getHotelId() {
        return hotelId;
    }
    public void setHotelId(short _hotelId) {
        this.hotelId = _hotelId;
    }

    public short getReceiptType() {
        return receiptType;
    }
    public void setReceiptType(short _receiptType) {
        this.receiptType = _receiptType;
    }

    public short getReceiptSerial() {
        return receiptSerial;
    }
    public void setReceiptSerial(short _receiptSerial) {
        this.receiptSerial = _receiptSerial;
    }

    public int getCorrelative() {
        return correlative;
    }
    public void setCorrelative(int _correlative) {
        this.correlative = _correlative;
    }

    public String getChargeDate() {
        return chargeDate;
    }
    public void setChargeDate(String _chargeDate) {
        this.chargeDate = _chargeDate;
    }

    public int getItemId() {
        return itemId;
    }
    public void setItemId(int _itemId) {
        this.itemId = _itemId;
    }

    public short getQuantity() {
        return quantity;
    }
    public void setQuantity(short _quantity) {
        this.quantity = _quantity;
    }

    public double getPrice() {
        return price;
    }
    public void setPrice(double _price) {
        this.price = _price;
    }

    public double getTotalCharge() {
        return totalCharge;
    }
    public void setTotalCharge(double _totalCharge) {
        this.totalCharge = _totalCharge;
    }

    public String getStatus() {
        return status;
    }
    public void setStatus(String _status) {
        this.status = _status;
    }

    public String getOperatorInitials() {
        return operatorInitials;
    }
    public void setOperatorInitials(String _operatorInitials) {
        this.operatorInitials = _operatorInitials;
    }

}