/*
 * CHello.java
 *
 */

package com.mycom.booking.tagslib;

import java.io.*;
import java.sql.*;
import java.util.ArrayList;
import java.util.Iterator;

import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;

import com.mycom.booking.beans.Reservation;
import com.mycom.booking.beans.SearchBean;
import com.mycom.booking.controllers.ReservationCtlr;
import com.mycom.booking.dispatchers.ConProvider;
import com.mycom.booking.dispatchers.ReservationDisp;
import com.mycom.booking.libraries.DateManager;


public class ReservationList extends TagSupport {
    
	private static final long serialVersionUID = 1L;
	private short  field;
    private String pattern;

    public int doStartTag() throws JspException {
        Reservation res = new Reservation();
        ReservationCtlr rctlr = new ReservationCtlr();

        Iterator<Reservation> list =
        	rctlr.getReportByPattern(1, pattern).iterator();
        
        String trclass = null;
        //String hrefValue = null;

        JspWriter out = this.pageContext.getOut();

        try {
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
                /*hrefValue = "ReservationServlet?show=show&hotelId=" + res.getHotelId() +
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
