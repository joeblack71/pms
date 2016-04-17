
<%@ page contentType="text/html" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@ taglib uri="http://displaytag.sf.net" prefix="display" %>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 //EN"
          "http://www.w3.org/TR/html4/strict.dtd">

<html>
<head>
  <meta http-equiv="Expires=-1" content="text/html; charset=iso-8859-1">
  <meta http-equiv="Content-Style-Type" content="text/css">
  <link rel='stylesheet' type='text/css' href="css/stylesheet.css">
  <link rel='stylesheet' type='text/css' href="css/displaytag.css" />
  <title>Company search</title>
  <script type='text/javascript' languaje='js/JavaScript'>
  <!--
  window.onload = function() {
      window.focus();
      document.SourceForm.sampleValue.select();
  }

  function sendForm(){
      document.frmsearch.show.click();
  }

  function editItem(idSource) {
  	var uri = "sourceEdit.do";
    var parameters = "?idSource=" + idSource;
    var appereance = "toolbar=0,location=0,status=0,menubar=0,"
        appereance += "width=580,height=640,left=300,top=40";
    var winSource = window.open(uri + parameters,"sourceForm",appereance);

    winSource.focus();
  }
  // -->
  </script>
</head>

<body>

<c:set var="form" value="${SourceListForm}" />

<form name='SourceForm' id='SourceForm' method='post'>
  <table class='SearchForm' width='100%'>
    <caption class='Search'>Search information</caption>
    <tr>
      <td align='center'>
          <select name='idHotel' id='idHotel'>
              <option value='1' selected>Unidad Hotelera 1</option>
          </select>
          <select name='sampleField' id='sampleField'>
              <option value='firmName'>Firm Name</option>
              <option value='commName'>Commercial Name</option>
              <option value='rucNumber'>RUC Number</option>
          </select>
          <input type='text' name='pattern' id='pattern'
                 value='${query.sampleValue}' maxlength='20'>
          <input type='submit' name='report' value='Show'>
         </td>
	</tr>
  </table>
</form>

<%--table width='100%' rules="groups">
    <colgroup>
        <col width='80' align='center'>
    </colgroup>
    <colgroup>
        <col width='280'>
    </colgroup>
    <thead>
	    <tr>
	        <th>RUC</th>
	        <th>Source Name</th>
	    </tr>
	</thead>

	<tbody>
	<c:forEach var='item' items='${SourceForm.items}' varStatus="status">
	    <tr class='${ ( status.count % 2 == 0 ) ? "Distinct" : "" }'>
			<td><a href="javascript:sourceEdit('${item.map.idSource}')">
			    ${item.map.documentNumber}</a></td>
			<td>${item.map.sourceName}</td>
		</tr>
	</c:forEach>
	</tbody>
</table--%>

<c:set var="radioColClass" value="icons" />
<c:set var="numberColClass" value="number" />
<c:set var="idSourceColClass" value="icons" />
<c:set var="sourceNameColClass" value="text" />
<c:set var="statusColClass" value="icons" />

<c:set var="radioColWidth" value="10" />
<c:set var="numberColWidth" value="10" />
<c:set var="idSourceColWidth" value="15" />
<c:set var="sourceNameColWidth" value="65" />
<c:set var="statusColWidth" value="10" />

<c:set var="tableWidth"
	value="${radioColWidth
    + numberColWidth + idSourceColWidth
    + sourceNameColWidth}" />
<%--c:set var="searchTableWidth" value="400" /--%>
<%--c:set var="tableContainerWidth" value="${tableWidth}"/--%>

<c:set var="radioColStyle" value="width:${radioColWidth}%" />
<c:set var="numberColStyle" value="width:${numberColWidth}%" />
<c:set var="idSourceColStyle" value="width:${idSourceColWidth}%" />
<c:set var="sourceNameColStyle" value="width:${sourceNameColWidth}%" />
<c:set var="statusColStyle" value="width:${statusColWidth}%" />

<c:set var="tableStyle" value="width:${tableWidth}%" />
<%--c:set var="tableContainerStyle" value="width:${tableContainerWidth}px" /--%>
<c:set var="searchTableStyle" value="" />

<div align="center">
<c:out value="${fn:length(form.list)}" />
<display:table
	name="${form.list}" id="item"
	requestURI="sourceList.do"
	excludedParams=""
	sort="list"	defaultsort="0" defaultorder="ascending"
	class="dtlist" style="${tableStyle}" pagesize="20"
	cellspacing="0" cellpadding="2"
	export="false"
	>
	<display:column title="&nbsp;" class="${radioColClass}"	style="${radioColStyle}">
		<input type="radio" name="idSource" value="${item.map.idSource}" />
	</display:column>
	<display:column title="N&deg;" media="html"
		sortable="true" sortName="rownum" class="${numberColClass}"	style="${numberColStyle}">
		<a href="javascript:editItem('${item.map.idSource}')"
			title="Editar el registro">${item_rowNum}</a>
	</display:column>
	<display:column title="<br/>Id Source" property="idSource"
		sortable="true" class="${idSourceColClass}" style="${idSourceColStyle}">
	</display:column>
	<display:column title="<br/>Source of Bussiness" property="sourceName"
		sortable="true" class="${sourceNameColClass}"	style="${sourceNameColStyle}" />
	<%--display:column title="<br/>Status" property="status"
		sortable="true"	class="${statusColClass}" style="${statusColStyle}" /--%>
	<%--display:column title="<br/>Creado" 	   		 property="fechaCreacion"
	    	sortable="true" class="${creadoColClass}" style="${creadoColStyle}" /--%>
</display:table>
</div>

</body>

</html>