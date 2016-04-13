
package com.mycom.booking.dispatchers;

import java.sql.*;
import java.util.ArrayList;

import com.mycom.booking.beans.*;


public class ModTableDisp {

    private Connection con=null;

    public ModTableDisp() {
    }

    public Connection getConnection() {
        return con;
    }
    public void setConnection(Connection con) {
        this.con = con;
    }

    public ArrayList getResStatus(){
        ArrayList al=new ArrayList();
        String QUERY = "SELECT * FROM reservation_status";
        try{
            ResultSet rs = con.createStatement().executeQuery(QUERY);
            while(rs.next()){
                TableElement te = new TableElement();
                te.setStringId( rs.getString(1) );
                te.setDescription( rs.getString(2) );
                al.add(te);
            }
        }catch (Exception e){
            e.printStackTrace();
            System.out.println("Error in getResStatus()'");
        }
        return al;
    }

    public ArrayList getPaymentTypes(){
        ArrayList al=new ArrayList();
        String QUERY = "SELECT * FROM hotel_account";
        try{
            ResultSet rs = con.createStatement().executeQuery(QUERY);
            while(rs.next()){
              TableElement te = new TableElement();
              te.setElementId( rs.getShort(2) );
              te.setDescription( rs.getString(4) );
              al.add(te);
            }
        }catch (Exception e){
            e.printStackTrace();
            System.out.println("Error in getPaymentTypes()'");
        }
        return al;
    }

    public ArrayList getCountries(){
        ArrayList al=new ArrayList();
        String QUERY = "SELECT * FROM country";
        try{
            ResultSet rs = con.createStatement().executeQuery(QUERY);
            while(rs.next()){
              Country c = new Country();
              c.setCountryId( rs.getShort(1) );
              c.setCountryName( rs.getString(2) );
              c.setAbbreviation( rs.getString(3) );
              c.setNationality( rs.getString(4) );
              al.add(c);
            }
        }catch (Exception e){
            e.printStackTrace();
            System.out.println("Error in 'getCountries()'");
        }
        return al;
    }

    public ArrayList getCities(){
        ArrayList al=new ArrayList();
        String QUERY = "SELECT * FROM city";
        try{
            ResultSet rs = con.createStatement().executeQuery(QUERY);
            while(rs.next()){
              TableElement te = new TableElement();
              te.setElementId( rs.getShort(2) );
              te.setDescription( rs.getString(3) );
              al.add(te);
            }
        }catch (Exception e){
            e.printStackTrace();
            System.out.println("Error in 'chargeCountries()'");
        }
        return al;
    }

    public ArrayList getSegments(){
        ArrayList al=new ArrayList();
        String QUERY = "SELECT * FROM segment";
        try{
            ResultSet rs = con.createStatement().executeQuery(QUERY);
            while(rs.next()){
              TableElement te = new TableElement();
              te.setElementId( rs.getShort(1) );
              te.setDescription( rs.getString(2) );
              al.add(te);
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return al;
    }

    public ArrayList getSources(){
        ArrayList al=new ArrayList();
        String QUERY = "SELECT * FROM source";
        try{
            ResultSet rs = con.createStatement().executeQuery(QUERY);
            while(rs.next()){
              TableElement te = new TableElement();
              te.setElementId( rs.getShort(2) );
              te.setDescription( rs.getString(3) );
              al.add(te);
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return al;
    }

    public ArrayList getSpecialRates(int hotelId){
        ArrayList al=new ArrayList();
        String QUERY = "SELECT * FROM rate WHERE nHotelId = " + hotelId;
        try {
            ResultSet rs = con.createStatement().executeQuery(QUERY);
            while( rs.next() ) {
                TableElement te = new TableElement();
                te.setElementId( rs.getShort(2) );
                te.setDescription( rs.getString(3) );
                al.add(te);
            }
        } catch (Exception e) { e.printStackTrace(); }
        return al;
    }

    /** Devuelve un "ArrayList" con los tipos de documentos
    * que puede tener una persona.
    * Nacional: DNI, Carnet FF.AA. FF.PP, etc.
    * Extranjero: Pasaporte, Carnet de Extranjeria, Cedula de Identidad, etc.
    */
    public ArrayList getDocumentTypes(){
        ArrayList al=new ArrayList();
        String QUERY = "SELECT * FROM table_item WHERE tableId = 1";
        try{
            ResultSet rs = con.createStatement().executeQuery(QUERY);
            while(rs.next()){
              DocumentType dt = new DocumentType();
              dt.setDocumentType( rs.getShort("itemId") );
              dt.setDescription( rs.getString("itemDescription") );
              al.add(dt);
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return al;
    }

    public ArrayList getRoomtypeRates(){
        ArrayList list = new ArrayList();
        String QUERY = "SELECT * FROM rate";
        try{
            ResultSet rs = con.createStatement().executeQuery(QUERY);
            while( rs.next() ) {
              TableElement te = new TableElement();
              te.setElementId( rs.getShort("nRateId") );
              te.setDescription( rs.getString("tDescription") );
              list.add(te);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

    /**
     * Devuelve los campos que pueden ser utilizados para busqueda
     * de reservas.
     * @return Devuelve un arreglo cargado con items disponibles.
     */
    public ArrayList getQryReservFields(){
        ArrayList al=new ArrayList();
        String QUERY = "SELECT * FROM table_item WHERE tableId = 2 ";
        try{
            ResultSet rs = con.createStatement().executeQuery(QUERY);
            while(rs.next()){
              TableItem i = new TableItem();
              i.setTableId( rs.getShort(1) );
              i.setItemId( rs.getShort(2) );
              i.setItemDescription( rs.getString(3) );
              i.setItemStatus( rs.getBoolean(4) );
              al.add(i);
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return al;
    }

}