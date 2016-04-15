
package dispatchers;

import java.io.*;
import java.sql.*;
import java.util.*;

public class ConnectionPool implements Runnable {
    private String driver, url, username, password;
    private int maxConnections;
    private boolean waitIfBusy;
    private Vector availableConnections, busyConnections;
    private boolean connectionPending = false;

    public ConnectionPool() throws SQLException {
    	//ResourceBundle res = ResourceBundle.getBundle("accounting");
        this.driver = "com.mysql.jdbc.Driver";
        this.url = "jdbc:mysql:///shop?user=root";
        /*this.username = (String)res.getObject("user");
        this.password = (String)res.getObject("password");
        this.maxConnections = Integer.parseInt((String)res.getObject("connections"));*/
        this.maxConnections = 10;
        this.waitIfBusy = true;
        //int initialConnections = Integer.parseInt((String)res.getObject("ini_conns"));
        int initialConnections = 5;
        if (initialConnections > maxConnections) {
            initialConnections = maxConnections;
        }
        availableConnections = new Vector(initialConnections);
        busyConnections = new Vector();
        for(int i=0; i<initialConnections; i++) {
            availableConnections.addElement(makeNewConnection());
        }
    }
  
    public synchronized Connection getConnection() throws SQLException {
        if (!availableConnections.isEmpty()) {
            Connection existingConnection =(Connection)availableConnections.lastElement();
            int lastIndex = availableConnections.size() - 1;
            availableConnections.removeElementAt(lastIndex);
            System.out.println("Con tomada "+lastIndex+" ");
            if (existingConnection.isClosed()) {
                notifyAll(); // Freed up a spot for anybody waiting
                return(getConnection());
            } 
            else {
                busyConnections.addElement(existingConnection);
                System.out.println("Se esta entregando : "+existingConnection);
                return(existingConnection);
            }
        }
        else {
            if ((totalConnections() < maxConnections) &&!connectionPending) {
                System.out.println("Se creara una conexion en BG");
                makeBackgroundConnection();
            }
            else 
                if (!waitIfBusy) {
                    throw new SQLException("Connection limit reached");
                }
            try {
                wait();
            } 
            catch(InterruptedException ie) {}
            return(getConnection());
        }
    }

  
    private void makeBackgroundConnection() {
        connectionPending = true;
        try {
            Thread connectThread = new Thread(this);
            connectThread.start();
        }
        catch(OutOfMemoryError oome) {}
    }

    public void run() {
        try {
            Connection connection = makeNewConnection();
            synchronized(this) {
                availableConnections.addElement(connection);
                connectionPending = false;
                notifyAll();
            }
        } 
        catch(Exception e) {}
    }
  
    private Connection makeNewConnection() throws SQLException {
        try {
            Class.forName(driver).newInstance();
            //Connection connection = DriverManager.getConnection(url, username, password);
            Connection connection = DriverManager.getConnection(url);
            return(connection);
        }
        catch(Exception cnfe) {
//            throw new SQLException("Can't find class for driver: " + driver);
            System.out.println("ERROR "+cnfe.getMessage());
            try{
            	PrintStream ps = new PrintStream(new BufferedOutputStream(new FileOutputStream("logsPool.txt"))); 
            	ps.println("ERROR : "+cnfe.getMessage());
             	cnfe.printStackTrace(ps);
            	ps.close();
            }
            catch (Exception e){}
        }
        return null;
    }

    public synchronized void free(Connection connection) {
        if(busyConnections.removeElement(connection)){
             availableConnections.addElement(connection);
             System.out.println("****Se esta liberando la conexion "+connection);
        }
        else
            System.out.println("*-*-*-*-*-No encontro a la conexion dentro de los busyConnection ");
        notifyAll(); 
    }

    public synchronized int totalConnections() {
        return(availableConnections.size() +
        busyConnections.size());
    }

    public synchronized void closeAllConnections() {
        closeConnections(availableConnections);
        availableConnections = new Vector();
        closeConnections(busyConnections);
        busyConnections = new Vector();
    }

    private void closeConnections(Vector connections) {
        try {
            for(int i=0; i<connections.size(); i++) {
                Connection connection =(Connection)connections.elementAt(i);
                if (!connection.isClosed()) {
                    connection.close();
                }
            }
        } catch(SQLException sqle) {}
    }

    public synchronized String toString() {
        String info =  "ConnectionPool(" + url + "," + username + ")" +
            ", available=" + availableConnections.size() +
            ", busy=" + busyConnections.size() +
            ", max=" + maxConnections;
        return(info);
    }
}
