
<%@ page contentType="text/html;charset=ISO-8859-1" %>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>

<html>
<head>
    <meta http-equiv="Expires=-1" content="text/html; charset=iso-8859-1">
    <meta http-equiv="Content-Style-Type" content="text/css">
    <meta http-equiv="Content-Script-Type" type="text/javascript" content="">
    <title>Reserva</title>
    <link rel='stylesheet' type='text/css' href="css/stylesheet.css">
    <style type="">
		body { margin: 0px; border: 0px; }
	</style>

	<script type="text/javascript" src="js/prototype.1.6.js"></script>
    <script type='text/javascript' language='JavaScript'>
    <!--
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

	/* Ajax function */	
	function addNewRate() {
		var form = document.getElementById('editForm');
		var url = "_AddRoomTypeRate.do";
		var id_hotel = form.idHotel.value;
		var id_roomtype = form.idRoomType.value;
		var id_special_rate = form.idSpecialRate.value;
		var id_period = form.idPeriod.value;
		var rateValue = form.rateValue.value;
		var pars = "&idHotel=" + id_hotel;
		    pars += "&idRoomType=" + id_roomtype;
		    pars += "&idSpecialRate=" + id_special_rate;
		    pars += "&idPeriod=" + id_period;
		    pars += "&rateValue=" + rateValue;

	    var myAjax = new Ajax.Request(
	        url,
	        {
	            parameters: pars,
	            onSuccess: function(transport) {
	                document.getElementById('specialRates').innerHTML = transport.responseText;
			    },
	            onFailure: function() {
	                alert('Sorry, Ajax Error');
	            }
	        }
	    );
	}

    function validateSubmit() {
        return true;
    }

    function cleanForm() {
        window.location.href = "SpecialRateEdit.do";;
    }

    /* FUNCIONES INCLUIDAS EN validateform.jsp QUITAR DESPUES DE PRUEBAS */
    function showRate(rateId) {
        var form = document.getElementById('editForm');

        form.submit();
    }
    function saveRate(rateId) {
        var form = document.getElementById('editForm');

        form.submit();
    }
    function disableSaveButton(){}
    
    window.onload = function() {
    	
    }
	//-->
    </script>
</head>

<c:set var="form" value="${SpecialRateForm}" />

<body style="margin: 0px; border: 0px; background-color: buttonface;">
    <form name='editForm' id='editForm' method="post" onsubmit='return validateSubmit()'>
    <table class='formContainer' width="80%" height="100%" align='center' >
        <caption class='Form'>
                RATE MANAGER
        </caption>

        <thead style='background: aliceblue;'>
            <tr><td colspan="3">&nbsp;
                <button type='button' name='new' value='new'
                        class='Tool' onclick='cleanForm()'>
                    <img src='images/nuevo04.jpg' alt='New Reservation'	class='Tool'>
                </button>
                <button type='button' name='search' value='search'
                        class='Tool' onclick='lookForRates()'>
                    <img src='images/lupa01.jpg' alt='Search Reservation' class='Tool'>
                </button>
                <button type='button' name='show' value='Show'
                        class='Tool' onclick='showRate(document.editForm.rateId.value)'>
                    <img src='images/lupa01.jpg' alt='Search Reservation' class='Tool'>
                </button>
                <button type='button' name='save' value="Save"
                       class="Tool" onclick='saveRate(document.editForm.rateId.value)'>
                    <img src='images/save.jpg' alt='Save item' class="Tool">
                </button>
                <button type='button' name='new' value="New"
                       class="Tool" onclick='resetFields(document.editForm)'>
                    <img src='images/new.jpg' alt='New item' class="Tool">
                </button>
        		</td>
        	</tr>
        </thead>
        
        <tfoot class='Form'>
            <tr><td colspan="3" align='right'>
                    Updated:&nbsp;${rate.status}&nbsp;
        		</td>
        	</tr>
        </tfoot>
        
        <tbody>
        	<tr><td class="tableContainer">
        		<table>
					<tr><td colspan="3">&nbsp;</td></tr>
					<tr><td class="label">
							<label for='idSpecialRate'>Special Id</label></td>
						<td><input type="hidden" name="idHotel" id="idHotel" value="1">
							<input type="text" name='item.idSpecialRate' id='idSpecialRate'
								value='${form.item.idSpecialRate}'
					 			class='Small' readonly="readonly"></td>
					     <td>&nbsp;</td></tr>
					<tr><td class="label">
							<label for='description'>Description</label></td>
					 	<td><input type="text" name='item.description' id='description'
					 			value='${form.item.description}'
					  			class='Large'></td>
						<td>&nbsp;</td></tr>
		          
					<tr><td class="label">
							<label for='status'>Status</label></td>
					 	<td><input type="text" name='item.status' id='status'
					 			value='${form.item.status}'
					  			class='Tiny'></td>
						<td>&nbsp;</td></tr>
					<tr><td>&nbsp;</td></tr>
				</table>
			</td></tr>
          
			<tr><td class="tableContainer" colspan="3">
				<table>
					<caption>Rates by Room Type</caption>
					<tbody>
						<tr><!--td><select name="period">
									<option value="1">ALL 2008</option>
								</select></td-->
							<td class="Medium">&nbsp;</td>
							<td>
								<select name="idRoomType">
									<option value="1">Roomtype 1</option>
								</select>
								<input type="hidden" name="idPeriod" id="idPeriod"
									value="001"></td>
							<td><input type="text" name="rateValue" id="rateValue"></td>
							<td colspan="2">
								<button type='button' name='new' value="New"
                       				class="Tool" onclick='addNewRate()'>
                    				<img src='images/new.jpg' alt='New item' class="Tool">
                				</button>
								<button type='button' name='new' value="New"
                       				class="Tool" onclick='deleteRate()'>
                    				<img src='images/new.jpg' alt='New item' class="Tool">
                				</button></td>
						</tr>
					</tbody>
				</table>
			</td></tr>

			<tr><td class="tableContainer" id="specialRates" colspan="3">
				<jsp:include page="_addRoomTypeRate.jsp" />
			</td></tr>
			
			<tr><td colspan="3">&nbsp;</td></tr>
       	  
       	  </tbody>
    </table>
    </form>

</body>

</html>
