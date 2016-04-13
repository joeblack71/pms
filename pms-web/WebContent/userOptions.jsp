
<%@ page contentType="text/html" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
          "http://www.w3.org/TR/html4/loose.dtd">

<html>

<head>
    <meta http-equiv="Expires=-1" content="text/html; charset=ISO-8859-1">
    <meta http-equiv="Content-Style-Type" content="text/css">
    <!--<base target="body">-->
    <link rel='stylesheet' type='text/css' href='css/stylesheet.css'>
    <link rel='stylesheet' type='text/css' href='css/navigation.css'>
    <style type="text/css">
    </style>
    <title>Guest Booking</title>
    <script>
    <!--
    function openWindow(uri, popup) {
        if ( popup ) {
            appeareance = "width=840,height=519,left=50,top=100,scrollbars=yes,status=yes,resizable";
            window.open(uri,"popup",appeareance);
        } else {
            window.parent.frames[1].document.location.href = uri;
        }
    }
    // -->
    </script>
</head>

<body>

<!--<img alt="" src="images/brand.gif">-->
<div align="center">
    <div id="brand">
        Central&nbsp;<span>&trade;</span>
    </div>
</div>

<%-- TODO: Cargar nombre del hotel --%>
<%--<h2 style="color: royalblue; text-align: center;">${user.hotelId} Hotel Testing</h2>--%>
<br><br><br>

<div>
<label>
    User:&nbsp;&nbsp;<b>${user.firstname}&nbsp;${user.lastname}</b>
</label>
</div>
<br><br>

<ul id=navigation>
<c:forEach var='opt' items='${uoptions}'>
    <c:set var="uri" value="javascript:openWindow('${opt.URI}',${opt.popup})" />
    <li><a href="${uri}"> ${opt.description} </a>
</c:forEach>
    <!--<li id="exit">
        <a href='http://localhost:8080/guestbooking' target="_parent">
            Close Session
        </a>-->
</ul>

<div align="center">
    <a href='http://localhost:8080/guestbooking'
       target="_parent" style="text-decoration: none;">
        Close Session
    </a>
</div>

Date:&nbsp;&nbsp;<b><%= java.util.Calendar.getInstance().getTime() %><br>
<div id="copy">
<br><br>
<p>Copyright&nbsp;<em>&copy;</em>&nbsp;2007<br>
by&nbsp;<em>Hotel Software Factory</em>
</div>

</body>

</html>