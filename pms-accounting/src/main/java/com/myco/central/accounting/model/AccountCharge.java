package com.myco.central.accounting.model;

import java.util.Date;

/**
 *
 * @author  Johnny Olivas
 * @version
 */
public class AccountCharge extends HotelAccount {

	private static final long serialVersionUID = 1L;

	private String accountCode;
	private Date chargeDate;
	private Long checkNumber;
	private String checkType;
	private String description;
	private Long accountId;
	private Long billId;
	private Long customerId;
	private Long hotelId;
	private Long receipt; // comanda / vale ..
	private String sequence;
	private String status;
	private Double totalCharge;

	/**
	 * Creates new AccountCharge
	 */
	public AccountCharge() {
	}

	public String getAccountCode() {
		return accountCode;
	}

	public Date getChargeDate() {
		return chargeDate;
	}

	public Long getCheckNumber() {
		return checkNumber;
	}

	public String getCheckType() {
		return checkType;
	}

	@Override
	public String getDescription() {
		return description;
	}

	@Override
	public Long getAccountId() {
		return accountId;
	}

	public Long getBillId() {
		return billId;
	}

	public Long getCustomerId() {
		return customerId;
	}

	@Override
	public Long getHotelId() {
		return hotelId;
	}

	public Long getReceipt() {
		return receipt;
	}

	public String getSequence() {
		return sequence;
	}

	@Override
	public String getStatus() {
		return status;
	}

	public Double getTotalCharge() {
		return totalCharge;
	}

	public void setAccountCode(String accountCode) {
		this.accountCode = accountCode;
	}

	public void setChargeDate(Date chargeDate) {
		this.chargeDate = chargeDate;
	}

	public void setCheckNumber(Long checkNumber) {
		this.checkNumber = checkNumber;
	}

	public void setCheckType(String checkType) {
		this.checkType = checkType;
	}

	@Override
	public void setDescription(String description) {
		this.description = description;
	}

	@Override
	public void setAccountId(Long accountId) {
		this.accountId = accountId;
	}

	public void setBillId(Long billId) {
		this.billId = billId;
	}

	public void setCustomerId(Long customerId) {
		this.customerId = customerId;
	}

	@Override
	public void setHotelId(Long hotelId) {
		this.hotelId = hotelId;
	}

	public void setReceipt(Long receipt) {
		this.receipt = receipt;
	}

	public void setSequence(String sequence) {
		this.sequence = sequence;
	}

	@Override
	public void setStatus(String status) {
		this.status = status;
	}

	public void setTotalCharge(Double totalCharge) {
		this.totalCharge = totalCharge;
	}

}