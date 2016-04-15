
<%@ page contentType="text/html" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ page import="java.sql.*,java.util.*" %>
<%@ page import="beans.*, dispatchers.*, libraries.*" %>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 //EN"
          "http://www.w3.org/TR/html4/strict.dtd">

<HTML>
<HEAD>
  <META http-equiv="Expires=-1" content="text/html; charset=iso-8859-1">
  <META http-equiv="Content-Style-Type" content="text/css">
  <LINK rel='stylesheet' type='text/css' href="css/stylesheet.css">
  <TITLE>Customer Production</title>
</HEAD>

<SCRIPT language='JavaScript'>
<!--
function loadDocument(){
    //document.frmFilter.hotel.focus();
}
function openDetail(URL){
    //alert(URL);
    var appearance = "status=yes,resizable=yes,toolbar=yes,scrollbars=yes";
    window.open(URL,"cust_receipt",appearance)
}
// -->
</SCRIPT>

<jsp:useBean id='recqry' class="beans.ReceiptQuery" scope='request' />

<%  session.setAttribute("option","customerProduction.jsp"); %>

<BODY onload='loadDocument()'>
<FORM method='post' name='frmFilter' action="ReceiptReportServlet">
  <TABLE width='800' border='1' rules='groups' cellspacing='0' cellpadding='4'>
    <CAPTION class='Form'>Customer Production</CAPTION>
    <COLGROUP><COL><COL><COL>
    <TR><TD><INPUT type='hidden' name='hotel' value='1'>
            <SELECT name='hotel' id='hotel' disabled>
                <OPTION value='1'>Unidad Hotelera</OPTION>
            </SELECT>

        <TD><LABEL for='period'>Periodo</LABEL>
            <SELECT name='period' class='Medium'>
                    <c:forEach var='p' items='${period}'>
                        <c:set var='selected' value='' />
                        <c:if test="${ recqry.period eq p }" >
                            <c:set var='selected' value='SELECTED' />
                        </c:if>
                <OPTION value='${p}' ${selected}>${p}</OPTION>
                    </c:forEach>
            </SELECT>
            <SELECT name='month' class='Medium'>
                <OPTION value='0'>--</OPTION>
                    <c:forEach var='m' items='${months}' varStatus="n">
                        <c:set var='selected' value='' />
                        <c:if test="${ recqry.month eq n.count }" >
                            <c:set var='selected' value='SELECTED' />
                        </c:if>
                <OPTION value='${n.count}' ${selected}>${m}</OPTION>
                    </c:forEach>
            </SELECT>
            <SELECT name='month_day' class='Small'>
                <OPTION value='0'>--</OPTION>
                    <c:forEach var='d' items='${m_days}'>
                        <c:set var='selected' value='' />
                        <c:if test="${ recqry.monthDay eq d }" >
                            <c:set var='selected' value='SELECTED' />
                        </c:if>
                <OPTION value='${d}' ${selected}>${d}</OPTION>
                    </c:forEach>
            </SELECT>

        <TD><LABEL for='period'>Produccion</LABEL>
            <SELECT name='production' class='Medium'>
                    <c:forEach var='t' items='${totals}'>
                        <c:set var='selected' value='' />
                        <c:if test="${ recqry.production eq t }" >
                            <c:set var='selected' value='SELECTED' />
                        </c:if>
                <OPTION value='${t}' ${selected}>&nbsp;&gt;&nbsp;${t}</OPTION>
                    </c:forEach>
            </SELECT>
        <TD align='center'>
            <INPUT type='submit' name='show'
                   class='Button Large' style='padding: 0px 0px'
                   value="Show Information" align='center'>
                   <!--margin: 2px;-->

  </TABLE>
</FORM>

<TABLE width='800' rules='groups' cellspacing='0'>
    <!--<CAPTION class='Form' align='left'>Producci&oacute;n por Cliente</CAPTION>-->
    <COLGROUP class='Small' align='center'>
    <COLGROUP>    
        <COL class='Medium Center'>
        <COL class='XLarge'>
    <COLGROUP>
        <COL class='Medium Number' span='4'>
    <THEAD><TR><TH>Periodo
               <TH>Cliente
               <TH>Nombres / Razon Social
               <TH align='center'>Neto
               <TH align='center'>IGV
               <TH align='center'>Serv.
               <TH align='center'>Total
    <!--<TFOOT>
        <TR><TD colspan='8'>&nbsp;-->

    <TBODY class='Report'>
<%  java.text.DecimalFormat df = new java.text.DecimalFormat("#,###,##0.00");
    double netProd=0, tax1Prod=0, tax2Prod=0, saleProd=0;

    ArrayList productionList = (ArrayList)request.getAttribute("cplist");

    if ( productionList != null && productionList.size() != 0 ) {
        CustomerProduction cp = new CustomerProduction();
        for ( int i=0, j=1; i < productionList.size(); i++, j++ ) {
            cp = (CustomerProduction)productionList.get(i);
            netProd  = netProd  + cp.getNetTotal();
            tax1Prod = tax1Prod + cp.getTax1Total();
            tax2Prod = tax2Prod + cp.getTax2Total();
            saleProd = saleProd + cp.getProduction();
            String rowclass = ( j % 2 == 0 ) ? "Distinct" : ""; %>
        <TR class='<%= rowclass %>'>
            <TD><%= cp.getPeriod() %>
            <TD><%= cp.getCustomerId() %>
            <TD><A href=
            "javascript:openDetail('ReceiptQueryServlet?hotel=<%= recqry.getHotelId() %>&'
                                               + 'customer=<%= cp.getCustomerId() %>&'
                                               + 'customerName=<%= cp.getCustomerName() %>&'
                                               + 'period=<%= cp.getPeriod() %>')">
                   <%= ( cp.getCustomerName() == null ) ? "S/D" : cp.getCustomerName() %>
                </A>
            <TD><%= df.format( cp.getNetTotal() ) %>
            <TD><%= df.format( cp.getTax1Total() ) %>
            <TD><%= df.format( cp.getTax2Total() ) %>
            <TD><B><%= df.format( cp.getProduction() ) %>
<%      } %>
        <TR class='Total'>
            <TD colspan='3'>TOTALES
            <TD><%= df.format(netProd) %>
            <TD><%= df.format(tax1Prod) %>
            <TD><%= df.format(tax2Prod) %>
            <TD><%= df.format(saleProd) %>
<%  } else { %>
        <TR><TD colspan='7'>&nbsp;
        <TR><TD colspan='7' style='color: red'>No hay informaci&oacute;n del periodo ingresado
        <TR><TD colspan='7'>&nbsp;
<%  } %>
</TABLE>
</BODY>
</HTML>