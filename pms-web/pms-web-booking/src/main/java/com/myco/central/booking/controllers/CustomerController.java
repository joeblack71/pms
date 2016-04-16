
package com.myco.central.web.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.multiaction.MultiActionController;

import com.myco.central.commons.service.CustomerService;

public class CustomerController extends MultiActionController {
    @SuppressWarnings("unused")
    private CustomerService customerService;

    Log log = LogFactory.getLog(getClass());

    public ModelAndView customerEdit(HttpServletRequest request,
            HttpServletResponse response) throws Exception {

        ModelAndView modelAndView = new ModelAndView("");

        //    	Customer customer = new Customer();

        //    	String idRegistrationHotel = request.getParameter("idHotel");
        //    	String idCustomer = request.getParameter("idCustomer");
        //    	String documentNumber = request.getParameter("documentNumber");

        //    	try {
        //        	if ( StringUtils.isNotBlank(idCustomer) || StringUtils.isNotBlank(documentNumber) ) {
        //        		customer.setIdCustomer(idCustomer);
        //        		customer.setDocumentNumber(documentNumber);
        //        		customer = customerService.search(customer);
        //        		if ( customer == null ) {
        //        			chargeActionMessages(request, "Customer id: " + idCustomer + "doesn�t exist");
        //        		}
        //        		editForm.setCust(customer);
        //            } else {
        //    			chargeActionMessages(request, "Either idCustomer or documentNumber is blank: " +idCustomer+","+documentNumber);
        //            }
        //        } catch(ServiceException ex) {
        //			chargeActionMessages(request, "CustomerService couldn't retrieve customer item");
        //    		log.info( ex.getMessage() );
        //        }

        //        if ( !messages.isEmpty() ) {
        //        	saveMessages(request, messages);
        //        }

        return modelAndView;
    }

    /**
     *
     * @return una lista conteniendo los huespedes registrados en el sistema
     * @throws ServletException
     * @throws IOException
     */
    public ModelAndView customerselect(HttpServletRequest request,
            HttpServletResponse response) throws Exception {
        ModelAndView modelAndView = new ModelAndView("");

        //        CommonFilter commonFilter = listForm.getFilter();
        //	    Customer filter = null;
        //
        //	    if (ON_TESTING) {
        //		    commonFilter.setIdHotel( request.getParameter("idHotel") );
        //		    commonFilter.setPattern( request.getParameter("pattern") );
        //	    }
        //
        //	    try { // TODO validar termino de sesion desde "filter"
        //		    //listForm.setPatternFieldselect( dao.getPatternFields() );
        //		    if ( isValidFilter(commonFilter) ) {
        //		    	filter = new Customer();
        //		    	filter.setHotelRegistration( commonFilter.getIdHotel() );
        //		    	filter.setLastName1( commonFilter.getPattern() );
        //
        //		    	listForm.setCustomers( customerService.select(filter) );
        //		    }
        //	    } catch(ServiceException ex) {
        //	    	log.info( ex.getMessage() );
        //	    }
        //
        //	    listForm.setFilter(commonFilter);

        return modelAndView;
    }

    public ModelAndView customerUpdate(HttpServletRequest request,
            HttpServletResponse response) throws Exception {
        ModelAndView modelAndView = new ModelAndView("");

        //        Customer customer = editForm.getCust();
        //
        //        String result = null;
        //        String message = null;
        //
        //        customer.setHotelRegistration("1"); // TEST
        //
        //        if ( StringUtils.isNotEmpty( customer.getHotelRegistration() ) ) {
        //        	try {
        //                if ( StringUtils.isBlank( customer.getIdCustomer() ) ) {
        //	        		result = customerService.insert(customer);
        //	        	} else {
        //	        		result = customerService.update(customer);
        //	        	}
        //                if ( result.equals(CentralModuleConstants.SUCCESSFUL_OPERATION ) ) {
        //                	message = "Successfull operation";
        //                } else {
        //                	message = "Invalid document number. Duplicated entry";
        //                }
        //        	} catch(ServiceException ex) {
        //        		message = CentralModuleConstants.MESSAGE_SERVICE_EXCEPTION;
        //        		log.info( ex.getMessage() );
        //        	}
        //        } else {
        //    		message = "Invalid identification hotel: " + customer.getHotelRegistration();
        //        }
        //
        //        chargeActionMessages(request, message);
        //        if ( !messages.isEmpty() ) {
        //        	saveMessages(request, messages);
        //        }

        return modelAndView;
    }

    /*private boolean isValidFilter(CommonFilter formFilter) {
	    String idHotel = formFilter.getIdHotel();
	    String field   = formFilter.getFieldPattern();
	    String pattern = formFilter.getPattern();

    	boolean result = true;

    	if ( StringUtils.isBlank(idHotel)
    		 || !StringUtils.isNumeric(idHotel)) {
    		result = false;
    	}

    	return result ;
    }

	private void chargeActionMessages(HttpServletRequest request, String message){
		ActionMessages messages = new ActionMessages();

		messages.add("errors", new ActionMessage("mess.value", message));
		saveMessages(request, messages);
	}

	private void chargeServiceMessages(HttpServletRequest request, String result){
		ActionMessages messages = new ActionMessages();

		String message = ( result.equals(CentralModuleConstants.ER_DUP_ENTRY) )
					   ? "errors.ER_DUP_ENTRY" : "";

		messages.add("errors", new ActionMessage(message));
		saveMessages(request, messages);
	}*/

    /// Dependencies Injection

    public void setCustomerService(CustomerService customerService) {
        this.customerService = customerService;
    }

}
