 
<%@ page contentType="text/html;charset=ISO-8859-1" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<%--<%@ page errorPage="errorPage.jsp" %>--%>

<%@ taglib uri="http://struts.apache.org/tags-logic" prefix="logic" %>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean" %>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html" %>

<html>
<head>
    <meta http-equiv="Expires=-1" content="text/html; charset=iso-8859-1">
    <meta http-equiv="Content-Style-Type" content="text/css">
    <link rel="stylesheet" type="text/css" href="/central/css/stylesheet.css">
    <style type="text/css">
		span.Resalt { color: red }
		span.ErrorMsg { center; color: red; font: menu 1em serif; }
	</style>
    <title>Customer Information</title>
    <!-- script language="JavaScript" src="js/validateCustomerForm.js"></script -->
    <script type="text/javascript" language="JavaScript">
    <!--
    function loadDocument(){
        document.CustomerForm.documentNumber.select();
    }

    function searchCustomer(){
		var customerId = document.getElementById("lastname1").value;
		URL = "customerList.do?patternField=lastname&patternValue=" + customerId;
		appeareance = "width=480,height=420,left=460,top=100,scrollbars=yes, resizable=yes";
		// "refsearch" nos permitira acceder a la ventana creada
		winSearch = window.open(URL,"search",appeareance);
		winSearch.focus();
    }

	/* Esta funcion tambien es llamada desde customerSearch.jsp */
	function showCustomer() {
		var idCustomer = document.getElementById('idCustomer').value;
		//var documentNumber = document.getElementById('documentNumber').value;
		var uri = "customerEdit.do?idCustomer=" + idCustomer;
		    //uri += "&documentNumber=" + documentNumber; // TODO testing
		    
       	window.location.href = uri;
	}

	function newCustomer() {
		var form = document.getElementById('CustomerForm');
	    var field;
	
	    if ( confirm('Se borrarán todos los datos del formulario') ) {
	        for ( i=0; i < form.length; i++ ) {
	          field = form.elements[i];
	          if ( field.type == 'text' ) {
	             field.value = "";
	          }
	          if ( field.type == 'select-one' ) {
	          		alert(field.value);
	             field.value = "";
	          }
	        }
	        form.documentNumber.focus();
	    }
	}

    function addReservationGuest() {
        var validForm = true;
        var form = document.getElementById('CustomerForm');

        var idCustomer = form.idCustomer.value;
        var documentGuest = form.documentNumber.value;
        var lastName = form.lastname1.value;
        var firstName = form.firstname.value;
        
        if ( documentGuest != '' && lastName != '' && firstName != '' ) {
        	form.action = "ReservationAddGuest.do";
        	form.submit();
	        //window.opener.refresh();
	        window.opener.refreshGuestList();
	        window.opener.focus();
	        //window.close();
        } else {
        	alert("Datos del formulario incompletos");
        }
        
    }

    function saveCustomer() {
    	var form = document.getElementById("CustomerForm");

    	form.action = "customerUpdate.do";

        if ( validateSubmit() ) {
            if ( confirm("Guardar Informacion ?") )
    			form.submit();
    	}
    }

    function validateSubmit() {
    	var form = document.getElementById('CustomerForm');
    	
    	/*if (form.country.value) {
    	}*/
    	
        return true;
    }

	function validateShow(event) {
		if ( event.keyCode != '13' ) return;
		
		showCustomer();
	}

    <!-- TODO: only for test-->
    function disableSaveButton(form) {
        return true;
    }

    //-->
    </script>
</head>

<%--TODO: implementar uso de constantes --%>

<body>

