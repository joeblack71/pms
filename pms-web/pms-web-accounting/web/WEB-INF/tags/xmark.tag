<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ tag display-name="xmark" description="xmark" %>
<%@ attribute name="test"%>
<c:choose>
    <c:when test="${test}">
        X
    </c:when>
    <c:otherwise>
        -
    </c:otherwise>
</c:choose>

