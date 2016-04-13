/*
 * CHello.java
 *
 */

package com.myco.central.tagslib;

import java.io.*;

import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;

public class CHello extends TagSupport {
    
    public int doStartTag() throws JspException {
        try {
            JspWriter out = this.pageContext.getOut();
            out.println("<H1>Bienvenido Mundo</H1>");
        } catch(IOException e) { throw new JspException( e.toString() ); }
        return SKIP_BODY;
    }
    
    public int doEndTag() {
        return EVAL_PAGE;
    }
    
}
