
<%@ page contentType="text/html" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>


<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 //EN"
          "http://www.w3.org/TR/html4/strict.dtd">

<HTML>
<HEAD>
  <META http-equiv="Expires=-1" content="text/html; charset=iso-8859-1">
  <META http-equiv="Content-Style-Type" content="text/css">
  <LINK rel='stylesheet' type='text/css' href="css/stylesheet.css">
  <TITLE>Source search</title>
  <SCRIPT type='text/javascript' languaje='js/JavaScript'>
  <!--
  function loadDocument(){
      document.frmsearch.sampleValue.select();
  }

  function chargeSource(sourceId,sourceNm,specialRt) {
     //parameters = 'sourceId=' + sourceId + '&sourceNm=' + sourceNm;
     //window.location.href='ReservationServlet?' + parameters;
     //window.opener.location.reload();
     window.opener.frmres.sourceId.value = sourceId;
     window.opener.frmres.sourceNm.value = sourceNm;
     window.opener.frmres.SpecialRate.value = specialRt;
     window.close();
  }
  // -->
  </SCRIPT>
</HEAD>

<jsp:setProperty name="query" property="*" />

<BODY onload='loadDocument()'>
<FORM name='frmsearch' method='post' action="SourceSearchServlet">
  <TABLE class='Search' width='800' border='0' cellspacing='0' cellpadding='2'>
    <CAPTION class='Search'>Search information</CAPTION>
    <TR>
      <TD align='center'>
          <SELECT name='hotelId' class='Large' id='hotelId' DISABLED>
              <OPTION value='1' selected>UNIDAD HOTELERA</OPTION>
          </SELECT>
          <INPUT type='hidden' name='roomType'
                 value='<%= request.getParameter("roomType") %>'>
          <SELECT name='sampleField' class='Large' id='field'>
              <OPTION value='lastname'>SEGMENT</OPTION>
          </SELECT>
          <INPUT type='text' name='sampleValue'
                 value='${query.sampleValue}' maxlength='20'
                 title='Input pattern to look for ..'>
          <INPUT type='submit' name='show' value='Show'>
  </TABLE>
</FORM>

<TABLE width='620' rules="groups">
    <COL width='80' align='center'>
    <COL width='280'>
  <THEAD>
    <TR>
        <TH>Source Code
        <TH>Description
  <TBODY>

<%  short lineCounter = 1; %>
    <c:forEach var="c" items="${cias}">
        <TR class='<%= (lineCounter++ % 2 == 0) ? "Distinct" : "" %>'>
        <TD><A href='javascript:chargeSource(${c.companyId},"${c.firmName}",${c.hsEowRate})'>
            ${c.rucNumber}
        </A>
        <TD>${c.firmName}
    </c:forEach>

</TABLE>
</BODY>

</HTML>