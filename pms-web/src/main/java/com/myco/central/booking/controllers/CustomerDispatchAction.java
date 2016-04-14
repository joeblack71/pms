
package com.myco.central.action;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.actions.MappingDispatchAction;

import com.myco.central.dao.CustomerDAO;
import com.myco.central.vo.Customer;

public class CustomerDispatchAction extends MappingDispatchAction {
	Log log = LogFactory.getLog(CustomerDispatchAction.class);

	/**
	 * 
	 * @return una lista conteniendo los huespedes registrados en el sistema
	 * @throws ServletException
	 * @throws IOException
	 */
    public ActionForward customerList(ActionMapping mapping, ActionForm form,
    		HttpServletRequest request,HttpServletResponse response)
    throws ServletException, IOException {
    	
        HttpSession session = request.getSession();
        List<Customer> list = null;
        String hotelId = (String)session.getAttribute("hotel");
        
        CustomerDAO dao = new CustomerDAO();
        list = dao.getCustomerList(hotelId);
        session.setAttribute("customerList", list);
        log.info("customers:"+list.size());

    	return mapping.findForward("success");
    }

    public ActionForward customerShow(ActionMapping mapping, ActionForm form,
    		HttpServletRequest request, HttpServletResponse response) {

    	HttpSession session = request.getSession();
    	String hotelId = (String)session.getAttribute("hotel");
    	
        List<Customer> customers = null; 
    	CustomerDAO dao = new CustomerDAO();
    	
        try {
            customers =  dao.getCustomerList(hotelId);
            request.setAttribute("customerList", customers);
        } catch(Exception ex) {
        	ex.printStackTrace();
        }

        return mapping.findForward("success");
    }
    
    public ActionForward customerUpdate(ActionMapping mapping, ActionForm form,
    		HttpServletRequest request,HttpServletResponse response)
    throws ServletException, IOException {
    	
        HttpSession session = request.getSession();
        Short hotelId = (Short)session.getAttribute("hotel");
        
        String documentNumber = request.getParameter("documentNumber");
        String show           = request.getParameter("show");
        String save           = request.getParameter("save");
        String delete         = request.getParameter("delete");
        String addCustomer    = request.getParameter("addGuest");

        Customer cust = new Customer();
        CustomerDAO gctlr = new CustomerDAO();

        String component = "/customer.jsp";
        boolean guestExists = false;
        boolean validDocumentNumber = ( documentNumber.equals("") ) ? false : true;
        if ( validDocumentNumber ) {
            cust.setHotelId( hotelId.shortValue() );
            cust.setDocumentNumber( documentNumber );
            //guestExists = gctlr.validate(cust);
        }
        
        if ( delete != null && guestExists ) {
            //gctlr.delete(cust);
            cust = new Customer();
        }

        if ( addCustomer != null && guestExists )
            component = "/GuestReservationAction?addGuest";

        request.setAttribute("cust",cust);
        RequestDispatcher dispatcher = request.getRequestDispatcher(component);
        if ( dispatcher != null ) dispatcher.forward(request, response);
        
        return mapping.findForward("success");
    }

}
