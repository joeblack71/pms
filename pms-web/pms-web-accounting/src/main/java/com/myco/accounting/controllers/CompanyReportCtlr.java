
package controllers;

import java.sql.*;
import java.util.ArrayList;

import beans.*;
import dispatchers.*;

public class CompanyReportCtlr {

    /** Creates new CompanyReportCtlr */
    public CompanyReportCtlr() {
    }

    public static ArrayList getCompanyPattern(CustomerQuery cqry) {
        Connection con = ConProvider.getConnection();
        CompanyReportDisp crd = new CompanyReportDisp();
        crd.setConnection(con);
        crd.setCustomerQuery(cqry);
        ArrayList lcia = crd.getCompanyPattern();
        try {
            con.close();
        } catch (Exception e) {}
        return lcia;
    }

}
