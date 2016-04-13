
package com.mycom.booking.servlets;

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

import com.mycom.booking.beans.*;
import com.mycom.booking.controllers.*;
import com.mycom.booking.dispatchers.*;
import com.mycom.booking.libraries.*;

import java.sql.*;
import java.util.ArrayList;
import java.util.Hashtable;
import java.util.Enumeration;
import java.text.SimpleDateFormat;


public class RoomRateServlet extends HttpServlet {

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
    protected void processRequest(HttpServletRequest request,
                                  HttpServletResponse response)
                   throws ServletException, IOException {
        HttpSession session = request.getSession();

        Short hotelId = (Short)session.getAttribute("hotel");

        SourceCtlr sc = new SourceCtlr();
        
        String roomType = request.getParameter("roomType");
        String rateId   = request.getParameter("rateId");
        
        String show     = request.getParameter("show");
        String save     = request.getParameter("save");
        String delete   = request.getParameter("delete");

        RoomRate rate = new RoomRate();
        SpecialRateCtlr ratectlr = new SpecialRateCtlr();

        boolean rateExists = false;
        boolean isValidKey = true;
        if ( roomType != null && rateId != null ) {
            try {
                rate.setHotelId( hotelId.shortValue() );
                rate.setRoomType(roomType);
                rate.setRateId( Short.parseShort(rateId) );
                rateExists = ratectlr.search(rate);
            } catch (NumberFormatException ex) { isValidKey = false; }
        }

        /*
        if ( show != null && isValidKey ) {
            rateExists = ratectlr.search(rate);
        }
         */

        if ( save != null ) {
            // TODO: Validar campos
            chargeRateValues(request, rate);
            boolean saveOK;
            if ( rateExists )
                 saveOK = ratectlr.update(rate);
            else saveOK = ratectlr.insert(rate);
        }

        if ( delete != null && rateExists ) {
            ratectlr.delete(rate);
            rate = new RoomRate();
        }

        request.setAttribute("rate",rate);
        RequestDispatcher dispatcher = request.getRequestDispatcher("/ratesManager.jsp");
        if ( dispatcher != null ) dispatcher.forward(request, response);
    }

    private void chargeRateValues(HttpServletRequest request, RoomRate rate) {
        String dh = request.getParameter("dowHighSeasonRate");
        String eh = request.getParameter("eowHighSeasonRate");
        String dl  = request.getParameter("dowLowSeasonRate");
        String el  = request.getParameter("eowLowSeasonRate");
        try {
            rate.setDowHighSeasonRate( Short.parseShort(dh) );
            rate.setEowHighSeasonRate( Short.parseShort(eh) );
            rate.setDowLowSeasonRate( Short.parseShort(dl) );
            rate.setEowLowSeasonRate( Short.parseShort(el) );
        } catch (NumberFormatException ex) {
            ex.printStackTrace();
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet Methods">
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
        return "Manage access to 'guest' table";
    }
    // </editor-fold>

}
