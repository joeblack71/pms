
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
import libraries.*;

public class CustomerReportServlet extends HttpServlet {

    String COMPANY = "C", PERSON = "P";

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
        //response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        HttpSession session = request.getSession();

        String hotel        = request.getParameter("hotel"),
               pattern      = request.getParameter("pattern"),
               customerType = request.getParameter("customerType"),
               show         = request.getParameter("show");

        CustomerQuery cqry = new CustomerQuery();
        boolean parametersOk=false;
        if (hotel != null && pattern != null && customerType != null) {
            try {
              cqry.setHotelId( Short.parseShort(hotel) );
            } catch(Exception e) {} // Todo: Error validation
            String fieldName = ( customerType.equals("C") )
                               ? "customerName" : "customerName";
            cqry.setField(fieldName);
            cqry.setPattern(pattern);
            cqry.setCustomerType(customerType);
            parametersOk = true;
        }

        if ( parametersOk ) {
            ArrayList customerList = null;
            if ( customerType.equals(COMPANY) ) {
                CompanyReportCtlr companyCtlr = new CompanyReportCtlr();
                customerList = companyCtlr.getCompanyPattern(cqry);
            }
            /*if ( customerType.equals(PERSON) ) {
                PersonCtlr  ctrlPerson  = new PersonCtlr();
                dp.setConnection(con);
                rs = dp.chargeSome(nhotel,pattern);
            }*/
            session.setAttribute("cqry",cqry);
            session.setAttribute("clist",customerList);
        }

        //Todo: review -> response.setHeader("pattern",pattern);
        response.sendRedirect("customerReport.jsp");
    }

    /** Devuelve el total de habitaciones disponibles en tipo
    * @param roomType - tipo requerido en la reserva
    */
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
