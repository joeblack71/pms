/*
 * UserOptions.java
 *
 * Created on December 11, 2002, 9:53 PM
 */

package servlets;

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.sql.*;

import beans.*;
import controllers.*;

public class UserOptionsServlet extends HttpServlet {

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
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException {

        // response.setContentType("text/html"); // no genera contenido html
        HttpSession session = request.getSession();

        //Connection c = ConProvider.getCon();
        Connection c = (Connection)session.getAttribute("conexion"); // Todo: review
        // Todo: Implements
        /*AppUserDisp aud = new AppUserDisp();
        aud.setConnection(c);
        ArrayList userList = aud.getAllUsers();
        session.setAttribute("users",users);
        response.sendRedirect("userOptions.jsp");*/
    }

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

}
