
<%@ page contentType="text/html" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
          "http://www.w3.org/TR/html4/loose.dtd">

<html>

<head>
    <meta http-equiv="Expires=-1" content="text/html; charset=ISO-8859-1">
    <meta http-equiv="Content-Style-Type" content="text/css">
    <!--<base target="body">-->
    <link rel='stylesheet' type='text/css' href='../../css/stylesheet.css'>
    <link rel='stylesheet' type='text/css' href='../../css/navigation.css'>

    <script>
    <!--
    function openWindow(option, uri, popup) {
    	var AVAILABILITY = 3;
    	var modalFeatures;
    	
		uri = "<%= request.getContextPath() %>/" + uri;
        if ( popup ) {
            appeareance  = "menubar=0,toolbar=0,location=0,status=0";
            //modalFeatures = "dialogWidth:820px; dialogHeight:420px; center:yes";
            //modalFeatures += "edge:sunken; resizable:yes; scroll:yes; status=no";
	    	if ( option == AVAILABILITY ) {
	            appeareance += ",width=780,height=400,left=80,top=140,scrollbars=0,resizable";
	        } else {
            	appeareance += ",width=920,height=440,left=50,top=100,scrollbars=0,resizable";
            }
            window.open(uri,"popup",appeareance);
			//showModalDialog(uri,"showAvailability",modalFeatures);            
        } else {
            alert(uri+';'+window.parent.frames[1].name);
            window.parent.frames[1].document.location.href = uri;
        }
    }
    //-->
    </script>
</head>

<body>

<!--<img alt="" src="images/brand.gif">-->
<div align="center">
	<br />
    <div class="brand">
        Central&nbsp;<span>&trade;</span>
    </div>
</div>

<div class="date">
	<br /><br />	
	&nbsp;<%= java.util.Calendar.getInstance().getTime() %><br />
</div>

<%-- TODO: Cargar nombre del hotel --%>
<%--<h2 style="color: royalblue; text-align: center;">${user.hotelId} Hotel Testing</h2>--%>

<div class="user">
	<br /><br />
	User:&nbsp;<i><c:out value="${user.firstname} ${user.lastname}" /></i>
</div>

<div class="menu">
	<ul class="navigation">
	        <c:out value="size: ${fn:length(userOptions)}" />
			<c:forEach var='opt' items='${userOptions}'>
	    	<c:set var="uri" value="javascript:openWindow('${opt.idOption}','${opt.URI}',${opt.popup})" />
	    <li><a href="${uri}"> ${opt.description} </a></li>
			</c:forEach>
	    <!--li id="exit">
	        <a href='Authenticate.do' target="_parent">
	            Close Session
	        </a></li-->
	</ul>
</div>

<!--div align="center">
    <a href='http://localhost:8080/guestbooking'
       target="_parent" style="text-decoration: none;">
        Close Session
    </a>
</div-->

<div class="copy">
	<br /><br />
	Copyright&nbsp;&copy;&nbsp;2007
	<br />by&nbsp;MyCo Solutions
</div>

</body>

</html>