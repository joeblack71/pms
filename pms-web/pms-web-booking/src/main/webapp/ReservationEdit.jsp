<%@ page language="java" contentType="text/html; charset=ISO-8859-1"  pageEncoding="ISO-8859-1" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">

<%--@ page errorPage="errorPage.jsp" --%>

<%--<%@ taglib uri="http://java.sun.com/jstl/core" prefix="c" %>--%>

<%--@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"--%>

<%--@ taglib tagdir="/WEB-INF/tags" prefix="t" --%>

<html>
<head>
<title>Reservation Maintenance</title>

<style type="text/css">
@import url("/a/js/dojo1.3.1/dojo/resources/dojo.css");
@import url("/a/js/dojo1.3.1/dijit/themes/tundra/tundra.css");
@import url("/a/css/estilos3_0.css");
                
.form-borde { border: 1px solid #366dba;}

TD.gamma {
background-color:#EEE; 
text-align:left; 
padding:2px;
font-weight:bold; 
font-size:11px; 
text-indent:5px;
}

.buttonbar{
background-color:#fff;
height:28px;
padding-top:3px;
padding-left:3px;
border-top:1px solid Black;
margin-top:6px;
}

#trEstados { display:none; }
</style>

<script language="JavaScript" src="/a/js/dojo1.3.1/dojo/dojo.js" 
        type="text/javascript" djConfig="parseOnLoad: false"></script>
<script language="JavaScript" src="/a/js/js2.js" type="text/javascript"></script>

<!--script type="text/javascript" src="../js/prototype.1.6.js"></script-->
<script type="text/javascript" src="../js/validateForm.js"></script>

<script type="text/javascript">
<!--
dojo.addOnLoad(function(){
    //dojo.require("dojo.data.ItemFileReadStore");
    //dojo.require("dojo.date.locale");
    dojo.require("dojo.parser");

    //dojo.require("dijit.Dialog");

    //dojo.require("dijit.form.Form");
    //dojo.require("dijit.form.ValidationTextBox");
    //dojo.require("dijit.form.TextBox");
    //dojo.require("dijit.form.Button");
    //dojo.require("dijit.form.FilteringSelect");
    dojo.require("dijit.form.DateTextBox");
    //dojo.require("dijit.form.NumberTextBox");
    //dojo.require("dijit.form.RadioButton");

    dojo.addOnLoad(function(){
        dojo.parser.parse();
        hideLoader();
        settings();
    });
});

function settings() {
    dijit.byId("txtArrival").attr("value", new Date("2010/10/21"));    
    dijit.byId("txtDeparture").attr("value", new Date("2010/10/23"));
}

function editItem() {
	var item = document.getElementById('txtReservation').value;
 	var uri = "ReservationEdit.htm?idReservation=" + item;
 	
	document.location.href = uri; 
    /*if ( isValidReservationNumber(idReservation) ) {
        window.location = "ReservationEdit.htm?idReservation="+idReservation;
    } else {
    	alert("Debe ingresar un numero de reserva valido");
    }*/
}

/* FUNCIONES INCLUIDAS EN validateform.jsp QUITAR DESPUES DE PRUEBAS */
function newItem() {
	var uri = "ReservationEdit.htm?idReservation=''";
    window.location.href = uri;
}

function saveItem() {
    var form = document.getElementById('editForm');
    form.action = "ReservationUpdate.htm";
    form.submit(); 
}

function disableSaveButton() {}

function isValidReservationNumber(resNumber) {
	var validValue = true;
	// TODO crear validacion
	if ( resNumber == '' ) {
		validValue = false;
	}
	
	return validValue;
}

//	    
// Toolbar items
//

function searchItem() {
    URL = "ReservationSearch.htm";
    appeareance = "width=700,height=450,left=250,top=100,scrollbars=yes,status=yes";
    refsearch = window.open(URL,"search",appeareance);
    refsearch.focus();
}

function setItem(idItem) {
	document.getElementById('txtReservation').value = idItem;
	editItem();
}	

function searchSource() {
    URL = "SelectSource.htm";
    appeareance = "width=700,height=450,left=50,top=100,scrollbars=yes,status=yes";
    refsearch = window.open(URL,"search",appeareance);
}

function searchContact() {
    URL = "ContactSearch.htm";
    appeareance = "width=700,height=450,left=50,top=100,scrollbars=yes,status=yes";
    refsearch = window.open(URL,"search",appeareance);
}

function showRoomTypeAvailability() {
	form = document.getElementById("editForm");
    URL = "ShowRoomTypeAvailability.htm?startDate=" + form.txtArrival.value +
          "&period=1&show=Mostrar";
    appeareance = "width=860,height=460,left=50,top=100,scrollbars=yes,status=yes";
    window.open(URL,"RTAvailability",appeareance);
}

function showSourceCodesList() {
    URL = "SelectSource.htm";
    appeareance = "width=680px,height=460px,left=50,top=100,scrollbars=yes,status=yes";
    window.open(URL,"selectSourceCode",appeareance);
}

function setSelectedItemValues(id,description) {
	var form = document.getElementById('editForm');
	
	form.idSource.value = id;
	form.sourceName.value = description;
	
	updateRoomRate();
}

/* Ajax function */	
function updateRoomRate() {
	var form = document.getElementById('editForm');
	var url = "_GetRoomRate.htm";
	var id_hotel = form.idHotel.value;
	var room_type = form.roomType.value;
	var id_source = form.idSource.value;
	var pars = "&idHotel=" + id_hotel;
	    pars += "&roomType=" + room_type;
	    pars += "&idSource=" + id_source;
	//alert(pars);

    /*var myAjax = new Ajax.Request(
        url,
        {
            parameters: pars,
            onSuccess: function(transport) {
                document.getElementById('roomRate').value = transport.responseText;
		    },
            onFailure: function() {
                alert('Sorry, Ajax Error');
            }
        }
    );*/
}

function mngGuests(action) {
	var idCustomer = document.getElementById('roomGuest').value;
	
   	uri = "CustomerEdit.htm?idCustomer=" + idCustomer;
    appeareance = "width=940,height=540,left=50,top=100,"
    			+ "scrollbars=yes,status=yes,resizable=yes";
   	winGuests = window.open(uri,"customer",appeareance);
   	winGuests.focus();
}

/**
 * Esta funcion refresca la pantalla luego de adicionar un huesped 
 */
/*function refresh() {
	var uri = "ReservationRefresh.htm";
	document.location.reload = uri;
}*/

function decideEdit(event) {
	if ( event.keyCode != 13 ) return;
	editItem();
}

function selectSource(source) {
	form = Document.getElementById("editForm");
    //if ( source == "roomType" )
    //    uri = "sourceSearch.jsp?roomType=" + form.roomType.value;
    if ( source == "buttonSource" )
        uri = "sourceSearch.jsp?roomType=" + form.roomType.value;
    appeareance = "width=600,height=450,left=50,top=100,scrollbars=yes,status=yes";
    refsearch = window.open(uri,"search",appeareance);
    //window.reload();
}

//AJAX functions
/* Actualiza el combo con huespedes registrados para una habitacion
 */
function refreshGuestList() {
	var url = "_reservationGuests.jsp";
	var pars = "";
	//var roomGuest = $('roomGuest').value;

    /*var myAjax = new Ajax.Request(
        url,
        {
            parameters: pars,
            onSuccess: function(transport) {
                setInnerHTMLForSelect($('roomGuest'), transport.responseText);
		    },
            onFailure: function() {
                alert('Sorry, Ajax Error');
            }
        }
    );*/
}

function removeGuest() {
	var url = "ReservationRemoveGuest.htm";
	var idCustomer = document.getElementById('roomGuest').value;
	var pars = "idCustomer=" + idCustomer;

    /*var myAjax = new Ajax.Request(
        url,
        {
            parameters: pars,
            onSuccess: function(transport) {
                setInnerHTMLForSelect($('roomGuest'), transport.responseText);
		    },
            onFailure: function() {
                alert('Sorry, Ajax Error');
            }
        }
    );*/
}

/* Cuando se selecciona un huesped, carga su documento
 * de identidad y su nacionalidad.
 */
function updateGuestInfo() {
    var url = '_UpdateGuestInfo.htm';
    //TODO
    var idHotel = dojo.byId('hotel');
    var roomType = dojo.byId('roomType');
    var pars = 'idHotel=' + idHotel;
        pars += 'roomType=' + roomType;

    /*var myAjax = new Ajax.Request(
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
    );*/
}

function setSpecialRate() {
    var url = '_SpecialRateValue.htm';
    var idHotel = dojo.byId('hotel');
    var roomType = dojo.byId('roomType');
    var pars = 'idHotel=' + idHotel;
        pars += 'roomType=' + roomType;

    /*var myAjax = new Ajax.Request(
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
    );*/
}

function loadDocument() {
	var form = document.getElementById('editForm');
    form.txtReservation.select();
	<%--c:if test="${ opExpected == 'I'}">
    	form.txtArrival.select();
    </c:if--%>
}

/*window.load = function() {
	loadDocument();
}*/
//-->
</script>
</head>
<body class="tundra">
    <%--c:set var="res" value="${ReservationForm.item}" /--%>
    <br />
        <div style="border: solid 1px">
        <span style="padding-left: 20px"> Reservation
        <%--#&nbsp;${ReservationForm.item.idReservation}&nbsp;-&nbsp;--%> 
        <%--c:forEach var="item" items="${contextAttributes.reservationStatusList}">
            <c:if test="${res.status eq item.status}">
	                ${item.description}
	            </c:if>
        </c:forEach--%>
        </span> 
        <span style="padding-left: 20px"> 
            <%--c:set var="cancel" value="${42}" />
			<c:forEach var="guest" items="${res.guests}">
				<c:if test="${guest.value.status != cancel}">
			    	<b>${guest.value.customerNames}</b>
		        </c:if>
			</c:forEach>
			<b><c:out value="Nationality" /></b> 
            <c:if test="${empty reg.guests}">
                <br />
            </c:if--%> 
        </span> 
        <span style="padding-left: 240px"></span></div>

        <!--a href="javascript:newItem()" title="New Reservation">
			<img class="Tool" alt="New" src="images/nuevo04.jpg"></a>
       	<a href="javascript:saveItem()" title="Save Reservation"
        	onmouseover="return createItemHelp()" onmouseout="defaultHelp()">
           	<img class="Tool" src="images/save.gif" alt="Save"/></a>
		<a href="javascript:showAvailability()" title="Show Availability Rooms">
			<img class="Tool" alt="Ava." src="images/calendar.jpg"></a-->

<form name="editForm" id="editForm" method="post" action="">
<table width="100%" class="TableContainer">
    <tr>
        <td width="50%" class="FormContainer" align="center"
            style="padding-left: 1em;">
    <%--c:set var="item" value="${ReservationForm.item}" /--%>
    <table class="TableContainer" align="center" style="width: 38em">
        <thead align="center">
            <tr><td colspan="2"></td></tr>
        </thead>

        <tbody>
        <tr><td class="" align="center" colspan="2">
                <label for="txtReservation">Reservation #&nbsp;</label>
                <input type="hidden" name="item.idHotel" id="idHotel"
                    value="<%--${hotel}--%>">
                <input type="hidden" name="item.type" id="reservationType"
                    value="I">
                <input type="text"
                    name="item.idReservation" id="txtReservation"
                    value="<%--${item.idReservation}--%>" onkeyup="decideEdit(event)"
                    class="Small Number Remark" maxlength="6"
                    title="Reservation code (autogenerated)"
                    <%--${ opexpected == 'i' ? 'readonly' : ''}--%>>
                <label for="status" >
                    <%--t:checkbox name="item.status" id="status" value="C"
                        test="${item.status == 'C'}" /--%>Confirmed
                </label>
            </td>
        </tr>
        <%--tr><td class="label">
                <label for="status">Status</label></td>
            <td><select name="item.status" id="status">
                        <c:forEach var="item"
                            items="${contextAttributes.reservationStatusList}">
                            <c:if test="${ item.status eq item.status }">
                                <c:set var="selected" value="SELECTED" />
                            </c:if>
                    <option value="${item.status}" ${selected}>
                        ${item.description}</option>
                        </c:forEach>
                </select></td>
        </tr--%>

        <tr><td colspan="2">&nbsp;</td></tr>
        
        <%--c:set var="statusField" value="" />
        <c:if test="${opExpected == 'I'}"> <!-- Insert record -->
            <c:set var="statusField" value="DISABLED" />
        </c:if--%>

        <tr>
            <td class="Label">
                <label for="txtArrival">Arrival Date</label></td>
            <td class="Label">
                <label for="txtDeparture">Departure Date</label></td>
        </tr>

        <tr>
            <td>
                <input type="text"  
                    name="item.departure" id="txtDeparture" value="<%--${item.departure}--%>"
                    dojoType="dijit.form.DateTextBox" required="true"
                    class="" 
                    maxlength="10" size="10" style="width:100px;"
                    title="Departure (DD/MM/YYYY)">
                    <img src="/a/imagenes/cal.gif" style="margin-bottom:-4px"/>
            </td>
            <td>
                <input type="text"
                    name="item.arrival" id="txtArrival" value="<%--${item.arrival}--%>"
                    dojoType="dijit.form.DateTextBox" required="true"
                    class="Small Remark Number" 
                    maxlength="10" size="10" style="width:100px;"
                    title="Arrival (DD/MM/YYYY)">
                    <img src="/a/imagenes/cal.gif" style="margin-bottom:-4px"/>
                <a href="javascript:searchItem()" title="Search Reservation">
                    
                </a>
            </td>
        </tr>

        <tr>
            <td class="label" colspan="2">
                <label for="nights">Nights Stay</label></td>
        </tr>
        <tr>
            <td colspan="2">
                <input type="text"
                    name="item.nights" id="nights" value="<%--${item.nights}--%>"
                    class="Tiny Remark Number" maxlength="3"
                    title="Number of nights of guest stay"
                    onchange="showTotal(this.form)"><img class="Tool" alt="Search" src="images/lupa01.jpg" style="height: 16px; width: 17px"></td>
        </tr>
        <%--tr>
            <td class="label">
                <label for="flight">Arrival expected (Flight)</label></td>
            <td><input type="text" name="item.flight" id="flight" value="${item.flight}"
                    class="Medium Remark" maxlength="20"
                    title="Expected arrival time" onchange=""></td>
        </tr--%>
        <tr><td colspan="2">&nbsp;</td></tr>

        <tr>
            <td class="label" colspan="2">
                <label for="adults">Adults</label>&nbsp;&nbsp;
                <label for="adults">Children</label>
            </td>
        </tr>
        <tr>
            <td colspan="2">
                <input type="text"
                    name="item.adults" id="adults" value="<%--${item.adults}--%>"
                    class="Tiny Number" maxlength="2"
                    title="Adults in the room">
                <input type="text"
                    name="item.children" id="children" value="<%--${item.children}--%>"
                    class="Tiny Number" maxlength="2"
                    title="Children in the room">
            </td>
        </tr>

        <tr>
            <td class="label">
                <label for="roomType">Room Type</label></td>
            <td class="label">
                <label for="roomNumber">Room Number</label></td>
        </tr>
        <tr>
            <td><%--t:select name="item.roomType" id="roomType" value="${item.roomType}"
                    items="${ReservationForm.roomTypeList}"
                /--%>
                <input type="button"
                    onclick="javascript:showRoomTypeAvailability()"
                    value="..." title="Muestra la disponibilidad por tipo para una
                    fecha determinada" accesskey="" />
            </td>
            <td>
                <input type="text" name="item.roomNumber" id="roomNumber"
                    value="<%--${item.roomNumber}--%>" items="<%--${ReservationForm.roomNumberList}--%>"
                >
                <input type="button"
                    onclick="javascript:showRoomAvailability()"
                    value="..." title="Muestra la disponibilidad de habitaciones para una
                    fecha determinada" accesskey="" />
            </td>
        </tr>

        <tr>
            <td class="label">
                <label for="quantity">Quantity Rooms</label></td>
            <td class="label">
                <label for="quantity">Quantity Rooms</label></td>
        </tr>
        <tr>
            <td colspan="2">
                <input type="text"
                name="item.quantity" id="quantity" value="<%--${item.quantity}--%>"
                class="Tiny Number" maxlength="3"
                title="Quantity of Rooms"></td>
        </tr>

        <tr><td colspan="2">&nbsp;</td></tr>

        <%--tr>
            <td class="label">
                <label for="package">Package</label></td>
            <td><select name="item.package" id="package" disabled="disabled">
                    <option value="" selected>Package</option>
                </select></td>
        </tr--%>
        <tr>
            <td class="label" colspan="2">
                <label for="sourceCode">Source of bussiness</label></td>
        </tr>
        <tr>
            <td colspan="2">
                <input type="hidden" name="item.idSource" id="idSource"
                    value="<%--${item.idSource}--%>"/>
                <input type="text" id="sourceName"
                    value="<%--${item.sourceName}--%>" readonly="readonly"
                    style="width: 35em" />
                <input type="button"
                    onclick="javascript:showSourceCodesList()"
                    value="..." title="Muestra la disponibilidad de habitaciones para una
                    fecha determinada" accesskey="" /></td>
        </tr>
        <tr>
            <td class="label">
                <label for="SpecialRate">Room Rate</label></td>
            <td class="label">
                <label for="balance">Total balance</label></td>
        </tr>
        <tr>
            <td>
                <input type="text"
                    name="item.roomRate" id="roomRate" value="<%--${item.roomRate}--%>"
                    class="Small Number" maxlength="10">
            </td>
            <td>
                <input type="hidden" name="item.total" id="total"
                        value="<%--${item.total}--%>" />
                <input type="text" disabled="disabled"
                    name="totalBalance" id="totalBalance" value="<%--${item.total}--%>"
                    class="Small Number">
            </td>
        </tr>

        <!--tr><td colspan="2">&nbsp;</td></tr-->

        <!--tr>
            <td class="label">
                <label for="paymentDue">Payment Due</label></td>
            <td class="label">
                <label for="paymentType">Payment Type</label></td>
        </tr-->
        <!--tr>
            <td>
                <input type="text"
                    name="item.paymentDue" id="paymentDue" value="${item.paymentDue}"
                    class="Small Number" maxlength="10"
                    title="Due Payment">
            </td>
            <td>
                <t:select name="item.paymentType" id="paymentType"
                    value="${item.paymentType}" items="${ReservationForm.paymentTypeList}"/>
            </td>
        </tr-->

        <tr><td colspan="2"><br /></td></tr>
        </tbody>
    </table>
        </td>
        <%--td width="50%" class="TableContainer" style="vertical-align: top">
			<jsp:include page="/_reservation_guest.jsp" />
		</td--%>
    </tr>
</table>
</form>

<div class="formFoot">Last
Update:&nbsp;<%--${res.updatedOn}--%>&nbsp;<span
    class="padding-left: 700px">JO.</span><br />
&nbsp;</div>

</body>
</html>

