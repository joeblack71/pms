/*
 * CHello.java
 *
 */

package com.myco.central.tagslib;

import java.io.IOException;

import javax.servlet.http.HttpSession;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.TagSupport;

public class AvailabilityChart extends TagSupport {
    
    private String[][] matrix = {{}};

    public int doStartTag() throws JspException {
        HttpSession session = pageContext.getSession();
        
        if ( matrix != null ) {
            int columns = matrix[0].length;
            try {
                JspWriter out = this.pageContext.getOut();

                /* PINTA CABECERAS */
                String header;
                out.println("<THEAD><TR>" + "<TH>Room Type<BR>");
                for ( int i=1; i < columns - 1; i++ ) {
                    header = "<TH>" +
                             "<A href='javascript:openDetail(\"" +
                             matrix[0][i] +"\")'>" + matrix[0][i] + "</A>";
                    out.println(header);
                }
                out.println("<TH align='center'>Period Total");
                
                /* COMPLETA EL CUERPO DEL CUADRO */
                out.println("<TBODY align='right'>" + "<TR><TD>&nbsp;" +
                            "<TD colspan='" + (columns - 2) + "'>&nbsp;<TD>&nbsp;");

                for ( int i=1; i < matrix.length - 1; i++ ) {
                    out.println("<TR><TH>" + matrix[i][0]);
                    for ( int j=1; j < columns; j++ ) {
                        out.println("<TD>" + matrix[i][j]);
                    }
                }
                out.println("<TR><TD>&nbsp;<TD colspan='" + (columns - 2) +"'>&nbsp;<TD>&nbsp;");
                
                /* PINTA TOTALES AL PIE DE PAGINA */
                out.println("<TFOOT><TR class='Footer'>" + "<TD>Total Rooms");
                for ( int i=1; i < columns; i++ )
                    out.println("<TD>" + matrix[matrix.length - 1][i] );
                
            } catch(IOException e) { throw new JspException( e.toString() ); }
        } else System.out.println("Matrix es null");
        return SKIP_BODY;
    }
    
    public int doEndTag() {
        return EVAL_PAGE;
    }

    public void setMatrix(String[][] matrix) {
        this.matrix = matrix;
    }

}
