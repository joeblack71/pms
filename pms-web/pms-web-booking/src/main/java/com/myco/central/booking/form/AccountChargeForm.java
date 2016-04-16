package com.myco.central.web.booking.form;

import com.myco.central.accounting.model.AccountCharge;

import java.util.List;
import java.util.Map;

public class AccountChargeForm {

    private List<AccountCharge> accountCharges; // charges in account

    private List<Map<String, String>> checkTypes; // comandas, vales, etc.
    private List<Map<String, String>> creditAccounts; // hotel credit accounts

    private List<Map<String, String>> inHouseRooms; // Occupied rooms
    private AccountCharge item;
    private List<Map<String, String>> roomAccounts; // accounts for room

    private Map<String, String> roomBill; // an specif bill (testing)
    private String selectedRoomNumber;

    public AccountChargeForm() {
        this.item = new AccountCharge();
    }

    public List<AccountCharge> getAccountCharges() {
        return accountCharges;
    }

    public List<Map<String, String>> getCheckTypes() {
        return checkTypes;
    }

    public List<Map<String, String>> getCreditAccounts() {
        return creditAccounts;
    }

    public List<Map<String, String>> getInHouseRooms() {
        return inHouseRooms;
    }

    public AccountCharge getItem() {
        return item;
    }

    public List<Map<String, String>> getRoomAccounts() {
        return roomAccounts;
    }

    public Map<String, String> getRoomBill() {
        return roomBill;
    }

    public String getSelectedRoomNumber() {
        return selectedRoomNumber;
    }


    public void setAccountCharges(List<AccountCharge> accountCharges) {
        this.accountCharges = accountCharges;
    }


    public void setCheckTypes(List<Map<String, String>> checkTypes) {
        this.checkTypes = checkTypes;
    }

    public void setCreditAccounts(List<Map<String, String>> creditAccounts) {
        this.creditAccounts = creditAccounts;
    }

    public void setInHouseRooms(List<Map<String, String>> inHouseRooms) {
        this.inHouseRooms = inHouseRooms;
    }

    public void setItem(AccountCharge item) {
        this.item = item;
    }

    public void setRoomAccounts(List<Map<String, String>> roomAccounts) {
        this.roomAccounts = roomAccounts;
    }

    public void setRoomBill(Map<String, String> roomBill) {
        this.roomBill = roomBill;
    }

    public void setSelectedRoomNumber(String selectedRoomNumber) {
        this.selectedRoomNumber = selectedRoomNumber;
    }

}
