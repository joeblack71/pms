
<!-- Lista actualizada de huespedes -->

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>

	<c:out value="${fn:length(guests)}" />
	<!-- select name="guest" id="roomGuest" class="XLarge Remark"
		onchange="updateGuestInfo()"-->
		<c:forEach var="item" items="${guests}">
			<option value="${item.key}">${item.value.customerNames}</option>
		</c:forEach>
	<!-- /select-->