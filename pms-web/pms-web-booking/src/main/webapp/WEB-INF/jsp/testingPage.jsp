<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<c:set var="ctx" value="${pageContext.request.contextPath}" />

<html>

<head>
<!--meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1"-->
<title>Insert title here</title>
<script type="text/javascript">
<!--
	function openWindow() {
		var url = "${ctx}/flashStatus.do"; 
		var params = "?idHotel=1&idRoomType=1&statusDate=01/01/2009";
		var appereance = "width=800, height=400, top=100, left=100"
					   + ", toolbar=yes, scrollbars=yes";
		

		//alert(url + params);
		var win = window.open(url, "flashStatus", appereance);

		win.focus(); 
	}
-->
</script>
</head>

<body>
	<table align="center">
		<tr>
			<td>
				<a href="javascript:openWindow()">Hotel Flash Status</a></td>
		</tr>
	</table>
</body>

</html>