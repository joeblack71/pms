package com.myco.central.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConProvider {

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
        Connection c=null;

        /*
        try { // SQL Server
            Class.forName("com.inet.tds.TdsDriver");
            String url = "jdbc:inetdae:inst209:1433?database=prueba";
            c = DriverManager.getConnection(url,"sa","");
        } catch (Exception e) { e.printStackTrace(); }
         */
        
        /*
        try { // ACCESS
            Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
            String url = "jdbc:odbc:laborat";
            c = DriverManager.getConnection(url,"sa","");
        } catch (Exception e) { e.printStackTrace(); }
         */
        
        
        try { // MySQL
            Class.forName("com.mysql.jdbc.Driver");
            String url = "jdbc:mysql://localhost/hotel";
            c = DriverManager.getConnection(url, "root", "");
        } catch (Exception e) { e.printStackTrace(); }
        
        return c;
    }
    
    public static Connection getAuthConnection() {
        Connection c=null;

        /*
        try { // SQL Server
            Class.forName("com.inet.tds.TdsDriver");
            String url = "jdbc:inetdae:inst209:1433?database=prueba";
            c = DriverManager.getConnection(url,"sa","");
        } catch (Exception e) { e.printStackTrace(); }
         */
        
        /*
        try { // ACCESS
            Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
            String url = "jdbc:odbc:laborat";
            c = DriverManager.getConnection(url,"sa","");
        } catch (Exception e) { e.printStackTrace(); }
         */
        
        
        try { // MySQL
            Class.forName("com.mysql.jdbc.Driver");
            String url = "jdbc:mysql://localhost/security";
            c = DriverManager.getConnection(url, "root", "");
        } catch (Exception e) { e.printStackTrace(); }
        
        return c;
    }
    
}