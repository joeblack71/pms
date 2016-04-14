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

import com.mycom.booking.beans.Customer;
import com.mycom.booking.beans.Reservation;
import com.mycom.booking.beans.ReservationGuest;

import java.util.Hashtable;


/**
 *
 * @author Developer
 * @version
 */
public class GuestReservationServlet extends HttpServlet {
    
    /** Processes requests for both HTTP <code>GET</code> and <code>POST</code> methods.
     * @param request servlet request
     * @param response servlet response
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
              throws ServletException, IOException {

        HttpSession session = request.getSession();

        String addGuest = request.getParameter("addGuest");
        String remGuest = request.getParameter("remGuest");
        String guestId  = request.getParameter("customerId");

        Reservation res = (Reservation)session.getAttribute("res");
        Customer   cust = (Customer)request.getAttribute("cust");

        if ( addGuest != null ) {
            ReservationGuest rg = new ReservationGuest();
            rg.setHotelId( cust.getHotelId() );
            rg.setReservationNumber( res.getReservation() );
            rg.setCustomerId( cust.getCustomerId() );
            rg.setCustomerDocument( cust.getDocumentNumber() );
            rg.setCustomerName( cust.getLastname1() + " " +
                                cust.getLastname2() + ", " +
                                cust.getFirstname() );
            rg.setStatus('A');
            Hashtable ht = res.getGuests();
            try {
                ht.put( new Short( rg.getCustomerId() ), rg);
                if ( ht.size() == 1 ) {
                    res.setLastname1( cust.getLastname1() );
                    res.setLastname2( cust.getLastname2() );
                    res.setFirstname( cust.getFirstname() );
                }
            } catch(NullPointerException ex) { ex.getMessage(); }
        }

        if ( remGuest != null ) {
            Hashtable ht = res.getGuests();
            try {
                ReservationGuest rg = (ReservationGuest)ht.get( new Short(guestId) );
                rg.setStatus('*');
                ht.put( new Short( rg.getCustomerId() ), rg);
            } catch (NullPointerException ex) { ex.getMessage(); }
        }

        response.sendRedirect( response.encodeRedirectURL("reservation.jsp") );
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
