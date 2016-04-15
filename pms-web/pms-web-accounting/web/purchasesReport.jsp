
<%@ page contentType="text/html" %>
<%@ page import="java.sql.*, java.util.*" %>
<%@ page import="beans.Receipt" %>
<%@ page import="beans.ReceiptQuery" %>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 //EN"
          "http://www.w3.org/TR/html4/strict.dtd">

<HTML>
<HEAD>
  <META http-equiv="Expires=-1" content="text/html; charset=iso-8859-1">
  <META http-equiv="Content-Style-Type" content="text/css">
  <LINK rel='stylesheet' type='text/css' href="css/stylesheet.css">
  <TITLE>Registro de Ventas</title>
</HEAD>

<SCRIPT language='JavaScript'>
<!--
function loadDocument(){
    //document.frmFilter.year.focus();
}
// -->
</SCRIPT>

<jsp:useBean id='recqry' class="beans.ReceiptQuery" scope='request' />

<%  session.setAttribute("option","purchasesReport.jsp");

    int[] period = (int[])application.getAttribute("period");
    int[] m_days = (int[])application.getAttribute("m_days");
    String[] months = (String[])application.getAttribute("months");

    session.setAttribute("option","purchasesReport.jsp");
 %>

<BODY onload='loadDocument()'>
<FORM method='post' name='frmFilter' action="ReceiptReportServlet">
  <TABLE width='620' border='1' rules='groups' cellspacing='0' cellpadding='4'>
    <CAPTION class='Form' style='background: teal'>Datos del Periodo
          <DIV align='right'>
              <A href='purchases.jsp'
                 style='color: white'>
               Registrar Comprobante</A>
           </DIV>
    </CAPTION>
    <COLGROUP><COL><COL><COL>
    <TR><TD><INPUT type='hidden' name='hotel' value='1'>
            <SELECT name='hotel' id='hotel' disabled>
              <OPTGROUP label="Unidad Hotelera">
                <OPTION value='1'>Apart Hotel El Doral</OPTION>
            </SELECT>

        <TD><LABEL for='period'>Periodo</LABEL>
            <SELECT name='period' class='Medium'>
<%      String seloption = null;
        for (int i=1; i < period.length; i++) {
            seloption = ( recqry.getPeriod() == period[i] ) ? "selected" : "";
%>
                <OPTION value='<%= period[i] %>' <%= seloption %>>
                    <%= period[i] %>
                </OPTION>
<%      } %>
            </SELECT>
            <SELECT name='month' class='Medium'>
<%      for (int i=1; i < months.length; i++) {
            seloption = ( recqry.getMonth() == i ) ? "selected" : ""; %>
                <OPTION value='<%= i %>' <%= seloption %>>
                    <%= months[i] %>
                </OPTION>
<%      } %>
            </SELECT>
            <SELECT name='month_day' class='Small'>
                <OPTION value='0'>--</OPTION>
<%      for (int i=1; i < m_days.length; i++) {
            seloption = ( recqry.getMonthDay() == i ) ? "selected" : "";
%>
                <OPTION value='<%= i %>' <%= seloption %>>
                    <%= m_days[i] %>
                </OPTION>
<%      } %>
            </SELECT>
        <TD align='center'>
            <INPUT type='submit' name='show'
                   class='Button Large' style='padding: 0px 0px'
                   value="Mostrar" align='center'>
                   <!--margin: 2px;-->

  </TABLE>
</FORM>

