<%@ page contentType="text/html;charset=ISO-8859-1" %>
<%-- <%@ page errorPage="errorPage.jsp" %> --%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<%-- TODO: Mover etiquetas <select> a tag customizados --%>

<%@ page import="com.mycom.booking.beans.*" %>
<%@ page import="com.mycom.booking.libraries.DateManager" %>

<jsp:useBean id='res' class="com.mycom.booking.beans.Reservation" scope='session' />

<HTML>
<HEAD>
    <META http-equiv="Expires=-1" content="text/html; charset=iso-8859-1">
    <META http-equiv="Content-Style-Type" content="text/css">
    <META http-equiv="Content-Script-Type" type="text/javascript">
    <!-- TODO: probar. Parece refrescar la pantalla
    <META http-equiv="refresh"
          content="4; url=http://localhost:8080/servlet/bookstore;">
     -->
    <TITLE>Reserva</TITLE>
    <LINK rel='stylesheet' type='text/css' href="stylesheet.css">
    <STYLE> BODY { background: inherit; }<!--#FAFAFA-->
            /*button, IMG { height: 16px; width: 12px; }*/
            TEXTAREA { /*color: royalblue;*/
                       width: 492px;
                       margin-left: 4px; }
            /*tr { margin-left: 40px;
                 margin-right: 40px;
            }*/
    </STYLE>
    <SCRIPT language='JavaScript' src="js/reservationValidate.js"></SCRIPT>
    <!--<SCRIPT language='JavaScript' src="js/reservationButtons.js"></SCRIPT>-->
    <SCRIPT type='text/javascript' language='JavaScript'>
    <!--
    function loadDocument(){
        document.frmres.reservation.select();
    }

    function searchReservation(){
        URL = "reservationSearch.jsp";
        appeareance = "width=700,height=450,left=50,top=100,scrollbars=yes,status=yes";
        refsearch = window.open(URL,"search",appeareance);
    }

    function showAvailability() {
        URL = "AvailabilityServlet?startDate=" + frmres.arrival.value +
              "&period=1&show=Mostrar";
        appeareance = "width=860,height=460,left=50,top=100,scrollbars=yes,status=yes";
        window.open(URL,"availability",appeareance);
    }

    function mngGuests(button) {
        guestId = frmres.guestname.value;
        if ( button == "addGuest" )
             reference = "customer.jsp";
        else reference = "GuestReservationServlet?remGuest=remGuest&customerId="+guestId;
        window.location.href = reference;
    }

    function selectSource(source) {
        //if ( source == "roomType" )
        //    URL = "sourceSearch.jsp?roomType=" + frmres.roomType.value;
        if ( source == "buttonSource" )
            URL = "sourceSearch.jsp?roomType=" + frmres.roomType.value;
        appeareance = "width=600,height=450,left=50,top=100,scrollbars=yes,status=yes";
        refsearch = window.open(URL,"search",appeareance);
        //window.reload();
    }

    /* FUNCIONES INCLUIDAS EN validateform.jsp QUITAR DESPUES DE PRUEBAS */
    function newReservation() {
        window.location.href = "ReservationServlet?new=";
    }
    function showReservation(reservation) {
        //return true;
        frmres.submit();
    }
    function saveReservation(reservation) {
        return true;
    }
    function disableSaveButton(){}
    function validateSubmit() {
        return true;
    }
//-->
    </SCRIPT>
</HEAD>

<!-- antiqueWhite, blanchedalmond, -->
<body onLoad='loadDocument()'>
    <form name='frmres' action="ReservationServlet" method="post"
          onSubmit='return validateSubmit()'>
               <!-- cellpadding='0' -->
    <table class='Form' align='center' cellpadding='4' style="border-bottom: 0px">
        <caption class="Form">
                <div align='right'>
                Res #&nbsp;${res.reservation}&nbsp;-
                <c:forEach var='item' items='${resStatus}'>
                    <c:if test="${ item.stringId eq res.status }" >
                        ${item.description}
                    </c:if>
                </c:forEach>&nbsp;
                </div>
                <%-- TODO: Traer el primer elemento del Hashtable que no sea nulo.
                <c:set var='g' value='${res.guests["1"].value}' />
                --%>
                <c:set var="cancel" value="${42}" />
                <c:forEach var='item' items='${res.guests}' end='0'>
                    <c:set var='g' value='${item.value}' />
                    <c:if test="${g.status != cancel}">
                        ${g.customerName}
                    </c:if>
                </c:forEach>
                <c:if test="${empty reg.guests}"><br></c:if>
        </caption>
        <!--
        <colgroup>
            <col class='Title' align='left' width='160'>
        </colgroup>
        <colgroup>
            <col class='Right' align='char' char=':'>
        </colgroup>
        -->

        <thead style='background: inherit;' />
            <tr><td colspan='2'>&nbsp;
                <!-- TODO: AL ENVIAR EL FORMULARIO TODOS LOS SUBMIT CONTIENEN VALORES
                <button type='submit' name='show' value='show' class='Bar'
                        onclick='showReservation(document.frmres.reservation.value)'>
                    <img alt='Show Reservation' src=''>
                </button>
                -->
                <button type="button" name='new' value='new' class="Tool" tabindex='1'
                        onclick='newReservation()'>
                    <img alt='New Reservation' src='images/nuevo04.jpg'>
                </button>
                <input type='button' name='availability' value='Avail.'
                       class='Tool' id='availability'
                       onClick="showAvailability()">
                <input type='submit' name='show'
                       class='Tool' value="Show"
                       onClick='showReservation(document.frmres.reservation.value)'>
                <input type='submit' name='save'
                       class='Tool' value="Save"
                       onClick='saveReservation(document.frmres.reservation.value)'>
                <!--
                <a name='search' value='search' class="Tool" tabindex='2'
                        onclick='searchReservation()'>
                    <img alt='Search Reservation' src='images/lupa01.jpg'>
                </a>
                <a name='save' value='save' class='Tool' tabindex='3'
                        onclick='saveReservation(document.frmres.reservation.value)'>
                    <img alt='Save Reservation' src='images/save.gif'>
                </a>
                -->
        
        <tfoot class='Form'>
            <tr><td colspan='2' align='right'>
                    Updated:&nbsp;${res.updatedOn}&nbsp;

