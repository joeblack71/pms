
package controllers;

import javax.servlet.*;
import javax.servlet.http.*;

import java.sql.*;
import java.util.Date;
import java.util.Calendar;
import java.util.ArrayList;
import java.text.SimpleDateFormat;

import lib.*;
import beans.AvailabilityQry;
import beans.AvailabilityDay;
import dispatchers.ProveedorCon;
import dispatchers.DisAvailability;

public class CtrlAvailability extends HttpServlet {

    /** Initializes the servlet.
    */
    public void init(ServletConfig config) throws ServletException {
        super.init(config);
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
        java.io.PrintWriter out = response.getWriter();
        HttpSession session = request.getSession(true);

        Connection con=null;
        AvailabilityQry aq=null;
        DisAvailability da=null;
        AvailabilityArray aa=null;
        ArrayList al=null;
        String[][] availability=null;
        short nHotel=0;

        String hotel      = request.getParameter("selHotel"),
               startDate  = request.getParameter("startDate"),
               period     = request.getParameter("selPeriod"),
               showPeriod = request.getParameter("show"), // button
               nextPeriod = request.getParameter("next");

        if(hotel != null){
          try{
            nHotel = Short.parseShort(hotel);
          }catch(Exception e){}
        }

        if(startDate != null) {
          if(startDate.length() < 6 || startDate.length() > 10)
            startDate = getValidDateFormat(startDate);
        }

        //System.out.println("1 "+hotel+"-"+startDate+"-"+period);
        if(showPeriod != null){
          aa = new AvailabilityArray(startDate,period);
          aq = new AvailabilityQry();

          aq.setHotel(nHotel);
          aq.setStartDate(aa.getStartDate());
          aq.setEndDate(aa.getEndDate());

          con = ProveedorCon.getCon();
          da = new DisAvailability();
          da.setConnection(con);
          da.setAvailabilityQry(aq);
          al = da.getAvailabilityRooms();

          aa.chargeRoomsOccupation(al);
          availability = aa.getAvailabilityArray();

          session.setAttribute("array",aa);
          session.setAttribute("matriz",availability);
          session.setAttribute("aq",aq);
          //System.out.println("Cargo atributos ;)");
        }

        if(nextPeriod != null){
          aa = (AvailabilityArray)session.getAttribute("array");
          availability = aa.getAvailabilityArray();
          //availability = (String[][])session.getAttribute("matriz");
        }

        if(con != null){
          try{
            con.close();
          }catch(Exception e){}
        }
        response.sendRedirect("availability.jsp");
        //System.out.println("redirecciona 'availability.jsp'");
    }

    private String getValidDateFormat(String strBadDateFormat){
      String validDateFormat=null;
      SimpleDateFormat bdf = new SimpleDateFormat("dd - MMM - yyyy");
      SimpleDateFormat sdf = new SimpleDateFormat("ddMMyy");
      Calendar cal = Calendar.getInstance();
      if(strBadDateFormat.length() == 15) { // "dd - MMM - yyyy" = 15 chars
        java.util.Date utilDate=null;
        try{
          utilDate = bdf.parse(strBadDateFormat);
        }catch(Exception e){}
        validDateFormat = sdf.format(utilDate);
      } else
        validDateFormat = sdf.format(cal.getTimeInMillis());
      return validDateFormat;
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
