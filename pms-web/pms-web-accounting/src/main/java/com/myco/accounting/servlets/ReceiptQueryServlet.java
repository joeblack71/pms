
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

public class ReceiptQueryServlet extends HttpServlet {

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

        /* Parameters from 'receipt_detail.jsp' */
        String hotel         = request.getParameter("hotel"),
               receiptType   = request.getParameter("receiptType"),
               receiptSerial = request.getParameter("receiptSerial"),
               correlative   = request.getParameter("correlative");
        /* Parameters from 'customer_report.jsp' */
        String customer      = request.getParameter("customer"),
               customerName  = request.getParameter("customerName");
        /* Parameters from 'customer_prod.jsp' */
        String period        = request.getParameter("period");

        System.out.println(customer+"-"+customerName);
        boolean customerReceipt=false, receiptDetail=false;
        /* Receipts by Customer and Period */
        if ( customer != null && customerName != null ) {
            ReceiptQuery rqry = new ReceiptQuery();
            ReceiptReportCtlr rrctlr = new ReceiptReportCtlr();
            try {
                rqry.setHotelId( Short.parseShort(hotel) );
                rqry.setCustomerDoc(customer);
            } catch(Exception e) {}

            if ( period != null ) {
                try {
                    rqry.setPeriod( Short.parseShort(period) );
                } catch(Exception e) {}
            }
            
            rrctlr.setReceiptQry(rqry);
            ArrayList receiptList = rrctlr.getSalesRequestedRows("salesByCustomerDoc");
            session.setAttribute("rlist",receiptList);
            customerReceipt = true;
        }
        /* Detail of Receipt */
        if ( hotel != null         && receiptType != null &&
             receiptSerial != null && correlative != null ) {
            //System.out.println(hotel+","+receiptSerial+","+correlative);
            ReceiptItem recd = new ReceiptItem();
            try {
              recd.setHotelId( Short.parseShort(hotel) );
              recd.setReceiptType( Short.parseShort(receiptType) );
              recd.setReceiptSerial( Short.parseShort(receiptSerial) );
              recd.setCorrelative( Integer.parseInt(correlative) );
            } catch(Exception e) {}
            // Todo: implements
            /*ReceiptQuery rqry = new ReceiptQuery();
            rqry.setHotelId(nHotel);
            rqry.setReceiptType();
            rqry.setReceiptSerial();
            rqry.setCorrelative();

            ReceiptDetailCtlr crecd = new ReceiptDetailCtlr();
            ArrayList recDetailList = crecd.chargeReceiptDetail(recd);
            session.setAttribute("lrecd",recDetailList);*/
            receiptDetail = true;
        }

        String caller = customerReceipt ? "customerReceipt.jsp" : "receiptDetail.jsp";
        RequestDispatcher dispatcher =
                          request.getRequestDispatcher(caller);
        if (dispatcher != null)
          dispatcher.forward(request, response);
        
        /*try {
            response.sendRedirect(caller);
        } catch (Exception e) { 
            System.out.println("'ReceiptQueryServlet' Error in redirection");
        }*/

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
