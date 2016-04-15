
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

public class CustomerSearchServlet extends HttpServlet {

    private ArrayList lc=null, ld=null, ls=null;
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

        CompanyReportCtlr crctlr = new CompanyReportCtlr();
        CustomerQuery cqry = new CustomerQuery();

        String hotel   = request.getParameter("hotel"),
               field   = request.getParameter("field"),
               pattern = request.getParameter("pattern");

        ArrayList customerList = new ArrayList();
        if ( hotel != null && field != null && pattern != null ) {
            try {
                cqry.setHotelId( Short.parseShort(hotel) );
                cqry.setField( field );
                cqry.setPattern( pattern );
            } catch(Exception e) {}
            session.setAttribute("cqry",cqry);
            customerList = crctlr.getCompanyPattern(cqry);
            session.setAttribute("clist",customerList);
        }

        response.sendRedirect("customerSearch.jsp");
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
        return "Search of Customers";
    }

}