<%  String selected=""; %>
        <tbody>
            <tr><td><label for='reservation'>Reservation</label>
                <td><input type='text' name='reservation'
                           maxlength='5' value='${res.reservation}'
                           class='Large Box Remark Number' id='reservation'
                           title="Reservation code (autogenerated)">
                    <select name='status' class='Large' id='status'>
                            <c:forEach var='item' items='${resStatus}'>
                                <c:if test="${ item.stringId eq res.status }" >
                                    <c:set var='selected' value='SELECTED' />
                                </c:if>
                        <option value='${item.stringId}' ${selected}> ${item.description}
                            </c:forEach>
                    </select>

            <tr><td><label for='arrival'>
                        Arrival<span style="color: silver">&nbsp;||&nbsp;</span>Departure
                    </label>
                <td><input type='text' name='arrival'
                           maxlength='10'
                           value='<%= res.getFormattedArrival() %>'
                           <%--<fmt:formatDate value='${res.arrival}' pattern="dd/MM/yy"/>--%>
                           class='Large Box Remark Number' id='arrival' 
                           title="Arrival (DDMMYY)" onChange=''
                           onKeyUp='disableSaveButton(document.frmres)'>
                    <input type='text' name='departure'
                           maxlength='10'
                           value='<%= res.getFormattedDeparture() %>'
                           <%--<fmt:formatDate value='${res.departure}' pattern="dd/MM/yy"/>--%>
                           class='Large Box Number' id='departure'
                           title="Departure (DDMMYY)" onChange=''
                           onKeyUp='disableSaveButton(document.frmres)'>

            <tr><td><label for='nights'>Nights Stay</label>
                <td><input type='text' name='nights'
                           maxlength='3' value='${res.nights}'
                           class='Large Box Remark Number' id='nights'
                           title="Large Number of nights of guest stay"
                           onChange='showTotal(this.form)'>
                    <input type='text' name='nights' disabled
                           maxlength='' value=''
                           class='Large Box Remark Number' id=''
                           title=""
                           onChange=''>

            <tr><td colspan='2'>&nbsp;

            <tr><td><label for='guestname'>Guest Names</label>
                <td><select name='guestname' id="guestname"
                            class='Remark' style='width: 248px;'>
                            <c:forEach var='item' items='${res.guests}'>
                                <c:set var="cancel" value="${42}" />
                                <c:if test="${ item.value.status != cancel}">
                          <option value='${item.key}'>${item.value.customerName}
                                </c:if>
                            </c:forEach>
                    </select>
                    <button type='button' name='addGuest' value='Add' class="Tool"
                            onclick="mngGuests(this.name)">+</button>
                    <button type='button' name='remGuest' value='Remove' class="Tool"
                            onclick="mngGuests(this.name)">-</button>

            <tr><td><label for='document'>
                            Document<span style="color: silver">&nbsp;||&nbsp;</span>Nationality
                    </label>
                <td><input type='text' name='document' readonly
                           maxlength='15' value='09549430'
                           class='Large Box' id='document'
                           title="Document of identification">
                    <input type='text' name='nationality' readonly
                           maxlength='20' value='PERUVIAN'
                           class='Large Box' id='nationality'
                           title="Nationality">

            <tr><td><label for='adults'>
                            Adults<span style="color: silver">&nbsp;||&nbsp;</span>Children
                    </label>
                <td><input type='text' name='adults'
                           maxlength='2' value='<%= res.getAdults() %>'
                           class='Large Box Number' id='adults'
                           title="Large Number of Adults">
                    <input type='text' name='children'
                           maxlength='2' value='${res.children}'
                           class='Large Box Number' id='children'
                           title="Large Number of Children">

            <tr><td>
                <label for='roomNumber'>
                    Room Type<span style="color: silver">&nbsp;||&nbsp;</span>Number
                </label>
                <!-- TODO: Actualizar campo Tarifa y Total cuando cambia tipo-->
                <td><select name='roomType' class='Large'
                            id='roomType' onchange='selectSource(this.name)'>
                            <c:forEach var='item' items='${roomTypes}'>
                                <c:set var='selected' value='' />
                                <c:if test="${ item.roomType eq res.roomType }" >
                                    <c:set var='selected' value='SELECTED' />
                                </c:if>
                        <option value='${item.roomType}' ${selected}> ${item.description}
                            </c:forEach>
                    </select>
                    <input type='text' name='roomNumber'
                           maxlength='7' value='${res.roomNumber}'
                           class='Large Box Remark Number' id='roomNumber'
                           title="Room Large Number"
                           onChange="showTotal(this.form)">

            <tr><td colspan='2'>&nbsp;

            <tr><td><label>Source | Company</label>
                <td><input type='hidden' name='sourceId'
                           value='${res.sourceId}'>
                    <input type='text' name='sourceNm' READONLY
                           maxlength='5' value='${res.sourceName}'
                           class='XLarge Box' style='width: 286px;' id='source'>
                    <button type='button' name='buttonSource'
                           class='Tool' value='...'
                           onclick='selectSource(this.name)'>...
                    </button>

