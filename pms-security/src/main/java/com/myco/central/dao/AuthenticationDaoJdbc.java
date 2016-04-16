package com.myco.central.dao;


import java.sql.Connection;
import java.sql.ResultSet;
import java.util.List;

import com.myco.central.model.Option;
import com.myco.central.model.User;

public class AuthenticationDaoJdbc implements IAuthenticationDao {
	
//	Log log = LogFactory.getLog(AuthenticationDaoJdbc.class);
	
	public AuthenticationDaoJdbc() {}

	public boolean authenticateUser(User user) {
        Connection conn = ConProvider.getConnection();
        ResultSet rs = null;
        
        final String sql =  "  SELECT idUser, lastname, firstname, status"
		        			+ "  FROM user"
				        	+ " WHERE idHotel = '" + user.getIdHotel()
				        	+  "' AND login = '" + user.getLogin()
				        	+  "' AND password = '" + user.getPassword() + "'";
        short k = 1;
        boolean result = false;

        //log.info(sql);

        try {
            rs = conn.createStatement().executeQuery(sql);
            if ( rs.next() ) {
                user.setId( rs.getString(k++) );
                user.setFirstname( rs.getString(k++) );
                user.setLastname( rs.getString(k++) );
                user.setDepartment( rs.getString(k++) );

                result = true;
            }
        } catch (Exception e) {
            e.printStackTrace();
        } /*finally {
       	    DAO.closeSQLObjects(rs, null, conn);
        }*/
        
        return result;
	}

	/**
	 * TODO: Implement
	 */
	public List<Option> getUserOptions(String user) {
		return null;
	}

}
