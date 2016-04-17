
<%@ page contentType="text/html"
         info="This page show a chart with occupation information"
%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%-- <%@ page errorPage="errorPage.jsp" %> --%>

<%--
TODO: La pagina debe mostar las habitaciones disponibles, no las ocupadas !!
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
    <style></style>
    <script type="text/javascript" languaje="JavaScript">
    <!--
    function loadDocument() {
        document.frmFilter.startDate.select();
    }

    function openDetail(occday) {
        URL = "reservationDetail.jsp?hotelId=" +
             this.frmFilter.hotelId.value + "&occupationDay="+occday;
        appereance = "width=900,height=555,left=50,top=100," +
                     "scrollbars=yes,resizable=no,status=no";
        //if ( confirm(occday) )
        window.open(URL,"occupation",appereance);
    }
    // -->
    </script>
</head>

<body onload="loadDocument()">
    <br><br>
<table align="center" style="width: 800; height: 494;">
<tbody class="Layout">
<tr><td>
    <table id="availability">
    <caption class="Search">Occupied Rooms</caption>
    <tbody class="Search">
        <tr><td colspan="9" id="pattern">
            <form name="frmFilter" method="post" action="AvailabilityShow.do">
                <select name="hotelId" class="Large" id="hotelId" DISABLED>
                    <option value="1" selected> UNIDAD HOTELERA</option>
                </select>
                <!-- TODO: Add: MONTH, QUARTER & YEAR -->
                <select name="period" class="Large">
                    <option value="1" selected>SEMANAL</option>
                </select>
                <input type="text" name="startDate" value="${param["startDate"]}"
                       class="Large" id="startDate" maxlength="10">
                <input type="submit" class="button" name="show" value="Show">
                <input type="submit" class="button" name="next" value="Next">
            </form>
    </table>

    <tr><td>
    <table id="matrix" rules="groups">
    <!--    
        <caption></caption>
    -->
    <col width="120" align="left">
    <colgroup><col span="7"></colgroup>
    <col width="100">
        <%-- <rpt:availability matrix="<%= (String[][])request.getAttribute("matriz") %>" /> --%>
<%  String[][] matrix = (String[][])request.getAttribute("matriz"); %>
<c:if test="${!empty matriz}">
    <c:set var="rows" value="<%= String.valueOf( matrix.length ) %>"></c:set>
    <c:set var="cols" value="<%= String.valueOf( matrix[0].length ) %>"></c:set>
        <thead>
            <tr><th>Room Type
                    <c:forEach var="day" items="${matriz[0]}" varStatus="i"
                               begin="1" end="${cols - 2}">
                <td><a href='javascript:openDetail("${day}")'>${day}</a>
                    </c:forEach>
                <th>Total

        <tbody>
            <tr><td>&nbsp;<td colspan="${cols - 2}">&nbsp;<td>&nbsp;

                <c:forEach var="row" items="${matriz}" begin="1" end="${rows - 2}">
            <tr align="right">
                <th>${row[0]}
                    <c:forEach var="roomsByType" items="${row}" begin="1" end="${cols}">
                <td>${roomsByType}
                    </c:forEach>
                </c:forEach>

            <tr><td>&nbsp;<td colspan="${cols - 2}">&nbsp;<td>&nbsp;

        <tfoot>
            <tr><th>Total Rooms
                    <c:forEach var="totalByType" items="${matriz[3]}"
                               begin="1" end="${cols - 1}">
                <th>${totalByType}
                    </c:forEach>
    </table>
</c:if>
</table>
<!--
TODO: Test build an html page with availability (avilability.html) and put here
<iframe src="availability.html" name="ifrAvailability"
    frameborder="1" width="620" height="400">
</iframe>
-->
</body>

</html>