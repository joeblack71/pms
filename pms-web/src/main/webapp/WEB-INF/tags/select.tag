<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<%@ tag display-name="select" description="select" %>
<%@ attribute name="name"%>
<%@ attribute name="id"%>
<%@ attribute name="items" type="java.util.List"%>
<%@ attribute name="value"%>
<%@ attribute name="onchange"%>
<%@ attribute name="tabindex"%>
<%@ attribute name="extraHtml"%>

<select name="${name}" id="${id}" onchange="${onchange}" tabindex="${tabindex}" ${extraHtml}>
    <option value="">Select</option>
    	<c:forEach var="item" items="${items}">
        	<c:choose>
            	<c:when test="${item.map.value == value}">
    <option value="${item.map.value}" selected="true">${item.map.label}</option>
            	</c:when>
            	<c:otherwise>
    <option value="${item.map.value}">${item.map.label}</option>
            	</c:otherwise>
        	</c:choose>
    	</c:forEach>
</select>
