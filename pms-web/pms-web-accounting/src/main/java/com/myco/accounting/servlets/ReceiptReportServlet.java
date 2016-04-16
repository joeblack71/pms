
package servlets;

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

import java.sql.*;
import java.util.ArrayList; // test Enumeration

import beans.ReceiptQuery;
import controllers.ReceiptReportCtlr;
import dispatchers.*;

public class ReceiptReportServlet extends HttpServlet {

    /** Initializes the servlet.
    */
    public void init() throws ServletException {
    }

    /** Destroys the servlet.
    */
    public void destroy() {}

    /** Processes requests for both HTTP <code>GET</code> and <code>POST</code> methods.
    * @param request servlet request
    * @param response servlet response
    */
    protected void processRequest(HttpServletRequest request,HttpServletResponse response)
                   throws ServletException, IOException {
        //response.setContentType("text/html");
        HttpSession session = request.getSession();

        ArrayList periodList=null;
        ArrayList monthList=null;
        ArrayList monthDayList=null;

        String hotel      = request.getParameter("hotel"),
               period     = request.getParameter("period"),
               month      = request.getParameter("month"),
               monthDay   = request.getParameter("month_day"),
               production = request.getParameter("production");
        
        ReceiptQuery rq = null;
        ReceiptReportCtlr rrc = null;

        String option = (String)session.getAttribute("option");
        if ( option == null ) option = "salesReport.jsp";
        
        boolean SALRPT = false, CUSPRD = false, PCHRPT = false;
        /*if ( production != null )
             CUSPRD = true;
        else SALRPT = true;*/
        SALRPT = ( option.equals("salesReport.jsp") ) ? true : false;
        CUSPRD = ( option.equals("customerProduction.jsp") ) ? true : false;
        PCHRPT = ( option.equals("purchasesReport.jsp") ) ? true : false;

        if ( hotel != null && period != null && month != null ) {
            rq = new ReceiptQuery();
            try {
                rq.setHotelId( Short.parseShort(hotel) );
                rq.setPeriod( Short.parseShort(period) );
                rq.setMonth( Short.parseShort(month) );
                rq.setMonthDay( Short.parseShort(monthDay) );
                if ( SALRPT || PCHRPT ) rq.setMonthDay( Short.parseShort(monthDay) );
            } catch(Exception e) { e.printStackTrace(); }
            
            if ( production != null ) {
                try {
                    rq.setProduction( Short.parseShort(production) );
                } catch (Exception e) {}
            }

            request.setAttribute("recqry",rq);
            rrc = new ReceiptReportCtlr();

            if ( SALRPT ) {
                rrc.setReceiptQry(rq);
                ArrayList rbpList = rrc.getSalesRequestedRows("salesByPeriod");
                request.setAttribute("rbplist",rbpList);
            }

            if ( CUSPRD ) {
                rrc.setReceiptQry(rq);
                ArrayList cpList = rrc.getSalesRequestedRows("customerProduction");
                request.setAttribute("cplist",cpList);
            }

            if ( PCHRPT ) {
                rrc.setRequest("purchaseByPeriod");
                ArrayList purchList = rrc.getPurchasesRequestedRows(rq);
                request.setAttribute("pbplist",purchList);
            }
        }

        //response.sendRedirect(option);
        RequestDispatcher dispatcher = request.getRequestDispatcher(option);
        if ( dispatcher != null ) dispatcher.forward(request, response);
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods">
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
        return "Manages 'Receipt' Reports";
    }
    // </editor-fold>

}
