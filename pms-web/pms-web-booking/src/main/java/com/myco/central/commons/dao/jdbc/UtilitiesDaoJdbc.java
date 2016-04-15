
package com.myco.central.commons.dao.jdbc;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.myco.central.commons.dao.UtilitiesDao;

public class UtilitiesDaoJdbc implements UtilitiesDao {
	Log log = LogFactory.getLog(UtilitiesDaoJdbc.class);

    public UtilitiesDaoJdbc() {
    }

    /* (non-Javadoc)
	 * @see com.myco.central.bussiness.reservations.dao.jdbc.UtilitiesDao#searchselect(java.lang.String, java.lang.String)
	 */
    public List<Map<String, Object>> searchselect(String idModule, String idTable)
    throws Exception {

    	Connection conn = ConProvider.getConnection(); 
		CallableStatement cstm = null;
		ResultSet rs = null;

		Map<String, Object> item = null;
		List<Map<String, Object>> items = new ArrayList<Map<String, Object>>();
		String sql = "{ call CMSP_TABLE_ITEM_select(?,?); }";
		short k = 1;
		
        try {
			cstm = conn.prepareCall(sql);

			cstm.setString(k++, idModule);
			cstm.setString(k++, idTable);

			rs = cstm.executeQuery();
			if( rs.next() ) {
				item = new HashMap<String, Object>();  
			    item.put("value", rs.getString("idItem") );
			    item.put("label", rs.getString("description") );
			    items.add(item);
			}
		} catch (SQLException e) {
			e.printStackTrace();
			throw new Exception();
		} finally {
			DAO.closeSQLObjects(rs, cstm, conn);
		}
        
        return items;
    }

    /* (non-Javadoc)
	 * @see com.myco.central.bussiness.reservations.dao.jdbc.UtilitiesDao#insert(org.apache.commons.beanutils.Map<String, Object>)
	 */
    public void insert(Map<String, Object> item) throws Exception {
    	Connection conn = ConProvider.getConnection(); 
        PreparedStatement ps = null;

        String sql = "INSERT INTO table_item(" +
        				" nIdTable, nIdItem, tItemDescription)" +
				        " VALUES(?,?,?);";
        short k = 1;

        try {
            ps = conn.prepareStatement(sql);
            ps.setString(k++, (String)item.get("idTable") );
            ps.setString(k++, (String)item.get("idItem") );
            ps.setString(k++, (String)item.get("description") );
            ps.executeUpdate();
        } catch (Exception e) {
        	e.printStackTrace();
        	throw new Exception();
        } finally {
        	DAO.closeSQLObjects(null, null, conn);
        }
        
    }

    /* (non-Javadoc)
	 * @see com.myco.central.bussiness.reservations.dao.jdbc.UtilitiesDao#update(org.apache.commons.beanutils.Map<String, Object>)
	 */
    public void update(Map<String, Object> item) throws Exception {
    	Connection conn = ConProvider.getConnection(); 
        PreparedStatement ps = null;

        String sql = "UPDATE table_item SET" +
						" tItemDescription = ?, tStatus = ?" +
				        " WHERE nIdTable = ? AND nIdItem = ?;";
        short k = 1;

        try {
            ps = conn.prepareStatement(sql);
            ps.setString(k++, (String)item.get("description") );
            ps.setString(k++, (String)item.get("status") );
            ps.setString(k++, (String)item.get("idTable") );
            ps.setString(k++, (String)item.get("idItem") );
            ps.executeUpdate();
        } catch (Exception e) {
        	e.printStackTrace();
        	throw new Exception();
        } finally {
        	DAO.closeSQLObjects(null, null, conn);
        }
        
    }

    /* (non-Javadoc)
	 * @see com.myco.central.bussiness.reservations.dao.jdbc.UtilitiesDao#delete(org.apache.commons.beanutils.Map<String, Object>)
	 */
    public void delete(Map<String, Object> item) throws Exception {
    	Connection conn = ConProvider.getConnection(); 
        PreparedStatement ps = null;

        String sql = "DELETE FROM table_item" +
        			 " WHERE nIdTable = ? AND nIdItem = ?";

        try {
            ps = conn.prepareStatement(sql);
            ps.setString(1, (String)item.get("idTable") );
            ps.setString(2, (String)item.get("idItem") );
            ps.executeUpdate();
        } catch (Exception e) {
        	e.printStackTrace();
        	e.printStackTrace();
        	throw new Exception();
        } finally {
        	DAO.closeSQLObjects(null, null, conn);
        }

    }

