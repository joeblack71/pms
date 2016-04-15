
package com.mycom.booking.servlets;

import javax.servlet.*;
import javax.servlet.http.*;

import java.sql.*;
import java.util.Calendar;
import java.util.ArrayList;
import java.text.SimpleDateFormat;
import javax.servlet.jsp.PageContext;

import com.mycom.booking.beans.*;
import com.mycom.booking.controllers.*;
import com.mycom.booking.events.AvailabilityQueryException;
import com.mycom.booking.libraries.*;
import com.mycom.booking.lists.OccupationByDays;


public class AvailabilityServlet extends HttpServlet {

    /** Initializes the servlet.
    */
    public void init() throws ServletException {
    }

    /** Destroys the servlet.
    */
    public void destroy() {
    }

    /** Processes requests for both HTTP <code>GET</code> and <code>POST</code> methods.
    * @param request servlet request
    * @param response servlet response
    */
    protected void processRequest(HttpServletRequest request,HttpServletResponse response)
                   throws ServletException, java.io.IOException {
        response.setContentType("text/html");
        HttpSession session = request.getSession();

        short hotelId = ( (Short)session.getAttribute("hotel") ).shortValue();
        
        String startDate = request.getParameter("startDate");
        String period    = request.getParameter("period");
        String show      = request.getParameter("show");
        String next      = request.getParameter("next");

        boolean isValidDateFormat = false;
        AvailabilityQry aq = (AvailabilityQry)request.getAttribute("aq");
        if ( aq == null ) aq = new AvailabilityQry();

        if ( !startDate.equals("") ) {
            try {
                aq.setHotelId(hotelId);
                aq.setPeriod(period);
                aq.setStartDate(startDate);
                if ( next != null )
                    aq.setStartDate( aq.getEndDate() );
                isValidDateFormat = true;
            } catch (AvailabilityQueryException ex) { isValidDateFormat = false; }
        }

        if ( isValidDateFormat ) {
            AvailabilityCtlr actlr = new AvailabilityCtlr();
            OccupationByDays obd = new OccupationByDays();
            actlr.setOccupationList(obd);
            actlr.chargeOccupationByType(aq);

            AvailabilityArray aa = new AvailabilityArray(period);
            aa.setOccupationByDays(obd);
            aa.chargeRoomsOccupation( aq.getStartDate() );
            
            request.setAttribute("matriz", aa.getMatrix() );
        }

        request.setAttribute("aq",aq);
        RequestDispatcher dispatcher = 
                request.getRequestDispatcher("/availability.jsp?startDate=" +
                             DateManager.sqlDateToString( aq.getStartDate() ) );
        if ( dispatcher != null ) dispatcher.forward(request, response);
    }

    //<editor-fold defaultstate="colapsed" desc="HttpServlet methods.">
    /** Handles the HTTP <code>GET</code> method.
    * @param request servlet request
    * @param response servlet response
    */
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, java.io.IOException {
        processRequest(request, response);
    }

    /** Handles the HTTP <code>POST</code> method.
    * @param request servlet request
    * @param response servlet response
    */
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, java.io.IOException {
        processRequest(request, response);
    }

    /** Returns a short description of the servlet.
    */
    public String getServletInfo() {
        return "Show Occupation chart";
    }
    //</editor-fold>

}
