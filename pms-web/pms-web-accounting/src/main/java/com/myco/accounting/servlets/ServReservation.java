
package servlets;

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

import java.sql.*;
//import java.util.Enumeration;
import java.util.ArrayList;
import java.text.SimpleDateFormat;

import beans.*;
import controllers.*;
import dispatchers.*;

public class ServReservation extends HttpServlet {

    /** Initializes the servlet.
    */
    public void init(ServletConfig config) throws ServletException {
        super.init(config);

        Connection con = ProveedorCon.getCon();

        DisTable dt = new DisTable();
        dt.setConnection(con);
      /* Charge 'ls' with reservation status */
        ArrayList ls = dt.chargeResStatus();
        config.getServletContext().setAttribute("ls",ls);

        DisRoomType drt = new DisRoomType();
        drt.setConnection(con);
      /* Charge 'lr' with reservation status */
        ArrayList lr = drt.chargeAll();
        config.getServletContext().setAttribute("lr",lr);

        try {
          con.close();
        } catch(Exception e){}

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
        PrintWriter out = response.getWriter();
        HttpSession session = request.getSession(true);

        //Connection con = ProveedorCon.getCon();
        /* El constructor inicializa las propiedades del objeto */
        Reservation res = new Reservation();
        CtrlReservation cr = new CtrlReservation();
        //DisReservation dr = new DisReservation();

        boolean reservationExist=false;

        /*if(session.getAttribute("ls") == null)
          chargeOptSelects(con, session);*/

        String hotel       = request.getParameter("hotel"),
               reservation = request.getParameter("reservation"),
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
               total       = request.getParameter("total"),
               lastname    = request.getParameter("lastname"),
               firstname   = request.getParameter("firstname"),
               show        = request.getParameter("show"),
               save        = request.getParameter("save"),
               delete      = request.getParameter("delete");

        //System.out.println("Res#: "+hotel+"-"+reservation);
        if (hotel != null && reservation != null) {
            res.setHotel(Byte.parseByte(hotel));
            try {
              res.setReservation(Integer.parseInt(reservation));
            } catch(Exception e){}
  
         	  //dr.setConnection(con);
            //cr.setReservation(res);
            /* Valida si la reserva existe. Si existe,
              los datos son cargados por 'DisReservation' ) */
            reservationExist = cr.validate(res);
        }

        ArrayList occupationDayList = null;
        if (arrival != null && departure != null &&
            roomType != null && quantity != null) {
            AvailabilityQry aq = new AvailabilityQry();
            aq.setHotel(Byte.parseByte(hotel));
            aq.setStartDate(getSqlFormat(arrival));
            aq.setEndDate(getSqlFormat(departure));
            aq.setRoomType(roomType);
            aq.setQuantity(Short.parseShort(quantity));

            DisAvailability da = new DisAvailability();
            Connection con = ProveedorCon.getCon();
            da.setConnection(con);
            da.setAvailabilityQry(aq);
            occupationDayList = da.getOccupationDays();
            try {
              con.close();
            } catch(Exception e) {}
            //System.out.println("al size: "+al.size());
        }

        /* Si es una consulta (show), no hace */

        if (save != null) {
          int roomsResv = res.getQuantity();
          ArrayList roomTypeList = (ArrayList)session.getAttribute("lr");
          boolean dateIsAvailable = verifyAvailability(roomTypeList,
                                    occupationDayList, roomsResv, roomType, quantity);
          if (dateIsAvailable) {
            res.setStatus(status);
            res.setNights(Short.parseShort(nights));
            res.setSource(source);
            res.setArrival(getSqlFormat(arrival));
            res.setDeparture(getSqlFormat(departure));
            res.setAdults(Short.parseShort(adults));
            res.setChildren(Short.parseShort(children));
            res.setRoomType(roomType);
            res.setQuantity(Short.parseShort(quantity));
            res.setRoomNumber(roomNumber);
            res.setRoomRate(Float.parseFloat(roomRate));
            res.setTotal(Float.parseFloat(total));
            res.setLastname(lastname);
            res.setFirstname(firstname);
            if (reservationExist)
              cr.update(res);
            else
              cr.insert(res);
          }
        }

        if (delete != null && reservationExist)
            cr.delete(res);

        session.setAttribute("res",res);
        response.sendRedirect("reservation.jsp");
    }

    private boolean verifyAvailability(ArrayList rtl, ArrayList odl,
                                       int roomsResv, String roomType,
                                       String quantity) {
        /* Habitaciones disponibles en tipo */
        int rtAvailableRooms=0;
        RoomType rt = new RoomType();
        for(int i=0; i < rtl.size(); i++) {
          rt = (RoomType)rtl.get(i);
          if(roomType.equals(rt.getRoomType()))
            rtAvailableRooms = rt.getAvailableRooms();
        }

        /* Si la reserva existe, guarda el numero de habitaciones
         bloqueadas por la misma. */
        /*if ( reservationExist )
           roomsResv = res.getQuantity();*/

        /* En esta parte se determina el numero de habitaciones
         disponibles para la fecha solicitada. */
        int roomsFree=0;
        boolean dateIsAvailable=false;
        if(odl.size() == 0)
          dateIsAvailable = true;
        else{
          AvailabilityDay a = new AvailabilityDay();
          for(int i=0; i < odl.size(); i++){
            a = (AvailabilityDay)odl.get(i);
            /* 'roomsResv' contiene las habitaciones bloqueadas
             anteriormente por la misma reserva */
            roomsFree = rtAvailableRooms - a.getOccupiedRooms() + roomsResv;
            if ( roomsFree > rtAvailableRooms )
               roomsFree = rtAvailableRooms;
            //System.out.println("Disp.: "+roomsFree+" ; Req.: "+quantity);
            if (roomsFree < Integer.parseInt(quantity)) {
              dateIsAvailable = false;
              break;
            } else {
              dateIsAvailable = true;
            }
          }
        }
        //System.out.println(rtAvailableRooms+" - "+a.getOccupiedRooms()+" = "+roomsFree);
        return dateIsAvailable;
    }

    private void chargeOptSelects(Connection con, HttpSession session) {
      /* Carga select de Estados de Reserva */
        /*DisTable dt = new DisTable();
        dt.setConnection(con);
        ArrayList ls = dt.chargeResStatus();
        session.setAttribute("ls",ls);*/

      /* Carga select de Tipos de Habitacion */
        /*DisRoomType drt = new DisRoomType();
        drt.setConnection(con);
        ArrayList lr = drt.chargeAll();
        session.setAttribute("lr",lr);*/
    }

    private java.sql.Date getSqlFormat(String strFormatDate){
        java.sql.Date sqlDateFormat = null;
        SimpleDateFormat sdf1 = new SimpleDateFormat("ddMMyy");
        SimpleDateFormat sdf2 = new SimpleDateFormat("dd/MM/yyyy");
        java.util.Date utilDate=null;

        if ( strFormatDate.length() == 6) {
          try{
            utilDate = sdf1.parse(strFormatDate);
          }catch(Exception e){}
        }

        if ( strFormatDate.length() == 10) {
          try{
            utilDate = sdf2.parse(strFormatDate);
          }catch(Exception e){}
        }

        sqlDateFormat = new java.sql.Date(utilDate.getTime());
        return sqlDateFormat;
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
