/*
 * CHello.java
 *
 */

package com.myco.central.tagslib;

import java.io.IOException;
import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.TagSupport;

import com.myco.central.dao.ConProvider;
import com.myco.central.dao.ModuleContextDAO;
import com.myco.central.vo.DocumentType;
import com.myco.central.vo.TableItem;

public class HTMLSelect extends TagSupport {
    
	private static final long serialVersionUID = 1L;

	private String matter;
    private String selectedItem;

    public int doStartTag() throws JspException {
        Connection conn = ConProvider.getConnection();
        ModuleContextDAO dao = new ModuleContextDAO();

        List<TableItem> list = null;
        //TODO modify return type of chargeDocumentTypes
        /*if ( matter.equals("DocumentTypes") )
            list = dao.chargeDocumentTypes(conn);*/
        //TODO add method on context Dao.
        /*if ( matter.equals("QueryReservation") )
            list = dao.chargeReservationFields(conn);*/

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
