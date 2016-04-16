<%@page contentType="text/html"%>
<%@page pageEncoding="UTF-8"%>

<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%--@taglib tagdir="/WEB-INF/tags" prefix="ct"--%> <!-- customized tags -->

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">
<script>
<!--
	function updateCharge() {
		var uri = "UpdateCharge.do";
		var form = document.forms[0];
		
		form.action = uri;
		form.submit();
	}
	
	function validateForm() {
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

	<c:set var="hotelDate" value="23/02/2008"/>
	<c:set var="idUser" value="JO"/>
    <form name='editForm' id="editForm" onSubmit="updateCharge();">
        <table width='474' height="234" class='Form' border="0">
            <caption class='Form'>Room Number #&nbsp;${roomNumber}</caption>

            <tr><td colspan='2'>&nbsp;
	            	<input type="hidden" name="item.idHotel" id="idHotel"
	            		   value="${AccountChargeForm.item.idHotel}">
	            	<input type="hidden" name="item.idCustomer" id="idCustomer"
	            		   value="${AccountChargeForm.item.idCustomer}">
	            	<input type="hidden" name="item.idBill" id="idBill"
	            		   value="${AccountChargeForm.item.idBill}">
	            	<input type="hidden" name="item.chargeDate" id="chargeDate"
	            		   value="${hotelDate}">
	            	<input type="hidden" name="item.madeBy" id="madeBy"
	            		   value="${idUser}">
            	</td></tr>
            <tr><td><label for='accountNumber'>Account number</label>
                <td><select name='item.idAccount' id='idAccount' class="Large">
                			<c:forEach var="item" items="${AccountChargeForm.creditAccounts}">
                        <option value="${item.map.idAccount}">${item.map.description}</option>
                        	</c:forEach>
                    </select></td>
            </tr>
                    
            <tr><td><label for='checkType'>Check Type</label>
                <td><select name='item.checkType' id='checkType' class='Medium'>
                			<c:forEach var="item" items="${AccountChargeForm.checkTypes}">
                        <option value="${item.map.value}">${item.map.label}</option>
                        	</c:forEach>
                    </select>
                    <input type='text' name='item.checkNumber' id="checkNumber"
                           value="${AccountChargeForm.item.checkNumber}" class='Medium'>
                </td>
            </tr>
                           
            <!--tr><td><label for='checkNumber'>Check Number</label></td>
            	<td><input type='text' name='checkNumber' id="checkNumber"
                           value="${item.checkNumber}" class='Medium'></td>
            </tr-->

            <tr><td><label for='amountCharge'>Amount Charge</label></td>
            	<td><input type='text' name='item.totalCharge' id='totalCharge'
            			   value="${AccountChargeForm.item.totalCharge}"
                           class='Large'></td>
            </tr>

            <tr><td colspan='2'>&nbsp;</td></tr>

            <tr><td colspan='2' align='center'>
                <input type='submit' name='add' value='Save'
                       class='MediumButton'>
                <input type='button' name='correct' value='Cancel'
                	   onclick="window.close();"
                       class='MediumButton'></td>
            </tr>

            <tr><td colspan='2'>&nbsp;

        </table>
    </form>
    
    </body>
</html>
