
package com.myco.central.web.booking.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.multiaction.MultiActionController;

import com.myco.central.booking.model.Reservation;
import com.myco.central.booking.service.ReservationReportsService;
import com.myco.central.booking.service.impl.ReservationReportsServiceImpl;

public class GuestbookingReportsController extends MultiActionController {

	public ModelAndView guestbookingReport(HttpServletRequest request,
			HttpServletResponse response) throws Exception {

        ModelAndView modelAndView = new ModelAndView("");

        String idHotel = request.getParameter("idHotel");
        String pattern = request.getParameter("pattern");
        String status = request.getParameter("status");

//        int field = 1;
        //String pattern = form.getPattern();
        
        ReservationReportsService reservationReportsService = new ReservationReportsServiceImpl();
        List<Reservation> list = null;

        try {
			list = reservationReportsService.listReservations(idHotel, pattern, status);
		} catch (Exception ex) {
			ex.printStackTrace();
		}

		request.setAttribute("list", list);
        
		return modelAndView;
    }

}