<TABLE width='1200' rules='groups' cellspacing='1'>
    <!--<CAPTION class='Form' align='left'>Registro de Ventas</CAPTION>-->
    <COLGROUP align='center'>
        <COL class='Medium'>
        <COL class='Tiny'>
        <COL class='Tiny'>
        <COL class='Medium'>
    <COLGROUP>
        <COL class='Medium' align='center'>
        <COL class='XLarge' align='left'>
    <COLGROUP>
        <COL class='Medium' align='right' span='5'>
    <COLGROUP align='center'>
        <!--<COL class='Tiny'>
        <COL class='Tiny' align='right'>-->
        <COL class='Tiny'>

    <THEAD>
        <TR><TH>Fecha
            <TH>Tipo
            <TH>Serie
            <TH>Correlativo
            <TH>Proveedor
            <TH>Nombres / Razon Social
            <TH style='text-align: center'>Afecto
            <TH style='text-align: center'>Exento
            <TH style='text-align: center'>IGV
            <TH style='text-align: center'>Serv.
            <TH style='text-align: center'>Total
            <!--<TH>Mon.
            <TH>T/C-->
            <TH>Est.

    <!--
    <TFOOT>
        <TR><TH colspan='12' style='background: mediumaquamarine'>&nbsp;
    -->    

    <TBODY align='decimal'>

<%  java.text.DecimalFormat df = new java.text.DecimalFormat("#,###,##0.00");
    double afectTotal=0, exemptTotal=0, tax1Total=0, serviceTotal=0, saleTotal=0;

    ArrayList receiptList = (ArrayList)request.getAttribute("pbplist");

    if ( receiptList != null && receiptList.size() != 0 ) {
        Receipt r = new Receipt();
        String trClass = null, tdTitle = null;
        for ( int i=0, j=1; i < receiptList.size(); i++, j++ ) {
            r = (Receipt)receiptList.get(i);
            String entityId = ( r.getEntityId() == null ) ? "" : r.getEntityId();
            String entityName = ( r.getStatus().equals("*") )
                             ? " * *   A   N   U   L   A   D  O   * *"  : r.getEntityName();
            double receiptAfect=0, receiptExempt=0;
            if ( !r.isExempt() )
                 receiptAfect  = r.getNet();
            else receiptExempt = r.getNet();
            afectTotal  = afectTotal  + receiptAfect;
            exemptTotal = exemptTotal + receiptExempt;
            tax1Total   = tax1Total   + r.getTax1();
            serviceTotal = serviceTotal + r.getService();
            saleTotal   = saleTotal   + r.getReceiptTotal();
            // TODO: Cambiar tipo de fuente y color
            tdTitle = "Correl.: " + r.getReceiptSerial() + " - " + r.getCorrelative();
            trClass = ( j % 2 == 0 ) ? "class='Distinct'" : "";
%>
        <TR <%= trClass %> >
            <TD><%= r.getIssueDate() %>
            <TD><%= r.getReceiptType() %>
            <TD><%= r.getReceiptSerial() %>
            <TD><%= r.getCorrelative() %>
            <TD><%= entityId %>
            <TD><%= entityName %>
            <TD><span title="<%= tdTitle %>">
                    <%= df.format(receiptAfect) %>
                </span>
            <TD><%= df.format(receiptExempt) %>
            <TD><%= df.format( r.getTax1() ) %>
            <TD><%= df.format( r.getService() ) %>
            <TD><B><%= df.format( r.getReceiptTotal() ) %>
            <TD><%= r.getStatus() %>
<%      } %>
        <TR><TD colspan='4'><TD colspan='2'><TD colspan='5'><TD>&nbsp;
        <TR class='Total' style='background: teal'>
            <TD colspan='6' align='right'>Totales
            <TD><%= df.format(afectTotal) %>
            <TD><%= df.format(exemptTotal) %>
            <TD><%= df.format(tax1Total) %>
            <TD><%= df.format(serviceTotal) %>
            <TD><%= df.format(saleTotal) %>
            <TD>&nbsp;
<%  } else { %>
        <TR><TD colspan='12'>&nbsp;
        <TR><TD colspan='12' style='text-color: blue; background: white'>
            <B>No hay informaci&oacute;n del periodo ingresado</B>
        <TR><TD colspan='12'>&nbsp;
<%  } %>
</TABLE>
</BODY>
</HTML>