
package com.myco.central.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.myco.central.vo.City;
import com.myco.central.vo.Country;
import com.myco.central.vo.DocumentType;
import com.myco.central.vo.ModuleContext;
import com.myco.central.vo.PaymentType;
import com.myco.central.vo.ReservationStatus;
import com.myco.central.vo.SpecialRate;
import com.myco.central.vo.TableElement;
import com.myco.central.vo.TableItem;

public class ModuleContextDAO {

	private ModuleContext mc;
	
    public ModuleContextDAO() {
    }

	public void setMc(ModuleContext mc) {
		this.mc = mc;
	}

    //TODO extraer closeSQLObjects() a una "super" clase

    /**
     * Carga las listas que son comunues a todos los usuarios
     * @param mc
     * @throws Exception
     */
    public void chargeGenericListModule()
    throws Exception {
    	Connection conn = null;
		try {
			conn = ConProvider.getConnection();
			mc.setCityList( chargeCities(conn) );
			mc.setCountryList( chargeCountries(conn) );
			mc.setDocumentTypeList( chargeDocumentTypes(conn) );
			mc.setPaymentTypeList( chargePaymentTypes(conn) );
			mc.setReservationStatusList( chargeReservationStatus(conn) );
			//mc.getRoomTypeList( chargeRoomTypeList(conn) );
			//mc.setSegmentList( chargeSegments(conn) );
			//mc.setSourceList( chargeSources(conn) );
			//mc.setSpecialRateList( chargeSpecialRates(conn) );
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception();
		} finally {
        	closeSQLObjects(null, null, conn);
		}
    }
    
    public List<ReservationStatus> chargeReservationStatus(Connection conn) 
    throws SQLException {
        ResultSet rs = null;

        ReservationStatus rstt = null;
        List<ReservationStatus> list = new ArrayList<ReservationStatus>();
        
        String sql = "SELECT * FROM reservation_status";
        
        try {
            rs = conn.createStatement().executeQuery(sql);
            while( rs.next() ){
                rstt = new ReservationStatus();
                rstt.setStatus( rs.getString(1) );
                rstt.setDescription( rs.getString(2) );
                list.add(rstt);
            }
        } finally {
        	closeSQLObjects(rs, null, null);
        }

        return list;
    }

    public List<PaymentType> chargePaymentTypes(Connection conn)
    throws SQLException {
        List<PaymentType> list = new ArrayList<PaymentType>();
        ResultSet rs = null;
        String sql = "SELECT * FROM hotel_account";

        try{
            rs = conn.createStatement().executeQuery(sql);
            while( rs.next() ) {
              PaymentType item = new PaymentType();
              item.setPaymentType( rs.getShort(2) );
              item.setDescription( rs.getString(4) );
              list.add(item);
            }
        } finally {
        	closeSQLObjects(rs, null, null);
        }

        return list;
    }

    public List<Country> chargeCountries(Connection conn)
    throws Exception {
        ResultSet rs = null;

        ArrayList<Country> list = new ArrayList<Country>();
        String QUERY = "SELECT * FROM country";
        try{
            rs = conn.createStatement().executeQuery(QUERY);
            while( rs.next() ){
              Country c = new Country();
              c.setCountryId( rs.getShort(1) );
              c.setCountryName( rs.getString(2) );
              c.setAbbreviation( rs.getString(3) );
              c.setNationality( rs.getString(4) );
              list.add(c);
            }
        } finally {
        	closeSQLObjects(rs, null, null);
        }

        return list;
    }

    public List<City> chargeCities(Connection conn)
    throws Exception {
        ResultSet rs = null;

        ArrayList<City> al=new ArrayList<City>();
        String QUERY = "SELECT * FROM city";
        try{
            rs = conn.createStatement().executeQuery(QUERY);
            while(rs.next()){
              City c = new City();
              c.setCityId( rs.getString(2) );
              c.setCityDescription( rs.getString(3) );
              al.add(c);
            }
        } finally {
        	closeSQLObjects(rs, null, null);
        }
        return al;
    }

