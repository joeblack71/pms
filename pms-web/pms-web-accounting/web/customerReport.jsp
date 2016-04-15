
<%@ page contentType="text/html" %>
<%@ page import="java.sql.*" %>
<%@ page import="beans.*" %>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 //EN"
          "http://www.w3.org/TR/html4/strict.dtd">

<HTML>
<HEAD>
  <META http-equiv="Expires=-1" content="text/html; charset=iso-8859-1">
  <META http-equiv="Content-Style-Type" content="text/css">
  <LINK rel='stylesheet' type='text/css' href="css/stylesheet.css">
  <TITLE>Customer Report</TITLE>
</HEAD>

<SCRIPT language='JavaScript'>
<!--
function loadDocument(){
    document.frmFilter.pattern.select();
}

function openDetail(URL){
   //alert(URL);
   var appereance = "status=yes,resizable=yes,toolbar=yes,scrollbars=yes";
   window.open(URL,"detalle",appereance);
}
//-->
</SCRIPT>

<jsp:useBean id='cqry' class="beans.CustomerQuery" />

<%  String customerType = "";
    if ( session.getAttribute("cqry") != null ) {
        cqry = (CustomerQuery)session.getAttribute("cqry");
        customerType = cqry.getCustomerType();
    }
    String checked = null;
 %>

<BODY onload='loadDocument()'>
<FORM method='post' name='frmFilter' action="CustomerReportServlet">
    <TABLE width='740' border='1' rules='groups' cellspacing='0' cellpadding='4'>
        <CAPTION class='Form'>Customer Report</CAPTION>
        <COLGROUP>
        <TR><TD><INPUT type='hidden' name='hotel' value='1'>
                <SELECT name='hotel'
                        class='Large' id='hotel' disabled>
                  <OPTGROUP label="Unidad Hotelera">
                    <OPTION value='1'>Apart Hotel El Doral</OPTION>
                  </OPTGROUP>
                </SELECT>
                <LABEL for='company'>Empresa</LABEL>
<%              checked = ( customerType.equals("C") ||
                            customerType.equals("") ) ? "checked" : ""; %>
                <INPUT type='radio' name='customerType' value='C'
                       class='NoBorder' id='company' <%= checked %> >
                <LABEL for='person'>Persona</LABEL>
<%              checked = ( customerType.equals("P") ) ? "checked" : ""; %>
                <INPUT type='radio' name='customerType' value='P'
                       class='NoBorder' id='person' <%=  checked %> >
                <INPUT type='text' name='pattern'  value='<%= cqry.getPattern() %>'
                       class='Large' id='pattern'
                       style='height: 16px; padding: 0px 4px'
                       title='Patron de busqueda'>
                <INPUT type='submit' name='show'
                       class='Button Large'
                       value="Show Information">
    </TABLE>
</FORM>

<TABLE width='900' rules='groups' cellspacing='0'>
    <!--<CAPTION class='Form' align='left'>Consulta por Cliente</CAPTION>-->
    <COLGROUP>
        <COL class='Medium' align='center'>
        <COL class='XLarge'>
        <COL class='Medium' align='center'>
        <COL class='XLarge'>

    <THEAD><TR><TH>RUC<TH>Nombres / Razon social<TH>Telefonos<TH>Direccion

    <!--<TFOOT>
        <TR><TD colspan='4'>&nbsp;-->

    <TBODY class='Report'>
<%  java.util.ArrayList customerList = null;
    if ( session.getAttribute("clist") != null )
        customerList = (java.util.ArrayList)session.getAttribute("clist");

    if ( customerList != null && customerList.size() > 0) {
        Company cust = new Company(); // Todo: usar Custamer class
        String hotel=null, customerId=null, customerName=null, address=null, phone=null,
               firstname=null, lastname1=null, lastname2=null;
        String reference = null, trclass=null;
        for ( int i=0, j=1; i < customerList.size(); i++,j++ ) {
            cust = (Company)customerList.get(i);
            hotel        = String.valueOf( cust.getHotelId() );
            customerId   = cust.getEntityDoc();
            customerName = cust.getEntityName();
            address      = cust.getAddress1();
            phone        = cust.getPhone1();
            /* reference = "javascript:openDetail('ReceiptQueryServlet?hotel=" +
                hotel + "&customer=" + customerId + "&description=" + description +"')"; */
            trclass = ( j % 2 == 0 ) ? "Distinct" : ""; %>
        <TR class='<%= trclass %>'>
            <TD><%= customerId %>
            <TD><A href="javascript:openDetail('ReceiptQueryServlet?hotel=<%= hotel %>&customer=<%= customerId %>&customerName=<%= customerName %>')">
                <%= customerName %></A>
            <TD><%= phone %>
            <TD><%= address %>
<%      } %>
        <TR class='Total'><TD colspan='4'>&nbsp;
<%  } else { %>
        <TR><TD colspan='4'>&nbsp;
        <TR><TD colspan='4' style='color: red'>No existen Clientes que coincidan con criterio ingresado.
        <TR><TD colspan='4'>&nbsp;
<%  } %>
</TABLE>
</BODY>
</HTML>
