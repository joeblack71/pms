
package dispatchers;

import java.sql.*;
import java.util.ArrayList;

import beans.*;

public class AppTableDisp {

    private Connection con = null;
    private String operation = null;

    public AppTableDisp() {
    }

    public AppTableDisp(String _operation) {
        this.operation = _operation;
    }

    public Connection getConnection() {
        return con;
    }
    public void setConnection(Connection con) {
        this.con = con;
    }

    /** Devuelve un "ArrayList" con los tipos de comprobantes
    * que pueden ser emitidos por una empresa.
    * Tipos de comprobante: BOLETA, FACTURAS, NOTA DE CREDITO, NOTA DE DEBITO
    */
    public ArrayList getReceiptType() {
        ArrayList al = new ArrayList();
        String QUERY = "SELECT * FROM receipt_type";
        try {
            ResultSet rs = con.createStatement().executeQuery(QUERY);
            while ( rs.next() ) {
                ReceiptType rt = new ReceiptType();
                rt.setReceiptType(rs.getShort(1));
                rt.setDescription(rs.getString(2));
                al.add(rt);
            }
        } catch (Exception e) { e.printStackTrace(); }
        
        return al;
    }

    public ArrayList getReceiptStatus() {
        ArrayList al = new ArrayList();
        String QUERY = "SELECT * FROM receipt_status";
                               //" WHERE tOperationType = " + operation;
        try {
            ResultSet rs = con.createStatement().executeQuery(QUERY);
            while ( rs.next() ) {
                ReceiptStatus rst = new ReceiptStatus();
                rst.setReceiptStatus(rs.getString(1));
                rst.setDescription(rs.getString(2));
                al.add(rst);
            }
        } catch (Exception e) { e.printStackTrace(); }
        
        return al;
    }

    public ArrayList getPaymentType() {
        ArrayList al = new ArrayList();
        String QUERY = "SELECT * FROM payment_type";
        try {
            ResultSet rs = con.createStatement().executeQuery(QUERY);
            while ( rs.next() ) {
                PaymentType rt = new PaymentType();
                rt.setPaymentType(rs.getInt(1));
                rt.setDescription(rs.getString(2));
                al.add(rt);
            }
        } catch (Exception e) { e.printStackTrace(); }
        
        return al;
    }

    public ArrayList getCountries() {
        ArrayList al = new ArrayList();
        String QUERY = "SELECT * FROM country";
        try {
            ResultSet rs = con.createStatement().executeQuery(QUERY);
            while ( rs.next() ) {
                Country c = new Country();
                c.setCountryCode(rs.getInt(1));
                c.setDescription(rs.getString(2));
                c.setAbbreviation(rs.getString(3));
                c.setNationality(rs.getString(4));
                al.add(c);
            }
        } catch (Exception e){ e.printStackTrace(); }
        
        return al;
    }

    /** Devuelve un "ArrayList" con los tipos de documentos
    * que puede tener una persona.
    * Nacional: DNI, Carnet FF.AA. FF.PP, etc.
    * Extranjero: Pasaporte, Carnet de Extranjeria, Cedula de Identidad, etc.
    */
    public ArrayList getDocumentTypes(){
        ArrayList al=new ArrayList();
        String QUERY = "SELECT * FROM document_types";
        try {
            ResultSet rs = con.createStatement().executeQuery(QUERY);
            while ( rs.next() ) {
                DocumentType dt = new DocumentType();
                dt.setDocumentType(rs.getInt(1));
                dt.setDescription(rs.getString(2));
                al.add(dt);
            }
        } catch (Exception e){ e.printStackTrace(); }
        
        return al;
    }

}