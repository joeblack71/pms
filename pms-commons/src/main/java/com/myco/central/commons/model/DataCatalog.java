/*
 * TableElement.java
 *
 * Created on 22 de junio de 2007, 19:18
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package com.myco.central.commons.model;

import javax.persistence.Entity;

@Entity
public class DataCatalog extends BaseEntity {
    
	private static final long serialVersionUID = 1L;

	private Long catalogId;
    private String description;

	public DataCatalog() {
	}

	public Long getCatalogId() {
		return catalogId;
	}

	public String getDescription() {
		return description;
	}

	public void setCatalogId(Long catalogId) {
		this.catalogId = catalogId;
	}

	public void setDescription(String description) {
		this.description = description;
	}

}
