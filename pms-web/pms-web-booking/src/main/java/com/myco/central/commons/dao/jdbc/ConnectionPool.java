
package com.myco.central.commons.dao.jdbc;

import java.io.*;
import java.sql.*;
import java.util.*;

public class ConnectionPool implements Runnable {
    private String driver, url, username;
    private int maxConnections;
    private boolean waitIfBusy;
    private Vector<Connection> availableConnections, busyConnections;
    private boolean connectionPending = false;

    public ConnectionPool() throws SQLException {
        // review how do function ResourceBundle
    	ResourceBundle res = ResourceBundle.getBundle("guestbooking");
        this.driver = "com.mysql.jdbc.Driver";
        this.url = "jdbc:mysql:///hotel?user=root";
        this.username = (String)res.getObject("root");
//        this.password = (String)res.getObject("");
        //this.maxConnections = Integer.parseInt((String)res.getObject("conexiones"));
        this.maxConnections = 20; // only for testing
        this.waitIfBusy = true;
        //int initialConnections = Integer.parseInt((String)res.getObject("conexiones"));
        int initialConnections = 10; // only for testing
        if (initialConnections > maxConnections) {
            initialConnections = maxConnections;
        }
        availableConnections = new Vector<Connection>(initialConnections);
        busyConnections = new Vector<Connection>();
        for(int i=0; i<initialConnections; i++) {
            availableConnections.addElement(makeNewConnection());
        }
    }

    public synchronized Connection getConnection() throws SQLException {
        if (!availableConnections.isEmpty()) {
            Connection existingConnection =
                       (Connection)availableConnections.lastElement();
            int lastIndex = availableConnections.size() - 1;
            availableConnections.removeElementAt(lastIndex);
            System.out.println("Connection was taken" + lastIndex + " ");
            if (existingConnection.isClosed()) {
                notifyAll(); // Freed up a spot for anybody waiting
                return(getConnection());
            } else {
                busyConnections.addElement(existingConnection);
                System.out.println("Giving connection: " + existingConnection);
                return(existingConnection);
            }
        } else {
            if ((totalConnections() < maxConnections) && !connectionPending) {
                System.out.println("A Background connection will be created ");
                makeBackgroundConnection();
            } else {
                if (!waitIfBusy) {
                    throw new SQLException("Connection limit reached");
                }
            }
            try {
                wait();
            } catch(InterruptedException ie) {}
            return(getConnection());
        }
    }

    private void makeBackgroundConnection() {
        connectionPending = true;
        try {
            Thread connectThread = new Thread(this);
            connectThread.start();
        } catch(OutOfMemoryError oome) {}
    }

    public void run() {
        try {
            Connection connection = makeNewConnection();
            synchronized(this) {
                availableConnections.addElement(connection);
                connectionPending = false;
                notifyAll();
            }
        } catch(Exception e) {}
    }

    private Connection makeNewConnection() throws SQLException {
        try {
            Class.forName(driver).newInstance();
            //Connection connection = DriverManager.getConnection(url, username, password);
            Connection connection = DriverManager.getConnection(url);
            return(connection);
        } catch(Exception cnfe) {
            //throw new SQLException("Can't find class for driver: " + driver);
            System.out.println("ERROR "+cnfe.getMessage());
            try{
                FileOutputStream fos = new FileOutputStream("logsPool.txt");
            	PrintStream ps = new PrintStream(new BufferedOutputStream(fos));
            	ps.println("ERROR : "+cnfe.getMessage());
             	cnfe.printStackTrace(ps);
            	ps.close();
            } catch (Exception e){}
        }
        return null;
    }

    public synchronized void free(Connection connection) {
        if(busyConnections.removeElement(connection)){
             availableConnections.addElement(connection);
             System.out.println("Connection is being freed "+connection);
        }
        else
            System.out.println("Connection not founded inside of the busyConnection ");
        notifyAll();
    }

    public synchronized int totalConnections() {
        return(availableConnections.size() +
        busyConnections.size());
    }

    public synchronized void closeAllConnections() {
        closeConnections(availableConnections);
        availableConnections = new Vector<Connection>();
        closeConnections(busyConnections);
        busyConnections = new Vector<Connection>();
    }

    private void closeConnections(Vector<Connection> connections) {
        try {
            for(int i=0; i<connections.size(); i++) {
                Connection connection =(Connection)connections.elementAt(i);
                if (!connection.isClosed()) {
                    connection.close();
                }
            }
        } catch(SQLException sqle) {}
    }

    @Override
	public synchronized String toString() {
        String info =  "ConnectionPool(" + url + "," + username + ")" +
            ", available=" + availableConnections.size() +
            ", busy=" + busyConnections.size() +
            ", max=" + maxConnections;
        return(info);
    }
}
