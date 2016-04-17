package com.myco.central.commons.dao.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.myco.central.commons.exceptions.DaoException;

public class ConProvider {

	private static final Logger logger = LoggerFactory.getLogger(ConProvider.class);

	private static final String MYSQL_CONN_DRIVER = "com.mysql.jdbc.Driver";
	private static final String MYSQL_DATABASE_URL = "jdbc:mysql://localhost/hotel";

	private static final String SQL_CONN_DRIVER = "com.inet.tds.TdsDriver";
	private static final String SQL_DATABASE_URL = "jdbc:inetdae:localhost:1433?database=hotel";

	private ConProvider() {}

	public static Connection getMySqlConnection() throws DaoException {
		Connection conn = null;
		try {
			Class.forName(MYSQL_CONN_DRIVER);
			String url = MYSQL_DATABASE_URL;
			conn = DriverManager.getConnection(url, "root", "root");
		} catch (SQLException | ClassNotFoundException e) {
			logger.error("", e);
			throw new DaoException();
		} finally {
			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {
					logger.error("", e);
				}
			}
		}

		return conn;
	}

	public static Connection getSqlServerConnection() throws DaoException {
		Connection conn = null;
		try {
			Class.forName(SQL_CONN_DRIVER);
			String url = SQL_DATABASE_URL;
			conn = DriverManager.getConnection(url, "sa", "");
		} catch (SQLException | ClassNotFoundException e) {
			logger.error("", e);
			throw new DaoException();
		} finally {
			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {
					logger.error("", e);
				}
			}
		}

		return conn;
	}

}