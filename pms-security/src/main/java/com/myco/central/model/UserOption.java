/*
 * Option.java
 *
 * Created on December 11, 2006, 7:42 PM
 */

package com.myco.central.model;

public class UserOption {

    private String idMenu;
    private String idOption;
    private String description;
    private String URI;
    private String image;
    private boolean popup;
    private String title;

    /** Creates new UserOption */
    public UserOption() {
    }

    public String getIdMenu() {
		return idMenu;
	}

	public void setIdMenu(String idMenu) {
		this.idMenu = idMenu;
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

    public String getURI() {
        return URI;
    }
    public void setURI(String URI) {
        this.URI = URI;
    }

    public boolean getPopup() {
        return this.popup;
    }

    public void setPopup(boolean popup) {
        this.popup = popup;
    }

    public String getImage() {
        return image;
    }
    public void setImage(String image) {
        this.image = image;
    }

    public String getTitle() {
        return title;
    }
    public void setTitle(String title) {
        this.title = title;
    }

}
