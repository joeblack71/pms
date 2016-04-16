
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
import libraries.*;

public class ReceiptServlet extends HttpServlet {

    private final double TAX1_RATE    = 0.19; // IGV
    private final double SERVICE_RATE = 0.10; // SERVICIOS
    private final short CHECK      = 22; // CHECKS
    private final short ON_ACCOUNT = 51; // CUENTAS X COBRAR
    private final short ON_CHARGE  = 52; // CUENTAS X PAGAR
    
    /* TODO: Colocar los mensajes en un atributo de aplicacion
    private final String[][] messages = {{"001","Número de comprobante incorrecto !!"},
                                         {"002","Fecha de Emisión inválida !!"},
                                         {"003","Monto ingresado es inválido !!"},
                                         {"004","El comprobante requiere de un documento de Cliente !!"},
                                         {"005","Formato de Fecha de cancelación invalido !!"},
                                         {"006","Comprobante no registrado !!"},
                                         {"100","La operación requerida se completo exitosamente !!"}
                                        };
     */

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

        String caller = (String)session.getAttribute("caller");
        if ( caller == null ) caller = "sales.jsp";

        // TODO: los atributos request definidos en la jsp no pueden ser recuperados
        /*String caller = (String)request.getAttribute("caller");
        if ( caller == null ) caller = "sales.jsp";*/
        
        //String transaction = (String)session.getAttribute("transaction");
        //String tableName = transaction;
        String tableName = "";
        if ( caller.equals("sales.jsp") ) tableName = "receipt";
        if ( caller.equals("purchases.jsp") ) tableName = "purchase";

        String hotel          = request.getParameter("hotel"),
               receiptType    = request.getParameter("receiptType"),    // Bol,Fact,etc.
               receiptSerial  = request.getParameter("receiptSerial"),
               correlative    = request.getParameter("correlative"),
               issueDate      = request.getParameter("issueDate"),      // Issued date 
               paymentDate    = request.getParameter("paymentDate"),    // Payment date
               entityDoc       = request.getParameter("entityDoc"),      // Entity document: customerDoc && providerDoc
               net            = request.getParameter("net"),            // Net amount
               exempt         = request.getParameter("exempt"),         // Exempt flag 
               applyService   = request.getParameter("applyService"),   // Apply Service flag
               servicePercent = request.getParameter("servicePercent"), // Service percent
               paymentType    = request.getParameter("paymentType"),    // S/.,US$,Visa,Multiple,etc.
               money          = request.getParameter("money"),          // Money Receipt Printed
               exchange       = request.getParameter("exchange"),       // Used money exchange
               status         = request.getParameter("status");         // Cancelled,Payed,other

        String show         = request.getParameter("show"),
               save         = request.getParameter("save"),
               delete       = request.getParameter("delete"),
               clean        = request.getParameter("new");

        ReceiptCtlr rctlr = new ReceiptCtlr(tableName);
        Receipt receipt = new Receipt();

        short nPaymentType=0;
        String entityName = "", requestStatus = "";
        java.sql.Date sqlIssueDate = null, sqlPaymentDate = null;
        double dNet=0, dTax1=0, dService=0, dServicePercent=0, dTotal=0, dExchange=0;
        boolean bExempt=false, bApplyService=false;

        /* Todo: Nota Credito y Nota Debito vs comprobante original */
        boolean validReceiptId = true,  validIssueDate = true,
                validNetValue = true,   validEntityId = true,
                validFieldValues = true, receiptExists = false,
                completedOk = true;
        
        if ( hotel != null && receiptType != null &&
             receiptSerial != null && correlative != null ) {
            short nHotel = 0, nReceiptType = 0, nReceiptSerial = 0;
            int   nCorrelative = 0;
            try {
                nHotel         = Short.parseShort(hotel);
                nReceiptType   = Short.parseShort(receiptType);
                nReceiptSerial = Short.parseShort(receiptSerial);
                nCorrelative   = Integer.parseInt(correlative);
            } catch(NumberFormatException e) { validReceiptId = false; }
            if ( nReceiptSerial != 0 && nCorrelative != 0 ) {
                receipt.setHotelId(nHotel);
                receipt.setReceiptType(nReceiptType);
                receipt.setReceiptSerial(nReceiptSerial);
                receipt.setCorrelative(nCorrelative);
                receiptExists = rctlr.executeRequest(receipt,"validate");
                requestStatus = !receiptExists ? "006" : "";
            } else {
                requestStatus = "001";
                validReceiptId = false;
            }
        }

