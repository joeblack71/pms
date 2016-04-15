/*
 * TableItem.java
 *
 * Created on 16 de mayo de 2007, 11:09
 */

package com.myco.central.commons.model;

/**
 * @author Developer
 */
public class Catalog {
    
    private String idTable;
    private String idItem;
    private String description;
    private String status;

    public Catalog() {}

	public String getIdTable() {
		return idTable;
	}

	public void setIdTable(String idTable) {
		this.idTable = idTable;
	}

	public String getIdItem() {
		return idItem;
	}

	public void setIdItem(String idItem) {
		this.idItem = idItem;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

}
