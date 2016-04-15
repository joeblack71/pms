<%--
<%@ page errorPage="errorPage.jsp" %>
--%>

<%@ page import="java.util.ArrayList" %>
<%@ page import="java.text.SimpleDateFormat" %>

<%@ page import="beans.BankTransaction" %>
<%@ page import="libraries.DateManager" %>

<jsp:useBean id='bt' class="beans.BankTransaction" scope='request'/>

<%  ArrayList accountList = null,
              ttList = null,
              twList = null;
              
    String[][] transactions = {{"1","EFECTIVO"},{"2","CHEQUE"},
                               {"3","RETIRO CAJERO"},{"4","TELE-PAGO"},
                               {"9","PORTES / MANT."}};

    String[][] customers = {{"1","INVERTUR"},{"2","INVER HOTEL"},
                            {"3","DERRAMA"},{"4","EL DORAL"}};
                               

    accountList = (ArrayList)application.getAttribute("accountList");
    /*ttList = (ArrayList)application.getAttribute("ttList"); // transaction type list
    twList = (ArrayList)application.getAttribute("twList"); // transaction way list*/

    String caption = "";
    bt = (BankTransaction)session.getAttribute("bt"); // bank transaction
    if ( bt != null) {
        caption = bt.getTransactionDate() + ", " + bt.getDocumentNumber() +
                  "\n" + bt.getTransactionType();
    } else {
        bt = new BankTransaction();
        bt.setTransactionNumber(0);
        bt.setTransactionDate("");
    }

    String selected = "";
 %>

<HTML>

<HEAD>
    <META http-equiv="Expires=-1" content="text/html; charset=iso-8859-1">
    <META http-equiv="Content-Style-Type" content="text/css">
    <LINK rel='stylesheet' type='text/css' href="css/stylesheet.css">
    <STYLE> SPAN.Resalt { color: red } </STYLE>
    <TITLE>Bank Transaction Register</TITLE>
    <!--<SCRIPT language='JavaScript' src="js/validateForm.js"></SCRIPT>-->
    <SCRIPT type='text/javascript' language='JavaScript'>
    <!--
    function loadDocument(){
        document.frmBankTransaction.transactionNumber.select();
    }

    function searchTransaction(){
       URL = "transactionSearch.jsp?selHotel=1";
       appeareance = "width=500,height=350,left=50,top=100,scrollbars=yes";
       // 'refsearch' nos permitira acceder a la ventana creada
       refserach = window.open(URL,"search",appeareance);
    }

    function disableSaveButton(form){}
//-->
    </SCRIPT>
</HEAD>

