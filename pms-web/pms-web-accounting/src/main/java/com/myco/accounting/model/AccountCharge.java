package com.myco.central.accounting.model;

/**
 *
 * @author  Johnny Olivas
 * @version
 */
public class AccountCharge {

    private String idHotel;
    private String idCustomer;
    private String idBill;
    private String secuence;
    private String chargeDate;
    private String idAccount;
    private String accountCode;
    private String description;
    private String receipt; // comanda / vale ..
    private String totalCharge;
    private String checkType;
    private String checkNumber;
    private String status;
    private String madeOn;
    private String madeBy;

    /**
     * Creates new AccountCharge
     */
    public AccountCharge() {
    }

	public String getIdBill() {
		return idBill;
	}

	public void setIdBill(String idBill) {
		this.idBill = idBill;
	}

	public String getReceipt() {
		return receipt;
	}

	public void setReceipt(String receipt) {
		this.receipt = receipt;
	}

	public String getSecuence() {
		return secuence;
	}

	public void setSecuence(String secuence) {
		this.secuence = secuence;
	}

	public String getIdAccount() {
		return idAccount;
	}

	public void setIdAccount(String idAccount) {
		this.idAccount = idAccount;
	}

	public String getTotalCharge() {
		return totalCharge;
	}

	public void setTotalCharge(String totalCharge) {
		this.totalCharge = totalCharge;
	}

	public String getCheckType() {
		return checkType;
	}

	public void setCheckType(String checkType) {
		this.checkType = checkType;
	}

	public String getCheckNumber() {
		return checkNumber;
	}

	public void setCheckNumber(String checkNumber) {
		this.checkNumber = checkNumber;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
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

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getIdHotel() {
		return idHotel;
	}

	public void setIdHotel(String idHotel) {
		this.idHotel = idHotel;
	}

	public String getIdCustomer() {
		return idCustomer;
	}

	public void setIdCustomer(String idCustomer) {
		this.idCustomer = idCustomer;
	}

	public String getAccountCode() {
		return accountCode;
	}

	public void setAccountCode(String accountCode) {
		this.accountCode = accountCode;
	}

	public String getChargeDate() {
		return chargeDate;
	}

	public void setChargeDate(String chargeDate) {
		this.chargeDate = chargeDate;
	}

}