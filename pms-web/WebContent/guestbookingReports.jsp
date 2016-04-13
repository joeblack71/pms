<%@ page contentType="text/html"%>
<%@ page pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib uri="/WEB-INF/tlds/reports.tld" prefix='mytag' %>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <!--<link type='text/css' rel="stylesheet" href="css/stylesheet.css">-->
    <link type='text/css' rel="stylesheet" href="css/searchform.css">
    <title>JSP Page</title>
    <script>
    <!--
    function showReservation(res) {
        parameters = "?show=show&hotelId=1" + "&reservation=" + res;
        window.location.href="ReservationServlet" + parameters;
    }
    // -->
    </script>
</head>
<body onload='document.form.sampleValue.select()'>
    <form name="form" action="ReservationReports" method="POST">
    <table class='Search' border="1" cellpadding='4' cellspacing='0'>
    <caption class='Search'>Reservation Search</caption>
    <tbody>
        <tr><td class='NoBorder'>
            <select name="hotelId" readonly>
                    <option value='1'>TESTING HOTEL</option>
            </select>
            <!--
            <select name="sampleField">
                <option value='1'>Daily Report</option>
                <option value='2'>Arrivals / Departures</option>
                <option value='3'>Payable Days (by Arrivals)</option>
            </select>
            -->
            <%--
            <mytag:select matter="QueryReservation" selectedItem="${search.sampleField}" />
            --%>
            <input type="text" name="sampleValue"
                   class='Search' value="${search.sampleValue}" size="20">
            <input class='Search' type="submit" name="send" value="Send Query">
    </table>
    </form>

    <table width='700' rules="groups">
	<colgroup id='reservation'>
		<col width='80' align='center'>
	</colgroup>
	<colgroup id='paxname'>
		<col width='380'>
	</colgroup>
	<colgroup id='stay'>
		<col width='120' align='center' span='2'>
	</colgroup>
	<colgroup id='status'>
		<col width='80' align='center'>
	</colgroup>
	<thead style='background: whitesmoke'>
            <tr><th>Reservation<th>Pax Names<th>Arrival<th>Departure<th>Status
            <%--
            <c:if test="${!empty search.sampleValue}">
                <mytag:reservation field='${search.sampleField}' pattern='${search.sampleValue}' />
            </c:if>
            --%>
                <c:forEach var="res" items="${list}">
                <tr><td><a href="javascript:showReservation(${res.reservation})">${res.reservation}
                    <td>${res.lastname1}, ${res.firstname}
                    <td><fmt:formatDate pattern="dd-MM-yyyy" type="date" value="${res.arrival}" />
                    <td><fmt:formatDate pattern="dd-MM-yyyy" type="date" value="${res.departure}" />
                    <td>${res.status}
                </c:forEach>
    </table>

</body>
</html>
