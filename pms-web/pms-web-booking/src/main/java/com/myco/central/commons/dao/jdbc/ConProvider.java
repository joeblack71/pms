package com.myco.central.commons.dao.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConProvider {

	private static final String MYSQL_CONN_DRIVER = "com.mysql.jdbc.Driver";
    private static final String MYSQL_DATABASE_URL = "jdbc:mysql://localhost/hotel";

//	private static final String SQL_CONN_DRIVER = "com.inet.tds.TdsDriver";
//  private static final String SQL_DATABASE_URL = "jdbc:inetdae:localhost:1433?database=hotel";

    private String driver;
    private String user;
    private String password;
    private String port;
    private String host;
    private String instance;

    public ConProvider() {
    }
    
    public String getDriver() {
        return driver;
    }
    public void setDriver(String _driver) {
        this.driver = _driver;
    }
    
    public String getUser() {
        return user;
    }
    public void setUser(String _user) {
        this.user = _user;
    }
    
    public String getPassword() {
        return password;
    }
    public void setPassword(String _password) {
        this.password = _password;
    }
    
    public String getPort() {
        return port;
    }
    public void setPort(String _port) {
        this.port = _port;
    }
    
    public String getHost() {
        return host;
    }
    public void setHost(String host) {
        this.host = host;
    }
    
    public String getInstance() {
        return instance;
    }
    public void setInstance(String _instance) {
        this.instance = _instance;
    }

    public static Connection getConnection() {
        Connection conn = null;

        /*
        try { // SQL Server
            Class.forName(SQL_CONN_DRIVER);
            String url = SQL_DATABASE_URL;
            c = DriverManager.getConnection(url,"sa","");
        } catch (Exception e) { e.printStackTrace(); }
         */
        
        try { // MySQL
            Class.forName(MYSQL_CONN_DRIVER);
            String url = MYSQL_DATABASE_URL;
            conn = DriverManager.getConnection(url, "root", "root");
        } catch (Exception e) { e.printStackTrace(); }
        
        return conn;
    }
    
}