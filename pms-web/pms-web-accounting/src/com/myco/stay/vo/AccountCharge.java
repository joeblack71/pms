/*
 * AccountCharge.java
 *
 * Created on Febrery 17, 2008, 09:30 PM
 * Last Modification:
 *
 */

package com.myco.stay.vo;


/**
 *
 * @author  Johnny Olivas
 * @version
 */
public class AccountCharge {

    private String idFolio;
    private String roomNumber;
    private String accountCharge;
    private String receipt; // comanda / vale ..
    private String amount;
    private String madeBy;
    private String madeOn;

    /**
     * Creates new AccountCharge
     */
    public AccountCharge() {
        final String SPACES = "";

        //this.idSource = SPACES;
    }

	public String getIdFolio() {
		return idFolio;
	}

	public void setIdFolio(String idFolio) {
		this.idFolio = idFolio;
	}

	public String getRoomNumber() {
		return roomNumber;
	}

	public void setRoomNumber(String roomNumber) {
		this.roomNumber = roomNumber;
	}

	public String getAccountCharge() {
		return accountCharge;
	}

	public void setAccountCharge(String accountCharge) {
		this.accountCharge = accountCharge;
	}

	public String getReceipt() {
		return receipt;
	}

	public void setReceipt(String receipt) {
		this.receipt = receipt;
	}

	public String getAmount() {
		return amount;
	}

	public void setAmount(String amount) {
		this.amount = amount;
	}

	public String getMadeBy() {
		return madeBy;
	}

	public void setMadeBy(String madeBy) {
		this.madeBy = madeBy;
	}

	public String getMadeOn() {
		return madeOn;
	}

	public void setMadeOn(String madeOn) {
		this.madeOn = madeOn;
	}

}