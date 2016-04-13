
<%@ page contentType="text/html" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<jsp:useBean id='query' class="com.mycom.booking.beans.SearchBean" scope='request'/>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 //EN"
          "http://www.w3.org/TR/html4/strict.dtd">

<HTML>
<HEAD>
  <META http-equiv="Expires=-1" content="text/html; charset=iso-8859-1">
  <META http-equiv="Content-Style-Type" content="text/css">
  <LINK rel='stylesheet' type='text/css' href="css/searchform.css">
  <TITLE>Company search</title>
  <SCRIPT type='text/javascript' languaje='js/JavaScript'>
  <!--
  function loadDocument(){
      window.focus();
      document.frmsearch.sampleValue.select();
  }
  function sendForm(){
      document.frmsearch.show.click();
  }
  function getCompany(document){
     window.opener.frmcompany.rucNumber.value = document;
     window.opener.frmcompany.show.click();
     window.close();
  }
  // -->
  </SCRIPT>
</HEAD>

<jsp:setProperty name="query" property="*" />

<BODY onload='loadDocument()'>
<FORM name='frmsearch' method='post' action="companySearch">
  <TABLE class='Search' width='800' border='0' cellpadding='2'>
    <CAPTION class='Search'>Search information</CAPTION>
    <TR>
      <TD align='center'>
          <SELECT name='hotelId' class='Large' id='hotelId' readonly>
              <OPTION value='1' selected>UNIDAD HOTELERA</OPTION>
          </SELECT>
          <SELECT name='sampleField' class='Large' id='field'>
              <OPTION value='firmName'>Firm Name</OPTION>
              <OPTION value='commName'>Commercial Name</OPTION>
              <OPTION value='rucNumber'>RUC Number</OPTION>
          </SELECT>
          <INPUT type='text' name='sampleValue'
                 value='${query.sampleValue}' maxlength='20'>
          <INPUT type='submit' name='report' value='Show'>
  </TABLE>
</FORM>

<TABLE width='800' rules="groups">
    <COLGROUP>
        <COL width='80' align='center'>
    <COLGROUP>
        <COL width='280'>
  <THEAD>
    <TR>
        <TH>RUC
        <TH>Firm Name

  <TBODY>
<%  short n = 1; %>
<c:forEach var='c' items='${companies}'>
           <TR class='<%= ( n++ % 2 == 0 ) ? "Distinct" : "" %>'>
           <TD><A href='javascript:getCompany(${c.rucNumber})'>
               ${c.rucNumber}
           </A>
           <TD>${firmName}
</c:forEach>

</TABLE>
</BODY>

</HTML>