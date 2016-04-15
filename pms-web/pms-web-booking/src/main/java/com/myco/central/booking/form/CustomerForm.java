package com.myco.central.form;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionMapping;

import com.myco.central.vo.Customer;
import com.myco.central.vo.Reservation;

public class CustomerForm extends ActionForm {
	private static final long serialVersionUID = 1L;
	
	private Customer item;
	
	public CustomerForm() {
		this.item = new Customer();
	}
	
	public Customer getItem() {
		return item;
	}

	public void setItem(Customer item) {
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
