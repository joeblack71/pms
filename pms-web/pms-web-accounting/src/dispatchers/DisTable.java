
package dispatchers;

import java.sql.*;
import java.util.ArrayList;

import beans.*;

public class DisTable {

    private Connection con=null;

    public DisTable() {
    }

    public Connection getConnection() {
        return con;
    }
    public void setConnection(Connection con) {
        this.con = con;
    }

    public ArrayList chargeResStatus(){
        ArrayList al=new ArrayList();
        String QUERY = "SELECT * FROM res_status";
        try{
            ResultSet rs = con.createStatement().executeQuery(QUERY);
            while(rs.next()){
              ResStatus st = new ResStatus();
              st.setStatus(rs.getString(1));
              st.setDescription(rs.getString(2));
              al.add(st);
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return al;
    }

}