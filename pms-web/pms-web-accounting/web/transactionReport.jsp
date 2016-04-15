
<%@ page contentType="text/html" %>
<%@ page import="java.sql.*, java.util.*" %>

<%@ page import="beans.BankTransaction" %>
<%@ page import="beans.PeriodQuery" %>
<%@ page import="libraries.DateManager" %>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 //EN"
          "http://www.w3.org/TR/html4/strict.dtd">

<HTML>
<HEAD>
  <META http-equiv="Expires=-1" content="text/html; charset=iso-8859-1">
  <META http-equiv="Content-Style-Type" content="text/css">
  <LINK rel='stylesheet' type='text/css' href="css/stylesheet.css">
  <TITLE>Estado de Cuenta Corriente</title>
</HEAD>

<SCRIPT language='JavaScript'>
<!--
function loadDocument(){
    //document.frmFilter.year.focus();
}
// -->
</SCRIPT>

<jsp:useBean id='periodQry' class="beans.PeriodQuery" scope="request" />
<jsp:setProperty name='periodQry' property="*" />

<%  int[]    period = (int[])application.getAttribute("period");
    String[] months = (String[])application.getAttribute("months");
    int[]    m_days = (int[])application.getAttribute("m_days");

    String seloption = "";
 %>

<BODY onload='loadDocument()'>
<FORM method='post' name='frmFilter' action="transactionReport.jsp">
  <TABLE width='620' border='1' rules='groups' cellspacing='0' cellpadding='4'>
    <CAPTION class='Form' style='background: teal'>Datos del Periodo
          <DIV align='right'>
              <A href='bankTransactions.jsp'
                 style='color: white'>
               Registrar Transaccion</A>
           </DIV>
    </CAPTION>
    <COLGROUP><COL><COL><COL>
    <TR><TD><INPUT type='hidden' name='bankId' value='1'>
            <SELECT name='accountNumber' disabled>
              <OPTGROUP label="Available Accounts">
                <OPTION value='1931126021159'>193-1126021-159</OPTION>
            </SELECT>

        <TD><LABEL for='period'>Periodo</LABEL>
            <SELECT name='year' class='Medium'>
<%                  if ( periodQry != null ) {
                        for (int i=1; i < period.length; i++) {
                            seloption = ( periodQry.getYear() == period[i] ) ? "selected" : "";
%>
                <OPTION value='<%= period[i] %>' <%= seloption %>>
                    <%= period[i] %>
                </OPTION>
<%                      }
                    } %>
            </SELECT>
            <SELECT name='month' class='Medium'>
<%                  if ( periodQry != null ) {
                        for (int i=1; i < months.length; i++) {
                            seloption = ( periodQry.getMonth() == i ) ? "selected" : ""; %>
                <OPTION value='<%= i %>' <%= seloption %>>
                    <%= months[i] %>
                </OPTION>
<%                      }
                    } %>
            </SELECT>
            <SELECT name='day' class='Small' disabled>
                <OPTION value='0'>--</OPTION>
<%                  if ( periodQry != null ) {
                        for (int i=1; i < m_days.length; i++) {
                            seloption = ( periodQry.getMonthDay() == i ) ? "selected" : "";
%>
                <OPTION value='<%= i %>' <%= seloption %>>
                    <%= m_days[i] %>
                </OPTION>
<%                      }
                    } %>
            </SELECT>
        <TD align='center'>
            <INPUT type='submit' name='show'
                   class='Button Large' style='padding: 0px 0px'
                   value="Mostrar" align='center'>
                   <!--margin: 2px;-->

  </TABLE>
</FORM>

<TABLE width='620' rules='groups' cellspacing='1'>
    <!--<CAPTION class='Form' align='left'>Registro de Ventas</CAPTION>-->
    <COLGROUP align='center'>
        <COL class='Medium'>
    <COLGROUP>
        <COL class='Medium' align='center'>
        <COL class='Medium'>
    <COLGROUP>
        <COL class='Medium' align='right' span='4'>

    <THEAD>
        <TR><TH>Fecha
            <TH>Numero
            <TH>Forma
            <TH>Cheque
            <TH>Cargo
            <TH>Abono
            <TH>ITF

    <!--
    <TFOOT>
        <TR><TH colspan='12' style='background: mediumaquamarine'>&nbsp;
    -->    

    <TBODY align='decimal'>

<%  java.text.DecimalFormat df = new java.text.DecimalFormat("#,###,##0.00");
    double chargeTotal=0, paymentTotal=0, itfTotal=0;

    String year = request.getParameter("year");
    String month = request.getParameter("month");
    //String day = request.getParameter("day");

    // TODO: Move to Servlet
        Connection con = dispatchers.ConProvider.getConnection();
        String query = "SELECT dTransactionDate, nTransactionNumber," +
                             " tTransactionType, nTransactionWay," +
                             " nDocumentNumber, nTransactionAmount," +
                             " nITFTransaction FROM transaction" +
                             " WHERE year(dTransactionDate) = " + year +
                             " AND month(dTransactionDate) = " + month;
        ArrayList list = new ArrayList();
        try {
            ResultSet rs = con.createStatement().executeQuery(query);
            while ( rs.next() ) {
                BankTransaction bt = new BankTransaction();
                bt.setTransactionDate( rs.getString(1) );
                bt.setTransactionNumber( rs.getInt(2) );
                bt.setTransactionType( rs.getString(3) );
                bt.setTransactionWay( rs.getShort(4) );
                bt.setDocumentNumber( rs.getInt(5) );
                bt.setTransactionAmount( rs.getDouble(6) );
                bt.setITFTransaction( rs.getDouble(7) );
                list.add(bt);
            }
        } catch (Exception e) { e.printStackTrace(); }
    //

    if ( list != null && list.size() != 0 ) {
        BankTransaction bt = new BankTransaction();
        String trClass = null, tdTitle = null;
        double charge, payment;
        for ( int i=0, j=1; i < list.size(); i++, j++ ) {
            bt = (BankTransaction)list.get(i);
            charge=0; payment=0;
            if ( bt.getTransactionType().equals("C") )
                 charge  = bt.getTransactionAmount();
            else payment = bt.getTransactionAmount();
            chargeTotal  = chargeTotal  + charge;
            paymentTotal = paymentTotal + payment;
            itfTotal     = itfTotal   + bt.getITFTransaction();
            trClass = ( j % 2 == 0 ) ? "class='Distinct'" : "";
%>
        <TR <%= trClass %> >
            <TD><%= DateManager.getDomesticFormat( bt.getTransactionDate() ) %>
            <TD><%= bt.getTransactionNumber() %>
            <TD><%= bt.getTransactionWay() %>
            <TD><%= bt.getDocumentNumber() %>
            <TD><%= df.format( charge ) %>
            <TD><%= df.format( payment ) %>
            <TD><%= df.format( bt.getITFTransaction() ) %>
<%      } %>
        <TR><TD colspan='1'><TD colspan='2'><TD colspan='4'>&nbsp;
        <TR class='Total' style='background: teal'>
            <TD colspan='4' align='right'>Totales
            <TD><%= df.format(chargeTotal) %>
            <TD><%= df.format(paymentTotal) %>
            <TD><%= df.format(itfTotal) %>
<%  } else { %>
        <TR><TD colspan='7'>&nbsp;
        <TR><TD colspan='7' style='text-color: blue; background: white'>
            <B>No hay informaci&oacute;n del periodo ingresado</B>
        <TR><TD colspan='7'>&nbsp;
<%  } %>
</TABLE>
</BODY>
</HTML>