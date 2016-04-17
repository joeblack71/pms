<%@page contentType="text/html"%>
<%@page pageEncoding="UTF-8"%>

<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%--@taglib tagdir="/WEB-INF/tags" prefix="ct"--%> <!-- customized tags -->

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">

<script>
<!--
	/* Abre un modal dependiendo del tipo de browser
	function modalWin() {
		if (window.showModalDialog) { // IExplorer
		window.showModalDialog("xpopupex.htm","name",
		"dialogWidth:255px;dialogHeight:250px");
		} else { // Mozilla
		window.open('xpopupex.htm','name',
		'height=255,width=250,toolbar=no,directories=no,status=no,
		continued from previous linemenubar=no,scrollbars=no,resizable=no ,modal=yes');
		}
	}
	*/

	function addCharge() {
		var roomNumber = document.forms[0].roomNumber.value; 

	    var myArguments = new Object();
	    myArguments.param1 = roomNumber;
	    //window.showModalDialog("http://www.java2s.com", myArguments, '');

        uri = "EditCharge.do?idHotel=1&idCustomer=1&idBill=1";
        appeareance = "dialogWidth:480px; dialogHeight:296px; status:no";
       	window.showModalDialog(uri,"winCharge",appeareance); // only IExplorer
	}

	function getBillCharges() {
		var idBill = document.forms[0].idBill.value;

	    /*var myArguments = new Object();
	    myArguments.param1 = roomNumber;
	    window.showModalDialog("http://www.java2s.com", myArguments, '');*/

        document.location = "AccountCharge.do?idHotel=1&idCustomer=1&idBill="+idBill;
	}

//-->
</script>

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link type="text/css" rel="stylesheet" href="css/stylesheet.css">
        <title>JSP Page</title>
    </head>
    <body>

	<c:set var="idHotel" value="1" />
	<c:set var="idCustomer" value="1" />

    <form name='AccountChargeForm' action=''>
        <table width='640' class='Form' border="0" style="border-style: solid 1px">
            <caption class='Form'>Room Number #</caption>

            <tr><td colspan='2'>&nbsp;

            <tr><td><label for='room'>Room</label>
            	<td><input type="hidden" name="item.idHotel" id="idHotel"
            			   value="${idHotel}">
            	    <input type="hidden" name="item.idCustomer" id="idCustomer"
            			   value="${idCustomer}">
                    <select name='item.roomNumber' id='roomNumber' class='Medium'>
                			<c:forEach var="item" items="${AccountChargeForm.inHouseRooms}">
                        <option value="${item.map.idRoom}">${item.map.roomNumber}</option>
                        	</c:forEach>
                    </select></td>
                    
            <tr><td><label for='guest'>Guest Names</label>
                <td><select name='item.idCustomer' id='idCustomer' class=''>
                			<c:forEach var="item" items="${AccountChargeForm.roomAccounts}">
                        <option value="${item.map.idCustomer}">
                        	${item.map.guestNames}
                        </option>
                        	</c:forEach>
                    </select>
                </td>
            </tr>
                           
            <tr><td><label for='idBill'>Bill Id</label></td>
                <td><select name='item.idBill' id='idBill' class='Medium'>
                			<c:forEach var="item" items="${AccountChargeForm.roomAccounts}">
                        <option value="${item.map.idBill}">
                        	${item.map.idBill}
                        </option>
                        	</c:forEach>
                    </select>
                	<input type='button' name='Look' value='Look'
                       	   class='MediumButton' onclick="getBillCharges()">
            </tr>

            <tr><td colspan='2'>&nbsp;
            
            <tr><td colspan='2'>
                <table rules='groups' style="width: inherited">
                    <colgroup><col class='Tiny'></colgroup>			<!-- Select item -->
                    <colgroup><col class='Small  Number'></colgroup>	<!-- Order -->
                    <colgroup><col class='Medium Center'></colgroup>	<!-- Date -->
                    <colgroup>
                        <col class='Tiny Center'> 	<!-- Status -->
                        <col class='Small Center'> 	<!-- Account -->
                        <col class='Large Text'> 	<!-- Account Desc. -->
                    </colgroup>
                    <colgroup>
                        <col class='Tiny Center'> 	<!-- Check Type -->
                        <col class='Medium Number'> <!-- Check Number -->
                        <col class='Large Number'> 	<!-- Amount -->
                    </colgroup>
                    <colgroup>
                        <col class='Small Center'>	<!-- Cashier -->
                    </colgroup>
                        
                    <thead>
                        <tr><th>&nbsp;</th>
                            <th>#</th>
                            <th>Date</th>
                            <th>St</th>
                            <th>Account</th>
                            <th>Account Desc.</th>
                            <th>Check Type</th>
                            <th>Check Number</th>
                            <th>Amount</th>
                            <th>Cashier</th>
                        </tr>
                    </thead>
                    <tbody>
                    	<c:forEach var="item" items="${AccountChargeForm.accountCharges}"
                    			   varStatus="status">
	                        <tr><td><input type='checkbox' name="check" class='NoBorder'></td>
	                            <td>${status.count}</td>
	                            <td>${item.madeOn}</td>
	                            <td>${item.status}</td> 	<!-- Corrected, Transfer, etc. -->
	                            <td>${item.idAccount}</td> 	<!-- Rest., Room, etc. -->
	                            <td>${item.description}</td><!-- Account Description -->
	                            <td>${item.checkType}</td>
	                            <td>${item.checkNumber}</td>
	                            <td>${item.totalCharge}</td>
	                            <td>${item.madeBy}</td>
                            </tr>
                    	</c:forEach>
                    </tbody>
                </table>
                
            <tr><td colspan='2'>&nbsp;

            <tr><td width="140">&nbsp;</td>
                <td style="padding-left: 300px;">
                	<label for='roomBalance'>
                		BALANCE:&nbsp;&nbsp;&nbsp;&nbsp;</label>
                	<input type='text' name='roomBalance' id="roomBalance"
            	    	   value="${AccountChargeForm.roomBill.map.balance}"
                           class='Medium Number' readonly>
                </td>
            </tr>

            <tr><td colspan='2'>&nbsp;

            <tr><td colspan='2' align='center'>
                <input type='button' name='add' value='Add'
                       class='MediumButton' onclick="addCharge()">
                <input type='submit' name='correct' value='Correct'
                       class='MediumButton'>
                <input type='submit' name='transfer' value='Transfer'
                       class='MediumButton'>
                <input type='submit' name='print' value='Print'
                       class='MediumButton'>
                <input type='submit' name='checkout' value='C/O'
                       class='MediumButton'>
                           
            <tr><td colspan='2'>&nbsp;<br/>&nbsp;

        </table>
    </form>
    
    </body>
</html>
