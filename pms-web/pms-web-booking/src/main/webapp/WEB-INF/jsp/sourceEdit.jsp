 
<%@ page contentType="text/html;charset=ISO-8859-1" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>

<%@ taglib uri="http://struts.apache.org/tags-logic" prefix="logic" %>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean" %>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html" %>

<%--<%@ page errorPage="errorPage.jsp" %>--%>

<html>
<head>
    <meta http-equiv="Expires=-1" content="text/html; charset=iso-8859-1">
    <meta http-equiv="Content-Style-Type" content="text/css">
    <link rel="stylesheet" type="text/css" href="css/stylesheet.css">
    <style>
    	span.Resalt { color: red }
		span.ErrorMsg { center; color: red; font: normal 1em monospace; }
    </style>
    <title>Source Information</title>
    <!-- script language="JavaScript" src="js/validateCustomerForm.js"></script -->
    <script type="text/javascript" language="JavaScript">
    <!--
    function loadDocument(){
        document.CustomerForm.documentNumber.select();
    }

    function searchCustomer(){
		var customerId = document.getElementById("lastname1").value;
		URL = "sourceList.do?patternField=lastname&patternValue=" + customerId;
		appeareance = "width=480,height=420,left=460,top=100,scrollbars=yes, resizable=yes";
		// "refsearch" nos permitira acceder a la ventana creada
		winSearch = window.open(URL,"search",appeareance);
		winSearch.focus();
    }

	/* Esta funcion tambien es llamada desde customerSearch.jsp */
	function showCustomer() {
		var documentNumber = document.getElementById('documentNumber').value;
		var uri = "sourceEdit.do?documentNumber=" + documentNumber;

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
        	form.action = "reservationAddGuest.do";
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

    	form.action = "sourceUpdate.do";

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

    <!-- TODO: only for test-->
    function disableSaveButton(form) {
        return true;
    }

    //-->
    </script>
</head>

<%--TODO: implementar uso de constantes --%>

<body onLoad="loadDocument()">
<c:set var="source" value="${SourceForm.item}" />
<form name="CustomerForm" id="CustomerForm" method="post">
    <table class="Form" align="center" border="0" cellspacing="0">
    <caption class="Form">
        &nbsp;${source.sourceName},&nbsp;${source.commercialName}
        <br />&nbsp;
	</caption>

    <thead class="Toolbar">
        <tr><td colspan="2">
                <input type="button" name="clean"
                       class="Button" value="New"
                       onclick="newCustomer()">
                <input type="button" name="show"
                       class="Button" value="Shw"
                       onclick="showCustomer()">
                <input type="button" name="save"
                		<%--${ disabled_insert ? 'disabled' : '' }--%>
                       class="Button" value="Sve"
                       onClick="saveCustomer()">
                <input type="button" name="search"
                       class="Button" id="search" value="Sch"
                       onClick="searchCustomer()">
        </tr>
    </thead>
    
    <tfoot class="Form">
        <tr><td colspan="2">&nbsp;</td></tr>
        <tr><td colspan="2">&nbsp;</td></tr>
    </tfoot>

	<tbody align="center">
		<tr>
			<td class="tableContainer">
			<table border="0">
			<thead align="center">
				<!--tr><td colspan="2">&nbsp;</td></tr-->
			</thead>
			<tbody>

	        <tr><td colspan="2" align="center">
					<label for="idSource">Id Source</label>&nbsp;
					<input type="hidden" name="item.hotelRegistration" id="idHotel"
	            			value="${sessionAttributes.idHotel}"/>
					<input name="item.idSource" id="idSource"
	                       type="text" class="Box Small" maxlength="11"
	                       value="${source.idSource}" tabindex="1">
				</td>
            </tr>
        
        	<tr><td colspan="2" align="center">
					<logic:messagesPresent property="errors" message="true">
       					<html:messages id="msg" property="errors" message="true">
							<span class="ErrorMsg">
								<bean:write name="msg" />
							</span>
						</html:messages>				
					</logic:messagesPresent>
					<logic:messagesNotPresent>
						&nbsp;
					</logic:messagesNotPresent>
        		</td>
        	</tr>

	        <tr><td colspan="2">
	        		<label for="sourceName" class="Remark"><span class="Resalt">*&nbsp;</span>
	        			Source Name
	        		</label></td>
       		</tr>

	        <tr><td colspan="2">
	        		<input name="item.sourceName" id="sourceName"
	                       type="text" class="Box XLarge"
	                       value="${source.sourceName}" maxlength="15" tabindex="2"
	                       onKeyUp="disableSaveButton(document.CustomerForm)"></td>
            </tr>
	
	        <tr>
	        	<td><label for="commercialName">Commercial Name / Category</label></td>
	        </tr>

	        <tr><td colspan="2">
	        		<input name="item.commercialName" id="commercialName"
	                       type="text" class="Box Large"
	                       value="${source.commercialName}" maxlength="15" tabindex="2"
	                       onKeyUp="disableSaveButton(document.CustomerForm)">
	                <select name="item.category" id="category" class="Tiny">
		                    <c:forEach var="item" items="${contextAttributes.categories}">
		                        <c:set var="selected" value="" />
		                        <c:if test="${item.map.value eq source.category}">
		                            <c:set var="selected" value="selected" />
		                        </c:if>
	                    <option value="${item.map.value}" ${selected}>${item.map.label}
		                    </c:forEach>
	                </select>
	            </td>
	        </tr>
	
			<tr>
				<td><label for="documentNumber">Document Number</label></td>
				<td><label for="specialRate" class="Remark">Special Rate</label></td>
			</tr>
	        <tr>
				<td>
	            	<input type="text" name="item.documentNumber"
	                       class="Box Medium" id="documentNumber" maxlength="11"
	                       value="${source.documentNumber}" tabindex="2">
				</td>
				<td>
					<select name="item.specialRate" id="specialRate"
	        	        	class="Medium">
	                        <c:forEach var="item" items="${contextAttributes.specialRates}">
                                <c:set var="selected" value="" />
	                            <c:if test="${item.map.idSpecialRate eq source.specialRate}">
	                                <c:set var="selected" value="selected" />
	                            </c:if>
	                    <option value="${item.map.idSpecialRate}" ${selected}>${item.map.description}
	                        </c:forEach>
                    </select>
	            </td>
            </tr>

			<tr><td colspan="2">&nbsp;</td></tr>

	        <tr><td colspan="2">
	                <label class="Remark">Address&nbsp;-</label>
	                <label for="streetName">Street</label>
	                <label for="streetName">&nbsp;/&nbsp;Number&nbsp;/&nbsp;Interior</label></td>
            </tr>
	        
	        <tr>
	            <td colspan="2">
	            	<select name="item.address.streetType" id="streetType" class="Tiny">
	                        <c:forEach var="item" items="${contextAttributes.streetTypes}">
                                <c:set var="selected" value="" />
	                            <c:if test="${item.map.value eq source.address.streetType}">
	                                <c:set var="selected" value="selected" />
	                            </c:if>
	                    <option value="${item.map.value}" ${selected}>${item.map.label}</option>
	                    	</c:forEach>
	                </select>
	        		<input type="text" name="item.address.streetName"
	        			value="${source.address.streetName}"
	                	class="Medium" id="streetName"
	                  	title="Street name">
	            	<input type="text" name="item.address.streetNumber"
	        			value="${source.address.streetNumber}"
	                	class="Tiny" id="streetNumber"
	                  	title="Street number">
	            	<input type="text" name="item.address.interior"
	        			value="${source.address.interior}"
	                	class="Tiny" id="interior"
	                  	title="Interior"></td>
	        </tr>
	
	        <tr><td><label for="district">District</label></td>
	            <td><label for="city">City</label></td>
	        </tr>
	        
	        <tr><td><input name="item.address.district" id="district"
	                       type="text" class="Box Medium" maxlength="10"
	                       value="${source.address.district}"></td>
	            <td><input name="item.address.city" id="city"
	                       type="text" class="Box Medium" maxlength="10"
	                       value="${source.address.city}"></td>
            </tr>
	
	        <tr>
	            <td><label for="country">Country</label></td>
	            <td><label for="zipCode">Zip Code</label></td>
	        </tr>
	        
	        <tr><td><select name="item.address.country" id="country" class="Medium">
	                        <c:forEach var="item" items="${contextAttributes.countries}">
                                <c:set var="selected" value="" />
	                            <c:if test="${item.map.idCountry eq source.address.country}">
	                                <c:set var="selected" value="selected" />
	                            </c:if>
	                    <option value="${item.map.idCountry}" ${selected}>${item.map.description}
	                        </c:forEach>
                     </select></td>
	        	<td><input type="text" name="item.address.zipCode" id="zipCode" 
	                       class="Box Medium" maxlength="10"
	                       value="${source.address.zipCode}"></td>
            </tr>
	
	        <tr><td colspan="2">&nbsp;</td></tr>

	        <tr>
	        	<td><label for="phone1">Phones 1 / 2</label></td>
	        	<td><label for="webPage">Web Page</label></td>
            </tr>
	
	        <tr><td><input type="text" name="item.phone1.number"
	                       class="Box Small" id="phone1"
	                       value="${source.phone1.number}" title="Phone number 1"
	                       maxlength="15">
	                <input type="text" name="item.phone2.number"
	                       class="Box Small" id="phone2"
	                       value="${source.phone2.number}" title="Phone number 2"
	                       maxlength="15">
	            </td>
	            <td><input type="text" name="item.webPage" id="webPage"
	                       value="${source.webPage}" 
	                       class="Box Medium" maxlength="50" tabindex="20">
	            </td>
            </tr>
            
			<tr><td colspan="2">&nbsp;</td></tr>

	        <tr><td><label for="sourceType">Source Type</label></td>
	            <td><label for="segment"></label>Segment</td>
       		</tr>
	
	        <tr><td><select name="item.sourceType" id="sourceType" class="Medium">
		                    <c:forEach var="item" items="${contextAttributes.sourceTypes}">
									<c:set var="selected" value="" />
		                        <c:if test="${item.map.idSourceType eq source.sourceType}">
									<c:set var="selected" value="selected" />
		                        </c:if>
	                    <option value="${item.map.idSourceType}" ${selected}>${item.map.description}
		                    </c:forEach>
	                </select></td>
	            <td><select name="item.segment" id="segment" class="Medium">
		                    <c:forEach var="item" items="${contextAttributes.segments}">
		                           <c:set var="selected" value="" />
		                        <c:if test="${item.map.idSegment eq source.segment}">
		                            <c:set var="selected" value="selected" />
		                        </c:if>
	                    <option value="${item.map.idSegment}" ${selected}>${item.map.description}
		                    </c:forEach>
	                </select></td>
            </tr>
	
	        <tr>
		        <td colspan="2">
		        	<label for="creditType">Credit Type</label></td>
	        </tr>
	
	        <tr>
	        	<td colspan="2">
	        		<select name="item.creditType" id="creditType" class="Medium">
	                    <option value="">7 DIAS
	                    <option value="">15 DIAS
	                    <option value="">30 DIAS
	                        <%--c:forEach var="item" items="${contextAttributes.titles}">
                                <c:set var="selected" value="" />
	                            <c:if test="${item.map.value eq source.sourceClass}">
	                                <c:set var="selected" value="selected" />
	                            </c:if>
	                    <option value="${item.map.value}" ${selected}>${item.map.label}
	                        </c:forEach--%>
                    </select>
	            </td>
            </tr>
	
            <tr><td colspan="2">
            		<input type="hidden" name="item.madeBy" id="madeBy" readonly
            				value="${sessionAttributes.idUser}">
            		<input type="hidden" name="item.status" id="status" readonly
            				value="${source.status}">
           			&nbsp;</td>
            </tr>

        	</tbody>
    		</table></td>
    
		</tr>
    </tbody>
    </table>
</form>
</body>
</html>
