
<%@ page contentType="text/html" %>

<%@ page import="java.sql.*, java.util.*" %>
<%@ page import="beans.Company" %>
<%@ page import="beans.CustomerQuery" %>
<%@ page import="libraries.DateManager" %>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 //EN"
          "http://www.w3.org/TR/html4/strict.dtd">

<HTML>
<HEAD>
  <META http-equiv="Expires=-1" content="text/html; charset=iso-8859-1">
  <META http-equiv="Content-Style-Type" content="text/css">
  <LINK rel='stylesheet' type='text/css' href="css/stylesheet.css">
  <TITLE>Busqueda de Clientes</title>
<SCRIPT type='text/javascript' languaje='JavaScript'>
<!--
function loadDocument(){
    window.focus();
    document.frmsearch.pattern.select();
}

function sendForm(){
    document.frmsearch.show.click();
}

function getCustomer(customerDoc,customerName) {
   //alert(companyId);
   window.opener.frmrec.customerDoc.value = customerDoc;
   window.opener.frmrec.customerName.value = customerName;
   //window.opener.frmrec.show.click();
   window.opener.focus();
   window.close();
}

function changeWindowFocus() {
   window.opener.focus();
   window.close();
}
// -->
</SCRIPT>
</HEAD>

<jsp:useBean id="qry" class="beans.CustomerQuery" scope="request" />

<%  String field = "", pattern = "", selected = "";
    if ( session.getAttribute("cqry") != null ) {
        qry = (CustomerQuery)session.getAttribute("cqry");
        field = qry.getField();
        pattern = qry.getPattern();
    }

    ArrayList lcia=null;
    if ( session.getAttribute("clist") != null )
        lcia = (ArrayList)session.getAttribute("clist");

    String[][] patterns = { {"customerName","Nombre Cliente"},
                            {"customerDoc","N&uacute;mero de Documento"} };      
%>

<BODY onload='loadDocument()'>
    <FORM method='post' name='frmsearch' action="CustomerSearchServlet" >
    <TABLE>
        <CAPTION class='Form'>Company Search</CAPTION>
        <TR><TD><INPUT type='hidden' name='hotel' value='1'>
                <SELECT name='field' class='Large' id='field'>
<%              for ( int i=0; i < patterns.length; i++) {
                    selected = ( field.equals(patterns[i][0]) ) ? "selected" : "";
%>
                    <OPTION value='<%=  patterns[i][0] %>' <%= selected %>><%= patterns[i][1] %> </OPTION>
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

<TABLE width='520' rules="groups">
    <COLGROUP>
        <COL class='Medium Center'>
    <COLGROUP>
        <COL class='XLarge'>
    <THEAD>
        <TR class='Header'>
            <TH>Id. Cliente
            <TH>Descripci&oacute;n
    <TBODY>
<%        if ( lcia != null ) {
                Company c = new Company();
                String paramValues = c.getEntityId() + "," + c.getEntityName();
                String trClass = null;
                for (int i=0; i < lcia.size(); i++) {
                    c = (Company)lcia.get(i);
                    trClass = ( i % 2 == 0 ) ? "class='Distinct'" : "";
%>
        <TR <%= trClass %> >
            <TD><A href='javascript:changeWindowFocus()'><%= c.getEntityId() %></A>
            <TD><%= c.getEntityName() %>
<%              }
          } %>
</TABLE>
</BODY>
<!-- Example about correct way for open a secondary window (popup)
<A href="pop.html" target="ventana"
 onclick="pop(this.src,this.target,'scrollbars=yes'); return false;">
 Abrir Ventana
</A>
-->

</HTML>