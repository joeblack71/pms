/*
 * GuestReservationServlet.java
 *
 * Created on 11 de mayo de 2007, 11:29
 */

package com.mycom.booking.servlets;

import java.io.*;
import java.net.*;

import javax.servlet.*;
import javax.servlet.http.*;

import com.mycom.booking.beans.Company;
import com.mycom.booking.beans.Reservation;
import com.mycom.booking.controllers.CompanyCtlr;
import com.mycom.booking.events.ReservationDataException;
import com.mycom.booking.lists.Companies;

import java.sql.*;


/**
 *
 * @author Developer
 * @version
 */
public class SourceSearchServlet extends HttpServlet {
    
    /** Processes requests for both HTTP <code>GET</code> and <code>POST</code> methods.
     * @param request servlet request
     * @param response servlet response
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
              throws ServletException, IOException {

        HttpSession session = request.getSession();
        Reservation res = (Reservation)session.getAttribute("res");
        String component = "sourceSearch.jsp";

        short hotelId  = ( (Short)session.getAttribute("hotel") ).shortValue();

        String field    = request.getParameter("sampleField");
        String pattern  = request.getParameter("sampleValue");
        String roomType = request.getParameter("roomType");

        if ( field != null && pattern != null ) {
            CompanyCtlr cctlr = new CompanyCtlr();
            Companies cias = new Companies();
            cctlr.setCompanyList(cias);
            // TODO: validar los parametros. en una reserva nueva es probable
            //  que no contengan valores.
            cctlr.chargeAll(pattern,hotelId,roomType);
            request.setAttribute("cias",cias);
        }

        /*
        String sourceId  = request.getParameter("sourceId");
        String sourceNm  = request.getParameter("sourceNm");
        if ( sourceId != null && sourceNm != null ) {
            Reservation res = (Reservation)session.getAttribute("res");
            try {
                res.setSourceId(sourceId);
                res.setSourceName(sourceNm);
            } catch (ReservationDataException ex) {}
            component = "reservation.jsp";
        }*/
        
        try {
            request.getRequestDispatcher(component).forward(request, response);
        } catch (Exception ex) {}

    }
    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods.">
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
