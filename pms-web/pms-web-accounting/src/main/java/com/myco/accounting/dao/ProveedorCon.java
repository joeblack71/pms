package dispatchers;

import java.sql.*;

public class ProveedorCon {

    private String driver;
    private String usuario;
    private String clave;
    private String puerto;
    private String host;
    private String instancia;

    public ProveedorCon() {
    }
    
    public String getDriver() {
        return driver;
    }
    public void setDriver(String driver) {
        this.driver = driver;
    }
    
    public String getUsuario() {
        return usuario;
    }
    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }
    
    public String getClave() {
        return clave;
    }
    public void setClave(String clave) {
        this.clave = clave;
    }
    
    public String getPuerto() {
        return puerto;
    }
    public void setPuerto(String puerto) {
        this.puerto = puerto;
    }
    
    public String getHost() {
        return host;
    }
    public void setHost(String host) {
        this.host = host;
    }
    
    public String getInstancia() {
        return instancia;
    }
    public void setInstancia(String instancia) {
        this.instancia = instancia;
    }

    public static Connection getCon(){
        Connection c=null;
        try{
            /** SQL
            Class.forName("com.inet.tds.TdsDriver");
            String url = "jdbc:inetdae:inst209:1433?database=prueba";
            c = DriverManager.getConnection(url,"sa","");
            */
            /** ACCESS
            Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
            String url = "jdbc:odbc:laborat";
            c = DriverManager.getConnection(url,"sa","");
            */
            //** MYSQL
            Class.forName("com.mysql.jdbc.Driver");
            //jdbc:mysql://localhost/test?user=monty&password=greatsqldb
            //String url = "jdbc:mysql://10.10.10.10/hoteles";
            String url = "jdbc:mysql://localhost/hotel";
            c = DriverManager.getConnection(url, "root", "");
        }
        catch (Exception e){
            e.printStackTrace();
        }
        return c;
    }
    
}