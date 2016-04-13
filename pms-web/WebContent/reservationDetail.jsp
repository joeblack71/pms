
<%--
Remarks: Used by Availability page to present arrivals report by day
--%>

<%@ page contentType="text/html" %>
<%@ taglib prefix='c' uri='http://java.sun.com/jsp/jstl/core' %>

<%@ page import="java.sql.*" %>
<%@ page import="java.util.ArrayList" %>

<%@ page import="com.mycom.booking.dispatchers.*" %>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 //EN"
          "http://www.w3.org/TR/html4/strict.dtd">
<HTML>
<HEAD>
    <TITLE>Occupation Day: <%= request.getParameter("occupationDay")%> (Detalle)</TITLE>
    <META http-equiv="Expires=-1" content="text/html; charset=iso-8859-1">
    <LINK rel='stylesheet' type='text/css' href='css/stylesheet.css'>
    <STYLE>
        H3 { color: darkcyan }
        THEAD,
        TFOOT  { background: darkcyan; color: white }
        TR.Distinct { background: lightcyan }
    </STYLE>
</HEAD>

<SCRIPT language='JavaScript'>
<!--
    function loadDocument(){
        window.focus();
    }

    function openDetail(reservation){
        URL = "ReservationServlet?hotel='1'&reservation=" + reservation;
        appereance = "width=700,height=350,left=50,top=100,scrollbars=yes,status=yes";
        //alert(URL);
        //window.open(URL,"occupation",appereance)
        window.open(URL);
    }
// -->
</SCRIPT>

<BODY onLoad='loadDocument()'>
<H3>Occupation Day: <%= request.getParameter("occupationDay")%></H3>

<TABLE width='860' rules="groups" border='1' cellspacing='0' cellpadding='2'>
    <COLGROUP>
        <COL class='Tiny'>
    <COLGROUP align='center'>
        <COL id='stay'        class='Medium' align='center' span='2'>
        <COL id='nights'      class='Tiny'   align='right'>
   <COLGROUP>     
        <COL id='paxNames'    class='Large'>
        <COL id='reservation' class='Small'  align='center'>
        <COL id='status'      class='Tiny'   align='center'>
        <COL id='people'      class='Tiny'   align='right' span='2'>
    <COLGROUP>
        <COL id='roomType'    class='Tiny'   align='center'>
        <COL id='roomNumber'  class='Small'  align='center'>
        <COL id='roomRate'    class='Medium' align='right'>
        <COL id='quantity'    class='Tiny'   align='right' span='2'>
    <COLGROUP>
        <COL id='balance'     class='Medium' align='right'>

    <THEAD>
        <TR><TH>#
            <TH>Arrival
            <TH>Departure
            <TH title='Total Nights'>Ngts
            <TH title='Guest names'>Pax
            <TH title='Reservation number'>Reserva.
            <TH title='Reservation status'>Stt
            <TH title='Adults'>Ad
            <TH title='Children'>Ch
            <TH title='Room Type'>RT
            <TH title='Room Number'>Room
            <TH title='Room Rate'>R.Rate
            <TH title='Rooms Quantity'>Qtty
            <TH>Balance

    <TFOOT><TR><TD colspan='14'>&nbsp;
  
    <TBODY>

<%-- TODO: Move database access instructions to a servlet --%>

<%  Connection con = ConProvider.getConnection();

    //Reservation r = new Reservation();
    ReservationDisp rdisp = new ReservationDisp();
    rdisp.setConnection(con);

    String hotel = request.getParameter("hotelId");
    String occupationDay = request.getParameter("occupationDay");
    ArrayList list = rdisp.chargeArrivals(hotel,occupationDay);
    
    try {
        con.close();
    } catch (Exception e) {}
%>

<%  short j = 0; %>
<c:forEach var='r' items='<%= list %>'>
    <TR class='<%= ( j++ % 2 == 0 ) ? "Distinct" : "" %>'>
    <TH><%= j %>
    <TD>${r.arrival}
    <TD>${r.departure}
    <TD>${r.nights}
    <TD>${r.lastName1}, ${r.firstName}
    <TD><A href='ReservationServlet?hotel=${r.hotelId}&reservation=${r.reservation}' >
        ${r.reservation}
    </A>
    <TD>${r.status}
    <TD>${r.adults}
    <TD>${r.children}
    <TD>${r.roomType}
    <TD>${r.roomNumber}
    <TD>${r.roomRate}
    <TD>${r.quantity}
    <TD>${r.total}
</c:forEach>

</TABLE>
</BODY>
</HTML>