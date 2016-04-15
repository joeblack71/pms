
<%@ page contentType="text/html" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<%@ page import="java.util.*" %>
<%@ page import="java.sql.*" %>

<%@ page import="beans.*" %>
<%@ page import="dispatchers.*" %>
<%@ page import="libraries.*" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD html 4.01 //EN"
          "http://www.w3.org/tr/html4/strict.dtd">

<html>
<head>
  <meta http-equiv="Expires=-1" content="text/html; charset=iso-8859-1">
  <meta http-equiv="Content-Style-Type" content="text/css">
  <link rel='stylesheet' type='text/css' href="css/stylesheet.css">
  <title>Sales Register</title>
</head>

<script language='JavaScript'>
<!--
function loadDocument(){
    //document.frmFilter.year.focus();
}
// -->
</script>

<jsp:useBean id='recqry' class="beans.ReceiptQuery" scope='request' />

<%  session.setAttribute("option","salesReport.jsp"); %>

<body onload='loadDocument()'>
<form method='post' name='frmFilter' action="ReceiptReportServlet">
  <table width='620' border='1' rules='groups' cellspacing='0' cellpadding='4'>
    <caption class='Form'>Sales Register
        <div align='right'>
            <A href='sales.jsp' style='color: white'>Registrar Comprobante</A>
        </div>
    </caption>

    <tr><td><input type='hidden' name='hotel' value='1'>
            <select name='hotel' id='hotel' disabled>
              <optgroup label="Unidad Hotelera">
                <option value='1'>Apart Hotel El Doral</option>
            </select>

            <label for='period'>Periodo</label>
            <select name='period' class='Medium'>
                    <c:forEach var="period" items="${period}">
                        <c:set var="selected" value="" />
                        <c:if test="${ recqry.period == period }" >
                            <c:set var="selected" value="SELECTED" />
                        </c:if>
                <option value="${period}" ${selected}>${period}
                    </c:forEach>
            </select>
            <select name='month' class='Medium'>
                    <c:forEach var="month" items="${months}" varStatus="status">
                        <c:set var="selected" value="" />
                        <c:if test="${ recqry.month == status.count }" >
                            <c:set var="selected" value="SELECTED" />
                        </c:if>
                <option value="${status.count}" ${selected}>${month}
                    </c:forEach>
            </select>
            <select name='month_day' class='Small'>
                <option value='0'>--
                    <c:forEach var="m_day" items="${m_days}">
                        <c:set var="selected" value="" />
                        <c:if test="${ recqry.monthDay == m_day }" >
                            <c:set var="selected" value="SELECTED" />
                        </c:if>
                <option value="${m_day}" ${selected}>${m_day}
                    </c:forEach>
            </select>
        <td><input type='submit' class="Button" value="Show Report">

  </table>
</form>

<table width='1200' rules='groups' cellspacing='0'>
    <!--<caption class='Form' align='left'>Registro de Ventas</caption>-->
    <colgroup align='center'>
        <col class='Medium'>
        <col class='Tiny'>
        <col class='Tiny'>
        <col class='Medium'>
    <colgroup>
        <col class='Medium' align='center'>
        <col class='XLarge'>
    <colgroup>
        <col class='Medium' align='right' span='5'>
    <colgroup align='center'>
        <!--<col class='Tiny'>-->
        <col class='Small'>
        <col class='Tiny'>

    <thead>
        <tr><th>Fecha
            <th>Tipo
            <th>Serie
            <th>Correlativo
            <th>Cliente
            <th>Nombres / Razon Social
            <th>Afecto
            <th>Exento
            <th>IGV
            <th>Serv.
            <th>Total
            <!--<th>Mon.-->
            <th>T/C
            <th>Est.

    <!--<tfoot>
        <tr><td colspan='12'>&nbsp;-->

<%  java.text.DecimalFormat df = new java.text.DecimalFormat("#,###,##0.00");
    double afectTotal=0, exemptTotal=0, tax1Total=0, serviceTotal=0, saleTotal=0;
%>
    <tbody class='Report'>
    <c:if test="${empty rbplist}">
        <tr><td colspan='13'>&nbsp;
        <tr><td colspan='13' style='color: red'>No hay informaci&oacute;n del periodo ingresado
        <tr><td colspan='13'>&nbsp;
    </c:if>
    <c:forEach var="res" items="${rbplist}" varStatus="status">
        <c:set var="distinct" value="" />
        <c:if test="${status.count % 2 == 0 }" >
            <c:set var="distinct" value="Distinct" />
        </c:if>
        <tr class="${distinct}">
            <td><fmt:formatDate pattern="dd/MM/yy" value="${res.issueDate}" />
            <td>${res.receiptType}
            <td>${res.receiptSerial}
            <td>${res.correlative}
            <td>${res.entityId}
            <c:set var="cancel" value="${42}" />
            <c:if test="${ res.status == cancel }">
                <c:set target="${res.entityName}" value="* *   A   N   U   L   A   D  O   * *" />
            </c:if>
            <td>${res.entityName}
            <c:if test="${res.exempt}">
                <c:set var="taxable" value="0" />
                <c:set var="exempt" value="${res.net}" />
            </c:if>
            <td>${taxable}
            <td>${exempt}
            <td>${res.tax1}
            <td>${res.service}
            <td title="Receipt: ${res.correlative}"><b>${res.receiptTotal}
            <td>${res.exchange}
            <td>${res.status}
            <c:set var="afectTotal" value="${afectTotal  + receiptAfect}" />
            <c:set var="exemptTotal" value="${exemptTotal  + receiptAfect}" />
            <c:set var="tax1Total" value="${tax1Total  + receiptAfect}" />
            <c:set var="serviceTotal" value="${serviceTotal  + receiptAfect}" />
            <c:set var="saleTotal" value="${saleTotal  + receiptAfect}" />
    </c:forEach>
        <tr><td colspan='4'><td colspan='2'><td colspan='5'><td>&nbsp;
        <tr class='Total' style='padding: 4px 2px'>
            <td colspan='6' align='center'>TOTALES
            <td>${afectTotal}
            <td>${exemptTotal}
            <td>${tax1Total}
            <td>${serviceTotal}
            <td>${saleTotal}
            <td colspan='2'>&nbsp;

<%
            /*String customerId = ( r.getEntityId() == null ) ? "" : r.getEntityId();
            String customerName = ( r.getStatus().equals("*") )
                             ? " * *   A   N   U   L   A   D  O   * *"  : r.getEntityName();
            double receiptAfect=0, receiptExempt=0;
            if ( !r.isExempt() )
                 receiptAfect  = r.getNet();
            else receiptExempt = r.getNet();
            afectTotal  = afectTotal  + receiptAfect;
            exemptTotal = exemptTotal + receiptExempt;
            tax1Total   = tax1Total   + r.getTax1();
            serviceTotal = serviceTotal + r.getService();
            saleTotal   = saleTotal   + r.getReceiptTotal();*/
%>
</table>
</body>
</html>