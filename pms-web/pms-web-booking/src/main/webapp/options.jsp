
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:set var="res" value="${activeRes}" />
<c:forEach var="item" items="${res.guests}">
	<option value="${item.key}">${item.value.customerNames}</option>
</c:forEach>
