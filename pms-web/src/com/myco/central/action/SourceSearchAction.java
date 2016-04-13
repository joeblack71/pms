/*
 * GuestReservationAction.java
 *
 * Created on 11 de mayo de 2007, 11:29
 */

package com.myco.central.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.myco.central.dao.CompanyDAO;
import com.myco.central.lists.Companies;
import com.myco.central.vo.Reservation;

/**
 *
 * @author Developer
 * @version
 */
public class SourceSearchAction extends HttpServlet {
    
	public ActionForward processRequest(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
	throws ServletException, IOException {

        HttpSession session = request.getSession();
        Reservation res = (Reservation)session.getAttribute("res");
        String component = "sourceSearch.jsp";

        short hotelId  = ( (Short)session.getAttribute("hotel") ).shortValue();

        String field    = request.getParameter("sampleField");
        String pattern  = request.getParameter("sampleValue");
        String roomType = request.getParameter("roomType");

        if ( field != null && pattern != null ) {
            CompanyDAO dao = new CompanyDAO();
            Companies cias = new Companies();
            cias = dao.getCompanies(pattern);
            request.setAttribute("cias",cias);
        }

        return mapping.findForward("success");
    }

}
