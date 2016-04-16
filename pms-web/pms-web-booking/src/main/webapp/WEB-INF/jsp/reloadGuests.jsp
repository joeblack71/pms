
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<select name="guestView.guestnames" id="guests" class="XLarge Remark">
	<c:forEach var="item" items="${res.guests}">
		<option value="${item.key}">${item.value.customerNames}</option>
		<c:set var="cancel" value="${42}" />
		<c:if test="${item.value.status != cancel}">
			<option value="${item.key}">${item.value.customerNames}</option>
		</c:if>
	</c:forEach>
</select>
