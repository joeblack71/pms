
<%@ page contentType="text/html" %>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
 
<!DOCTYPE HTML PUBLIC "-//W3C//DTD html 4.01 //EN"
          "http://www.w3.org/TR/html4/strict.dtd">

<html>
<head>
<meta http-equiv="Expires=-1" content="text/html; charset=iso-8859-1">
<meta http-equiv="Content-Style-Type" content="text/css">
<link rel='stylesheet' type='text/css' href="/central/css/stylesheet.css">
<title>Customer Search</title>
<script type='text/javascript' language='javascript'>
	<!--
	function loadDocument() {
	    window.focus();
	    document.ListForm.pattern.select();
	}
	
	function showCustomer(idCustomer) {
		//window.opener.showCustomer(documentNumber);
		//window.close();
		appeareance = "width=580,height=640,left=300,top=40,scrollbars=no, resizable=yes";
		var uri = "customerEdit.do";
		    uri += "?idCustomer=" + idCustomer;
			//uri += "&documentNumber=" + documentNumber;
		//alert(uri);
		win = window.open(uri,"customerForm",appeareance);
		win.focus();
	}
	// -->
</script>
</head>

<c:set var="ctx" value="${pageContext.request.contextPath}" />
<body onload='loadDocument()'>
<form name='ListForm' id='ListForm' method='post' action='${ctx}/customerList.do'>
  	<table class='Search' align="center" border='0'>
    <caption class='Search'>Customer Search</caption>
    <tbody>
    <tr>
        <td align='right'>Hotel</td>
        <td><select name='filter.idHotel' class='Medium' id='idHotel'>
              <option value='1' selected>UNIDAD HOTELERA</option>
          	</select></td>
      	<td><input type='submit' value='Search'></td>
    </tr>
    <tr>
	    <td align="right">Criterian</td>
	    <td><select name='filter.fieldPattern' class='Medium' id='field'>
            	<option value='1' selected>Last name</option>
	    	<%--c:forEach var="item" items="${CustomerListForm.patternFieldList}">
	    		<c:set var="selected"
	    		 value="${ CustomerListForm.filter.field == item.map.value ? 'selected' : '' }" />
				<option value='${item.map.value}' ${selected}>${item.map.label}</option>
			</c:forEach--%>
	     	</select></td>
    	<td><input type='text' name='filter.pattern' id='pattern'
                 value='${CustomerListForm.filter.pattern}' maxlength='20'
                 title='Input pattern to look for ..'>
        </td>
    </tr>
  	</table>
</form>

<div align="center">
<table class="Listing" rules="groups" width="">
<col class="Number Tiny">
<col class="Text Medium">
<col class="Text Large">
<col class="Text Medium">
<thead>
   <tr>
       <td>#</td>
       <td>Document</td>
       <td>Pax Names</td>
       <td>Nationality</td>
   </tr>
</thead>
<tbody>
	<c:forEach var="cust" items="${CustomerListForm.customers}" varStatus="status">
	<tr class="${ status.count % 2 == 0 ? 'Odd' : ''}">
		<td>${status.count}</td>
	    <td>
	    	<a href="javascript:showCustomer('${cust.map.idCustomer}')">
	        	${cust.map.idCustomer}
	        </a>
	    </td>
	    <td align="left">${cust.map.customerNames}</td>
	    <td>${cust.map.nationality}</td>
	</tr>
	</c:forEach>
</tbody>
</table>
</div>
</body>
</html>