    //TODO: move to an specific class
    /* (non-Javadoc)
	 * @see com.myco.central.bussiness.reservations.dao.jdbc.UtilitiesDao#getRateselect()
	 */
    public List<Map<String, Object>> getRateselect() throws Exception {
    	Connection conn = DAO.getConnection();
    	Statement stmt = null;
    	ResultSet rs = null;
    	
    	List<Map<String, Object>> list = new ArrayList<Map<String, Object>>();
    	Map<String, Object> item = null;

    	final String SQL = "SELECT nIdSpecialRate,"
    					 +       " tDescription,"
    					 +       " tStatus"
    					 + "  FROM hotel.special_rate"
    					 + " WHERE nIdHotel = 1"; // TODO parametrized hotel id.
    	
    	try {
    		rs = conn.createStatement().executeQuery(SQL);
    		
    		while( rs.next() ) {
    			item = new HashMap<String, Object>();
    			
    			item.put("value", rs.getString(1));
    			item.put("label", rs.getString(2));
    			
    			list.add(item);
    		}
    	} catch(Exception e) {
    		e.printStackTrace();
    		throw new Exception();
    	} finally {
    		DAO.closeSQLObjects(rs, stmt, conn);
    	}
    	
    	return list;
    }

    /* (non-Javadoc)
	 * @see com.myco.central.bussiness.reservations.dao.jdbc.UtilitiesDao#getCreditAccountselect(java.lang.String, java.lang.String, java.lang.String)
	 */
    public List<Map<String, Object>> getCreditAccountselect(String idHotel,
    		String accountType, String status)
    throws Exception {
    	Connection conn = ConProvider.getConnection();
    	PreparedStatement pstm = null;
    	ResultSet rs = null;
    	
    	List<Map<String, Object>> list = new ArrayList<Map<String, Object>>();
    	Map<String, Object> item = null;
    	
    	final String SQL = "SELECT nIdAccount, nAccountNumber,"
    					 + "       tAccountType, tDescription, tStatus"
    					 + "  FROM hotel_account"
    					 + " WHERE nIdHotel = ?"
    					 + "   AND tAccountType = ?"
    					 + "   AND tStatus like ?";
    	short k = 1;
    	
    	try {
    		pstm = conn.prepareStatement(SQL);
    		
    		pstm.setString(k++, idHotel);
    		pstm.setString(k++, accountType);
    		pstm.setString(k++, status + '%');

    		log.info("pstm:"+pstm);
    		rs = pstm.executeQuery();
    		while( rs.next() ) {
    			item = new HashMap<String, Object>();
    			
    			item.put("idAccount", rs.getString(1) );
    			item.put("accountNumber", rs.getString(2) );
    			item.put("accountType", rs.getString(3) );
    			item.put("description", rs.getString(4) );

				list.add(item);
    		}
    	} catch(Exception e) {
			e.printStackTrace();
			//throw new Exception();
    	} finally {
			DAO.closeSQLObjects(rs, pstm, conn);
    	}

    	//log.info("list.size:"+list.size());
    	return list;
    }

    /* (non-Javadoc)
	 * @see com.myco.central.bussiness.reservations.dao.jdbc.UtilitiesDao#getCheckTypeselect()
	 */
    public List<Map<String, Object>> getCheckTypeselect() {
    	List<Map<String, Object>> list = new ArrayList<Map<String, Object>>();
    	Map<String, Object> item = null;
    	
    	item = new HashMap<String, Object>();
    	item.put("label","Vale");
    	item.put("value","1");
    	list.add(item);
    	
    	item = new HashMap<String, Object>();
    	item.put("label","Comanda");
    	item.put("value","2");
    	list.add(item);
    	
    	return list;
    }

}