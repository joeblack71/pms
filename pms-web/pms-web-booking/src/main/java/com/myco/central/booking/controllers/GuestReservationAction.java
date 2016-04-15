/*
 * GuestReservationAction.java
 *
 * Created on 11 de mayo de 2007, 11:29
 */

package com.myco.central.action;

import java.io.IOException;
import java.util.HashMap;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.actions.DispatchAction;

import com.myco.central.dao.GuestDAO;
import com.myco.central.form.ReservationForm;
import com.myco.central.util.Constants;
import com.myco.central.vo.Guest;

/**
 *
 * @author Developer
 * @version
 */
public class GuestReservationAction extends DispatchAction {
    
	public ActionForward addReservationGuest(ActionMapping mapping,
			ActionForm form, HttpServletRequest request, HttpServletResponse response)
	throws ServletException, IOException {

        HttpSession session = request.getSession();
        ReservationForm rForm = (ReservationForm)form;
        GuestDAO gDao = new GuestDAO();
        Guest guest = null;
        HashMap<String, Guest> guestsMap = null;
        String hotelId = String.valueOf( rForm.getItem().getHotelId() );
        String reservationNumber = String.valueOf( rForm.getItem().getReservation() );
        String customerId = (String)session.getAttribute("customerId");

        guestsMap = gDao.chargeGuests(hotelId, reservationNumber);
        if ( guestsMap == null )
        	guestsMap = new HashMap<String, Guest>();
        
        guest = new Guest();
        guest.setHotelId(hotelId);
        guest.setReservationNumber(reservationNumber);
        guest.setCustomerId(customerId);
        guest.setCustomerDocument( request.getParameter("customerDoc") );
        guest.setCustomerNames( request.getParameter("customerNames") );
        guest.setStatus(Constants.NEW_RESERVATION_GUEST);

        guestsMap.put(customerId, guest);

        return mapping.findForward("success");
    }
    
	public ActionForward removeReservationGuest(ActionMapping mapping,
			ActionForm form, HttpServletRequest request, HttpServletResponse response)
	throws ServletException, IOException {
	
		ReservationForm rForm = (ReservationForm)form;
	    HttpSession session = request.getSession();
        Guest guest = null;
        String customerId = (String)session.getAttribute("customerId");
	
        HashMap<String, Guest> guestsMap = null;
        guestsMap = rForm.getItem().getGuests();

        guest = (Guest)guestsMap.get(customerId);
        guest.setStatus(Constants.REMOVED_RESERVATION_GUEST);
        guestsMap.put(customerId, guest);
	
	    return mapping.findForward("success");
	}
	
}
