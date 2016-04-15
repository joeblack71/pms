<%@page isErrorPage='true'%>

<HTML>
<BODY>
Ocurrio el error :
<P> <%= exception.toString()%> <BR>
<P> <%= exception.getMessage()%> <BR>
</BODY>
</HTML>