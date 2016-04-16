package com.myco.central.commons.dto;

/**
 * @author Developer
 */
public class CatalogDto extends BaseDto {
	private static final long serialVersionUID = 1L;

	private String idTable;
    private String idItem;
    private String description;
    private String status;

    public CatalogDto() {}

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