<%--  TODO: Formatear roomRate y totalBalance --%>
            <tr><td><label for='roomRate'>Room Rate</label>
                <td>
                    <select name='package' class='Large' id='package' DISABLED>
<%--                    
                            <c:forEach var='item' items='${packages}'>
                                <c:set var='selected' value='' />
                                <c:if test="${ item.packageId eq res.packageCode }" >
                                    <c:set var='selected' value='SELECTED' />
                                </c:if>
                        <option value='${item.elementId}' ${selected}> ${item.description}
                            </c:forEach>
--%>
                        <option value='' selected>PACKAGE
                    </select>
                    <input type='text' name='roomRate' maxlength='10'
                           value='<fmt:formatNumber value='${res.roomRate}'
                                       type='currency' currencySymbol="$" />'
                           class='Large Box Number' id='roomRate'>

            <!--<tr class='Help'><TH>&nbsp;
                <td colspan='2'>* Large Number of rooms taken by this reservation-->

            <tr><td><label for='quantity'>
                        Qtty Rooms<span style="color: silver">&nbsp;||&nbsp;</span>Due
                    </label>
                <td>
                    <input type='text' name='paymentdue'
                           maxlength='10' value='${res.paymentDue}'
                           class='Large Box Number' id='paymentdue'
                           title="Due Payment">
                    <input type='text' name='quantity'
                           maxlength='3' value='${res.quantity}'
                           class='Large Box Number' id='quantity'
                           title="Quantity of Rooms">

            <tr><td><label for='paymentdue'>
                        Total<span style="color: silver">&nbsp;||&nbsp;</span>Payment Type
                    </label>
                <td>
                    <select name='paymenttype' class='Large'>
                            <c:forEach var='item' items='${payTypes}'>
                                <c:set var='selected' value='' />
                                <c:if test="${ item.elementId eq res.paymentType }" >
                                    <c:set var='selected' value='SELECTED' />
                                </c:if>
                        <option value='${item.elementId}' ${selected}> ${item.description}
                            </c:forEach>
                    </select>
                    <input type='text' name='balance' READONLY
                           value='<fmt:formatNumber value='${res.total}'
                                       type='currency' currencySymbol="$" />'
                           class='Large Box Remark Number'>

            <tr><td colspan='2'>&nbsp;

            <!--
            <tr><td><label for='status'>
                        Attentions<span style="color: silver">&nbsp;||&nbsp;</span>Instructions
                    </label>
            -->
                <%--
                <td><select name='attentions' class='Large' id='status'>
                            <c:forEach var='item' items='${attentions}'>
                                <c:set var='selected' value='' />
                                <c:if test="${ item.elementId eq res.attentionId }" >
                                    <c:set var='selected' value='SELECTED' />
                                </c:if>
                        <option value='${item.elementId}' ${selected}> ${item.description}
                            </c:forEach>
                    </select>
                --%>
        <%--
                <td><select name='attentions' class='Large' id='attentions' DISABLED>
                        <option value='1' selected>SPECIAL ATENTS.
        <!--
                        <option value='1'>Canasta de Frutas
                        <option value='2'>Botella Champagne
                        <option value='3'>Tabla de Quesos
                        <option value='4'>Otras Atenciones
        -->
                    </select>
        --%>
        <!--
        <tr><td colspan='2'>
            <textarea name='instructions' rows='2' cols='40'>${res.instructions}</TEXTAREA>
        -->

        <!--
        <tr><td colspan='2' align='center'>
                <input type='submit' name='show'
                       class='Button Large Remark' value="Show Reservation"
                       onClick='showReservation(document.frmres.reservation.value)'>
                <input type='submit' name='save'
                       class='Button Large Remark' value="Save Reservation"
                       onClick='saveReservation(document.frmres.reservation.value)'>
        -->
    </table>
    </form>

</body>

</html>