<c:set var="cust" value="${CustomerForm.cust}" />
<form name="CustomerForm" id="CustomerForm" method="post" action="">
    <table class="TableContainer" border="0" align="center" style="width: 38em">
    <caption style="border: solid 1px; text-align: left">
        &nbsp;${cust.lastName1},&nbsp;${cust.firstName}
        <span style="padding-left: 16em;">${cust.nationality}(nationality)</span>
        <br />&nbsp;
	</caption>

    <thead class="Form">
        <tr><td colspan="2">
                <input type="button" name="clean"
                       class="Button" value="New"
                       onclick="newCustomer()">
                <input type="button" name="save"
                		<%--${ disabled_insert ? 'disabled' : '' }--%>
                       class="Button" value="Sve"
                       onclick="saveCustomer()">
                <input type="button" name="addGuest" disabled
                       class="Button" value="Add"
                       onclick="addReservationGuest()">
        </td></tr>
    </thead>
    
    <tfoot class="Form">
        <tr><td colspan="2">&nbsp;</td></tr>
    </tfoot>

	<tbody>
		<tr>
			<td class="FormContainer" align="center" style="padding-left: 1em;">
			<table border="0">
			<thead align="center">
				<!--tr><td colspan="2">&nbsp;</td></tr-->
			</thead>
			<tbody>

	        <tr><td colspan="2" align="center">
	        		<label for="idCustomer">Id Customer</label>
	                <input type="hidden" name="cust.hotelRegistration" id="idHotel"
	            			value="${sessionAttributes.idHotel}"/>
	                <input type="text" name="cust.idCustomer" id="idCustomer"
	            			value="${cust.idCustomer}" class="Box"
	            			onkeyup="validateShow(event)" />
	            </td>
            </tr>
        
        	<tr><td colspan="2" align="center">
					<jsp:include page="/pages/errors.jsp" />
					<%--logic:messagesPresent property="errors" message="true">
       					<html:messages id="msg" property="errors" message="true">
							<span class="ErrorMsg">
								<bean:write name="msg" />
							</span>
						</html:messages>				
					</logic:messagesPresent>
					<logic:messagesNotPresent>
						&nbsp;
					</logic:messagesNotPresent--%>
        		</td>
        	</tr>

	        <tr><td><label for="lastname1"><span class="Resalt">*&nbsp;</span>Last Name (pat)</label>
	            </td><td><label for="lastname2"><span class="Resalt">*&nbsp;</span>Last Name (mat)</label>
	
	        </td></tr><tr><td><input type="text" name="cust.lastName1"
	                       class="Box Medium" id="lastname1"
	                       value="${cust.lastName1}" maxlength="15" tabindex="2"
	                       onkeyup="disableSaveButton(document.CustomerForm)">
	            </td><td><input type="text" name="cust.lastName2"
	                       class="Box Medium" id="lastname2" tabindex="3"
	                       value="${cust.lastName2}" maxlength="15">
	
	        </td></tr><tr><td><label for="firstname"><span class="Resalt">*&nbsp;</span>First Name(s)</label>
	            </td><td><label for="title"><span class="Resalt">*&nbsp;</span>Title</label>
	
	        </td></tr><tr><td><input type="text" name="cust.firstName"
	                       class="Box Medium" id="firstname"  tabindex="4"
	                       value="${cust.firstName}" maxlength="15"
	                       onkeyup="disableSaveButton(document.CustomerForm)">
	            </td><td><select name="cust.title" id="title" class="Tiny">
	                        <c:forEach var="item" items="${contextAttributes.titles}">
                                <c:set var="selected" value="" />
	                            <c:if test="${item.map.value eq cust.title}">
	                                <c:set var="selected" value="selected" />
	                            </c:if>
	                    <option value="${item.map.value}" ${selected}>${item.map.label}</option>
	                        </c:forEach>
	                </select>
	                <select name="cust.vipStatus" id="vipStatus" class="Tiny">
	                        <c:forEach var="item" items="${contextAttributes.vipStatusList}">
                                <c:set var="selected" value="" />
	                            <c:if test="${item.map.value eq cust.vipStatus}">
	                                <c:set var="selected" value="selected" />
	                            </c:if>
	                    <option value="${item.map.value}" ${selected}>${item.map.label}
	                        </option></c:forEach>
	                </select></td>
	
	        </tr><tr><td><label for="nationality">Nationality</label></td>
	            <td><label for="documentType">Identification Document</label></td>
            </tr>
	        <tr>
	            <td><select name="cust.nationality" id="nationality" class="Medium">
	                        <c:forEach var="item" items="${contextAttributes.countries}">
                                <c:set var="selected" value="" />
	                            <c:if test="${item.map.idCountry eq cust.nationality}">
	                                <c:set var="selected" value="selected" />
	                            </c:if>
	                    <option value="${item.map.idCountry}" ${selected}>${item.map.nationality}
	                        </option></c:forEach>
	                </select></td>
	            <td><select name="cust.documentType" id="documentType" class="Small">
	                        <c:forEach var="item" items="${contextAttributes.documentTypes}">
                                <c:set var="selected" value="" />
	                            <c:if test="${item.map.value eq cust.documentType}">
	                                <c:set var="selected" value="selected" />
	                            </c:if>
	                    <option value="${item.map.value}" ${selected}>${item.map.label}</option>
	                        </c:forEach>
	                </select>
   	            	<input type="text" name="cust.documentNumber" id="documentNumber"
	            			value="${cust.documentNumber}"  
	            			class="Box Small" maxlength="11" tabindex="1">
	                <input type="button" value="..." onclick="searchCustomer()"/></td>
            </tr>
        
        	<tr><td colspan="2">&nbsp;</td></tr>

	        <tr><td colspan="2">
	                <label class="Remark">Address&nbsp;-</label>
	                <label for="streetName">Street</label>
	                <label for="streetName">&nbsp;/&nbsp;Number&nbsp;/&nbsp;Interior</label></td>
            </tr>
	        
	        <tr>
	            <td colspan="2">
	            	<select name="cust.address.streetType" id="streetType" class="Tiny">
	                        <c:forEach var="item" items="${contextAttributes.streetTypes}">
                                <c:set var="selected" value="" />
	                            <c:if test="${item.map.value eq cust.address.streetType}">
	                                <c:set var="selected" value="selected" />
	                            </c:if>
	                    <option value="${item.map.value}" ${selected}>${item.map.label}</option>
	                    	</c:forEach>
	                </select>
	        		<input type="text" name="cust.address.streetName"
	        			value="${cust.address.streetName}"
	                	class="Medium" id="streetName"
	                  	title="Street name">
	            	<input type="text" name="cust.address.streetNumber"
	        			value="${cust.address.streetNumber}"
	                	class="Tiny" id="streetNumber"
	                  	title="Street number">
	            	<input type="text" name="cust.address.interior"
	        			value="${cust.address.interior}"
	                	class="Tiny" id="interior"
	                  	title="Interior"></td>
	        </tr>
	
	        <tr><td><label for="city">City</label></td>
	        	<td><label for="district">District</label></td>
	            
	        </tr>
	        
	        <tr><td><input type="text" name="cust.address.city"
	                       class="Box Medium" id="city" maxlength="10"
	                       value="${cust.address.city}"></td>
	            <td><input type="text" name="cust.address.district"
	                       class="Box Medium" id="district" maxlength="10"
	                       value="${cust.address.district}"></td>
            </tr>
	
	        <tr>
	            <td><label for="country">Country</label></td>
	            <td><label for="zipCode">Zip Code</label></td>
	        </tr>
	        
	        <tr><td><select name="cust.address.country" id="idCountry" class="Medium">
	                        <c:forEach var="item" items="${contextAttributes.countries}">
                                <c:set var="selected" value="" />
	                            <c:if test="${item.map.idCountry eq cust.address.country}">
	                                <c:set var="selected" value="selected" />
	                            </c:if>
	                    <option value="${item.map.idCountry}" ${selected}>${item.map.description}</option>
	                        </c:forEach>
                     </select></td>
	        	<td><input type="text" name="cust.address.zipCode"
	                       class="Box Medium" id="zipCode" maxlength="10"
	                       value="${cust.address.zipCode}"></td>
            </tr>
	
        	<tr><td colspan="2">&nbsp;</td></tr>

	        <tr><td colspan="2">
	        		<label class="Remark">Contact phones&nbsp;-</label>
	        		<label for="phone1">Home&nbsp;/&nbsp;Job</label>
	            	<label for="phone2">/&nbsp;Movil(s)</label></td>
            </tr>
	
	        <tr><td><input type="text" name="cust.phone1.number"
	                       class="Box Small" id="phone1"
	                       value="${cust.phone1.number}" title="Phone number 1"
	                       maxlength="15">
	                <input type="text" name="cust.phone2.number"
	                       class="Box Small" id="phone2"
	                       value="${cust.phone2.number}" title="Phone number 2"
	                       maxlength="15"></td>
	            <td><input type="text" name="cust.phone3.number"
	                       class="Box Medium" id="phone3"
	                       value="${cust.phone3.number}" title="Phone number 3"
	                       maxlength="15"></td>
            </tr>
            
	        <tr><td colspan="2">
	                <label for="email">E-mail</label></td>
            </tr>
	
	        <tr><td colspan="2">
	                <input type="text" name="cust.emails"
	                       class="Box XLarge" id="email"
	                       value="${cust.emails}" title="Electronic Mail (e-mail)"
	                       maxlength="50"></td>
            </tr>

	        <tr><td colspan="2">
	                <label for="email">Comments / Requests</label></td>
            </tr>
	
	        <tr><td colspan="2">
	                <input type="text" name="cust.requests"
	                       class="Box XLarge" id="email"
	                       value="${cust.requests}" title="Comments"
	                       maxlength="50"></td>
            </tr>

            <tr><td colspan="2">
            		<input type="hidden" name="cust.madeBy" id="madeBy"
            				value="${sessionAttributes.idUser}">
            		<input type="hidden" name="cust.status" id="status"
            				value="${cust.status}">
           			&nbsp;&nbsp;</td>
            </tr>

        	</tbody>
    		</table></td>
    
    		<%--
			<td class="tableContainer" width="50%">
			<table border="0">
			<thead align="center">
				<tr><td colspan="2">&nbsp;</td></tr>
			</thead>
			<tbody>
	
	        <tr><td><label for="birthdate">&nbsp;Birth Date</label>
	            <td><label for="nationality">&nbsp;Nationality</label>
	
	        <tr><td><input type="text" name="cust.birthDate"
	                       class="Box Medium" id="birthdate"  tabindex="4"
	                       value="${cust.birthDate}" maxlength="15"
	                       onKeyUp="disableSaveButton(document.CustomerForm)"></td>
	
	        <tr><td><label for="occupation">&nbsp;Occupation</label>
	            <td><label for="vipStatus">&nbsp;VIP Status</label>
	
	        <tr><td><input type="text" name="cust.occupation"
	                       class="Box Medium" id="occupation"  tabindex="4"
	                       value="${cust.occupation}" maxlength="20"
	                       onKeyUp="disableSaveButton(document.CustomerForm)"></td>
	
			</tbody>
			</table></td>
			--%>
		</tr>
    </tbody>
    </table>
</form>
</body>
</html>
