
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
  function validateForm(){
      return true;
  }

  function editItem(idItem) {
  	var uri = "RoomEdit.do";
    var parameters = "?idRoom=" + idItem;
    var appereance = "toolbar=0,location=0,status=0,menubar=0,"
        appereance += "height=560,width=940,left=40,top=60";
    var win = window.open(uri + parameters,"roomForm",appereance);

    win.focus();
  }

  window.onload = function() {
      window.focus();
      document.SourceForm.pattern.select();
  }
  // -->
  </script>
</head>

<body>
<form name='listForm' id='SourceForm' method='post'
		onsubmit="validateForm()">
  <table class='Search' width='800' border='0' cellpadding='2'>
    <caption class='Search'>Search information</caption>
    <tr>
      <td align='center'>
          <select name='idHotel' id='idHotel' class='Large' readonly>
              <option value='1' selected>UNIDAD HOTELERA</option>
          </select>
          <!--select name='criterian' id='criterion' class='Large'>
              <option value='commName'>Description</option>
          </select-->
          <input type='text' name='pattern' id='pattern'
                 value='${pattern}' maxlength='20'>
          <input type='submit'>
         </td>
	</tr>
  </table>
</form>

<table width='800' rules="groups">
    <colgroup>
        <col width='80' align='center'>
        <col width='80' align='center'>
        <col width='80' align='center'>
        <col width='140'>
        <col width='80' align='center'>
    </colgroup>
    <thead>
	    <tr>
	        <th>Id Room</th>
	        <th>Room Type</th>
	        <th>Room Number</th>
	        <th>Description</th>
	        <th>Room Rate</th>
	    </tr>
	</thead>

	<tbody>
	<c:forEach var='item' items='${RoomForm.items}' varStatus="status">
	    <tr class='${ ( status.count % 2 == 0 ) ? "Distinct" : "" }'>
			<td><a href="javascript:editItem('${item.map.idRoom}')">
			    ${item.map.idRoom}</a></td>
			<td>${item.map.roomType}</td>
			<td>${item.map.roomNumber}</td>
			<td>${item.map.description}</td>
			<td>${item.map.roomRate}</td>
		</tr>
	</c:forEach>
	</tbody>

</table>
</body>

</html>