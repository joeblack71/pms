/*
 * ReservationSearchServlet.java
 *
 * Created on 12 de mayo de 2007, 13:12
 */

package com.mycom.booking.servlets;

import java.io.*;
import java.net.*;

import javax.servlet.*;
import javax.servlet.http.*;

import com.mycom.booking.beans.Reservation;
import com.mycom.booking.beans.SearchBean;
import com.mycom.booking.dispatchers.ConProvider;
import com.mycom.booking.dispatchers.ReservationDisp;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;


/**
 *
 * @author Developer
 * @version
 */
public class ReservationSearchServlet extends HttpServlet {
    
	private static final long serialVersionUID = 1L;

	/** Processes requests for both HTTP <code>GET</code> and <code>POST</code> methods.
     * @param request servlet request
     * @param response servlet response
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        //PrintWriter out = response.getWriter();
        HttpSession session = request.getSession();
        
        String hotelId   = request.getParameter("hotelId");
        String fieldName = request.getParameter("fieldName");
        String pattern   = request.getParameter("pattern");

        SearchBean search = new SearchBean();
        List<Reservation> list = null;
        if ( hotelId != null && fieldName != null && pattern != null ) {
            Connection con = ConProvider.getConnection();
            ReservationDisp rdisp = new ReservationDisp();
            rdisp.setConnection(con);

            search.setHotelId( Short.parseShort(hotelId) );
            search.setSampleField(fieldName);
            search.setSampleValue(pattern);
    
            if ( fieldName.equals("lastname") && pattern.length() > 0 )
                list = rdisp.chargeByLastName(hotelId, pattern);
            if ( fieldName.equals("arrival") && pattern.length() >= 6 )
                list = rdisp.chargeByArrival(hotelId, pattern);
            
            session.setAttribute("search", search);
        }

        if ( list != null ) session.setAttribute("resList",list);

        try {
            response.sendRedirect( response.encodeRedirectURL("reservationSearch.jsp") );
        } catch (IOException ex) { ex.printStackTrace(); }
        
    }
    
    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /** Handles the HTTP <code>GET</code> method.
     * @param request servlet request
     * @param response servlet response
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        processRequest(request, response);
    }
    
    /** Handles the HTTP <code>POST</code> method.
     * @param request servlet request
     * @param response servlet response
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        processRequest(request, response);
    }
    
    /** Returns a short description of the servlet.
     */
    public String getServletInfo() {
        return "Short description";
    }
    // </editor-fold>
}
