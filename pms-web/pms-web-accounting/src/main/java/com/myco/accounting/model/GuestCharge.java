/*
 * GuestCharge.java
 *
 * Created on January 29, 2007, 21:30 PM
 */

package beans;

import java.sql.Date;

/**
 *
 * @author  Johnny Olivas
 * @version
 */
public class GuestCharge {

    private byte   hotel;
    private String roomNumber;
    private int    folio;
    private Date   dateCharge;
    private int    account;
    private short  quantity;
    private float  amount;
    private String cashier;

    /** Creates new GuestCharge */
    public GuestCharge() {
        String SPACES = "";
        short  S_ZERO = 0;
        int    I_ZERO = 0;
        float  F_ZERO = 0;
        Date   D_ZERO = new Date(0);

        this.roomNumber = SPACES;
        this.folio      = I_ZERO;
        this.dateCharge = D_ZERO;
        this.account    = I_ZERO;
        this.quantity   = S_ZERO;
        this.amount     = F_ZERO;
    }

    /** Hotel Destination **/
    public byte getHotel() {
        return hotel;
    }
    public void setHotel(byte hotel) {
        this.hotel = hotel;
    }

    /** Room Number **/
    public String getRoomNumber() {
        return roomNumber;
    }
    public void setRoomNumber(String roomNumber) {
        this.roomNumber = roomNumber;
    }

    /** Folio number **/
    public int getFolio() {
        return folio;
    }
    public void setFolio(int folio) {
        this.folio = folio;
    }

    /** Date charge **/
    public Date getDateCharge() {
        return dateCharge;
    }
    public void setDateCharge(Date dateCharge) {
        this.dateCharge = dateCharge;
    }

    /** Account of charge **/
    public int getAccount() {
        return account;
    }
    public void setAccount(int account) {
        this.account = account;
    }

    /** Rooms Quantity **/
    public short getQuantity() {
        return quantity;
    }
    public void setQuantity(short quantity) {
        this.quantity = quantity;
    }

    /** Amount of charge **/
    public float getAmount() {
        return amount;
    }
    public void setAmount(float amount) {
        this.amount = amount;
    }

    /** Cashier **/
    public String getCashier() {
        return cashier;
    }
    public void setCashier(String cashier) {
        this.cashier = cashier;
    }

}
