<%@page contentType="text/html"%>
<%@page pageEncoding="UTF-8"%>

<%@ page import="com.mycom.booking.beans.AvailabilityQry" %>
<%@ page import="com.mycom.booking.lists.OccupationByDays" %>
<%@ page import="com.mycom.booking.controllers.AvailabilityCtlr" %>

<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%> 

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>

    <h1>JSP Page</h1>
    
    <%--
    This example uses JSTL, uncomment the taglib directive above.
    To test, display the page like this: index.jsp?sayHello=true&name=Murphy
    --%>
    <%--
    <c:if test="${param.sayHello}">
        <!-- Let's welcome the user ${param.name} -->
        Hello ${param.name}!
    </c:if>
    --%>

<%  AvailabilityQry aq = new AvailabilityQry();
    short s = 1;
    aq.setHotelId( s );
    aq.setRoomType("SJ");
    aq.setStartDate("011207");
    aq.setEndDate("031207");
    OccupationByDays obd = new OccupationByDays();
    AvailabilityCtlr ac = new AvailabilityCtlr();
    ac.setOccupationList(obd);
    ac.chargeOccupationOnStay(aq);
%>
    <c:forEach var="item" items="<%= obd %>">
        ${item.occupiedRooms}
    </c:forEach>
    
    </body>
</html>
