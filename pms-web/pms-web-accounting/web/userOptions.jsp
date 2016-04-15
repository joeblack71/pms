
<%@page contentType="text/html" %>
<%@page import="java.sql.*, java.util.*" %>
<%@page import="beans.*" %>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 //EN"
          "http://www.w3.org/TR/html4/strict.dtd">

<HTML>
<HEAD>
  <META http-equiv="Expires=-1" content="text/html; charset=iso-8859-1">
  <META http-equiv="Content-Style-Type" content="text/css">
  <LINK rel='stylesheet' type='text/css' href='css/stylesheet.css'>
  <STYLE type='text/css'>
         P{ font: 8pt verdana, serif; color:white; text-align: justify }
         P.Remark{font: bold 8pt verdana, serif; color:white; text-align: justify }
         EM{ font-weight: bold }
  </STYLE>
  <TITLE>Registro de Ventas de Hoteles</TITLE>
</HEAD>

<%  AppUser user = null;
    if ( session.getAttribute("user") != null )
        user = (AppUser)session.getAttribute("user");

    ArrayList usrOptions = null;
    if ( session.getAttribute("uoptions") != null )
        usrOptions = (ArrayList)session.getAttribute("uoptions");

    Calendar today = Calendar.getInstance();
%>
<BODY class='Menu'>

<P><BR><BR>
<LABEL>User:<BR>
    &nbsp;<B><%=user.getFirstname()%>&nbsp;<%=user.getLastname()%></B>
    <BR><BR>
</LABEL>
        
<TABLE class='Menu' style='width: 180px'>
    <CAPTION>&nbsp;</CAPTION>
    <COLGROUP><COL>
    <THEAD>
        <TR><TH align='center' style='background: steelblue; color: white'>
            Menu Options

    <TFOOT style='background: steelblue; color: white'>
        <TR><TH align='center'>
                <A target='body' href="http://www.google.com.pe"
                   class='Menu' style='color: white'
                   onmouseover='this.style.background="white";
                                this.style.color="steelblue"'
                   onmouseout ='this.style.background="steelblue";
                                this.style.color="white"'>
                   Home Site
                </A>

    <TBODY>    
        <TR><TH>&nbsp;
<%  if ( user != null && usrOptions != null ) {
        String target = null;
        for ( int i=0; i < usrOptions.size(); i++ ) {
           MenuOption opt = (MenuOption)usrOptions.get(i);
 %>
        <TR><TD align='center'>
                <A class='Menu' target='body' href='<%=opt.getResourceName()%>'
                   onmouseover='this.style.background="white";
                                this.style.color="steelblue"'
                   onmouseout ='this.style.background="steelblue";
                                this.style.color="white"'>
                   <%=opt.getDescription()%>
                </A>
<%     }
    } %>
        <TR><TD>&nbsp;<BR><BR>
        <TR><TD>&nbsp;
</TABLE>
<P>
<!--Sistema hotelero <EM>CHSS</EM>.-->
<P><%=today.getTime()%>
<P>Copyright&nbsp;<EM>&copy; 2007</EM><BR>
by&nbsp;<EM>GS Technologies.</EM>
</BODY>
</HTML>