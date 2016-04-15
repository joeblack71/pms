package com.myco.central.reservations.web.form;

import java.util.List;

import org.apache.commons.beanutils.DynaBean;

import com.myco.central.accounting.model.AccountCharge;

public class AccountChargeForm {
	
	private String selectedRoomNumber; 

	private AccountCharge item;
	private DynaBean roomBill; // an specif bill (testing)
	
	private List<DynaBean> inHouseRooms; // Occupied rooms
	private List<DynaBean> roomAccounts; // accounts for room 
	private List<AccountCharge> accountCharges; // charges in account
	
	private List<DynaBean> creditAccounts; // hotel credit accounts
	private List<DynaBean> checkTypes; // comandas, vales, etc.

	public String getSelectedRoomNumber() {
		return selectedRoomNumber;
	}

	public void setSelectedRoomNumber(String selectedRoomNumber) {
		this.selectedRoomNumber = selectedRoomNumber;
	}

	public List<DynaBean> getInHouseRooms() {
		return inHouseRooms;
	}

	public void setInHouseRooms(List<DynaBean> inHouseRooms) {
		this.inHouseRooms = inHouseRooms;
	}

	public List<AccountCharge> getAccountCharges() {
		return accountCharges;
	}

	public void setAccountCharges(List<AccountCharge> accountCharges) {
		this.accountCharges = accountCharges;
	}

	public AccountChargeForm() {
	    this.item = new AccountCharge();
	}
	
	public AccountCharge getItem() {
	    return item;
	}

	public void setItem(AccountCharge item) {
		this.item = item;
	}


    public List<DynaBean> getRoomAccounts() {
		return roomAccounts;
	}


    public void setRoomAccounts(List<DynaBean> roomAccounts) {
		this.roomAccounts = roomAccounts;
	}

	public List<DynaBean> getCreditAccounts() {
		return creditAccounts;
	}

	public void setCreditAccounts(List<DynaBean> creditAccounts) {
		this.creditAccounts = creditAccounts;
	}

	public List<DynaBean> getCheckTypes() {
		return checkTypes;
	}

	public void setCheckTypes(List<DynaBean> checkTypes) {
		this.checkTypes = checkTypes;
	}

	public DynaBean getRoomBill() {
		return roomBill;
	}

	public void setRoomBill(DynaBean roomBill) {
		this.roomBill = roomBill;
	}

}
