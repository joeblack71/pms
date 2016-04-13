
<%@ page contentType="text/html" %>
<%@ page import="com.mycom.booking.beans.*" %>

<%@ taglib uri='/WEB-INF/tlds/reports.tld' prefix="mytag" %>

<jsp:useBean id='search' class="com.mycom.booking.beans.SearchBean" />

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 //EN"
          "http://www.w3.org/TR/html4/strict.dtd">

<HTML>
<HEAD>
  <META http-equiv="Expires=-1" content="text/html; charset=iso-8859-1">
  <META http-equiv="Content-Style-Type" content="text/css">
  <LINK rel='stylesheet' type='text/css' href="css/stylesheet.css">
  <TITLE>Busqueda de Reservas</TITLE>
  <SCRIPT type='text/javascript' languaje='js/JavaScript'>
  <!--
  function loadDocument(){
      document.frmsearch.pattern.select();
  }
  function getReservation(reservation){
     hotelId = document.frmsearch.hotelId.value;
     parameters = "?show=show&hotelId=" + hotelId + "&reservation=" + reservation;
     window.opener.location.href="ReservationServlet" + parameters;
     window.close();
  }
  // -->
  </SCRIPT>
</HEAD>

<jsp:setProperty name='search' property="*" />

<BODY onload='loadDocument()'>
<FORM name='frmsearch' method='post' action="<%= request.getRequestURI() %>">
    <TABLE class='Search' width='680'>
        <CAPTION class='Form'>Search information</CAPTION>
        <TR><TD>
            <SELECT name='hotelId' class='Large'>
                <OPTION value='1' selected>UNIDAD HOTELERA</OPTION>
            </SELECT>
            
            <mytag:select matter="QueryReservation" selectedItem="${search.sampleField}" />
            
            <INPUT type='text' name='sampleValue'
                   class='Large' id='pattern'
                   style='height: 16px'
                   value='${search.sampleValue}'
                   maxlength='10'
                   title='Input pattern to look for ..'>
            
            <INPUT type='submit' name='show'
                   class='Button Large' value='Show Records'>
    </TABLE>
</FORM>

<TABLE class='Report' width='680' rules="groups" border='0' cellspacing='4' cellpadding='2'>
    <COLGROUP id='reservation'>
        <COL width='80' align='center'>
    <COLGROUP id='paxname'>
        <COL width='280'>
    <COLGROUP id='stay'>
        <COL width='120' align='center' span='2'>
    <COLGROUP id='status'>
        <COL width='80'  align='center'>
    <THEAD>
        <TR><TH>Reservation<TH>Pax Names<TH>Arrival<TH>Departure<TH>Status

    <TBODY>
        <mytag:reservation field='${search.sampleField}' pattern='${search.sampleValue}' />
</TABLE>

</BODY>
</HTML>