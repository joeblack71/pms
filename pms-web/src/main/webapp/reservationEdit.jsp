<%@ taglib uri="http://struts.apache.org/tags-tiles" prefix="tiles" %>

<%--@ page errorPage="errorPage.jsp" --%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%--@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"--%>

<%--@ taglib tagdir="/WEB-INF/tags" prefix="t" --%>

<tiles:insert definition="FormLayout">
	<!--tiles:put name="moduleTitle" value="Registro de Contactos" /-->
    <tiles:put name="title" value="Registro" />

    <tiles:put name="jstlDefs">
    </tiles:put>

	<tiles:put name="cssLib" />
    <tiles:put name="cssDefs" />

	<tiles:put name="jsLib" />
    <tiles:put name="jsDefs">
		<script type="text/javascript" src="../../js/prototype.1.6.js"></script>
		<script type="text/javascript" src="../../js/validateForm.js"></script>
        <script type="text/javascript">
		<!--
		function editItem() {
			var item = document.getElementById('reservation').value;
		 	var uri = "ReservationEdit.do?idReservation=" + item;
		 	
			document.location.href = uri; 
	        /*if ( isValidReservationNumber(idReservation) ) {
		        window.location = "ReservationEdit.do?idReservation="+idReservation;
	        } else {
	        	alert("Debe ingresar un numero de reserva valido");
	        }*/
		}

	    /* FUNCIONES INCLUIDAS EN validateform.jsp QUITAR DESPUES DE PRUEBAS */
	    function newItem() {
	    	var uri = "ReservationEdit.do?idReservation=''";
	        window.location.href = uri;
	    }
	    
	    function saveItem() {
	        var form = document.getElementById('editForm');
	        form.action = "ReservationUpdate.do";
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
	        URL = "ReservationSearch.do";
	        appeareance = "width=700,height=450,left=250,top=100,scrollbars=yes,status=yes";
	        refsearch = window.open(URL,"search",appeareance);
	        refsearch.focus();
	    }

		function setItem(idItem) {
			document.getElementById('reservation').value = idItem;
			editItem();
		}	

	    function searchSource() {
	        URL = "SelectSource.do";
	        appeareance = "width=700,height=450,left=50,top=100,scrollbars=yes,status=yes";
	        refsearch = window.open(URL,"search",appeareance);
	    }
	
	    function searchContact() {
	        URL = "ContactSearch.do";
	        appeareance = "width=700,height=450,left=50,top=100,scrollbars=yes,status=yes";
	        refsearch = window.open(URL,"search",appeareance);
	    }
	
	    function showRoomTypeAvailability() {
	    	form = document.getElementById("editForm");
	        URL = "ShowRoomTypeAvailability.do?startDate=" + form.arrival.value +
	              "&period=1&show=Mostrar";
	        appeareance = "width=860,height=460,left=50,top=100,scrollbars=yes,status=yes";
	        window.open(URL,"RTAvailability",appeareance);
	    }
	
	    function showSourceCodesList() {
	        URL = "SelectSource.do";
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
			var url = "_GetRoomRate.do";
			var id_hotel = form.idHotel.value;
			var room_type = form.roomType.value;
			var id_source = form.idSource.value;
			var pars = "&idHotel=" + id_hotel;
			    pars += "&roomType=" + room_type;
			    pars += "&idSource=" + id_source;
			//alert(pars);
	
		    var myAjax = new Ajax.Request(
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
		    );
		}

	    function mngGuests(action) {
	    	var idCustomer = document.getElementById('roomGuest').value;
	    	
	       	uri = "CustomerEdit.do?idCustomer=" + idCustomer;
	        appeareance = "width=940,height=540,left=50,top=100,"
	        			+ "scrollbars=yes,status=yes,resizable=yes";
	       	winGuests = window.open(uri,"customer",appeareance);
	       	winGuests.focus();
	    }

		/**
		 * Esta funcion refresca la pantalla luego de adicionar un huesped 
		 */
		/*function refresh() {
			var uri = "ReservationRefresh.do";
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
	
		    var myAjax = new Ajax.Request(
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
		    );
		}
	
		function removeGuest() {
			var url = "ReservationRemoveGuest.do";
			var idCustomer = document.getElementById('roomGuest').value;
			var pars = "idCustomer=" + idCustomer;
	
		    var myAjax = new Ajax.Request(
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
		    );
		}
	
	    /* Cuando se selecciona un huesped, carga su documento
	     * de identidad y su nacionalidad.
	     */
		function updateGuestInfo() {
		    var url = '_UpdateGuestInfo.do';
		    //TODO
		    var idHotel = $F('hotel');
		    var roomType = $F('roomType');
		    var pars = 'idHotel=' + idHotel;
		        pars += 'roomType=' + roomType;
	
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
	
		function setSpecialRate() {
		    var url = '_SpecialRateValue.do';
		    var idHotel = $F('hotel');
		    var roomType = $F('roomType');
		    var pars = 'idHotel=' + idHotel;
		        pars += 'roomType=' + roomType;
	
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
	
	    function loadDocument() {
	    	var form = document.getElementById('editForm');
	        form.reservation.select();
	    	<c:if test="${ opExpected == 'I'}">
	        	form.arrival.select();
	        </c:if>
	    }
	
		window.load = function() {
			loadDocument();
		}
		//-->
		</script>
	</tiles:put>

    <%--tiles:put name="header">
        Reservaciones - <b>Registro de Reservas</b>
    </tiles:put--%>

    <%--tiles:put name="toolbar">
        <!--a href="javascript:cancel()" title="Cancelar"
	        onmouseover="return cancelHelp()" onmouseout="defaultHelp()">
            <img src="images/cancel.png" width="16" height="16" border="0" alt="Cancelar"/>
            Cancelar
        </a-->
		<a href="javascript:newItem()" title="New Reservation">
			<img alt="New" src="images/nuevo04.jpg"></a>
       	<a href="javascript:saveItem()" title="Save Reservation"
        	onmouseover="return createItemHelp()" onmouseout="defaultHelp()">
           	<img src="images/save.gif" width="16" height="16" border="0" alt="Save"/></a>
		<!--a href="javascript:showItem()" title="Show Reservation">
			<img alt="Shw" src="images/showRes.jpg"></a-->
		<a href="javascript:searchItem()" title="Search Reservation">
			<img alt="Sch" src="images/lupa01.jpg"></a>
		<a href="javascript:showAvailability()" title="Show Availability Rooms">
			<img alt="Ava." src="images/calendar.jpg"></a>
		<%--jsp:include page="toolbar.jsp" /--%>
    <%--/tiles:put--%>	
	
	<%--tiles:put name="body"--%>
	<!--div id="helpBox" class="helpBox"></div>
	<div id="warningBox" class="warningBox" style="display: none"></div-->

	<c:set var="res" value="${ReservationForm.item}" /><br />
	<tiles:put name="formCaption">
		<div style="border: solid 1px">
		<span style="padding-left: 20px">
			Reservation	#&nbsp;${ReservationForm.item.idReservation}&nbsp;-&nbsp;
			<c:forEach var="item" items="${contextAttributes.reservationStatusList}">
				<c:if test="${res.status eq item.status}">
	                ${item.description}
	            </c:if>
			</c:forEach>
		</span>
		<span style="padding-left: 20px">
			<%--c:set var="cancel" value="${42}" />
			<c:forEach var="guest" items="${res.guests}">
				<c:if test="${guest.value.status != cancel}">
			    	<b>${guest.value.customerNames}</b>
		        </c:if>
			</c:forEach>
			--%>
			<b><c:out value="Nationality" /></b>
			<c:if test="${empty reg.guests}">
				<br />
			</c:if>
		</span>
		<span style="padding-left: 240px"></span>
		</div>
	</tiles:put>
		
	<tiles:put name="formHead" />
	<tiles:put name="toolbar">
		<!--a href="javascript:newItem()" title="New Reservation">
			<img class="Tool" alt="New" src="images/nuevo04.jpg"></a>
       	<a href="javascript:saveItem()" title="Save Reservation"
        	onmouseover="return createItemHelp()" onmouseout="defaultHelp()">
           	<img class="Tool" src="images/save.gif" alt="Save"/></a>
		<a href="javascript:showAvailability()" title="Show Availability Rooms">
			<img class="Tool" alt="Ava." src="images/calendar.jpg"></a-->
	</tiles:put>
	
	<tiles:put name="formBody">
		<form name="editForm" id="editForm" method="post">
		<table width="100%" class="TableContainer">
			<tr><td width="50%" class="FormContainer" align="center" style="padding-left: 1em;">
					<jsp:include page="/pages/reservations/_reservation_stay.jsp" />
				</td>
				<%--td width="50%" class="TableContainer" style="vertical-align: top">
					<jsp:include page="/_reservation_guest.jsp" />
	 			</td--%>
	 		</tr>
	 	</table>
		</form>
	</tiles:put>

	<tiles:put name="formFoot">
		<div class="formFoot">
		Last Update:&nbsp;${res.updatedOn}&nbsp;<span class="padding-left: 700px">JO.</span><br />&nbsp;
		</div>
	</tiles:put>

</tiles:insert>
