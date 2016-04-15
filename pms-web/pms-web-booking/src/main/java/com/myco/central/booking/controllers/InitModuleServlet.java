/*
 * InitModuleServlet.java
 *
 * Created on 17 de mayo de 2007, 11:17
 */

package com.mycom.booking.servlets;

import java.io.*;
import java.net.*;

import javax.servlet.*;
import javax.servlet.http.*;

import com.mycom.booking.dispatchers.*;

import java.sql.*;
import java.util.ArrayList;


/**
 *
 * @author Developer
 * @version
 */
public class InitModuleServlet extends HttpServlet {
    
    ServletContext moduleContext;
    
    String[] hotels = {"hoteles","Apart Hotel El Doral"};
    int[]    years  = {0,2007,2006,2005,2004,2003,2002,2001,2000,1999}; // TODO: Debe empezar con el año de operacion de la empresa
    String[] months = {"Meses","Enero","Febrero","Marzo","Abril","Mayo","Junio","Julio","Agosto","Setiembre","Octubre","Noviembre","Diciembre"};
    int[]    days   = {0,1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20,21,22,23,24,25,26,27,28,29,30,31};
    int[]    sales  = {0,1000,5000,10000,20000};

    /** Initializes the servlet.
    */
    public void init() throws ServletException {
        moduleContext = getServletContext();
        moduleContext.setAttribute("years",years);
        moduleContext.setAttribute("months",months);
        moduleContext.setAttribute("days",days);
        moduleContext.setAttribute("sales",sales);
    }

    /** Processes requests for both HTTP <code>GET</code> and <code>POST</code> methods.
     * @param request servlet request
     * @param response servlet response
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        //PrintWriter out = response.getWriter();
        HttpSession session = request.getSession();

        // TODO: Probar pool de conexiones
        /*ConnectionPool pool = new ConnectionPool();
        moduleContext.setAttribute("pool",pool);
         */

        // TODO: Mover este segmento a init()
            Connection con = ConProvider.getConnection();
            ModTableDisp mtd = new ModTableDisp();
            mtd.setConnection(con);
            moduleContext.setAttribute("resStatus",mtd.getResStatus());
            moduleContext.setAttribute("payTypes", mtd.getPaymentTypes());
            moduleContext.setAttribute("countries",mtd.getCountries());
            moduleContext.setAttribute("cities",   mtd.getCities());
            moduleContext.setAttribute("segments", mtd.getSegments());
            moduleContext.setAttribute("sources",  mtd.getSources());
             // TODO: must change with selected hotel
            moduleContext.setAttribute("spRates",  mtd.getSpecialRates(1));
            moduleContext.setAttribute("docTypes", mtd.getDocumentTypes());
            //moduleContext.setAttribute("rates",    mtd.getRoomtypeRates());

            RoomTypeDisp rtd = new RoomTypeDisp();
            rtd.setConnection(con);
            moduleContext.setAttribute("roomTypes",rtd.chargeAll());

            session.setAttribute("hotel",new Short("1"));
                    
            /*
            SourceDisp sd = new SourceDisp();
            sd.setConnection(con);
            session.setAttribute("sources",sd.getSources());
             */

            try { con.close();
            } catch(Exception e){}
        //
        response.sendRedirect( response.encodeRedirectURL("startApplication.html") );

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
