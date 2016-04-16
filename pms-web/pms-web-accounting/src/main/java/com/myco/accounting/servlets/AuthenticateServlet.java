
package servlets;

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

import java.sql.*;
import java.util.*;

import beans.AppUser;
import controllers.AppUserCtlr;
import dispatchers.*;
import libraries.*;

public class AuthenticateServlet extends HttpServlet {

    String[] hotels = {"UNIDAD HOTELERA"};
    String[] months = {"Enero","Febrero","Marzo","Abril","Mayo","Junio","Julio","Agosto","Setiembre","Octubre","Noviembre","Diciembre"};
    int[]    period = {2007,2006,2005,2004,2003,2002,2001,2000,1999}; // TODO: Debe empezar con el año de operacion de la empresa
    int[]    m_days = {1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20,21,22,23,24,25,26,27,28,29,30,31};
    int[]    totals = {0,1000,5000,10000,20000};

    /** Initializes the servlet.
    */
    public void init() throws ServletException {
        getServletContext().setAttribute("period",period);
        getServletContext().setAttribute("months",months);
        getServletContext().setAttribute("m_days",m_days);
        getServletContext().setAttribute("totals",totals);
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

        // Cuando todos los tipos de comprobante, estados y tipos de pago
        // esten definidos, mover esta informacion a init().
        Connection con = ConProvider.getConnection();
       
        // TODO: Select items on accord operation requested
        if (con != null ) {
            AppTableDisp atd = new AppTableDisp();
            atd.setConnection(con);
            getServletContext().setAttribute("lrt",atd.getReceiptType());
            getServletContext().setAttribute("lrs",atd.getReceiptStatus());
            getServletContext().setAttribute("lpt",atd.getPaymentType());
            try { con.close();
            } catch(Exception e) {}
        }
        
        String login = request.getParameter("login");
        String password = request.getParameter("password");

        if ( login != null && password != null ) {
            AppUser u = new AppUser();
            u.setLogin(login);
            u.setPassword(password);

            AppUserCtlr usrCtlr = new AppUserCtlr();
            boolean flag = AppUserCtlr.validate(u);
            if ( flag ) {
                ArrayList userOptions = usrCtlr.chargeOptions(u);
                session.setAttribute("user",u);
                session.setAttribute("uoptions",userOptions);
                response.sendRedirect("start_app.html");
            } else { 
                System.out.println("Conexion con MySQL fallo");
                response.sendRedirect("access_control.html");
            }
        } else response.sendRedirect("access_control.html");
    }

    //<editor-fold defaultstate="collapsed" desc="HttpServlet methods">
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
    //</editor-fold>

}