        // TODO: validar que los datos ingresados sean numericos
        if ( save != null && validReceiptId ) {
            if ( !issueDate.equals("") && issueDate.length() >= 6 ) {
                sqlIssueDate = DateManager.getSqlDateFormat(issueDate);
                
                boolean paymentDateOk = true;
                if ( paymentDate.equals("") ) {
                    if ( !paymentType.equals(String.valueOf(ON_ACCOUNT) ) &&
                         !paymentType.equals(String.valueOf(ON_CHARGE) )  &&
                         !paymentType.equals(String.valueOf(CHECK) ) )
                        sqlPaymentDate = sqlIssueDate;
                    else sqlPaymentDate = null;
                } else {
                    if ( paymentDate.length() >= 6 && paymentDate.length() <= 10)
                        sqlPaymentDate = DateManager.getSqlDateFormat(paymentDate);
                    else { 
                        requestStatus = "005";
                        paymentDateOk = false;
                    }
                }
                //if ( paymentDateOk ) receipt.setPaymentDate(sqlPaymentDate);

                if ( exchange != null && !exchange.equals("") ) {
                    try {
                        exchange = exchange.contains(",") ?
                                   exchange.replace(",",".") : exchange;
                        dExchange = Double.valueOf(exchange).doubleValue();
                    } catch(Exception e) {}
                }

                try {
                    nPaymentType = Short.parseShort(paymentType);
                } catch (Exception e) {}

            } else {
                requestStatus = "002";
                validIssueDate = false;
            }
        }

        // Validate Net amount and then calculate Taxes
        if ( save != null && validIssueDate ) {
            if ( net != null && !net.equals("") ) {
                try {
                    net = net.contains(",") ? net.replace(",",".") : net;
                    dNet = Double.valueOf(net).doubleValue();
                } catch (Exception e) { validNetValue = false; }
            }

            // TODO: Redondear a 2 decimales
            if ( validNetValue ) {
                bExempt = ( exempt != null ) ? true : false;
                dTax1 = ( bExempt ) ? 0 : dNet * TAX1_RATE;

                bApplyService = ( applyService != null ) ? true : false;
                if ( bApplyService ) {
                    if ( servicePercent != null && !servicePercent.equals("") ) {
                        try {
                            servicePercent = servicePercent.contains(",") ?
                                             servicePercent.replace(",",".") : servicePercent;
                            dServicePercent = Double.valueOf(servicePercent).doubleValue();
                        } catch(Exception e) {}
                        dService = ( dServicePercent != 0 ) ? dNet * dServicePercent : 0;
                    } else dService = dNet * SERVICE_RATE;
                }
                dTotal  = dNet + dTax1 + dService;
                //System.out.println("Total receipt:"+dTotal);
            } else requestStatus = "003";
        }

        // Validate Customer ID
        if ( save != null && validIssueDate && validNetValue ) {
            if ( entityDoc != null && !entityDoc.equals("") ) {
                EntityCtlr  ectlr = new EntityCtlr();
                ectlr.setRequest("validate");
                if ( tableName.equals("purchase") ) {
                     Provider prv = new Provider();
                     prv.setHotelId( receipt.getHotelId() );
                     prv.setEntityDoc(entityDoc);
                     validEntityId = ectlr.executeRequest(prv); // provider
                     entityName = prv.getEntityName();
                } else {
                     Company  cia = new Company();
                     cia.setHotelId( receipt.getHotelId() );
                     cia.setEntityDoc(entityDoc);
                     validEntityId = ectlr.executeRequest(cia); // customer
                     entityName = cia.getEntityName();
                }
            } else validEntityId = ( receipt.getReceiptType() == 1 ) ? false : true;
            
            if ( !validEntityId ) {
                System.out.println(entityDoc);
                receipt.setEntityId(entityDoc);
                requestStatus = "004";
            }
        }
        
        validFieldValues = validReceiptId && validIssueDate && validEntityId && validNetValue;

        // TODO: definir si una vez anulado el documento puede volver a activarse
        //if ( validFieldValues && !status.equals("*") ) {
        if ( save != null && validFieldValues ) {
            receipt.setIssueDate(sqlIssueDate);
            receipt.setPaymentDate(sqlPaymentDate);
            receipt.setEntityId(entityDoc);
            receipt.setEntityName(entityName);
            receipt.setNet(dNet);
            receipt.setExempt(bExempt);
            receipt.setTax1(dTax1);
            receipt.setApplyService(bApplyService);
            receipt.setServicePercent(dServicePercent);
            receipt.setService(dService);
            receipt.setReceiptTotal(dTotal);
            receipt.setPaymentType(nPaymentType);
            receipt.setMoney(money);
            receipt.setExchange(dExchange);
            receipt.setStatus(status);
            String opRequest = (!receiptExists) ? "insert" : "update";
            completedOk = rctlr.executeRequest(receipt,opRequest);
            requestStatus = ( completedOk ) ? "100" : "400";
        }

        // TODO: Registrar fecha de la eliminacion y usuario
        //       Desactivar registro, mantener datos historicos.
        if ( delete != null && receiptExists ) {
            completedOk = rctlr.executeRequest(receipt,"delete");
            requestStatus = ( completedOk ) ? "100" : "400";
            receipt = new Receipt();
        }

        if ( clean != null ) {
            receipt = new Receipt();
        }

        request.setAttribute("requestStatus",requestStatus);
        request.setAttribute("receipt",receipt);
        //response.sendRedirect(caller);
        RequestDispatcher dispatcher = request.getRequestDispatcher(caller);
        if ( dispatcher != null ) dispatcher.forward(request, response);
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
