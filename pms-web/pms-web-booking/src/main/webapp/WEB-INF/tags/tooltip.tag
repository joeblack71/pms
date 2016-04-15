<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@ tag display-name="tooltip" description="tooltip" %>
<%@ attribute name="forid"%>
<%@ attribute name="label"%>
<%@ attribute name="msg"%>
<%-- Requiere wz_tooltip.js (usado en DefaultLayout)  --%>
<%--<a class="tooltip" href="javascript:;" onmouseover="Tip('${msg}')">${label}</a>--%>
<label class="tooltip" onmouseover="Tip('${msg}')" for="${forid}">${label}</label>