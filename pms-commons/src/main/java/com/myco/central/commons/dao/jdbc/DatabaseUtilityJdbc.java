package com.myco.central.commons.dao.jdbc;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class DatabaseUtilityJdbc {
	
	static Logger log = LoggerFactory.getLogger(DatabaseUtilityJdbc.class);

	public static void close(PreparedStatement pstm) {
	    if (pstm == null) return;
	    try { pstm.close(); }
	    catch(SQLException e) {
	    	//LogManager.getLogger().logWarning("Prepared statement close error", e);
			log.info("Prepared statement close error", e);
	    }
	}

	public static void close(Statement stmt) {
	    if (stmt == null) return;
	    try  { stmt.close(); }
	    catch (SQLException e) {
	    	log.info("Statement close error", e);
	    }
	}

	public static void close(ResultSet rs) {
	    if (rs == null) return;
	    try { rs.close(); }
	    catch (SQLException e) {
			log.info("ResultSet close error", e);
	    }
	}

    public static void close(Object dbObj) {
		if (dbObj == null) return;
		
		if (dbObj instanceof PreparedStatement) close( (PreparedStatement) dbObj);
		else if (dbObj instanceof Statement) close( (Statement) dbObj);
		else if (dbObj instanceof ResultSet) close( (ResultSet) dbObj);
		else if (dbObj instanceof CallableStatement) close( (CallableStatement)
		 dbObj);
		else if (dbObj instanceof Connection) close( dbObj);
		else throw new IllegalArgumentException(
				"Close attempted on unrecognized Database Object!");
	}
}