/*
 * TableElement.java
 *
 * Created on 22 de junio de 2007, 19:18
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package com.myco.central.commons.model;

/**
 *
 * @author Developer
 */
public class DataCatalog {
    
    private String idCatalog;
    private String idDataCatalog;
    private String description;

    public DataCatalog() {
    }

	public String getIdCatalog() {
		return idCatalog;
	}

	public void setIdCatalog(String idCatalog) {
		this.idCatalog = idCatalog;
	}

	public String getIdDataCatalog() {
        return this.idDataCatalog;
    }

    public void setIdDataCatalog(String idDataCatalog) {
        this.idDataCatalog = idDataCatalog;
    }
    
    public String getDescription() {
        return this.description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

}
