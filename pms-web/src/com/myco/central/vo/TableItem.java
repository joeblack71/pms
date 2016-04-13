/*
 * TableItem.java
 *
 * Created on 16 de mayo de 2007, 11:09
 */

package com.myco.central.vo;

/**
 * @author Developer
 */
public class TableItem {
    
    private short   tableId;
    private short   itemId;
    private String  itemDescription;
    private boolean itemStatus;

    public TableItem() {
    }

    public short getTableId() {
        return tableId;
    }

    public void setTableId(short tableId) {
        this.tableId = tableId;
    }

    public short getItemId() {
        return this.itemId;
    }

    public void setItemId(short itemId) {
        this.itemId = itemId;
    }

    public String getItemDescription() {
        return this.itemDescription;
    }

    public void setItemDescription(String itemDescription) {
        this.itemDescription = itemDescription;
    }

    public boolean isItemStatus() {
        return this.itemStatus;
    }

    public void setItemStatus(boolean itemStatus) {
        this.itemStatus = itemStatus;
    }

    
}
