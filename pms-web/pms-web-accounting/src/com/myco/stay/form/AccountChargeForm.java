package com.myco.stay.form;


import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.beanutils.DynaBean;
import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionMapping;

import com.myco.stay.vo.AccountCharge;

public class AccountChargeForm extends ActionForm {
	private static final long serialVersionUID = 1L;
	
	private String selectedRoomNumber; 

	private AccountCharge item;
	
	private List<DynaBean> inHouseRooms;
	private List<DynaBean> accountCharges;
	
	public String getSelectedRoomNumber() {
		return selectedRoomNumber;
	}

	public void setSelectedRoomNumber(String selectedRoomNumber) {
		this.selectedRoomNumber = selectedRoomNumber;
	}

	public List<DynaBean> getInHouseRooms() {
		return inHouseRooms;
	}

	public void setInHouseRooms(List<DynaBean> inHouseRooms) {
		this.inHouseRooms = inHouseRooms;
	}

	public List<DynaBean> getAccountCharges() {
		return accountCharges;
	}

	public void setAccountCharges(List<DynaBean> accountCharges) {
		this.accountCharges = accountCharges;
	}

	public AccountChargeForm() {
	    this.item = new AccountCharge();
	}
	
	public AccountCharge getItem() {
	    return item;
	}

	public void setItem(AccountCharge item) {
		this.item = item;
	}
	
    /**
     * Validamos las propiedades que se han establecido para esta petición HTTP,
     * y devolvemos un objeto <code>ActionErrors</code> que encapsula cualquier
     * error de validación que encontremos. Si no se encuentran errores, devolvemos
     * <code>null</code> o un objeto <code>ActionErrors</code> sin mensajes de error.
     **/
    public ActionErrors validate(ActionMapping mapping, HttpServletRequest request) {
        ActionErrors errors = new ActionErrors();
        
        if ( getItem() == null ) {
            //errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("global.required", "email"));
            //errors.add("email", new ActionMessage("global.required") );
        }
        
        return errors;
    }
    
	public void reset(ActionMapping arg0, HttpServletRequest arg1) {
	}

}
