<%@ page contentType="text/html;charset=ISO-8859-1"%>
<%-- <%@ page errorPage="errorPage.jsp" %> --%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<%--
TODO: Mover etiquetas <select> a tag customizados
--%>

<html>
<head>
<%--
TODO: probar. Parece refrescar la pantalla
<meta http-equiv="refresh"
      content="4; url=http://localhost:8080/servlet/bookstore;">
--%>
<meta http-equiv="Expires=-1" content="text/html; charset=iso-8859-1" />
<meta http-equiv="Content-style-Type" content="text/css" />
<meta http-equiv="Content-script-Type" type="text/javascript" content="" />
<title>Reserva</title>
<link rel="stylesheet" type="text/css" href="css/stylesheet.css" />
<style type="text/css">
body {
	/* testing values: antiquewhite, linen, oldlace, snow, blanchedalmond */
	background: whitesmoke;
}

table#frmReservation {
	width: 420px;
}

textarea#instructions {
	width: 492px;
	margin-left: 0px;
}

button img {
	height: 32px;
	width: 32px;
}

label.textc {
	color: orange;
	/*background: silver;*/
	text-align: center;
	vertical-align: middle;
	font-size: .9em;
	font-family: verdana;
	font-weight: bold;
	width: 160px;
	height: 24px;
}

.medium { width: 160px; }

</style>

<%-- TODO: Revisar. Genera un error al cargar la pagina
<script type="text/javascript" src="js/validateForm.js" />
--%>
<!--
<script type="text/JavaScript" src="js/prototype.js"></script>
-->

<script type="text/javascript">
    <!--
    function loadDocument() {
    	form = document.getElementById("ReservationForm");
        //form.reservation.select();
    }

    function searchReservation() {
        URL = "reservationSearch.jsp";
        appeareance = "width=700,height=450,left=50,top=100,scrollbars=yes,status=yes";
        refsearch = window.open(URL,"search",appeareance);
    }

    function showAvailability() {
    	form = document.getElementById("ReservationForm");
        URL = "AvailabilityServlet?startDate=" + form.arrival.value +
              "&period=1&show=Mostrar";
        appeareance = "width=860,height=460,left=50,top=100,scrollbars=yes,status=yes";
        window.open(URL,"availability",appeareance);
    }

    function mngGuests(button) {
        if ( button == "addGuest" )
             reference = "customer.jsp";
        else reference = "GuestReservationServlet?remGuest=remGuest&customerId="+guestId;
        window.location.href = reference;
    }

    function selectSource(source) {
    	form = Document.getElementById("ReservationForm");
        //if ( source == "roomType" )
        //    URL = "sourceSearch.jsp?roomType=" + form.roomType.value;
        if ( source == "buttonSource" )
            URL = "sourceSearch.jsp?roomType=" + form.roomType.value;
        appeareance = "width=600,height=450,left=50,top=100,scrollbars=yes,status=yes";
        refsearch = window.open(URL,"search",appeareance);
        //window.reload();
    }

    /* FUNCIONES INCLUIDAS EN validateform.jsp QUITAR DESPUES DE PRUEBAS */
    function newReservation() {
        window.location.href = "ReservationServlet?new=";
    }
    
    function showReservation() {
    	var resNumber = document.getElementById("reservation").value;
    	if ( validReservationNumber(resNumber) ) {
	        window.location = "ReservationShow.do?resNumber="+resNumber;
        }
    }
    
    function validReservationNumber(resNumber) {
    	// TODO crear validacion
    	return true;
    }
    
    function saveReservation(reservation) {
    	var resNumber = document.getElementById("reservation").value;
        window.location = "ReservationSave.do?resNumber="+resNumber;
    }
    
    function disableSaveButton(){}
    
    function validateSubmit() {
        return true;
    }
    
    //AJAX functions
	function setRoomRate() {
	    var url = '_RoomRateValue.do';
	    var roomType = $F('roomType');
	    var pars='roomType=' + roomType;
	    var myAjax = new Ajax.Request(
	        url,
	        {
	            parameters: pars,
	            onSuccess: function(transport) {
	                setInnerHTMLForSelect($('roomRate'), transport.responseText);
	            },
	            onFailure: function() {
	                alert('Sorry, Ajax Error');
	            }
	        }
	    );
	}

	// Actualiza rutas
	var R=[['','']
	<c:forEach var="item" items="${ClienteEditForm.rutaDireccionList}">
			,['${item.map.tipo}','${item.map.secuencia}']
	<%--<option value="${item.map.num}" selected="true">${item.map.tipo}-${item.map.secuencia}</option>--%>
	</c:forEach>
	];
	function actualizaRuta(){
		var url = '_ClienteRutaDireccion.do';
		var form = $('editForm');        	
		var index = form.rutaSelect.value;
		var pars='direccion.codigoCliente=' + form.idCliente.value;
		pars=pars+'&direccion.tipoDireccion=' + R[index][0];
		pars=pars+'&direccion.secuencia=' + R[index][1];
		var myAjax = new Ajax.Request(
	        url,
	        {
	            parameters: pars,
	            onSuccess: function(transport) {
	                document.getElementById("rutaDireccionCliente").innerHTML=transport.responseText;
	            },
	            onFailure: function() {
	                alert('Sorry, Ajax Error');
	            }
	        }
	    );
		/*alert(index);
		alert(R[index][0]);
		alert(R[index][1]);*/
	}
        
