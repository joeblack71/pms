
package controllers;

import java.sql.*;
import java.util.ArrayList;

import beans.*;
import dispatchers.*;

public class EntityCtlr {

    private static String request = null;
    private static String tableName = null;

    /** Creates new EntityCtlr */
    public EntityCtlr() {
    }

    /** Creates new EntityCtlr */
    public EntityCtlr(String _tableName) {
        this.tableName = _tableName;
    }

    public String getRequest() {
        return request;
    }
    public void setRequest(String _req) {
        this.request = _req;
    }

    public static boolean executeRequest(Company c) {
        Connection con = ConProvider.getConnection();
        CompanyDisp cd = new CompanyDisp();
        cd.setConnection(con);
        //cd.setTableName(tableName);
        cd.setCompany(c);
        String[] operation = {"validate","insert","update","delete"};

        boolean flag = false;
        if ( request.equals(operation[0]) )
            flag = cd.validate();
        if ( request.equals(operation[1]) )
            flag = cd.insert();
        if ( request.equals(operation[2]) )
            flag = cd.update();
        if ( request.equals(operation[3]) )
            flag = cd.delete();

        try { con.close();
        } catch (Exception e){}

        return flag;
    }

    public static boolean executeRequest(Provider p){
        Connection con = ConProvider.getConnection();
        ProviderDisp pd = new ProviderDisp();
        pd.setConnection(con);
        //pd.setTableName(tableName);
        pd.setProvider(p);

        String[] operation = {"validate","insert","update","delete"};
        //System.out.println(request);
        boolean flag = false;
        if ( request.equals(operation[0]) )
            flag = pd.validate();
        if ( request.equals(operation[1]) )
            flag = pd.insert();
        if ( request.equals(operation[2]) )
            flag = pd.update();
        if ( request.equals(operation[3]) )
            flag = pd.delete();

        try { con.close();
        } catch (Exception e){}

        return flag;
    }

    /*
    public static boolean validate(Company c){
        Connection con = ConProvider.getConnection();
        CompanyDisp cd = new CompanyDisp();
        cd.setConnection(con);
        cd.setCompany(c);
        boolean flag = cd.validate();
        try {
            con.close();
        } catch (Exception e) {}
        return flag;
    }

    public static boolean insert(Company c){
        Connection con = ConProvider.getConnection();
        CompanyDisp cd = new CompanyDisp();
        cd.setConnection(con);
        cd.setCompany(c);
        boolean flag = cd.insert();
        try {
            con.close();
        } catch (Exception e) {}
        return flag;
    }

    public static boolean update(Company c){
        Connection con = ConProvider.getConnection();
        CompanyDisp cd = new CompanyDisp();
        cd.setConnection(con);
        cd.setCompany(c);
        boolean flag = cd.update();
        try {
            con.close();
        } catch (Exception e) {}
        return flag;
    }

    public static boolean delete(Company c){
        Connection con = ConProvider.getConnection();
        CompanyDisp cd = new CompanyDisp();
        cd.setConnection(con);
        cd.setCompany(c);
        boolean flag = cd.delete();
        try {
            con.close();
        } catch (Exception e) {}
        return flag;
    }
    */
}
