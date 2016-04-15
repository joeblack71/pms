
<%@ page contentType="text/html" %>

<%@ page import="java.sql.*, java.util.*" %>
<%@ page import="beans.*,dispatchers.*" %>
<%@ page import="libraries.DateManager" %>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 //EN"
          "http://www.w3.org/TR/html4/strict.dtd">
<HTML>
<HEAD>
  <TITLE>Receipt by Customer</TITLE>
  <META http-equiv="Expires=-1" content="text/html; charset=iso-8859-1">
  <LINK rel='stylesheet' type='text/css' href='css/stylesheet.css'>
</HEAD>

<SCRIPT language='JavaScript'>
<!--
function loadDocument(){
    window.focus();
}
// -->
</SCRIPT>

<BODY onLoad='loadDocument()'>
    <H3 style='color: steelblue'>
        <%= request.getParameter("customer") + " - " +request.getParameter("customerName") %>
<BR><BR>

<TABLE width='740' rules="groups" border='1' cellspacing='1' cellpadding='2'>
    <COLGROUP align='center'>
        <COL class='Tiny' span='2'>
    <COLGROUP align='center'>
        <COL class='Medium'>
        <COL class='Tiny'>
        <COL class='Medium'>
    <COLGROUP align='right'>
        <COL class='Medium' span='5'>
    <COLGROUP>
        <COL class='Small' align='right'>
        <COL class='Tiny' align='center'>
    
    <THEAD>
        <TR style='background: steelblue; color:white'>
            <TH>#
            <TH>Hotel
            <TH>Fecha
            <TH>Tipo
            <TH>Documento <!-- Serie - Correlative -->
            <TH align='center'>Afecto
            <TH align='center'>Exento
            <TH align='center'>IGV
            <TH align='center'>Serv.
            <TH align='center'>Total
            <TH align='center'>T/C
            <TH>Est.

    <TBODY>
<%  java.util.ArrayList receiptList = null;
    if ( session.getAttribute("rlist") != null )
        receiptList = (java.util.ArrayList)session.getAttribute("rlist");

    double totAfect=0, totExempt=0, totTax1=0, totTax2=0, totSale=0;
    java.text.DecimalFormat df = new java.text.DecimalFormat("#,###,##0.00");

    if ( receiptList != null && receiptList.size() != 0) {
        Receipt r = new Receipt();
        String trclass = null;
        for ( int i=0,j=1; i < receiptList.size(); i++,j++ ) {
            r = (Receipt)receiptList.get(i);
            double receiptAfect=0, receiptExempt=0;
            if ( !r.isExempt() )
                 receiptAfect  = r.getNet();
            else receiptExempt = r.getNet();
            trclass = ( j % 2 == 0 ) ? "Distinct" : "";
 %>
        <TR class='<%= trclass %>'>
            <TD><%= j %>
            <TD><%= r.getHotelId() %>
            <TD><%= DateManager.formatDate( r.getIssueDate() ) %>
            <TD><%= r.getReceiptType() %>
            <TD><%= r.getReceiptSerial() + "-" + r.getCorrelative() %>
            <TD><%= df.format(receiptAfect) %>
            <TD><%= df.format(receiptExempt) %>
            <TD><%= df.format( r.getTax1() ) %>
            <TD><%= df.format( r.getService() ) %>
            <TD><%= df.format( r.getReceiptTotal() ) %>
            <TD><%= df.format( r.getExchange() ) %>
<%      //String money = (r.getMoney().equals("S") ? "S/." : "US$"; %>
            <%-- <TD><%= money %> --%>
            <TD><%= r.getStatus() %>
<%          if ( !r.isExempt() )
                 totAfect  = totAfect  + r.getNet();
            else totExempt = totExempt + r.getNet();
            totTax1 = totTax1 + r.getTax1();
            totTax2 = totTax2 + r.getService();
            totSale = totSale + r.getReceiptTotal();
        }
 %>
        <TR style='background: steelblue; color:white'>
            <TH colspan='4' >&nbsp;
            <TH align='center'>Totales
            <TH><%= df.format(totAfect) %>
            <TH><%= df.format(totExempt) %>
            <TH><%= df.format(totTax1) %>
            <TH><%= df.format(totTax2) %>
            <TH><%= df.format(totSale) %>
            <TH colspan='2'>&nbsp;
<%  } else { %>
        <TR><TH colspan='12'>&nbsp;
        <TR class='Distinct'>
            <TH colspan='12'><B>No hay informacion registrada !!
<%  } %>
</TABLE>
</BODY>
</HTML>