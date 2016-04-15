
package controllers;

import java.sql.*;
import java.util.ArrayList;

import beans.*;
import dispatchers.*;

public class ReceiptCtlr {

    private static String tableName = null;

    /** Creates new ReceiptCtlr */
    public ReceiptCtlr(String tableName) {
        this.tableName = tableName;
    }

    public static boolean executeRequest(Receipt receipt, String request){
        Connection con = ConProvider.getConnection();
        
        ReceiptDisp rdisp = new ReceiptDisp();
        rdisp.setConnection(con);
        rdisp.setTableName(tableName);
        rdisp.setReceipt(receipt);

        boolean flag = false;
        if ( request.equals("validate") )
            flag = rdisp.validate();
        if ( request.equals("insert") )
            flag = rdisp.insert();
        if ( request.equals("update") )
            flag = rdisp.update();
        if ( request.equals("delete") )
            flag = rdisp.delete();

        try { con.close();
        } catch (Exception e) {}

        return flag;
    }

}
