
<%@ page contentType="text/html" %>

<%@ page import="java.sql.*, java.util.*" %>
<%@ page import="beans.*, dispatchers.*" %>
<%@ page import="libraries.DateManager" %>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 //EN"
          "http://www.w3.org/TR/html4/strict.dtd">

<HTML>
<HEAD>
  <META http-equiv="Expires=-1" content="text/html; charset=iso-8859-1">
  <META http-equiv="Content-Style-Type" content="text/css">
  <LINK rel='stylesheet' type='text/css' href="css/stylesheet.css">
  <TITLE>Busqueda de Comprobantes</title>
<SCRIPT type='text/javascript' languaje='JavaScript'>
<!--
function loadDocument(){
    window.focus();
    document.frmsearch.pattern.select();
}

function sendForm(){
    document.frmsearch.show.click();
}

function getReceipt(receiptType,receiptSerial,correlative) {
   //window.opener.frmrec.receiptType.value = receiptType;
   window.opener.frmrec.receiptSerial.value = receiptSerial;
   window.opener.frmrec.correlative.value = correlative;
   window.opener.frmrec.show.click();
   window.opener.focus();
   window.close();
   //window.opener.testing(correlative);
}
function changeWindowFocus() {
   //window.opener.focus();
   window.close();
}
// -->
</SCRIPT>
</HEAD>
<jsp:useBean id="rqry" class="beans.ReceiptQuery" scope="request" />

<%  String field = "", pattern = "", selected = null;
    if ( session.getAttribute("rqry") != null ) {
        rqry = (ReceiptQuery)session.getAttribute("rqry");
        field = rqry.getField();
        if ( field.equals("issueDate") || field.equals("paymentDate") )
            pattern = DateManager.formatDate( rqry.getQueryDate() );
        if ( field.equals("customerName") )
            pattern = rqry.getCustomerName();
        if ( field.equals("customerDoc") )
            pattern = rqry.getCustomerDoc();
    }
    
    String[][] patterns = { {"issueDate","Fecha Emisi&oacute;n"},
                            {"paymentDate","Fecha Cancelaci&oacute;n"},
                            {"customerName","Nombre Cliente"},
                            {"customerDoc","N&uacute;mero de Documento"} };
 %>

<BODY onload='loadDocument()'>
    <FORM method='post' name='frmsearch' action="ReceiptSearchServlet" >
    <TABLE>
        <CAPTION class='Form'>Receipt Search</CAPTION>
        <TR><TD><!--<LABEL for='hotel'>Hotel</LABEL>-->
                <INPUT type='hidden' name='hotel' value='1'>
                <SELECT name='field' class='Large' id='field'>
<%              for ( int i=0,j=0; i < patterns.length; i++) {
                    selected = ( field.equals(patterns[i][0]) ) ? "selected" : "";
 %>
                    <OPTION value='<%= patterns[i][0] %>' <%= selected %>><%= patterns[i][1] %> </OPTION>
<%              } %>                    
                </SELECT>
                <INPUT type='text' name='pattern'
                       value='<%= pattern %>'
                       class='Large'
                       title='Valor del patr&oacute;n seleccionado'>
                <INPUT type='submit' name='show'
                       class='LargeButton' value='Show'>
        <TR><TD><LABEL><SPAN style='color: red'>*</SPAN>
                    Seleccione el 'patr&oacute;n' de b&uacute;squeda y luego ingrese un valor para el mismo
                </LABEL>
    </TABLE>
</FORM>

<TABLE width='620' rules="groups">
    <COLGROUP>
        <COL class='Medium Center'>
    <COLGROUP>
        <COL class='Small Center' span='2'>
        <COL class='Medium Center'>
        <COL class='XLarge'>

    <THEAD>
        <TR class='Header'>
            <TH>Emision
            <TH>Tipo
            <TH>Serie
            <TH>Correlativo
            <TH>Cliente

    <TBODY>
<%  ArrayList lrec = null;
    if ( session.getAttribute("lrec") != null ) {
        lrec = (ArrayList)session.getAttribute("lrec");
        Receipt r = new Receipt();
        String trclass = null, paramValues = null;
        for ( int i=0,j=1; i < lrec.size(); i++,j++ ) {
            r = (Receipt)lrec.get(i);
            paramValues = "ReceiptServlet?hotel='1'&" +
                         "receiptType='"   + r.getReceiptType()   + "'&" +
                         "receiptSerial='" + r.getReceiptSerial() + "'&" +
                         "correlative='"   + r.getCorrelative()   + "'";
            //System.out.println(paramValues);                   
            trclass = ( j % 2 == 0 ) ? "Distinct" : ""; %>
        <TR class='<%= trclass %>'>
            <TD><%= DateManager.formatDate( r.getIssueDate() ) %>
            <TD><%= r.getReceiptType() %>
            <TD><%= r.getReceiptSerial() %>
            <!--<TD><A href='javascript:getReceipt(<%--<%= r.getReceiptType() %>,<%= r.getReceiptSerial() %>,<%= r.getCorrelative() %>)--%>'>-->
            <TD><A href="<%= paramValues %>" onClick='changeWindowFocus()' readonly>
                    <%= r.getCorrelative() %>
                </A>
            <TD><%= r.getEntityName() %>
<%          }
        } else { %>
       <TR><TD colspan='5' style='color: red'>No existen registros con criterio ingresado !
<%      } %>
</TABLE>
</BODY>

<!-- Example about correct way for open a secondary window (popup)
<A href="pop.html" target="ventana"
   onclick="pop(this.src,this.target,'scrollbars=yes'); return false;">
 Abrir Ventana
</A>
-->

</HTML>