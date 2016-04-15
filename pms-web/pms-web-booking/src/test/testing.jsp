<%@page contentType="text/html"%>

<%-- Muestra contenido de pagina excel 
<%@ page contentType="application/vnd.ms-excel" %>
--%>
<!-- Observe que hay tabuladores, no espacios entre columnas. -->
<!--
1997 1998 1999 2000 2001
12.3 13.4 14.5 15.6 16.7
-->

<%@page pageEncoding="UTF-8"%>
<%@taglib uri="/WEB-INF/tlds/reports.tld" prefix="mytag"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Test customized tags</title>
</head>
<body>

<mytag:report />

</body>
</html>

<!-- Example about correct way for open a secondary window (popup)
<A href="pop.html" target="ventana"
 onclick="pop(this.src,this.target,'scrollbars=yes'); return false;">
 Abrir Ventana
</A>

-->

