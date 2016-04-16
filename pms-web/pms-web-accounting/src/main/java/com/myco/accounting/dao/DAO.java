package com.myco.stay.dao;

import java.sql.*;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

public final class DAO {

	private static DataSource dataSource = null;
	
	private DAO() {
		// nothing
	}

	public static void setDataSource(DataSource ds) {
		dataSource = ds;
	}
	
	public static DataSource setupDataSource()
		throws Exception {
		DataSource dataSource = null;

		String resourceName = "jdbc/hotel";

		try {
			Context initContext = new InitialContext();
			Context envContext  = (Context)initContext.lookup("java:/comp/env");
			dataSource = (DataSource)envContext.lookup(resourceName);
		} catch(NamingException e) {
			throw new DAOException(
				"Cannot locate data source at " + resourceName + "\n" + e, e );
		}

		return dataSource;
	}

	public static Connection getConnection()
	throws DAOException, SQLException, Exception {
		if ( dataSource == null ) {
			dataSource = setupDataSource();
		}
		return dataSource.getConnection();
	}

	public static void closeSQLObjects(ResultSet rs,
			Statement stmt, Connection conn) {
	  if ( rs != null ) {
		  try {
			  rs.close();
		  } catch(Exception e) {}
	  }
	  if ( stmt != null ) {
		  try {
			  stmt.close();
		  } catch(Exception e) {}
	  }
	  if ( conn != null ) {
		  try {
			  conn.close();
		  } catch(Exception e) {}
	  }
	}


}