//-->
</script>

</head>

<body onload="loadDocument()">

<c:set var="res" value="${ReservationForm.item}" scope="request" />
<form name="ReservationForm" method="post"	onSubmit="showReservation()">
<table class="Form" id="frmReservation" align="center" border="0">
	<caption class="Form">
	<span style="text-align: right">
		Res	#&nbsp;${res.reservation}&nbsp;-
		<c:forEach var="item" items="${reservationStatus}">
			<c:if test="${res.status  eq item.status}">
	                ${item.description}
            </c:if>
		</c:forEach>
		&nbsp;
	</span>
	<%-- TODO: Traer el primer elemento del Hashtable que no sea nulo --%>
	<c:set var="cancel" value="${42}" />
	<c:forEach var="guest" items="${res.guests}">
		<c:if test="${guest.value.status != cancel}">
	            ${guest.value.customerNames}
	        </c:if>
	</c:forEach>
	<c:if test="${empty reg.guests}">
		<br />
	</c:if>
	</caption>

	<colgroup>
		<col id="leftLabel">
	</colgroup>
	<colgroup>
		<col id="rightLabel">
	</colgroup>

	<thead class="Toolbar" style="background: peachpuff;" />
	<jsp:include page="toolbar.jsp" />

	<tfoot class="Form">
		<tr>
			<td colspan="2">Last Update:&nbsp;${res.updatedOn}&nbsp;</td>
		</tr>
	</tfoot>
	<tbody>
		<tr>
			<td colspan="2">&nbsp;</td>
		</tr>
		<tr>
			<td><label for="reservation">Reservation:</label></td>
			<td><label for="status">Status:</label></td>
		</tr>

		<tr>
			<td><input type="text" name="item.reservation" id="reservation"
				onchange="showReservation(this.value)" maxlength="5"
				value="${res.reservation}" class="Large Box Remark Number"
				title="Reservation code (autogenerated)"></td>
			<td><select name="res.status" class="Large" id="status">
				<c:forEach var="item" items="${ReservationForm.reservationStatusList}">
					<c:if test="${ res.status eq item.status }">
						<c:set var="selected" value="SELECTED" />
					</c:if>
					<option value="${item.status}"${selected}>
					${item.description}</option>
				</c:forEach>
				</select></td>
		</tr>

		<tr>
			<td colspan="2"><label for="guestname">Guest Names</label></td>
		</tr>

		<tr><td colspan="2">
			<select name="guestname" id="guestname"	class="XLarge Remark">
				<c:forEach var="item" items="${res.guests}">
					<c:set var="cancel" value="${42}" />
					<c:if test="${item.value.status != cancel}">
						<option value="${item.key}">${item.value.customerNames}</option>
					</c:if>
				</c:forEach>
			</select></td>
		</tr>

		<tr>
			<td><label for="document">Document</label></td>
			<td><label for="nationality">Nationality</label></td>
		</tr>

		<tr>
			<td><input type="text" name="document" readonly maxlength="15"
				value="99999999" class="Large Box Number" id="document"
				title="Document of identification"></td>
			<td><label class="textc medium">${nationality}PERUVIAN</label></td>
		</tr>

		<tr>
			<td><label for="arrival">Arrival:</label></td>
			<td><label for="departure">Departure:</label></td>
		</tr>

		<tr>
			<td><input type="text" name="item.arrival" maxlength="10"
				value="${ res.formattedArrival }" class="Large Box Remark Number"
				id="arrival" title="Arrival (DDMMYY)" onChange=""
				onKeyUp="disableSaveButton(document.frmres)"></td>
			<td><input type="text" name="item.departure" maxlength="10"
				value="${ res.formattedDeparture }" class="Large Box Number"
				id="departure" title="Departure (DDMMYY)" onChange=""
				onKeyUp="disableSaveButton(document.frmres)"></td>
		</tr>

		<tr>
			<td><label for="nights">Nights Stay:</label></td>
			<td><label for="nights">Flight:</label></td>
		</tr>

		<tr>
			<td><input type="text" name="item.nights" maxlength="3"
				value="${res.nights}" class="Large Box Remark Number" id="nights"
				title="Large Number of nights of guest stay"
				onChange="showTotal(this.form)"></td>
			<td><input type="text" name="" disabled maxlength=""
				value="" class="Large Box Remark Number" id="" title="" onChange=""></td>
		</tr>

		<tr>
			<td><label for="adults">Adults</label></td>
			<td><label for="adults">Children</label></td>
		</tr>

		<tr>
			<td><input type="text" name="item.adults" maxlength="2"
				value="${res.adults}" class="Large Box Number" id="adults"
				title="Large Number of Adults"></td>
			<td><input type="text" name="item.children" maxlength="2"
				value="${res.children}" class="Large Box Number" id="children"
				title="Large Number of Children"></td>
		</tr>

		<!-- TODO: Actualizar campo Tarifa y Total cuando cambia tipo-->
		<tr>
			<td><label for="roomNumber">Room Type</label></td>
			<td><label for="roomNumber">Room Number</label></td>
		</tr>

		<tr>
			<td><select name="item.roomType" class="Large" id="roomType"
				onchange="selectSource(this.name)">
				<c:forEach var="item" items="${ReservationForm.roomTypeList}">
					<c:set var="selected" value="" />
					<c:if test="${ res.roomType eq item.roomType }">
						<c:set var="selected" value="SELECTED" />
					</c:if>
					<option value="${item.roomType}"${selected}>
					${item.description}</option>
				</c:forEach>
			</select></td>
			<td><input type="text" name="item.roomNumber" maxlength="7"
				value="${res.roomNumber}" class="Large Box Remark Number"
				id="roomNumber" title="Room Large Number"
				onChange="showTotal(this.form)"></td>
		</tr>

	</tbody>
	<tbody>
		<tr>
			<td colspan="2"><label>Source </label></td>
		</tr>
		<tr>
			<td><input type="hidden" name="item.sourceId" value="${res.sourceId}">
			<input type="text" name="item.sourceNm" READONLY maxlength="5"
				value="${res.sourceName}" class="XLarge Box" id="source"></td>
			<td><label name="rucNumber" value="" class="Large Box" id="rucNumber">
			</label></td>
		</tr>
      	<!--  TODO: Formatear roomRate y totalBalance -->
		<tr>
			<td><label for="roomRate">Package code</label></td>
			<td><label for="roomRate">Room Rate</label></td>
		</tr>
		<tr>
			<td><select name="item.package" class="Large" id="package" DISABLED>
				<!--                    
	                <c:forEach var="item" items="${packages}">
	                    <c:set var="selected" value="" />
	                    <c:if test="${ item.packageId eq res.packageCode }" >
	                        <c:set var="selected" value="SELECTED" />
	                    </c:if>
			            <option value="${item.elementId}" ${selected}> ${item.description}
	                </c:forEach>
				-->
				<option value="" selected>PACKAGE</option>
			</select></td>
			<td><input type="text" name="item.roomRate" id="roomRate" maxlength="10"
				value='<fmt:formatNumber value="${res.roomRate}"
                                       type="currency" currencySymbol="$" />'
				class="Large Box Number" id="roomRate"> <!--<tr class="Help"><TH>&nbsp;
                <td colspan="2">* Large Number of rooms taken by this reservation-->
			</td>
		</tr>
		<tr>
			<td><label for="quantity">Payment Due</label></td>
			<td><label for="quantity">Qtty Rooms</label></td>
		</tr>
		<tr>
			<td><input type="text" name="item.paymentdue" maxlength="10"
				value="${res.paymentDue}" class="Large Box Number" id="paymentdue"
				title="Due Payment"></td>
			<td><input type="text" name="item.quantity" maxlength="3"
				value="${res.quantity}" class="Large Box Number" id="quantity"
				title="Quantity of Rooms"></td>
		</tr>
		<tr>
			<td><label for="paymenttype">Payment Type</label></td>
			<td><label for="balance">Total balance</label></td>
		</tr>
		<tr>
			<td><select name="item.paymentType" class="Large">
				<c:forEach var="item" items="${ReservationForm.paymentTypeList}">
					<c:set var="selected" value="" />
					<c:if test="${ res.paymentType eq item.paymentType }">
						<c:set var="selected" value="SELECTED" />
					</c:if>
					<option value="${item.paymentType}"${selected}>
					${item.description}</option>
				</c:forEach>
				</select></td>
			<td><input type="text" name="item.balance" READONLY
				value='<fmt:formatNumber value="${res.total}"
                                       type="currency" currencySymbol="$" />'
				class="Large Box Remark Number"></td>
		</tr>
		<tr>
			<td><label for="instructions">Instructions</label></td>
            <td><select name="item.attentions" class="Large" id="attentions">
				<c:forEach var="item" items="${attentions}">
					<c:set var="selected" value="" />
					<c:if test="${res.attentionId eq item.elementId}">
						<c:set var="selected" value="SELECTED" />
					</c:if>
					<option value="${item.elementId}"${selected}>
					${item.description}
				</c:forEach>
					<option value="1" selected>SPECIAL ATENTS.
                </select>
		</tr>
		<tr>
			<td colspan="2"><textarea id="instructions" name="item.instructions"
				rows="3" cols="60">${res.instructions}</textarea></td>
		</tr>
		<tr>
			<td colspan="2">&nbsp;</td>
		</tr>
	</tbody>
</table>
</form>

</body>

</html>
