/*
 * CHello.java
 *
 */

package com.mycom.booking.tagslib;

import java.io.*;
import java.sql.*;
import java.util.ArrayList;

import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;

import com.mycom.booking.beans.TableItem;
import com.mycom.booking.dispatchers.ConProvider;
import com.mycom.booking.dispatchers.ModTableDisp;


public class HTMLSelect extends TagSupport {
    
    private String matter;
    private String selectedItem;

    public int doStartTag() throws JspException {
        Connection con = ConProvider.getConnection();
        ModTableDisp mdisp = new ModTableDisp();
        mdisp.setConnection(con);

        ArrayList list = new ArrayList();
        if ( matter.equals("DocumentTypes") )
            list = mdisp.getDocumentTypes();
        if ( matter.equals("QueryReservation") )
            list = mdisp.getQryReservFields();

        TableItem item = new TableItem();
        String option, selected;
        try {
            JspWriter out = this.pageContext.getOut();
            out.println("<SELECT name='sampleField' class='Large'>");
            for ( int i=0,j=1; i < list.size(); i++,j++ ) {
                item = (TableItem)list.get(i);
                selected = ( String.valueOf(item.getItemId()).equals(selectedItem) )
                                           ? "selected": "";
                option = "<OPTION value='" + item.getItemId() + "'" + selected + ">" +
                            item.getItemDescription() + "</OPTION>";
                out.println(option);
            }
        } catch(IOException e) { throw new JspException( e.toString() ); }
        return SKIP_BODY;
    }
    
    public int doEndTag() {
        return EVAL_PAGE;
    }

    public void setMatter(String table) {
        this.matter = table;
    }

    public void setSelectedItem(String selectedItem) {
        this.selectedItem = selectedItem;
    }

}
