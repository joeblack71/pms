/*
 * CHello.java
 *
 */

package com.myco.central.tagslib;

import java.io.IOException;
import java.util.Iterator;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.TagSupport;

import com.myco.central.dao.ReservationDAO;
import com.myco.central.util.DateManager;
import com.myco.central.vo.Reservation;

public class ReservationList extends TagSupport {
    
    private short  field;
    private String pattern;

    public int doStartTag() throws JspException {
        /*Connection con = ConProvider.getConnection();
        ReservationDao rdisp = new ReservationDao();
        rdisp.setConnection(con);

        ArrayList list = new ArrayList();
        switch (field) {
            case 1: list = rdisp.chargeByLastName("1", pattern); break;
            case 2: list = rdisp.chargeByArrival("1", pattern); break;
            case 3: list = rdisp.chargeByDeparture("1", pattern); break;
            case 4: list = rdisp.chargeByCreationDate("1", pattern); break;
            //case 5: list = rdisp.chargeByLastName("1", pattern); break;
        }*/
        ReservationDAO rctlr = new ReservationDAO();
        Iterator list = rctlr.getReportByPattern(field, pattern).iterator();
        
        Reservation res = new Reservation();
        try {
            String trclass, hrefValue;
            JspWriter out = this.pageContext.getOut();
            /*for ( int i=0,j=1; i < list.size(); i++,j++ ) {
                res = (Reservation)list.get(i);*/
            short counter = 1;
            while ( list.hasNext() ) {
                res = (Reservation)list.next();
                trclass = ( counter++ % 2 == 0 ) ? "<TR class='Distinct'>" : "<TR>";
                out.println(trclass);
                out.println("<TD><A href='javascript:getReservation(" +
                            res.getReservation() + ")'>" + 
                            res.getReservation() + "</A>" );
                // TODO: Debe volver a la pantalla desde donde fue llamada
                /*hrefValue = "ReservationDispatchAction?show=show&hotelId=" + res.getHotelId() +
                                              "&reservation=" + res.getReservation();
                out.println("<TD>" + "<A href='" + hrefValue + "'" +
                            " onClick='window.close()' target='javascript:window.opener'>" +
                            res.getReservation() + "</A>");*/
                out.println("<TD>" + res.getLastname1() + ", " + res.getFirstname() );
                out.println("<TD>" + DateManager.sqlDateToString( res.getArrival() ) );
                out.println("<TD>" + DateManager.sqlDateToString( res.getDeparture() ) );
                out.println("<TD>" + res.getStatus() );
            }
        } catch(IOException e) { throw new JspException( e.toString() ); }
        return SKIP_BODY;
    }
    
    public int doEndTag() {
        return EVAL_PAGE;
    }

    public void setField(short fieldId) {
        this.field = fieldId;
    }

    public void setPattern(String pattern) {
        this.pattern = pattern;
    }
    
}
