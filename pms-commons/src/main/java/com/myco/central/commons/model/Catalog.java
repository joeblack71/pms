/*
 * TableItem.java
 *
 * Created on 16 de mayo de 2007, 11:09
 */

package com.myco.central.commons.model;

import javax.persistence.Entity;

@Entity
public class Catalog extends BaseEntity {
    
	private static final long serialVersionUID = 1L;

	private Long tableId;
	private Long itemId;
    private String description;
    private String status;

    public Catalog() {}

	public Long getTableId() {
		return tableId;
	}

	public Long getItemId() {
		return itemId;
	}

	public String getDescription() {
		return description;
	}

	@Override
	public String getStatus() {
		return status;
	}

	public void setTableId(Long tableId) {
		this.tableId = tableId;
	}

	public void setItemId(Long itemId) {
		this.itemId = itemId;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	@Override
	public void setStatus(String status) {
		this.status = status;
	}

}