    public List<TableElement> chargeSegments(Connection conn)
    throws Exception {
        ResultSet rs = null;
    	TableElement e = null;

        ArrayList<TableElement> al=new ArrayList<TableElement>();
        String QUERY = "SELECT * FROM segment";
        try{
            rs = conn.createStatement().executeQuery(QUERY);
            while(rs.next()){
            	e = new TableElement();
            	e.setElementId( rs.getShort(1) );
	            e.setDescription( rs.getString(2) );
	            al.add(e);
            }
        } finally {
        	closeSQLObjects(rs, null, null);
        }
        return al;
    }

    public List<TableElement> chargeSources(Connection conn)
    throws Exception {
        ResultSet rs = null;

        ArrayList<TableElement> al=new ArrayList<TableElement>();
        String QUERY = "SELECT * FROM source";
        try{
            rs = conn.createStatement().executeQuery(QUERY);
            while(rs.next()){
              TableElement te = new TableElement();
              te.setElementId( rs.getShort(2) );
              te.setDescription( rs.getString(3) );
              al.add(te);
            }
        } finally {
        	closeSQLObjects(rs, null, null);
        }
        return al;
    }

    public List<SpecialRate> chargeSpecialRates(Connection conn, int hotelId)
    throws Exception {
        ResultSet rs = null;
        SpecialRate sr = null;

        ArrayList<SpecialRate> al = new ArrayList<SpecialRate>();
        String QUERY = "SELECT * FROM rate WHERE nHotelId = " + hotelId;
        try {
            rs = conn.createStatement().executeQuery(QUERY);
            while( rs.next() ) {
                sr = new SpecialRate();
                sr.setRateId( rs.getShort(2) );
                sr.setRateDescription( rs.getString(3) );
                al.add(sr);
            }
        } finally {
        	closeSQLObjects(rs, null, null);
        }
        return al;
    }

    /** Devuelve un "ArrayList" con los tipos de documentos
    * que puede tener una persona.
    * Nacional: DNI, Carnet FF.AA. FF.PP, etc.
    * Extranjero: Pasaporte, Carnet de Extranjeria, Cedula de Identidad, etc.
    */
    public List<DocumentType> chargeDocumentTypes(Connection conn)
    throws Exception {
        ResultSet rs = null;

        ArrayList<DocumentType> al=new ArrayList<DocumentType>();
        String QUERY = "SELECT * FROM table_item WHERE tableId = 1";
        try{
            rs = conn.createStatement().executeQuery(QUERY);
            while(rs.next()){
              DocumentType dt = new DocumentType();
              dt.setDocumentType( rs.getShort("itemId") );
              dt.setDescription( rs.getString("itemDescription") );
              al.add(dt);
            }
        } finally {
        	closeSQLObjects(rs, null, null);
        }
        return al;
    }

    /**
     * Devuelve los campos que pueden ser utilizados para busqueda
     * de reservas.
     * @return Devuelve un arreglo cargado con items disponibles.
     */
    public List<TableItem> getQryReservFields(Connection conn)
    throws Exception {
    	ResultSet rs = null;
    	
        ArrayList<TableItem> al=new ArrayList<TableItem>();
        String QUERY = "SELECT * FROM table_item WHERE tableId = 2 ";
        try{
            rs = conn.createStatement().executeQuery(QUERY);
            while(rs.next()){
              TableItem i = new TableItem();
              i.setTableId( rs.getShort(1) );
              i.setItemId( rs.getShort(2) );
              i.setItemDescription( rs.getString(3) );
              i.setItemStatus( rs.getBoolean(4) );
              al.add(i);
            }
        } finally {
        	closeSQLObjects(rs, null, null);
        }
        
        return al;
    }

    private void closeSQLObjects(ResultSet rs, Statement stmt, Connection conn) {
		if ( conn != null ) {
			try {
				conn.close();
			} catch(Exception e) {}
		}
    }

}