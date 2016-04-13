/*
 * ReservationReportsServlet.java
 *
 * Created on 23 de agosto de 2007, 13:06
 */

package com.mycom.booking.servlets;

import java.io.*;
import java.net.*;

import javax.servlet.*;
import javax.servlet.http.*;

import com.mycom.booking.beans.Reservation;
import com.mycom.booking.controllers.ReservationCtlr;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Developer
 * @version
 */
public class ReservationReportsServlet extends HttpServlet {
    
	private static final long serialVersionUID = 1L;

	/** Processes requests for both HTTP <code>GET</code> and <code>POST</code> methods.
     * @param request servlet request
     * @param response servlet response
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");

        String field   = request.getParameter("sampleField");
        String pattern = request.getParameter("sampleValue");
        
        ReservationCtlr rctlr = new ReservationCtlr();
        List<Reservation> list = rctlr.getReportByPattern(Integer.parseInt(field),pattern);
        request.setAttribute("list",list);

        RequestDispatcher dispatcher = request.getRequestDispatcher("/reports.jsp");
        if ( dispatcher != null )
            dispatcher.forward(request, response);
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
