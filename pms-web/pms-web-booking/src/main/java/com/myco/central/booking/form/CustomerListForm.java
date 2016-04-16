package com.myco.central.web.form;

import com.myco.central.web.vo.CommonFilterVo;

import java.util.List;
import java.util.Map;

public class CustomerListForm {
    private List<Map<String,String>> customers;
    private CommonFilterVo filter;

    public CustomerListForm() {
        this.filter = new CommonFilterVo();
    }

    public List<Map<String,String>> getCustomers() {
        return customers;
    }

    public CommonFilterVo getFilter() {
        return filter;
    }

    public void setCustomers(List<Map<String,String>> customers) {
        this.customers = customers;
    }

    public void setFilter(CommonFilterVo filter) {
        this.filter = filter;
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
