
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


public class CustomerServlet extends HttpServlet {

    private ArrayList countryList = null, documentTypes = null;
    
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
                   throws ServletException, IOException {
        response.setContentType("text/html");
        //PrintWriter out = response.getWriter();
        HttpSession session = request.getSession();

        Short hotelId = (Short)session.getAttribute("hotel");
        
        String documentNumber = request.getParameter("documentNumber");
        String show           = request.getParameter("show");
        String save           = request.getParameter("save");
        String delete         = request.getParameter("delete");
        String addCustomer    = request.getParameter("addGuest");

        Customer cust = new Customer();
        CustomerCtlr gctlr = new CustomerCtlr();

        String component = "/customer.jsp";
        boolean guestExists = false;
        boolean validDocumentNumber = ( documentNumber.equals("") ) ? false : true;
        if ( validDocumentNumber ) {
            cust.setHotelId( hotelId.shortValue() );
            cust.setDocumentNumber( documentNumber );
            guestExists = gctlr.validate(cust);
        }
        
        if ( save != null ) {
            // TODO: Validar campos
            chargeCustomerValues(request, cust);
            boolean saveOK;
            if ( guestExists )
                 saveOK = gctlr.update(cust);
            else saveOK = gctlr.insert(cust);
        }

        if ( delete != null && guestExists ) {
            gctlr.delete(cust);
            cust = new Customer();
        }

        if ( addCustomer != null && guestExists )
            component = "/GuestReservationServlet?addGuest";

        request.setAttribute("cust",cust);
        RequestDispatcher dispatcher = request.getRequestDispatcher(component);
        if ( dispatcher != null ) dispatcher.forward(request, response);
    }

    private void chargeCustomerValues(HttpServletRequest request, Customer cust) {
        String customerId   = request.getParameter("customerId"),
               nationality  = request.getParameter("nationality"),
               documentType = request.getParameter("documentType"),
               country      = request.getParameter("country"),
               phone1       = request.getParameter("phone1"),
               phone2       = request.getParameter("phone2"),
               source       = request.getParameter("source"),
               contact      = request.getParameter("contact");

        cust.setFirstname( request.getParameter("firstname") );
        cust.setLastname1( request.getParameter("lastname1") );
        cust.setLastname2( request.getParameter("lastname2") );
        cust.setAddress1( request.getParameter("address1") );
        cust.setAddress2( request.getParameter("address2") );
        cust.setCity( request.getParameter("city") );
        cust.setEmail( request.getParameter("email") );
        cust.setRequests( request.getParameter("requests") );
        try {
            cust.setNationality( Short.parseShort(nationality) );
            cust.setCountryId( Short.parseShort(country) );
            cust.setDocumentType( Short.parseShort(documentType) );
            cust.setPhone1( Integer.parseInt(phone1) );
            cust.setPhone2( Integer.parseInt(phone2) );
            cust.setContact( Boolean.parseBoolean(contact) );
        } catch (Exception e) {}
        cust.setSource(source);
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
        return "Manage access to 'guest' table";
    }

}
