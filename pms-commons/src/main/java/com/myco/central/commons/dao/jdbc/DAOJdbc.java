package com.myco.central.commons.dao.jdbc;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.myco.central.commons.exceptions.DaoException;

public final class DAOJdbc {
	private static final Logger logger = LoggerFactory.getLogger(DAOJdbc.class);

	private static DataSource dataSource = null;
	
	private DAOJdbc() {}

	public static void setDataSource(DataSource ds) {
		dataSource = ds;
	}
	
	public static DataSource setupDataSource() throws DaoException {
		DataSource dataSource = null;

		String resourceName = "jdbc/hotel";

		try {
			Context initContext = new InitialContext();
			Context envContext  = (Context)initContext.lookup("java:/comp/env");
			dataSource = (DataSource)envContext.lookup(resourceName);
		} catch(NamingException e) {
			logger.info("", e);
			throw new DaoException(
				"Cannot locate data source at " + resourceName + "\n" + e, e );
		}

		return dataSource;
	}

	public static Connection getConnection() throws DaoException, SQLException {
		if ( dataSource == null ) {
			dataSource = setupDataSource();
		}
		return dataSource.getConnection();
	}

	public static void closeSQLObjects(ResultSet rs, Statement stmt, Connection conn) {
		if ( rs != null ) {
			try {
				rs.close();
			} catch(SQLException e) {
				logger.info("", e);
			}
		}
		if ( stmt != null ) {
			try {
				stmt.close();
			} catch(SQLException e) {
				logger.info("", e);
			}
		}
		if ( conn != null ) {
			try {
				conn.close();
			} catch(SQLException e) {
				logger.info("", e);
			}
		}
	}
}
