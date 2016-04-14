/*
 * TestingServlet.java
 *
 * Created on 9 de mayo de 2007, 18:22
 */

package servlets;

import java.io.*;
import java.net.*;

import javax.servlet.*;
import javax.servlet.http.*;

import java.util.Enumeration;
/**
 *
 * @author Developer
 * @version
 */
public class TestingServlet extends HttpServlet {
    
    /** Processes requests for both HTTP <code>GET</code> and <code>POST</code> methods.
     * @param request servlet request
     * @param response servlet response
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        out.println("<HTML>" +
                    "<BODY BGCOLOR=\"#FDF5E6\">\n" +
                    "<H1 ALIGN=CENTER>" + "TESTING" + "</H1>\n" +
                    "<B>Request Method: </B>" +
                    request.getMethod() + "<BR>\n" +
                    "<B>Request URI: </B>" +
                    request.getRequestURI() + "<BR>\n" +
                    "<B>Request Protocol: </B>" +
                    request.getProtocol() + "<BR><BR>\n" +
                    "<TABLE BORDER=1 ALIGN=CENTER>\n" +
                    "<TR BGCOLOR=\"#FFAD00\">\n" +
                    "<TH>Header Name<TH>Header Value");
        Enumeration headerNames = request.getHeaderNames();
        while(headerNames.hasMoreElements()) {
            String headerName = (String)headerNames.nextElement();
            out.println("<TR><TD>" + headerName);
            out.println(" <TD>" + request.getHeader(headerName));
        }
        out.println("</TABLE>\n");

        out.println( "<P>" + "<b>Path info: </b>" + request.getPathInfo() + "<BR>" +
                     "<b>Path translated: </b>" + request.getPathTranslated() + "<BR>" +
                     "<b>Servlet path: </b>"    + request.getServletPath() + "<BR>" +
                     "<b>Context path: </b>"    + request.getContextPath() + "<BR>" +
                     "<b>Referer: </b>"    + request.getHeader("referer") + "<BR>" +
                     "<b>Request URL: </b>"      + request.getRequestURL() + "<BR>" +
                     "<b>Request URI: </b>"     + request.getRequestURI() );

        String caller = request.getHeader("referer");
        out.println("\n<P><a href=" + caller + ">" +
                    caller.substring( caller.lastIndexOf('/') ) + "</a>");

        out.println("</BODY></HTML>");
        
        // Way 1
        /*RequestDispatcher dispatcher =
               getServletContext().getRequestDispatcher("/reservationSearch.jsp");
         if ( dispatcher != null )
             dispatcher.forward(request,response);
         */

        // Way 2
        /*String caller = request.getServletPath();
        if ( caller.equals("/reservsearch") ) {
            try {
                request.getRequestDispatcher(caller + ".jsp")
                       .forward(request,response);
            } catch(Exception ex) { ex.printStackTrace(); }
        }
         */
        out.close();
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
