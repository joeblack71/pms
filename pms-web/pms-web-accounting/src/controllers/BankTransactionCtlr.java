
package controllers;

import java.sql.*;
import java.util.ArrayList;

import beans.*;
import dispatchers.*;

public class BankTransactionCtlr {

    /** Creates new BankTransactionCtlr */
    public BankTransactionCtlr() {
    }

    public static boolean executeRequest(BankTransaction bt, String request){
        Connection con = ConProvider.getConnection();
        
        BankTransactionDisp tdisp = new BankTransactionDisp();
        tdisp.setConnection(con);
        tdisp.setBankTransaction(bt);

        boolean flag = false;
        if ( request.equals("validate") )
            flag = tdisp.validate();
        if ( request.equals("insert") )
            flag = tdisp.insert();
        if ( request.equals("update") )
            flag = tdisp.update();
        if ( request.equals("delete") )
            flag = tdisp.delete();

        try { con.close();
        } catch (Exception e) {}

        return flag;
    }

}
