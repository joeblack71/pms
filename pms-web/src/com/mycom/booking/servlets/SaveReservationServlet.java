
package com.mycom.booking.servlets;

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

import com.mycom.booking.beans.*;
import com.mycom.booking.controllers.*;
import com.mycom.booking.dispatchers.*;
import com.mycom.booking.events.ReservationDataException;
import com.mycom.booking.libraries.DateManager;

import java.sql.*;
import java.util.ArrayList;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.Enumeration;
import java.text.SimpleDateFormat;
//import javax.transaction.UserTransaction; //TODO Adicionar libreria


public class SaveReservationServlet extends HttpServlet {

    /** Initializes the servlet.
    */
    public void init() throws ServletException {
    }

    /** Destroys the servlet.
    */
    public void destroy() {}

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code> methods.
     * 
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException 
     * @throws java.io.IOException 
     */
    protected void processRequest(HttpServletRequest request,HttpServletResponse response)
                   throws ServletException, IOException {
        response.setContentType("text/html");
        HttpSession session = request.getSession();

        Reservation res = (Reservation)session.getAttribute("res");
        chargeReservationValues(request, res);

        boolean saveOk;
        ReservationCtlr rctlr = new ReservationCtlr();
        if ( res.getReservation() == 0 )
             saveOk = rctlr.insert(res);
        else { 
            if ( rctlr.validate(res) )
                saveOk = rctlr.update(res);
            else saveOk = false;
        }
            
        if ( saveOk ) {
            ReservationGuest rg = new ReservationGuest();
            ReservationGuestCtlr rgctlr = new ReservationGuestCtlr();
            
            // TODO: change guest saving status in new reservations
            Enumeration e = res.getGuests().elements();
            while ( e.hasMoreElements() ) {
                rg = (ReservationGuest)e.nextElement();
                rg.setReservationNumber( res.getReservation() );
                if ( rg.getStatus() == 'A' ) { // Guest must be add to reservation
                    rgctlr.insert(rg);
                    rg.setStatus(' ');
                }
                if ( rg.getStatus() == '*' ) // Deleted from reservation
                    rgctlr.delete(rg);
            }
        } else System.out.println("Reservation can not be registered.");
        
        try {
            response.sendRedirect( response.encodeRedirectURL("reservation.jsp") );
        } catch (IOException ex) { ex.printStackTrace(); }
    }

    private void chargeReservationValues(HttpServletRequest request, Reservation res) {
        Company co = new Company();
        CompanyCtlr cctlr = new CompanyCtlr();
        co.setCompanyId( res.getSourceId() );
        cctlr.search(co);
        RoomRate r = new RoomRate();
        SpecialRateCtlr rctlr = new SpecialRateCtlr();
        r.setHotelId( res.getHotelId() );
        r.setRoomType( res.getRoomType() );
        r.setRateId( co.getSpecialRate() );
        rctlr.search(r);
        // TODO: Determine what rate assign on accord with season
        try {
            //res.setArrival( request.getParameter("arrival") );
            //res.setDeparture( request.getParameter("departure") );
            //res.setNights( request.getParameter("nights") );
            //res.setAdults( request.getParameter("adults") );
            res.setChildren( request.getParameter("children") );
            //res.setRoomType( request.getParameter("roomType") );
            //res.setQuantity( request.getParameter("quantity") );
            res.valRoomNumber( request.getParameter("roomNumber") );
            //res.setSourceId( request.getParameter("source") );
            res.setRoomRate( request.getParameter("roomRate") );
            res.setPaymentDue( request.getParameter("paymentdue") );
            res.setPaymentType( request.getParameter("paymenttype") );
            res.setInstructions( request.getParameter("instructions") );
            res.setStatus( request.getParameter("status") );
        } catch (ReservationDataException ex) {
            ex.printStackTrace();
        }
    }

    // <editor-fold defaultstate="colapsed" desc="HttpServlet methods.">
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
        return "Managing access to 'reservation' table";
    }
    //</editor-fold>

}
