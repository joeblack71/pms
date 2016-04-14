
<%@ page contentType="text/html" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>


<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 //EN"
          "http://www.w3.org/TR/html4/strict.dtd">

<html>
<head>
  <meta http-equiv="Expires=-1" content="text/html; charset=iso-8859-1">
  <meta http-equiv="Content-Style-Type" content="text/css">
  <link rel='stylesheet' type='text/css' href="css/stylesheet.css">
  <title>Source search</title>
  <script type='text/javascript' languaje='js/JavaScript'>
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
  </script>
</head>

<jsp:setProperty name="query" property="*" />

<body onload='loadDocument()'>
<FORM name='frmsearch' method='post' action="SpecialRateShow.do">
  <table class='Search' width='800' border='0' cellspacing='0' cellpadding='2'>
    <caption class='Search'>Search information</CAPTION>
    <tr>
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
  </table>
</form>

<table width='620' rules="groups">
	<thead>
		<tr>
			<th>#</th>
			<th>Rate Id</th>
		    <th>Description</th>
		    <th>Room Type</th>
		</tr>
	</thead>
	
	<tbody>
	<c:set var="lineCounter" value="1" ></c:set>
	<c:forEach var="r" items="${rates}" varStatus="status">
		<tr class="${(lineCounter % 2 == 0) ? 'Distinct' : "" }">
			<td>${status.count}</td>
			<td><a href="javascript:chargeSource('${r.rateId}','${r.roomType}')">
			   	${r.rateId}
				</a>
			</td>
			<td>${r.rateDescription}</td>
			<td>${r.roomType}</td>
		</tr>
	</c:forEach>
	</tbody>
</table>

</body>

</html>