
package dispatchers;

import java.sql.*;

public class ConProvider {

    private String host;
    private String port;
    private String driver;
    private String user;
    private String password;
    private String instance;

    public ConProvider() {
    }

    public String getHost() {
        return host;
    }
    public void setHost(String host) {
        this.host = host;
    }

    public String getPort() {
        return port;
    }
    public void setPort(String port) {
        this.port = port;
    }

    public String getDriver() {
        return driver;
    }
    public void setDriver(String driver) {
        this.driver = driver;
    }

    public String getUser() {
        return user;
    }
    public void setUser(String user) {
        this.user = user;
    }
    
    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }
    
    public String getInstance() {
        return instance;
    }
    public void setInstance(String instance) {
        this.instance = instance;
    }

    /** Retrieves a database connection. 
     */
    public static Connection getConnection() {
        Connection c = null;
        String engine   = "MySQL",
               host     = "localhost",
               //host     = "192.168.0.69:3306",
               //port     = "3306",
               database = "/mycompany",
               driver   = "com.mysql.jdbc.Driver",
               user     = "root",
               password = "",
               //password = "doral97",
               url      = "jdbc:mysql://" + host + database;
        
        if ( engine.equals("SQL Server") ) { // Derrama Magisterial
            host = "10.10.10.145:1433";
            driver = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
            //url    = "jdbc:sqlserver://10.10.10.145:1433;databaseName=DERRAMA;user=conta;password=conta;";
            url    = "jdbc:sqlserver://" + host + ";databaseName=" + database;
            user   = "conta";
            password = "conta";
        }
            
        try {
            Class.forName(driver);
            c = DriverManager.getConnection(url, user, password);
        } catch (Exception e) { e.getMessage(); }
        
        return c;
    }

}