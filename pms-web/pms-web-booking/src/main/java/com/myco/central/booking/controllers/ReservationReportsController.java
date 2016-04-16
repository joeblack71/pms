/*
 * ReservationReportsAction.java
 *
 * Created on 23 de agosto de 2007, 13:06
 */

package com.myco.central.web.booking.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.multiaction.MultiActionController;

import com.myco.central.booking.dao.ReservationDao;

/**
 *
 * @author Developer
 * @version
 */
public class ReservationReportsController extends MultiActionController {
	private ReservationDao reservationDao;
	
    public ReservationDao getReservationDao() {
		return reservationDao;
	}

	public void setReservationDao(ReservationDao reservationDao) {
		this.reservationDao = reservationDao;
	}

	protected ModelAndView reports(HttpServletRequest request, 
			HttpServletResponse response) throws Exception {
        ModelAndView modelAndView = new ModelAndView();

//        response.setContentType("text/html;charset=UTF-8");
//
//        List<Reservation> list = null;
//
//        String field   = request.getParameter("sampleField");
//        String pattern = request.getParameter("sampleValue");
        
        /*try {
			list = rctlr.getReportByPattern(Integer.parseInt(field),pattern);
		} catch (NumberFormatException ex) {
			ex.printStackTrace();
		} catch (Exception ex) {
			ex.printStackTrace();
		}*/

//        request.setAttribute("list", list);

		return modelAndView;
    }
    
}
