
<%@page contentType="text/html" %>

<%@page import="java.sql.*" %>
<%@page import="java.util.*" %>

<%@page import="com.mycom.booking.beans.*" %>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 //EN"
          "http://www.w3.org/TR/html4/strict.dtd">

<HTML>
<HEAD>
    <META http-equiv="Expires=-1" content="text/html; charset=iso-8859-1">
    <META http-equiv="Content-Style-Type" content="text/css">
    <!-- <LINK rel='stylesheet' type='text/css' href='css/stylesheet.css'> -->
    <STYLE type='text/css'>
        BODY { BACKGROUND-COLOR: lightskyblue; color: white; } /*#D19275*/
        A:link, A:visited { color: yellow; }
        /*A:active { color: orange; }*/
        P { font: 8pt verdana, serif; color: white; text-align: justify }
        P.Remark { font: bold 8pt Verdana, Serif;
                   color: white; text-align: justify
        }
        EM { font-weight: bold; }
        
        LABEL { color: white; }
        
    </STYLE>
    <SCRIPT>
    <!--
    function resaltLink(link) {
        link.style.color = "orange";
    }
    function normalLink(link) {
        link.style.color = "yellow";
    }
    // -->
    </SCRIPT>
    <TITLE>Guest Booking</TITLE>
</HEAD>

<%  AppUser user = (AppUser)session.getAttribute("user");
    ArrayList usrOptions = (ArrayList)session.getAttribute("uoptions");
%>
<BODY class='Menu'>
    <span style='font-size: 26pt'>Central</span>&nbsp;&trade;

<%-- TODO: Cargar nombre del hotel --%>
<H2>${user.hotelId}</H2>
<P>
<BR><BR>
<LABEL>
    User:<BR>&nbsp;<B>${user.firstname}&nbsp;${user.lastname}</B>
</LABEL>
<BR><BR>

<TABLE class='Menu'>
    <TBODY>    
        <TR><TD style='background: white'>&nbsp;
<%      String target = null;
        MenuOption mo = null;
        java.util.Iterator options = usrOptions.iterator();
        while ( options.hasNext() ) {
            mo = (MenuOption)options.next();
 %>
        <TR><TD align='center'>
                <!--
                   onmouseover='this.style.background="white";
                                this.style.color="steelblue"'
                   onmouseout ='this.style.background="steelblue";
                                this.style.color="white"'>
                -->
                <A class='Menu' id='linkOpt' target='body' href='<%= mo.getURI() %>'
                   onmouseover='resaltLink(this)'
                   onmouseout ='normalLink(this)'>
                   <%= mo.getDescription()%>
                </A>
<%     } %>
        <TR><TD>&nbsp;<BR><BR>
        <TR><TD>&nbsp;
</TABLE>
<P>

<p><%= Calendar.getInstance().getTime() %>
<p>Copyright&nbsp;<EM>&copy; 2007</em><br>
by&nbsp;<em>Global Software Factory</em>
</body>
</html>