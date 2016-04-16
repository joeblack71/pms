/*
 * TableElement.java
 *
 * Created on 22 de junio de 2007, 19:18
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package com.myco.central.model;

/**
 *
 * @author Developer
 */
public class TableElement {
    
    private String idElement;
    private String stringId;
    private String description;

    public TableElement() {
    }

	public String getIdElement() {
		return idElement;
	}

	public void setIdElement(String idElement) {
		this.idElement = idElement;
	}

	public String getStringId() {
        return this.stringId;
    }

    public void setStringId(String stringId) {
        this.stringId = stringId;
    }
    
    public String getDescription() {
        return this.description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

}
