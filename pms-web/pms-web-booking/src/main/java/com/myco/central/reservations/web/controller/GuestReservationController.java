/*
 * GuestReservationAction.java
 *
 * Created on 11 de mayo de 2007, 11:29
 */

package com.myco.central.reservations.web.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.multiaction.MultiActionController;

import com.myco.central.reservations.dao.GuestDao;

/**
 *
 * @author Developer
 * @version
 */
public class GuestReservationController extends MultiActionController {
	private GuestDao guestDao;
    
	public GuestDao getGuestDao() {
		return guestDao;
	}

	public void setGuestDao(GuestDao guestDao) {
		this.guestDao = guestDao;
	}

	public ModelAndView addReservationGuest(HttpServletRequest request, 
			HttpServletResponse response) throws Exception {

        ModelAndView modelAndView = new ModelAndView();
        
//        Guest guest = null;
//        Map<String, Guest> guests = null;
        
//        String idHotel = String.valueOf( rForm.search().getIdHotel() );
//        String idReservation = String.valueOf( rForm.search().getIdReservation() );
//        String idCustomer = (String)session.getAttribute("customerId");

//        try {
//			guests = guestDao.listGuestsInRoom(idHotel, idReservation);
//
//			if ( guests == null ) {
//				guests = new HashMap<String, Guest>();
//			}
//			
//			guest = new Guest();
//
//			guest.setIdHotel(idHotel);
//			guest.setIdReservation(idReservation);
//			guest.setIdCustomer(idCustomer);
//			guest.setCustomerDocument( request.getParameter("customerDoc") );
//			guest.setCustomerNames( request.getParameter("customerNames") );
//			guest.setStatus(CentralModuleConstants.NEW_RESERVATION_GUEST);
//
//			guests.put(idCustomer, guest);
//		} catch (Exception ex) {
//			ex.printStackTrace();
//			//TODO customized message
//		}

		return modelAndView;
    }
    
}
