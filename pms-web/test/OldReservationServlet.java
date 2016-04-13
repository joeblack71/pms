
package servlets;

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

import java.sql.*;
//import java.util.Enumeration;
import java.util.ArrayList;
import java.text.SimpleDateFormat;
//import javax.transaction.UserTransaction; //TODO Adicionar libreria

import beans.*;
import controllers.*;
import dispatchers.*;
import libraries.DateManager;

public class ReservationServlet_1 extends HttpServlet {

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
        
        Short hotelId = (Short)session.getAttribute("hotel");

        String reservation = request.getParameter("reservation"),
               status      = request.getParameter("status"),
               nights      = request.getParameter("nights"),
               source      = request.getParameter("source"),
               arrival     = request.getParameter("arrival"),
               departure   = request.getParameter("departure"),
               adults      = request.getParameter("adults"),
               children    = request.getParameter("children"),
               roomType    = request.getParameter("roomType"),
               quantity    = request.getParameter("quantity"),
               roomNumber  = request.getParameter("roomNumber"),
               roomRate    = request.getParameter("roomRate"),
               balance     = request.getParameter("balance"),
               paymentDue  = request.getParameter("paymentdue"),
               paymentType = request.getParameter("paymenttype"),
               lastname1   = request.getParameter("lastname1"),
               lastname2   = request.getParameter("lastname2"),
               firstname   = request.getParameter("firstname"),
               instructions = request.getParameter("instructions"),
               addCustomer = request.getParameter("addCustomer"),
               removeCustomer = request.getParameter("removeCustomer"),
               show        = request.getParameter("show"),
               save        = request.getParameter("save"),
               delete      = request.getParameter("delete");
               //removeGuest = request.getParameter("removeguest");

        ReservationCtlr  rctlr = new ReservationCtlr();
        AvailabilityCtlr avctlr = new AvailabilityCtlr();
        Reservation res = new Reservation();

        ArrayList occupationByDays = null;

        short nQuantity=0;
        short nHotelId=0;
        int   nReservation=0;
        boolean reservationExist = false;
        boolean availableRooms = false;

        try {
            nHotelId = hotelId.shortValue();
            nReservation = Integer.parseInt(reservation);
            res.setHotelId( nHotelId );
            res.setReservation(nReservation);
            reservationExist = rctlr.search(res);
        } catch(Exception e) {
            System.out.println("Numero de reserva invalido !!");
        }

        if ( show != null ) {
            if ( reservationExist ) {
                ReservationGuestCtlr rgc = new ReservationGuestCtlr();
                ArrayList gl = rgc.getReservationGuests(nHotelId, nReservation);
                session.setAttribute("resGuests",gl);
            } else System.out.println("Reservacion no registrada !!");
        }

        if ( save != null ) {
            request.setAttribute("exist", new Boolean( String.valueOf(reservationExist) ) );
            try {
                nQuantity = Short.parseShort(quantity);
            } catch(Exception e) {}
            
            //TODO: Verificar si alguna de las fechas fue modificada antes de
            // consultar la disponibilidad
            /*boolean availabilityVerify = true;
            System.out.println(res.getReservation()+";"+nReservation);
            if ( res.getReservation() == nReservation ) {
                if ( res.getArrival().equals(dArrival)  ||
                     res.getDeparture().equals(dDeparture) )
                    availabilityVerify = false;
            }*/
            
            //if ( availabilityVerify ) {
                AvailabilityQry aq = new AvailabilityQry();
                aq.setHotelId(nHotelId);
                aq.setStartDate(departure);
                aq.setEndDate(arrival);
                aq.setRoomType(roomType);
                aq.setQuantity(nQuantity);
                avctlr = new AvailabilityCtlr();
                occupationByDays = avctlr.chargeOccupationOnStay(aq);
                int requestedRooms = Integer.parseInt(quantity);
                int reservationBlockedRooms = reservationExist ? res.getQuantity() : 0;
                availableRooms = avctlr.isAvailability(occupationByDays,
                                                           getRoomTypeRooms(roomType),
                                                           requestedRooms,
                                                           reservationBlockedRooms);
            //} else availableRooms = true;
        }

        if ( save != null && availableRooms ) {
            res.setStatus(status);
            res.setNights(Short.parseShort(nights));
            res.setSource(source);
            res.setArrival(DateManager.getSqlDateValueOf(arrival));
            res.setDeparture(DateManager.getSqlDateValueOf(departure));
            res.setAdults(Short.parseShort(adults));
            res.setChildren(Short.parseShort(children));
            res.setRoomType(roomType);
            res.setQuantity(Short.parseShort(quantity));
            res.setRoomNumber(roomNumber);
            res.setRoomRate(Float.parseFloat(roomRate));
            //TODO: Calculate Total
            //res.setTotal(Float.parseFloat(balance));
            res.setPaymentDue(DateManager.getSqlDateValueOf(paymentDue));
            res.setPaymentType(Short.parseShort(paymentType));
            res.setLastName1(lastname1);
            res.setLastName2(lastname2);
            res.setFirstName(firstname);
            res.setInstructions(instructions);
            
            boolean txOk = false;
            if (reservationExist)
                txOk = rctlr.update(res);
            else txOk = rctlr.insert(res);
            
            if ( txOk ) {
                ArrayList list = (ArrayList)session.getAttribute("resGuests");
                ArrayList removedList = (ArrayList)session.getAttribute("removedGuestList");
                ReservationGuest rg = new ReservationGuest();
                // Despues de grabar la reserva recien obtenemos el numero de la misma
                for (int i=0; i < list.size(); i++) {
                    rg = (ReservationGuest)list.get(i);
                    rg.setReservationNumber( res.getReservation() );
                }
                ReservationGuestCtlr rgctlr = new ReservationGuestCtlr();
                rgctlr.saveCustomers(list, removedList);
            }
        }

        if ( delete != null && reservationExist ) {
            rctlr.delete(res);
            res = new Reservation();
        }

        if ( addCustomer != null ) {
            /*RequestDispatcher dispatcher = request.getRequestDispatcher("/customer.jsp");
            if ( dispatcher != null ) dispatcher.forward(request, response);*/
            response.sendRedirect( response.encodeRedirectURL("customer.jsp") );
        }

        if ( addCustomer == null && removeCustomer == null ) {
            session.setAttribute("res",res);
            RequestDispatcher dispatcher = request.getRequestDispatcher("/reservation.jsp");
            if ( dispatcher != null ) dispatcher.forward(request, response);
        }
        
    }

    /** Obtiene el numero de habitaciones disponibles para la venta en un
     * tipo especifico. El dato se extrae de <B>rtList</B>, que es un <U>ArrayList</U>
     * con informacion de los tipos disponibles, cargado al inicio de la
     * sesion del usuario.
     *
     * @param roomType Tipo de habitacion del cual se desea conocer el numero
     * de habitaciones disponibles para la venta.
     */
    private int getRoomTypeRooms(String roomType) {
        ArrayList roomTypes = (ArrayList)getServletContext().getAttribute("roomTypes");
        int rtAvailableRooms = 0;
        RoomType rt = new RoomType();
        for ( int i=0; i < roomTypes.size(); i++ ) {
            rt = (RoomType)roomTypes.get(i);
            if ( roomType.equals( rt.getRoomType() ) )
                rtAvailableRooms = rt.getAvailableRooms();
        }
        return rtAvailableRooms;
    }

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

}
