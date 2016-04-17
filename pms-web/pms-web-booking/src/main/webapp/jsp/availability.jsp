
<%@ page contentType="text/html"
         info="This page show a chart with occupation information"
%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@ taglib tagdir="/WEB-INF/tags" prefix="t" %>

<%-- <%@ page errorPage="errorPage.jsp" %> --%>

<%--
TODO: La pagina debe mostar la disponibilidad, no la ocupacion !!
--%>

<!--
<!DOCTYPE html PUBLIC "-//W3C//DTD html 4.01 //EN"
          "http://www.w3.org/tr/html4/strict.dtd">
-->
<html>
<head>
    <meta http-equiv="Expires=-1" content="text/html; charset=iso-8859-1">
    <meta http-equiv="Content-Style-Type" content="text/css">
    <link rel="stylesheet" type="text/css" href="css/availability.css">
    <title>Rooms Occupation</title>
    <script type="text/javascript" language="javascript">
    <!--
    function openDetail(occday) {
    	var form = document.getElementById('filterForm');
    	alert(occday) 
        URL = "ReservationList.do?hotelId=" +
             form.idHotel.value + "&occupationDay="+occday;
        appereance = "width=900,height=555,left=50,top=100," +
                     "scrollbars=yes,resizable=no,status=no";
        //if ( confirm(occday) )
        window.open(URL,"occupation",appereance);
    }
    
    function showAvailability() {
    	var form = document.getElementById('filterForm');
    	form.action = "ShowRoomTypeAvailability.do";
    	if ( validateForm() ) {
    		form.submit();
    	} else {
    		alert("Error en datos del formulario");
    	}
    }
    ///
    // VALIDACION DE FORMULARIO
    ///

	function validateForm() {
		var result = true;
		var form = document.getElementById('filterForm');

		result = result & validateNotEmpty(form.idHotel);
		result = result & validateNotEmpty(form.period);

        /* El submit no reconoce el valor de result (0 o 1) 
         */
		if (result) {
			return true;
		} else {
			return false;
		}
	}
    
	function validateNotEmpty(textfield) {
	    var result = true;

	    if (!textfield.value) {
	        textfield.style.backgroundColor = '#ffc'; //'light-yellow';
	        result = false;
	    } else {
	        textfield.style.backgroundColor = 'white';
	        result = true;
	    }

	    return result;
	}
    
    ///
    
    function loadDocument() {
        document.getElementById('startDate').select();
    }

    window.onload = function() {
    	loadDocument();
    	window.focus();
    }
    // -->
    </script>
</head>

<body>
<c:set var="form" value="${AvailabilityForm}" />
<form name="filterForm" id="filterForm" method="post">
<!--table align="center">
	<tr><td-->
    <table class="searchForm" width="100%" align="center">
		<tr><td>
			<t:select name="filter.idHotel" id="idHotel"
				value="${form.filter.idHotel}"
				items="${form.hotels}"
				onchange="validateNotEmpty(this)"
			/>
			<t:select name="filter.roomType" id="roomType"
				value="${form.filter.roomType}"
				items="${form.roomTypes}"
				onchange="validateNotEmpty(this)"
			/>
	        <input type="text"
				name="filter.startDate" id="startDate" value="${form.filter.startDate}"
				class="Large" maxlength="10">
			<t:select name="filter.period" id="period"
				value="${form.filter.period}"
				items="${form.periodTypes}"
				onchange="validateNotEmpty(this)"
			/>
	        <label>
        		<!--input type="checkbox" name="filter.status" id="status"	value="C"-->
        		<t:checkbox name="filter.status" id="status"
        			value="C" test="${form.filter.status == 'C'}"></t:checkbox>Confirmed
	        </label>
	        <input type="submit" name="button" value="Show" onclick="showAvailability()">
	        <input type="submit" name="button" value="Next" onclick="showAvailability()">
	    </td></tr>
    </table>
    <!--/td></tr>
</table-->
</form>

<c:if test="${!empty matriz}">
<!--table align="center">
    <tr><td class="tableContainer"-->
		<c:if test="${!empty matriz}">
		    <c:set var="rows" value="${fn:length(matriz)}" />
		    <c:set var="cols" value="${fn:length(matriz[0])}" />
    <table class="chart" rules="groups" width="100%">
    <colgroup><col width="15%" align="left" /></colgroup>
    <colgroup><col span="${cols - 2}" /></colgroup>
    <colgroup><col width="10%" /></colgroup>
	<caption>Availability Rooms</caption>
	<tbody>
	    <tr><th>Room Type</th>
	            <c:forEach var="day" items="${matriz[0]}"
	            	varStatus="i" begin="1" end="${cols - 2}">
	        <td class="detail" style="text-align: center"><a href='javascript:openDetail("${day}")'>${day}</a></td>
	            </c:forEach>
	        <th>Total</th>
		</tr>
	</tbody>

	<tbody>
	    <tr>
	    	<td>&nbsp;</td>
	    	<td colspan="${cols - 2}" class="detail">&nbsp;</td>
	    	<td>&nbsp;</td>
	    </tr>
	        <c:forEach var="row" items="${matriz}" begin="1" end="${rows - 2}">
	    <tr>
	        <th>${row[0]}</th>
	            <c:forEach var="roomsByType" items="${row}" begin="1" end="${cols}">
	        <td class="number">${roomsByType}</td>
	            </c:forEach>
	    </tr>
	        </c:forEach>
	
	    <tr><td>&nbsp;</td>
	    	<td colspan="${cols - 2}">&nbsp;</td>
	    	<td>&nbsp;</td>
	    </tr>
	</tbody>

	<tfoot>
	    <tr><th>Total Rooms</th>
	            <c:forEach var="totalByType" items="${matriz[3]}"
	                       begin="1" end="${cols - 1}">
	        <td class="number"><b>${totalByType}</b></td>
	            </c:forEach>
		</tr>
	</tfoot>
    </table>
		</c:if>
    <!--/td></tr>
</table-->
</c:if>
<!--
TODO: Test build an html page with availability (avilability.html) and put here
<iframe src="availability.html" name="ifrAvailability"
    frameborder="1" width="620" height="400">
</iframe>
-->
</body>

</html>