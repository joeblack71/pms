
package com.myco.central.commons.model;

import java.util.ArrayList;
import java.util.List;


public class UserMenu {

    private String idMenu;
    private List<Option> options;

    /** Creates new UserMenu */
    public UserMenu() {
    	this.options = new ArrayList<Option>();
    }

	public String getIdMenu() {
		return idMenu;
	}

	public void setIdMenu(String idMenu) {
		this.idMenu = idMenu;
	}

	public List<Option> getOptions() {
		return options;
	}

	public void setOptions(List<Option> options) {
		this.options = options;
	}

}
