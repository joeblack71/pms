<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>

<%@ taglib tagdir="/WEB-INF/tags" prefix="t" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Flash Status</title>
<style type="text/css">
	.number {
		text-align: right;
	}
</style>
<script>
<!--
	function forward() {
		var form = document.getElementByName('filterForm');
		var startDate = document.getElementById('startDate').value;
		var base = "http://localhost:8080/central";
		var url = base + "/forwardFlashStatus.do?idHotel=1&idRoomType=1&statusDate=" + startDate;

		//window.location = url;
		form.action = base + "/forwardFlashStatus.do";
		form.submit();
	}
	
	window.onload = function() {
		//window.focus();
	}
-->
</script>
</head>

<body>

<br />

<table align="center" cellspacing="0" cellpadding="0" width="100%">
	<!-- caption style="border: solid 1px"><h3>Hotel Flash Status</h3></caption-->
	<!--colgroup><col></col></colgroup>
	<colgroup align="right"><col align="right"></col></colgroup-->
	<!--thead>
		<tr>
			<td>&nbsp;</td>
		</tr>
	</thead-->
		<tr>
			<td id="filtro" style="border: solid">
			<form name="filterForm" method="post">
			<table class="searchForm" width="100%" align="center">
				<tr><td>&nbsp;</td></tr>
				<tr>
					<td align="center">
						<input type="hidden" name="idHotel" id="idHotel" value="1" >
						<%--label>Hotel</label>
						<t:select name="idHotel" id="idHotel"
							value="1" items="${hotels}"
							onchange="validateNotEmpty(this)" /--%>
						<label>Room Type</label>
						<t:select name="idRoomType" id="idRoomType"
							value="1" items="${roomTypeList}"
							onchange="validateNotEmpty(this)" />
						<input type="text" name="idRoomType" id="idRoomType"
							value="1" class="Large" readonly="readonly">
						<label>
							<%--t:checkbox name="filter.status" id="status" value="C"
								test="${status == 'C'}">
								</t:checkbox--%>
							Tentatives
							<input type="checkbox" name="status" id="status" value="">
						</label></td>
				</tr>
				<tr>
					<td align="center">
						<label>Period</label>
						<t:select name="period" id="period"
							value="${period}" items="${periodTypes}"
							onchange="validateNotEmpty(this)" />
						<label>Start Date</label>
						<input type="text" name="startDate" id="startDate"
							value="${startDate}" class="Large" maxlength="10">
						<img src="" alt="Cal" border="1" width="20">
						<input type="submit" name="button" value="Show"
							onclick="showAvailability()"></td>
				</tr>
			</table>
			</form>
			</td></tr>
		<tr><td id="matrix">
		<table width="100%" border="0">
		<tr>
			<td colspan="7">&nbsp;</td>
		</tr>
		<tr>
			<td>
			<table id="titles" width="100%">
				<tr>
					<td>&nbsp;</td>
				</tr>
				<tr>
					<td>Total Rooms</td>
				</tr>
				<tr>
					<td>&nbsp;</td>
				</tr>
				<tr>
					<td>Tentative Rooms</td>
				</tr>
				<tr>
					<td>Confirmed Rooms</td>
				</tr>
				<tr>
					<td>Locked Rooms</td>
				</tr>
				<tr>
					<td>Maintenance Rooms</td>
				</tr>
				<tr>
					<td>&nbsp;</td>
				</tr>
				<tr>
					<td>Available Rooms</td>
				</tr>
			</table></td>
			<td>	
					<c:if test="${!empty flashStatusBean}">
				<input type="hidden" id="startDate"
					value="${flashStatusBean.matrix[0][flashStatusBean.lastCol]}">
				<table id="data" width="100%">
						<c:forEach var="row" items="${flashStatusBean.matrix}"
							varStatus="rowStatus" end="${flashStatusBean.rows}">
							<c:if test="${ (rowStatus.count == 3)
										|| (rowStatus.count == 7) }">
					<tr>
						<td colspan="7">&nbsp;</td>
					</tr>
							</c:if>
					<tr>
							<c:forEach var="cell" items="${row}"
								begin="${flashStatusBean.firstCol}"
								end="${flashStatusBean.lastCol}">
						<td class="number">${cell}</td>
							</c:forEach>
					</tr>
						</c:forEach>
				</table>
					</c:if></td>
		</tr>
		<tr>
			<td colspan="7">&nbsp;</td>
		</tr>
		</table></td></tr>
	<tbody>
		<tr>
			<td colspan="7" align="right" style="border: solid 1px">
				<input type="button" value="Next" onclick="forward()"></td>
		</tr>
	</tbody>
</table>

</body>
</html>

<jsp:include page="/pages/errors.jsp" />
