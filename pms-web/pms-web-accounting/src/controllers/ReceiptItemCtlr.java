
package controllers;

import java.sql.*;
import java.util.ArrayList;

import beans.*;
import dispatchers.*;
import dispatchers.*;

public class ReceiptItemCtlr {

    /** Creates new ItemCtlr */
    public ReceiptItemCtlr() {
    }

    public static boolean validate(ReceiptItem ri){
        Connection c = ConProvider.getConnection();
        ReceiptItemDisp rid = new ReceiptItemDisp();
        rid.setConnection(c);
        rid.setReceiptItem(ri);
        boolean flag = rid.validate();
        try { c.close();
        } catch (Exception e){}
        return flag;
    }

    public static boolean insert(ReceiptItem ri){
        Connection c = ConProvider.getConnection();
        ReceiptItemDisp rid = new ReceiptItemDisp();
        rid.setConnection(c);
        rid.setReceiptItem(ri);
        boolean flag = rid.insert();
        try { c.close();
        } catch (Exception e){}
        return flag;
    }

    public static boolean update(ReceiptItem ri){
        Connection c = ConProvider.getConnection();
        ReceiptItemDisp rid = new ReceiptItemDisp();
        rid.setConnection(c);
        rid.setReceiptItem(ri);
        boolean flag = rid.update();
        try { c.close();
        } catch (Exception e){}
        return flag;
    }

    public static boolean delete(ReceiptItem ri){
        Connection c = ConProvider.getConnection();
        ReceiptItemDisp rid = new ReceiptItemDisp();
        rid.setConnection(c);
        rid.setReceiptItem(ri);
        boolean flag = rid.delete();
        try { c.close();
        } catch (Exception e){}
        return flag;
    }

    /*public static ArrayList getReceiptItem(ReceiptItem ri) {
        Connection c = ConProvider.getConnection();
        ReceiptItemDisp rid = new ReceiptItemDisp();
        rid.setConnection(c);
        rid.setReceiptItem(ri);
        ArrayList lrecd = rid.getReceiptItems();
        try { c.close();
        } catch (Exception e){}
        return lrecd;
    }*/

}
