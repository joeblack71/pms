<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ tag display-name="checkbox" description="checkbox" %>
<%@ attribute name="name"%>
<%@ attribute name="id"%>
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
<input type="checkbox" name="${name}" id="${id}" value="${value}" onclick="${onclick}" ${extraHtml} ${checkedHtml}/>