<BODY onLoad='loadDocument()'>
    <TABLE class='Form' align='center' border='0' cellspacing='6' cellpadding='0'> <!--rules='groups'-->
    <FORM name='frmBankTransaction' action="BankTransactionServlet" method="post"
          onSubmit='return validateSubmit()'>
    <CAPTION class='Form'>
        <BR><%= caption %><BR>
        <DIV align='right'>
          <A href='transactionReport.jsp'
             style='color: white'>
           Ver Reporte</A>
        </DIV>
    <COLGROUP>
    <COL STYLE='text-align: left'><COL>

    <TR><TD colspan='2'>&nbsp;

    <TR><TH><LABEL for='accountNumber'>Account Number</LABEL>
        <TD><INPUT type='hidden' name='bankId' value="1">
            <SELECT name='accountNumber' class='Large' id='accountNumber'>
                <OPTION value='1931126021159' selected>193-1126021-159
            </SELECT>
            <INPUT type='button' class='Button Large' value='' disabled>

    <TR><TH><LABEL>Bank Name</LABEL>
          <TD><INPUT type='text' name='bankName' class='XLarge'
                     value='BANCO DE CREDITO DEL PERU'>

    <TR><TD colspan='2'>&nbsp;

    <TR><TD><LABEL for='transactionNumber'>
                <SPAN class='Resalt'>*&nbsp;</SPAN>Transaction Number
            </LABEL>
        <TD><INPUT type='text' name='transactionNumber'
                   class='Large' id='transactionNumber'
                   value='<%= bt.getTransactionNumber() %>' maxlength='8'
                   onKeyUp='disableSaveButton(document.frmBankTransaction)'>
            <INPUT type='button' name='transactionSearch'
                   class='Button Large' value='Trans. Search'>
                   
    <TR><TH><LABEL for='transactionDate'>
                <SPAN class='Resalt'>*&nbsp;</SPAN>Transaction Date || Type
            </LABEL>
            <TD><INPUT type='text' name='transactionDate'
                       class='Large' id='transactionDate' maxlength='10'
                       value='<%= DateManager.getDomesticFormat( bt.getTransactionDate() ) %>'>
                    <% String checked = ( bt.getTransactionType().equals("C") ) ? "checked":""; %>
                <LABEL for='chargeTransaction' 
                       style='height: 26px; vertical-align: middle'>CARGO</LABEL>
                <INPUT type='radio' name='transactionType' <%= checked %>
                       class='NoBorder' id='chargeTransaction' value='C'>
                <SPAN>&nbsp;&nbsp;&nbsp;</SPAN>
                    <% checked = ( bt.getTransactionType().equals("P") ) ? "checked":""; %>
                <LABEL for='depositTransaction'
                       style='height: 26px; vertical-align: middle'>ABONO</LABEL>
                <INPUT type='radio' name='transactionType' <%= checked %>
                       class='NoBorder' id='depositTransaction' value='P'>

    <TR><TD><LABEL for='receiptNumber' disabled>
                <SPAN class='Resalt'>*&nbsp;</SPAN>Receipt to payment
            </LABEL>
        <TD><INPUT type='text' name='receiptNumber' class='Large' DISABLED>
            <INPUT type='button' name='receiptNumber' class='Button Large' DISABLED>

    <TR><TD><LABEL for='transactionAmount'>
                <SPAN class='Resalt'>*&nbsp;</SPAN>Transaction Amount || I.T.F.
            </LABEL>
        <TD><INPUT type='text' name='transactionAmount'
                   class='Large' id='transactionAmount' maxlength='10'
                   value='<%= bt.getTransactionAmount() %>'>
            <INPUT type='text' name='ITFTransaction'
                   class='Large' readonly
                   value='<%= bt.getITFTransaction() %>'>

    <TR><TD><LABEL for='documentNumber' disabled>
                <SPAN class='Resalt'>*&nbsp;</SPAN>Check number
            </LABEL>
        <TD><INPUT type='text' name='documentNumber' class='Large' DISABLED>
            <SELECT name='transactionWay' class='Large'>
<%                  for ( int i=0; i < transactions.length; i++ ) {
                        selected = ( Short.parseShort( transactions[i][0] ) ==
                                     bt.getTransactionWay() ) ? "selected" : "";
%>
                <OPTION value='<%= transactions[i][0] %>' <%= selected %> ><%= transactions[i][1] %>
<%                  } %>
            </SELECT>

    <TR><TD><LABEL for='documentNumber' disabled>
                <SPAN class='Resalt'>*&nbsp;</SPAN>Customer / Receipt Number
            </LABEL>
        <TD><INPUT type='text' name='customer' disabled
                   class='Large' >
            <SELECT name='receiptNumber' class='Large'>
<%                  for ( int i=0; i < customers.length; i++ ) {
                        selected = ( Short.parseShort( customers[i][0] ) ==
                                     bt.getCustomerId() ) ? "selected" : "";
%>
                <OPTION value='<%= customers[i][0] %>' <%= selected %> ><%= customers[i][1] %>
<%                  } %>
            </SELECT>

      <TR><TD colspan='2'>&nbsp;

      <TR><TD align='center' colspan='2'>
              <INPUT type='submit' name='show'
                     class='Button Large' value="Show Transaction"
                     onClick='showGuest(document.frmBankTransaction.bt.value)'>
              <INPUT type='submit' name='save'
                     class='Button Large' value="Save Transaction"
                     onClick='saveGuest(document.frmBankTransaction.bt.value)'>
              <INPUT type='submit' name='reset'
                     class='Button Large' value="New Transaction"
                     onClick='resetFields(document.frmBankTransaction)'>
              <!--
              <INPUT type='submit' name='delete'
                     class='Button' value="Delete"
                     onClick='deleteGuest(document.frmBankTransaction.bt.value)'>
              <INPUT type='submit' name='exit' value="Exit"
                     onClick='window.close()'>
              -->

    </TABLE>
  </FORM>
</BODY>

</HTML>
