
package com.mycom.booking.servlets;

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

import com.mycom.booking.beans.*;
import com.mycom.booking.controllers.*;
import com.mycom.booking.dispatchers.*;
import com.mycom.booking.events.AvailabilityQueryException;
import com.mycom.booking.events.ReservationDataException;
import com.mycom.booking.libraries.DateManager;
import com.mycom.booking.lists.OccupationByDays;
import com.mycom.booking.lists.ReservationList;

import java.sql.*;
//import java.util.Enumeration;
import java.util.ArrayList;
import java.util.Iterator;
import java.text.SimpleDateFormat;
//import javax.transaction.UserTransaction; //TODO Adicionar libreria


public class ReservationServlet extends HttpServlet {

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

        // TEST
        String p = request.getQueryString();
        java.lang.CharSequence cs;
        //

        //String blank  = request.getParameter("new");
        String show   = request.getParameter("show");
        String save   = request.getParameter("save");
        String delete = request.getParameter("delete");

        //Reservation res = new Reservation();
        Reservation res = (Reservation)session.getAttribute("res");
        ReservationCtlr rctlr = new ReservationCtlr();
        ReservationGuestCtlr rgc = null;

        boolean reservationIdOk = false;
        boolean reservationExist = false;
        try {
            res.setHotelId( ( (Short)session.getAttribute("hotel") ).shortValue() );
            res.setReservation( request.getParameter("reservation") );
            reservationIdOk = true;
        } catch(Exception ex) { System.out.println("Error in reservation Id."); }
            
        // TODO: Validate when is a new record
        /*if ( blank != null ) {
            res = new Reservation();
        }*/
        
        if ( show != null && reservationIdOk ) {
            reservationExist = rctlr.search(res);
            if ( reservationExist ) {
                new ReservationGuestCtlr().chargeGuests(res);
                Company co = new Company();
                co.setCompanyId( res.getSourceId() );
                new CompanyCtlr().search(co);
                res.setSourceName( co.getFirmName() );
            } else {
                res = null;
                System.out.println("Reservation not found.");
            }
        }

        boolean saveOk = false;
        if ( save != null ) {
            // TODO: Move "isAvailability" method to Reservation bean.
            if ( isAvailability(request, res) ) {
                try {
                    request.getRequestDispatcher("/SaveReservationServlet")
                           .forward(request, response);
                    saveOk = true;
                } catch (Exception ex) { }
            } 
        }

        if ( delete != null && reservationIdOk ) {
            if ( rctlr.validate(res) ) {
                rctlr.delete(res);
                res = new Reservation();
            }
        }

        if ( save == null || saveOk == false) {
            session.setAttribute("res",res);
            try {
                response.sendRedirect( response.encodeRedirectURL("reservation.jsp") );
            } catch (IOException ex) { ex.printStackTrace(); }
        }
        
    }
    
    private boolean isAvailability(HttpServletRequest request, Reservation res) {
        Date   oldArrival   = res.getArrival();
        Date   oldDeparture = res.getDeparture();
        String oldRoomType  = res.getRoomType();
        short  oldQuantity  = res.getQuantity();

        boolean validFieldValues = true;
        boolean needAvailabilityCheck = true;
        boolean availableRooms = true;
        try {
            res.setArrival( request.getParameter("arrival") );
            res.setDeparture( request.getParameter("departure") );
            res.setAdults( request.getParameter("adults") );
            res.setRoomType( request.getParameter("roomType") );
            res.setSourceId( request.getParameter("sourceId") );
            res.setQuantity( request.getParameter("quantity") );
            if ( oldArrival != null && oldDeparture != null ) {
                if ( oldArrival.equals( res.getArrival() ) &&
                     oldDeparture.equals( res.getDeparture() ) &&
                     oldRoomType.equals( res.getRoomType() ) &&
                     oldQuantity == res.getQuantity() )
                    needAvailabilityCheck = false;
            }
        } catch (ReservationDataException ex) { validFieldValues = false; }
        
        if ( validFieldValues && needAvailabilityCheck ) {
            AvailabilityQry aq = new AvailabilityQry();
            aq.setHotelId( res.getHotelId() );
            aq.setStartDate( res.getArrival() );
            aq.setEndDate( res.getDeparture() );
            aq.setRoomType( res.getRoomType() );
            aq.setQuantity( res.getQuantity() );
            aq.setOldArrival(oldArrival);
            aq.setOldDeparture(oldDeparture);
            aq.setReservationRooms( res.getQuantity() );
            aq.setRoomTypeAvailability( getRoomTypeRooms( res.getRoomType() ) );
            AvailabilityCtlr avctlr = new AvailabilityCtlr();
            availableRooms = avctlr.isAvailability(aq);
        }

        if ( !validFieldValues )
            System.out.println("\nField values are wrong.\n");
        if ( !availableRooms )
            System.out.println("\nThere is not available rooms.\n");
        
        return validFieldValues && availableRooms;
    }
    
    /** 
     * Obtiene el numero de habitaciones disponibles para la venta en un
     * tipo especifico. El dato se extrae de <B>rtList</B>, que es un <U>ArrayList</U>
     * con informacion de los tipos disponibles, cargado al inicio de la
     * sesion del usuario.
     *
     * @param roomType Tipo de habitacion del cual se desea conocer el numero
     * de habitaciones disponibles para la venta.
     */
    private short getRoomTypeRooms(String roomType) {
        ArrayList roomTypes = (ArrayList)getServletContext().getAttribute("roomTypes");
        short rtAvailableRooms = 0;
        RoomType rt = new RoomType();
        Iterator i = roomTypes.iterator();
        while ( i.hasNext() ) {
            rt = (RoomType)i.next();
            if ( roomType.equals( rt.getRoomType() ) )
                rtAvailableRooms = rt.getAvailableRooms();
        }
        return rtAvailableRooms;
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods.">
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
    // </editor-fold>

}
