
<%@page contentType="text/html"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri='/WEB-INF/tlds/reports.tld' prefix="mytag"%>

<%@ taglib uri="http://displaytag.sf.net" prefix="display"%>

<html>
<head>
<meta http-equiv="Expires=-1" content="text/html; charset=iso-8859-1" />
<meta http-equiv="Content-Style-Type" content="text/css" />
<link rel='stylesheet' type='text/css' href="../../css/stylesheet.css" />
<link rel='stylesheet' type='text/css' href="../../css/displaytag.css" />
<title>Busqueda de Reservas</title>

<script type='text/javascript'>
	<!--
	function editItem(idHotel,idReservation) {
	 	var uri = "../../ReservationEdit.do";
	    var parameters = "?idHotel=" + idHotel + "&idReservation=" + idReservation;
	    var appereance = "menubar=0,toolbar=0,location=0,status=0,scrollbars=0,resizable"
	        appereance += ",height=540,width=940,left=40,top=60";

	    //var resWindow = window.open(uri + parameters,"reservationForm",appereance);
	    //resWindow.focus();

        alert(uri + parameters);

        window.location.href = uri + parameters;

	}

	function decideSearch(event) {
		if ( event.keyCode != '13' ) return;
		
		searchItem();
	}	

	function searchItem() {
		var form = document.getElementById('searchForm');
		
		form.action = "ReservationList.do";
		form.submit();
	}

	function loadDocument() {
		var form = document.getElementById('searchForm');

	    form.guestName.focus();
	}
	  
	window.onload = function() {
		loadDocument();
	} 
	// -->
</script>
</head>

<c:set var="radioColClass" value="icons" />
<c:set var="numberColClass" value="number" />
<c:set var="idReservationColClass" value="icons" />
<c:set var="idSourceColClass" value="text" />
<c:set var="arrivalColClass" value="icons" />
<c:set var="departureColClass" value="icons" />
<c:set var="statusColClass" value="icons" />

<c:set var="radioColWidth" value="20" />
<c:set var="numberColWidth" value="20" />
<c:set var="idReservationColWidth" value="40" />
<c:set var="idSourceColWidth" value="40" />
<c:set var="arrivalColWidth" value="80" />
<c:set var="departureColWidth" value="80" />
<c:set var="statusColWidth" value="20" />
<c:set var="tableWidth"
	value="${radioColWidth
    + numberColWidth    + idReservationColWidth
    + idSourceColWidth  + arrivalColWidth
    + departureColWidth + statusColWidth}" />
<c:set var="searchTableWidth" value="400" />
<%--c:set var="tableContainerWidth" value="${tableWidth}"/--%>

<c:set var="radioColStyle" value="width:${radioColWidth}px" />
<c:set var="numberColStyle" value="width:${numberColWidth}px" />
<c:set var="idReservationColStyle"
	value="width:${idReservationColWidth}px" />
<c:set var="idSourceColStyle" value="width:${idSourceColWidth}px" />
<c:set var="arrivalColStyle" value="width:${arrivalColWidth}px" />
<c:set var="departureColStyle" value="width:${departureColWidth}px" />
<c:set var="statusColStyle" value="width:${statusColWidth}px" />

<c:set var="tableStyle" value="width:700px" />
<%--c:set var="tableContainerStyle" value="width:${tableContainerWidth}px" /--%>
<c:set var="searchTableStyle" value="" />

<body>
<c:set var="form" value="${ReservationListForm}" />
<form name='searchForm' id="searchForm" method='post'>
<table class='SearchForm' align="center">
	<!--caption class='Form'>Search information</caption-->
	<tbody>
	<tr>
		<td class="label">
			<label>Hotel</label></td>
		<td>
			<select name='filter.idHhotel' id='idHotel'>
				<option value='${idHotel}' selected>Unidad Hotelera</option>
			</select>
			<a href="javascript:searchItem()" title="Search pattern">
				<img alt="Search pattern" src="../../images/lupa02.jpg"
					class="Tool" onclick="searchItem()" /></a>
			<a href="javascript:editItem('','')" title="Make a new reservation">
				<img alt="New Reservation" src="../../images/nuevo04.jpg"
					class="Tool" onclick="editItem('','')" /></a>
		<%--mytag:select matter="QueryReservation" selectedItem="${search.sampleField}" /--%>
		</td>
	</tr>
	<tr>
		<td class="label">
			<label>Guest name</label></td>
		<td colspan="2">
			<input type='text' name='filter.guestName' id='guestName'
				value='${form.filter.guestName}' onkeyup="decideSearch(event)"
				class='Large' maxlength='40'
				title='Input pattern to look for ..' />
		</td>
	</tr>
	</tbody>
	<!--tfoot>
		<tr><td class="label" colspan="2"><label>Ingrese parametros de busqueda</label>
		</td></tr>
	</tfoot-->
</table>
</form>

<div align="center">
<display:table name="${form.reservations}" id="item"
	requestURI="ReservationList.do" excludedParams=""
	class="dtlist" style="${tableStyle}" pagesize="10"
	sort="list"	defaultsort="0" defaultorder="ascending"
	export="false" cellspacing="0" cellpadding="2">
	<display:column title="&nbsp;" class="${radioColClass}"
		style="${radioColStyle}">
		<input type="radio" name="idReservation" value="${item.idReservation}"
			onmouseover="" onmouseout="" />
	</display:column>
	<display:column title="N&deg;" sortable="true" sortName="rownum"
		value="${item_rowNum}" class="${numberColClass}"
		style="${numberColStyle}" />
	<display:column title="<br/>Reservation" media="html" sortable="true"
		class="${idReservationColClass}" style="${idReservationColStyle}">
		<a href="javascript:editItem('${item.idHotel}','${item.idReservation}')"
			onmouseover="" onmouseout=""
			title="Editar el registro"> ${item.idReservation} </a>
	</display:column>
	<display:column title="<br/>Source of Bussiness" property="idSource"
		sortable="true" class="${idSourceColClass}"
		style="${idSourceColStyle}" />
	<display:column title="<br/>Arrival" property="arrival" sortable="true"
		class="${arrivalColClass}" style="${arrivalColStyle}" />
	<display:column title="<br/>Departure" property="departure"
		sortable="true" class="${departureColClass}"
		style="${departureColStyle}" />
	<display:column title="<br/>Status" property="status" sortable="true"
		class="${statusColClass}" style="${statusColStyle}" />
	<%--display:column title="<br/>Creado" 	   		 property="fechaCreacion"
	    	sortable="true" class="${creadoColClass}" style="${creadoColStyle}" /--%>
</display:table>
</div>
</body>
</html>