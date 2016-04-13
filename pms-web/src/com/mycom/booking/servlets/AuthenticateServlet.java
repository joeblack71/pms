
package com.mycom.booking.servlets;

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

import com.mycom.booking.beans.AppUser;
import com.mycom.booking.controllers.AppUserCtlr;
import com.mycom.booking.dispatchers.*;

//import java.sql.*;
import java.util.ArrayList;


public class AuthenticateServlet extends HttpServlet {

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
              throws ServletException, java.io.IOException {
        HttpSession session = request.getSession();

        AppUser u = new AppUser();
        AppUserCtlr usrCtlr = new AppUserCtlr();

        String hotel    = request.getParameter("hotelId");
        String login    = request.getParameter("login");
        String password = request.getParameter("password");

        if ( login.length() > 0 && password.length() >= 0 ) {
            u.setHotelId( Short.parseShort(hotel) );
            u.setLogin(login);
            u.setPassword(password);
            if ( AppUserCtlr.validate(u) ) {
                ArrayList userOptions = usrCtlr.chargeOptions(u);
                session.setAttribute("user",u);
                session.setAttribute("hotel",new Short( u.getHotelId() ));
                session.setAttribute("uoptions",userOptions);
                response.sendRedirect("InitModuleServlet");
            } else { 
                response.sendRedirect("login.html");
            }
        } else response.sendRedirect("login.html");
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
        return "User Access Control";
    }

}
