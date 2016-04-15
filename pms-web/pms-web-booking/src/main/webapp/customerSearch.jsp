
<%@ page contentType="text/html" %>

<%@ page import="java.sql.*" %>
<%@ page import="java.util.*" %>

<%@ page import="com.mycom.booking.beans.Customer" %>
<%@ page import="com.mycom.booking.dispatchers.*" %>
<%@ page import="com.mycom.booking.libraries.DateManager" %>

<jsp:useBean id='query' class="com.mycom.booking.beans.SearchBean" />

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 //EN"
          "http://www.w3.org/TR/html4/strict.dtd">

<HTML>
<HEAD>
  <META http-equiv="Expires=-1" content="text/html; charset=iso-8859-1">
  <META http-equiv="Content-Style-Type" content="text/css">
  <LINK rel='stylesheet' type='text/css' href="css/searchform.css">
  <TITLE>Customer search</title>
  <SCRIPT type='text/javascript' languaje='js/JavaScript'>
  <!--
  function loadDocument(){
      window.focus();
      document.frmsearch.sampleValue.select();
  }
  function sendForm(){
      document.frmsearch.show.click();
  }
  function getGuest(document){
     window.opener.frmres.document.value = document;
     window.opener.frmres.show.click();
     //window.opener.focus();
     window.close();
  }
  // -->
  </SCRIPT>
</HEAD>

<jsp:setProperty name="query" property="*" />

<BODY onload='loadDocument()'>
<FORM name='frmsearch' method='post' action="customerSearch.jsp">
  <TABLE class='Search' width='800' border='0' cellspacing='0' cellpadding='2'>
    <CAPTION class='Search'>Search information</CAPTION>
    <TR>
      <TD align='center'>
          <SELECT name='hotelId' class='Large' id='hotelId' readonly>
              <OPTION value='1' selected>UNIDAD HOTELERA</OPTION>
          </SELECT>
          <SELECT name='sampleField' class='Large' id='field'>
              <OPTION value='lastname'>Last Name</OPTION>
              <OPTION value='firstname'>First Name</OPTION>
              <OPTION value='document'>Document</OPTION>
              <OPTION value='customerCode'>Customer Code</OPTION>
              <OPTION value='source'>Source</OPTION>
              <OPTION value='lastArrival'>Last Arrival</OPTION>
              <OPTION value='country'>Country</OPTION>
          </SELECT>
          <INPUT type='text' name='sampleValue'
                 value='${query.sampleValue}' maxlength='20'
                 title='Input pattern to look for ..'>
          <INPUT type='submit' name='show' value='Show'>
  </TABLE>
</FORM>

<TABLE width='800' rules="groups">
    <COLGROUP id='code'>
        <COL width='80' align='center'>
    <COLGROUP id='paxname'>
        <COL width='280'>
    <COLGROUP id='paxdoc'>
        <COL width='120' align='center' span='2'>
    <COLGROUP id='residence'>
        <COL id='ctry' width='80'  align='center'>
        <COL id='phne' width='80'  align='center'>
    <COLGROUP id='nationality'>
        <COL width='80'  align='center'>
    <COLGROUP id='lastarrival'>
        <COL width='80'  align='center'>
  <THEAD>
    <TR>
        <TH>Customer Code
        <TH>Pax Names
        <TH>Document
        <TH>Residence
        <TH>Nationality
        <TH>Last Arrival
  <TBODY>
<%  String hotel = request.getParameter("hotelId");
    String field = request.getParameter("sampleField");
    String pattern = request.getParameter("sampleValue");
    if ( hotel != null && field != null && pattern != null ) {
        Connection con = ConProvider.getConnection();
        CustomerDisp cdisp = new CustomerDisp();
        cdisp.setConnection(con);
        ArrayList list = null;
        boolean validField = true;
        // TODO: Create routines for search of customers
        //if ( field.equals("lastname") && pattern.length() > 0 ) {
            list = cdisp.chargeAll(hotel);
        /*} else {
            if ( field.equals("arrival") && pattern.length() >= 6 ) {
               pattern = DateManager.getSqlFormat(pattern);
               list = rdisp.chargeByArrival(hotel, pattern);
            } else validField = false;
        }*/

        String trclass = "";
        if ( list != null && list.size() > 0 ) {
            Customer cust = new Customer();
            for ( int i=0,j=1; i < list.size(); i++,j++ ) {
                cust = (Customer)list.get(i);
                trclass = ( j % 2 == 0 ) ? "Distinct" : "";
%>
    <TR class='<%=trclass %>'>
        <TD><A href='javascript:getGuest(<%=cust.getCustomerId()%>)'>
            <%=cust.getDocumentNumber()%>
            </A>
        <TD><%=cust.getLastname1() + ", " + cust.getFirstname() %>
        <TD>&nbsp;<TD>&nbsp;<TD>&nbsp;<TD>&nbsp;
<%         }
        }%>
</TABLE>
<%  } %>
</BODY>
<!-- Example about correct way for open a secondary window (popup)
<A href="pop.html" target="ventana"
 onclick="pop(this.src,this.target,'scrollbars=yes'); return false;">
 Abrir Ventana
</A>

-->

</HTML>