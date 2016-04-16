/*
 * Option.java
 *
 * Created on December 11, 2006, 7:42 PM
 */

package com.myco.central.model;

/*
 * Menu option
 */
public class Option {

    private String idOption;
    private String description;
    private String idParent;

    /** Creates new Option */
    public Option() {
    }

	public String getIdOption() {
		return idOption;
	}

	public void setIdOption(String idOption) {
		this.idOption = idOption;
	}

	public String getDescription() {
        return description;
    }
    public void setDescription(String description) {
        this.description = description;
    }

    public String getIdParent() {
		return idParent;
	}

	public void setIdParent(String idParent) {
		this.idParent = idParent;
	}

}
