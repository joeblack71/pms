
package servlets;

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

import java.sql.*;
//import java.util.Enumeration;
import java.util.ArrayList;

import beans.*;
import controllers.*;
import dispatchers.*;
import libraries.DateManager;

public class BankTransactionServlet extends HttpServlet {

    /** Initializes the servlet.
    */
    public void init() throws ServletException {
        //TODO: Cargar lista con formas de transaccion (CHEQUES, CASH, etc.) 
        //ArrayList list = new ArrayList();
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

        BankTransaction bt = new BankTransaction();
        BankTransactionCtlr tctlr= new BankTransactionCtlr();

        String bankId            = request.getParameter("bankId"),
               accountNumber     = request.getParameter("accountNumber"),
               transactionNumber = request.getParameter("transactionNumber"),
               transactionDate   = request.getParameter("transactionDate"),
               transactionType   = request.getParameter("transactionType"),
               transactionWay    = request.getParameter("transactionWay"),
               documentNumber    = request.getParameter("documentNumber"),
               transactionAmount = request.getParameter("transactionAmount");

        String show   = request.getParameter("show"),
               save   = request.getParameter("save"),
               delete = request.getParameter("delete"),
               clean  = request.getParameter("new");

        boolean transactionExist   = true;
        boolean validTransactionId = true;
        boolean validTransactionFileds = true;
        boolean completedOk        = true;
        
        if ( bankId != null && accountNumber != null && transactionNumber != null ) {
            try {
                bt.setBankId( Short.parseShort(bankId) );
                bt.setAccountNumber( Long.parseLong(accountNumber) );
                bt.setTransactionNumber( Integer.parseInt(transactionNumber) );
                transactionExist = tctlr.executeRequest(bt,"validate");
            } catch(NumberFormatException e) { validTransactionId = false; }
        }

        if ( save != null && validTransactionId ) {
            bt.setTransactionDate( DateManager.getSqlFormat(transactionDate) );
            bt.setTransactionType(transactionType);
            try {
                bt.setTransactionWay( Short.parseShort(transactionWay) );
                //bt.setDocumentNumber( Integer.parseInt(documentNumber) );
                bt.setTransactionAmount( Double.parseDouble(transactionAmount) );
            } catch(NumberFormatException e) { validTransactionFileds = false; }

            if ( bt.getTransactionWay() != 9 )
                bt.setITFTransaction( bt.getTransactionAmount() * 0.0008 );

            if ( bt.getTransactionNumber() == 0 && bt.getTransactionWay() != 9 )
                validTransactionId = false;
            
            if ( validTransactionFileds && bt.getTransactionAmount() != 0 ) {
                String opRequest = (!transactionExist) ? "insert" : "update";
                completedOk = tctlr.executeRequest(bt,opRequest);
            }
        }

        if ( delete != null && transactionExist ) {
            completedOk = tctlr.executeRequest(bt,"delete");
            //requestStatus = ( completedOk ) ? "100" : "400";
            bt = new BankTransaction();
        }

        if ( clean != null ) {
            bt = new BankTransaction();
        }

        //session.setAttribute("requestStatus",requestStatus);
        session.setAttribute("bt",bt);
        response.sendRedirect("bankTransactions.jsp");
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
        return "Manages 'receipt' register";
    }

}
