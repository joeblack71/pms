<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<fmt:setLocale value="en_us" />
<fmt:formatNumber var="fmtRoomRate" value="${specialRateValue}"
	pattern="###,##0.00" />
${fmtRoomRate}
