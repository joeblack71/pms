
<%@ page contentType="text/html" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 //EN"
          "http://www.w3.org/TR/html4/strict.dtd">

<html>
<head>
  <meta http-equiv="Expires=-1" content="text/html; charset=iso-8859-1">
  <meta http-equiv="Content-Style-Type" content="text/css">
  <link rel='stylesheet' type='text/css' href="css/stylesheet.css">
  <title>Company search</title>
  <script type='text/javascript' languaje='js/JavaScript'>
  <!--
  window.onload = function() {
      window.focus();
      document.SourceForm.sampleValue.select();
  }

  function sendForm(){
      document.frmsearch.show.click();
  }

  function editItem(idHotel, idRate) {
  	var uri = "SpecialRateEdit.do";
    var params = "?idHotel=" + idHotel + "&idSpecialRate=" + idRate;
    var appereance = "toolbar=0,location=0,status=0,menubar=0,"
        appereance += "height=400,width=620,left=40,top=60";
    var winSource = window.open(uri + params,"sourceForm",appereance);
    winSource.focus();
  }
  // -->
  </script>
</head>

<body>
<form name='SourceForm' id='SourceForm' method='post'>
  <table class='SearchForm'>
    <caption class='Search'>Search information</caption>
    <tr>
      <td align='center'>
          <select name='hotelId' class='Large' id='hotelId'>
              <option value='1' selected>UNIDAD HOTELERA</option>
          </select>
          <input type='text' name='sampleValue' id='sampleValue'
                 value='${query.sampleValue}' maxlength='20'>
          <input type='submit' name='report' value='Show'>
         </td>
	</tr>
  </table>
</form>

<table rules="groups" width="100%">
    <colgroup>
        <col width='80' align='center'>
    </colgroup>
    <colgroup>
        <col width='280'>
    </colgroup>
    <thead>
	    <tr>
	        <th>Id Rate</th>
	        <th>Description</th>
	        <th>Status</th>
	    </tr>
	</thead>

	<tbody>
	<c:forEach var='item' items='${SpecialRateForm.items}' varStatus="status">
	    <tr class='${ ( status.count % 2 == 0 ) ? "Distinct" : "" }'>
			<td><a href="javascript:editItem('${item.map.idHotel}','${item.map.idSpecialRate}')">
			    ${item.map.idSpecialRate}</a></td>
			<td>${item.map.description}</td>
			<td>${item.map.status}</td>
		</tr>
	</c:forEach>
	</tbody>

</table>
</body>

</html>