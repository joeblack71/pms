
package com.mycom.booking.servlets;

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

import com.mycom.booking.beans.*;
import com.mycom.booking.controllers.*;
import com.mycom.booking.dispatchers.*;
import com.mycom.booking.events.CompanyDataException;
import com.mycom.booking.libraries.*;
import com.mycom.booking.lists.Companies;

import java.sql.*;
import java.util.ArrayList;
import java.util.Hashtable;
import java.util.Iterator;
import java.text.SimpleDateFormat;


public class CompanyServlet extends HttpServlet {

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
        String caller = request.getServletPath();
        Short hotelId = (Short)session.getAttribute("hotel");
        String component = "/company.jsp";

        Company co = new Company();
        CompanyCtlr cctlr = new CompanyCtlr();
        
        String show   = request.getParameter("show");
        String save   = request.getParameter("save");
        String delete = request.getParameter("delete");
        String report = request.getParameter("report");

        if ( !caller.equals("/companySearch") ) {
            boolean companyExists = false;
            try {
                co.setRucNumber( request.getParameter("rucNumber") );
                companyExists = cctlr.validate(co);
            } catch(Exception ex) {}
            
            if ( show != null && companyExists )
                companyExists = cctlr.search(co);
            
            if ( save != null ) {
                boolean saveOK;
                try {
                    chargeCompanyValues(request, co);
                    if ( companyExists )
                         saveOK = cctlr.update(co);
                    else saveOK = cctlr.insert(co);
                } catch(Exception ex) { ex.getMessage(); }
            }

            if ( delete != null && companyExists ) {
                cctlr.delete(co);
                co = new Company();
            }
            request.setAttribute("co",co);
        } else {
            String field = request.getParameter("sampleField");
            String pattern = request.getParameter("sampleValue");
            Companies cias = new Companies();
            cctlr.setCompanyList(cias);
            cctlr.chargeAll(pattern);
            request.setAttribute("companies",cias);
            component = "/companySearch.jsp";
        }

        try {
            request.getRequestDispatcher(component).forward(request, response);
        } catch(Exception ex) { ex.printStackTrace(); }
    }

    private void chargeCompanyValues(HttpServletRequest request, Company co) 
                 throws CompanyDataException {
        co.setRucNumber( request.getParameter("rucNumber") );
        co.setFirmName( request.getParameter("firmName") );
        co.setCommercialName( request.getParameter("commercialName") );
        co.setSegment( request.getParameter("segment") );
        co.setSourceId( request.getParameter("source") );
        co.setSpecialRate( request.getParameter("specialRate") );
        co.setContact( request.getParameter("contact") );
        co.setEmailContact( request.getParameter("emailContact") );
        co.setAddress( request.getParameter("address") );
        co.setDistrict( request.getParameter("district") );
        co.setCity( request.getParameter("city") );
        co.setCountry( request.getParameter("country") );
        co.setZipCode( request.getParameter("zipCode") );
        co.setPhone1( request.getParameter("phone1") );
        co.setPhone2( request.getParameter("phone2") );
    }
    
    //<editor-fold defaultstate="collapsed" desc="HttpServlet methods.">
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
    //</editor-fold>

}
