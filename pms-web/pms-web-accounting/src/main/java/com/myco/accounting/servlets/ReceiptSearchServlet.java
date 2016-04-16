
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

public class ReceiptSearchServlet extends HttpServlet {

    /** Initializes the servlet.
    */
    public void init() throws ServletException {}

    /** Destroys the servlet.
    */
    public void destroy() {}

    /** Processes requests for both HTTP <code>GET</code> and <code>POST</code> methods.
    * @param request servlet request
    * @param response servlet response
    */
    protected void processRequest(HttpServletRequest request,HttpServletResponse response)
                   throws ServletException, IOException {
        response.setContentType("text/html");
        //PrintWriter out = response.getWriter();
        HttpSession session = request.getSession();

        String hotel   = request.getParameter("hotel"),
               field   = request.getParameter("field"),
               pattern = request.getParameter("pattern");

        ArrayList lrec = new ArrayList();
        if ( hotel != null && field != null && pattern != null ) {
            ReceiptQuery rqry = new ReceiptQuery();
            try {
                rqry.setHotelId( Short.parseShort(hotel) );
            } catch(Exception e) {}

            rqry.setField(field);
            if ( field.equals("issueDate") || field.equals("paymentDate") )
                 rqry.setQueryDate( DateManager.getSqlDateFormat(pattern) );
            if ( field.equals("customerDoc") )
                rqry.setCustomerDoc(pattern);
            if ( field.equals("customerName") )
                rqry.setCustomerName(pattern);
            //System.out.println( rqry.getQueryDate()+";"+rqry.getCustomerName() );
            ReceiptReportCtlr rrctlr = new ReceiptReportCtlr();
            rrctlr.setReceiptQry(rqry);
            if ( field.equals("issueDate") )
                 lrec = rrctlr.getSalesRequestedRows("salesByIssueDate");
            if ( field.equals("paymentDate") )
                 lrec = rrctlr.getSalesRequestedRows("salesByPaymentDate");
            if ( field.equals("customerDoc") )
                 lrec = rrctlr.getSalesRequestedRows("salesByCustomerDoc");
            if ( field.equals("customerName") )
                 lrec = rrctlr.getSalesRequestedRows("salesByCustomerName");

            session.setAttribute("rqry",rqry);
        }

        if ( lrec != null )
            session.setAttribute("lrec",lrec);
        response.sendRedirect("receiptSearch.jsp");
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
        return "";
    }

}
