
package controllers;

import java.sql.*;
import java.util.ArrayList;

import beans.ReceiptQuery;
import dispatchers.*;

public class ReceiptReportCtlr {

    private static ReceiptQuery receiptQry = null;
    private static String request = null;
    private static String[] purchaseOption =
                            {"purchaseByPeriod","purchaseByDate",
                             "purchaseByCustomer","consumptionRanking"};

    /** Creates new ReceiptReportCtlr */
    public ReceiptReportCtlr() {
    }

    public ReceiptQuery getReceiptQry() {
        return receiptQry;
    }
    public void setReceiptQry(ReceiptQuery receiptQry) {
        this.receiptQry = receiptQry;
    }
    
    public String getRequest() {
        return request;
    }
    public void setRequest(String req) {
        this.request = req;
    }

    /** Return a List with all "Sales Receipt" required by
    * Application programs.
    */
    public static ArrayList getSalesRequestedRows(String queryRequest) {
        Connection con = ConProvider.getConnection();
        String[] salesOption = {"salesByPeriod",
                                "salesByIssueDate","salesByPaymentDate",
                                "salesByCustomerDoc", "salesByCustomerName",
                                "customerProduction"};
        SalesReportDisp srd = new SalesReportDisp();
        srd.setConnection(con);
        srd.setReceiptQuery(receiptQry);

        ArrayList reqList = new ArrayList();
        if ( queryRequest.equals( salesOption[0]) )
            reqList = srd.getSalesByPeriod();
        if ( queryRequest.equals( salesOption[1] ) )
            reqList = srd.getSalesByDate(true);
        if ( queryRequest.equals( salesOption[2] ) )
            reqList = srd.getSalesByDate(false);
        if ( queryRequest.equals( salesOption[3] ) )
            reqList = srd.getSalesByCustomerDoc();
        if ( queryRequest.equals( salesOption[4] ) )
            reqList = srd.getSalesByCustomerName();
        if ( queryRequest.equals( salesOption[5] ) )
            reqList = srd.getCustomerProduction();

        try { con.close();
        } catch (Exception e){}

        return reqList;
    }

    /** Return a List with all "Purchase Receipt" required by
    * Application programs.
    */
    public static ArrayList getPurchasesRequestedRows(ReceiptQuery rq){
        Connection con = ConProvider.getConnection();
        PurchaseReportDisp srd = new PurchaseReportDisp();
        srd.setConnection(con);
        srd.setReceiptQuery(rq);

        ArrayList reqList = new ArrayList();
        if ( request.equals(purchaseOption[0]) ) {
            boolean purchasesRegister = true;
            reqList = srd.getPurchaseByPeriod(purchasesRegister);
        }
        if ( request.equals(purchaseOption[1]) )
            reqList = srd.getPurchaseByDate();
        if ( request.equals(purchaseOption[2]) )
            reqList = srd.getPurchaseByProvider();
        if ( request.equals(purchaseOption[3]) )
            reqList = srd.getConsumptionRanking();

        try { con.close();
        } catch (Exception e){}

        return reqList;
    }

}
