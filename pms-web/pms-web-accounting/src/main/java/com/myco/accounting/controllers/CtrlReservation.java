
package controllers;

import java.sql.*;

import beans.Reservation;
import dispatchers.DisReservation;
import dispatchers.ProveedorCon;

public class CtrlReservation {

    /** Creates new CtrlReservation */
    public CtrlReservation() {}

    public static boolean validate(Reservation r){
        Connection c = ProveedorCon.getCon();
        DisReservation dr = new DisReservation();
        dr.setConnection(c);
        dr.setReservation(r);
        boolean flag = dr.validate();
        try{
        	c.close();
        }catch (Exception e){}
        return flag;
    }

    public static boolean insert(Reservation r){
        Connection c = ProveedorCon.getCon();
        DisReservation dr = new DisReservation();
        dr.setConnection(c);
        dr.setReservation(r);
        boolean flag = dr.insert();
        try{
        	c.close();
        }catch (Exception e){}
        return flag;
    }

    public static boolean update(Reservation r){
        Connection c = ProveedorCon.getCon();
        DisReservation dr = new DisReservation();
        dr.setConnection(c);
        dr.setReservation(r);
        boolean flag = dr.update();
        try{
        	c.close();
        }catch (Exception e){}
        return flag;
    }

    public static boolean delete(Reservation r){
        Connection c = ProveedorCon.getCon();
        DisReservation dr = new DisReservation();
        dr.setConnection(c);
        dr.setReservation(r);
        boolean flag = dr.delete();
        try{
        	c.close();
        }catch (Exception e){}
        return flag;
    }
}
