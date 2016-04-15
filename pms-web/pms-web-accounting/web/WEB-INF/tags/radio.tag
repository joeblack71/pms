<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ tag display-name="radio" description="radio" %>
<%@ attribute name="name"%>
<%@ attribute name="value"%>
<%@ attribute name="test"%>
<%@ attribute name="onclick"%>
<%@ attribute name="extraHtml"%>
<c:choose>
    <c:when test="${test}">
        <c:set var="checkedHtml">checked="true"</c:set>
    </c:when>
    <c:otherwise>
        <c:set var="checkedHtml" value=""/>
    </c:otherwise>
</c:choose>
<input type="radio" name="${name}" value="${value}" onclick="${onclick}" ${extraHtml} ${checkedHtml}/>
