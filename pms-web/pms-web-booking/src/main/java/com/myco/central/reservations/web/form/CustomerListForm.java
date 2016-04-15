package com.myco.central.reservations.web.form;

import java.util.List;

import org.apache.commons.beanutils.DynaBean;

import com.myco.central.reservations.web.vo.CommonFilter;

public class CustomerListForm {
	private static final long serialVersionUID = 1L;
	
	private CommonFilter filter;
	private List<DynaBean> customers;
	
	public CustomerListForm() {
		this.filter = new CommonFilter();
	}
	
	public CommonFilter getFilter() {
		return filter;
	}

	public void setFilter(CommonFilter filter) {
		this.filter = filter;
	}

	public List<DynaBean> getCustomers() {
		return customers;
	}

	public void setCustomers(List<DynaBean> customers) {
		this.customers = customers;
	}

	//@Override
	/*public void reset(ActionMapping arg0, HttpServletRequest arg1) {
		/*this.field = null;
		this.pattern = null;
	}*/

	//@Override
	/*public ActionErrors validate(ActionMapping arg0, HttpServletRequest arg1) {
	        ActionErrors errors = new ActionErrors();
	        
	        if ( getIdHotel() == null ) {
	            //errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("global.required", "email"));
	            //errors.add("email", new ActionMessage("global.required") );
	        }
	        
	        return errors;
	}*/

}
