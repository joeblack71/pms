
<%@ page contentType="text/html;charset=ISO-8859-1" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ page import="com.mycom.booking.beans.*" %>
<%@ page import="com.mycom.booking.libraries.DateManager" %>

<jsp:useBean id='rate' class="com.mycom.booking.beans.RoomRate" scope='request' />

<html>
<head>
    <meta http-equiv="Expires=-1" content="text/html; charset=iso-8859-1">
    <meta http-equiv="Content-Style-Type" content="text/css">
    <meta http-equiv="Content-Script-Type" type="text/javascript">
    <!-- TODO: probar. Parece refrescar la pantalla
    <meta http-equiv="refresh"
          content="4; url=http://localhost:8080/servlet/bookstore;">
     -->
    <title>Reserva</title>
    <link rel='stylesheet' type='text/css' href="css/stylesheet.css">
    <style> body { background: inherit; }<!--#FAFAFA-->
            /*button, img { height: 16px; width: 12px; }*/
            TEXTAREA { /*color: royalblue;*/
                       width: 492px;
                       margin-left: 4px; }
    </style>
    <script language='JavaScript' src="js/reservationValidate.js"></script>
    <!--<script language='JavaScript' src="js/reservationButtons.js"></script>-->
    <script type='text/javascript' language='JavaScript'>
    <!--
    function loadDocument(){
        document.frmrate.rateId.select();
    }

    function lookForRates(){
        URL = "rateSearch.jsp";
        appeareance = "width=700,height=450,left=50,top=100,scrollbars=yes,status=yes";
        // 'refsearch' nos permitira acceder a la ventana
        refsearch = window.open(URL,"search",appeareance);
    }

    function lookForSource(){
        URL = "sourceSearch.jsp";
        appeareance = "width=600,height=450,left=50,top=100,scrollbars=yes,status=yes";
        refsearch = window.open(URL,"search",appeareance);
        //window.reload();
    }

    function validateSubmit() {
        return true;
    }

    function cleanForm() {
        window.location.href = "RoomRateServlet";;
    }

    /* FUNCIONES INCLUIDAS EN validateform.jsp QUITAR DESPUES DE PRUEBAS */
    function showRate(rateId) {
        //return true;
        frmrate.submit();
    }
    function saveRate(rateId) {
        //return true;
        frmrate.submit();
    }
    function disableSaveButton(){}
//-->
    </script>
</head>
<body onLoad=''>
    <form name='frmrate' action="RoomRateServlet" method="post"
          onSubmit='return validateSubmit()'>
    <table class='Form' align='center' cellpadding='4' border="1">
        <caption class='Form'>
                <div align='left'>RATE MANAGER</div><br>
        </caption>

        <thead style='background: aliceblue;'>
            <tr><td colspan="3">&nbsp;
                <button type='button' name='new' value='new'
                        style='height: 24px; width: 32' onclick='cleanForm()'>
                    <img alt='New Reservation' src='images/nuevo04.jpg'>
                </button>
                <button type='button' name='search' value='search'
                        style='height: 24px; width: 32' onclick='lookForRates()'>
                    <img alt='Search Reservation' src='images/lupa01.jpg'>
                </button>
                <input type='submit' name='show'
                       class='Button Remark' value="Show"
                       onclick='showRate(document.frmrate.rateId.value)'>
                <input type='submit' name='save' value="Save"
                       onclick='saveRate(document.frmrate.rateId.value)'>
                <input type='button' name='new' DISABLED value="New"
                       onclick='resetFields(document.frmrate)'>

        <tfoot class='Form'>
            <tr><td colspan="3" align='right'>
                    Updated:&nbsp;${rate.status}&nbsp;

<%  String selected="";%>
        <tbody align="center">
            <tr><td colspan="3">&nbsp;
                
            <tr><td><label for='roomNumber'>Room Type</label>
                <td><select name='roomType' class='Large' id='roomType'>
                            <c:forEach var="type" items="${roomTypes}">
                                <c:set var="selected" value="" />
                                <c:if test="${rate.roomType == type.roomType}">
                                      <c:set var="selected" value="selected" />
                                </c:if>
                        <option value='${type.roomType}' ${selected}>${type.description}
                                </c:forEach>
                    </select>
                    <td>&nbsp;
            
            <tr><td><label for='roomNumber'>Room Type</label>
                <td><select name='rateId' class='Large' id='rateId'>
                            <c:forEach var="spRate" items="${spRates}">
                                <c:set var="selected" value="" />
                                <c:if test="${rate.rateId == spRate.elementId}">
                                      <c:set var="selected" value="selected" />
                                </c:if>
                        <option value='${spRate.elementId}' ${selected}>${spRate.description}
                                </c:forEach>
                    </select>
                    <td>&nbsp;

            <tr><td colspan="3">&nbsp;

                <!--<tr><td><label>Rate by Demand</label>-->

            <tr><td>&nbsp;
                <td><label>High season</label>
                <td><label>Low season</label>

            <tr><td><label for='dowHighSeasonRate'>Day of week</label>
                <td><input type='text' name='dowHighSeasonRate'
                           maxlength='5' value='${rate.dowHighSeasonRate}'
                           class='Large Box Number'
                           title="Large Number of Adults">
                <td><input type='text' name='eowHighSeasonRate'
                           maxlength='5' value='${rate.eowHighSeasonRate}'
                           class='Large Box Number'
                           title="Large Number of Children">

            <tr><td><label for="hdowSeason">End of week</label>
                <td><input type='text' name='dowLowSeasonRate'
                           maxlength='5' value='${rate.dowLowSeasonRate}'
                           class='Large Box Number'
                           title="Quantity of Rooms">
                <td><input type='text' name='eowLowSeasonRate'
                           maxlength='5' value='${rate.eowLowSeasonRate}'
                           class='Large Box Number'
                           title="Due Payment">

            <tr><td colspan="3">&nbsp;

    </table>
    </form>

</body>

</html>
