<%-- 03/07/2008 
	Fragmento utilizado para mostrar las tarifas por tipo
	de habitacion que tiene asociada una tarifa especial.
--%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<c:set var="form" value="${SpecialRateForm}" />
<table>
	<thead style="background-color: buttonface;">
		<tr>
			<td class="Small">&nbsp;</td>
			<!--td>Id Period</td>
			<td>Period</td-->
			<td>Room type</td>
			<td>Rate</td>
			<!--td>Start date</td>
			<td>End date</td-->
			<td>Updated on</td>
			<td>Updated by</td>
		</tr>
	</thead>
	<tbody>
			<c:forEach var="item" items="${form.item.rates}" >
		<tr><%--td class="Center">
				<span title="Del ${item.map.startDate} al ${item.map.endDate}">
					<c:out value="${item.map.idPeriod}" /></span></td>
			<td class="Center">
				<c:out value="${item.map.periodDescription}" /></td--%>
			<td class="Medium">&nbsp;</td>
			<td><c:out value="${item.map.rtDescription}" /></td>
			<td class="Number">
				<c:out value="${item.map.roomValue}" /></td>
			<%--td class="Center">
				<c:out value="${item.map.startDate}" /></td>
			<td class="Center">
				<c:out value="${item.map.endDate}" /></td--%>
			<td class="Center">
				<c:out value="${item.map.lastUpdate}" /></td>
			<td class="Center">
				<c:out value="${item.map.updatedBy}" /></td>
		</tr>
			</c:forEach>
	</tbody>
</table>
