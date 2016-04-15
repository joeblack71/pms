
<%@page contentType="text/html"%>

<%@page import="java.sql.*"%>
<%@page import="java.util.ArrayList"%>

<%@page import="beans.Reservation"%>
<%@page import="dispatchers.ProveedorCon"%>
<%@page import="dispatchers.DisReservation"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 //EN"
          "http://www.w3.org/TR/html4/strict.dtd">
<HTML>
<HEAD>
  <TITLE>Ocupacion del: <%=request.getParameter("occupationDay")%> (Detalle)</TITLE>
  <META http-equiv="Expires=-1" content="text/html; charset=iso-8859-1">
  <!--<LINK rel='stylesheet' type='text/css' href='body.css'>-->
</HEAD>

<SCRIPT language='JavaScript'>
<!--
function loadDocument(){
    window.focus();
}
// -->
</SCRIPT>

<%!  public void jspInit(){}

     public void jspDestroy(){}
%>

<BODY onLoad='loadDocument()'>
<H3>Dia: <%=request.getParameter("occupationDay")%></H3>

<%   Connection con=null;
     ResultSet  rs=null;
     ArrayList  list=null;

     Reservation    r  = new Reservation();
     DisReservation dr = new DisReservation();

     String     hotel=null, occupationDay=null;
     double     totAfecto=0, totExento=0,
                totImpto1=0, totImpto2=0, totMonDoc=0;

     int totRooms=0, totAdult=0, totChildren=0, rowCounter=0;

     con = ProveedorCon.getCon();
     dr.setConnection(con);
%>
<TABLE width='1200' rules="groups">
    <COLGROUP>
        <COL class='Tiny'>
    <COLGROUP>
        <COL class='Small'>
    <COLGROUP>
        <COL span='2' class='Large'>
        <COL class='Tiny'>
    <COLGROUP>
        <COL span='4' class='Small'>
    <COLGROUP>
        <COL span='2' class='Medium'>
        <COL class='Small'>
        <COL span='2' class='Medium'>
    <COLGROUP>
        <COL class='Medium, Number'>
  <THEAD>
    <TR>
        <TH>#
        <TH>Reserva
        <TH>Apellido
        <TH>Nombre
        <TH>Estado
        <TH>Tipo Hbtn.
        <TH>Numero Hbtn.
        <TH>Tarifa
        <TH>Cant. Hbtns.
        <TH>Llegada
        <TH>Salida
        <TH>Noches
        <TH>Adultos
        <TH>Niños
        <TH>Total Hbtn.
  <TBODY>
<%    hotel=request.getParameter("hotel");
      occupationDay=request.getParameter("occupationDay");
      System.out.println(occupationDay);
      list=dr.chargeArrivals(hotel,occupationDay);
      while(rowCounter < list.size()){
        r = (Reservation)list.get(rowCounter++);
        if(rowCounter % 2 == 0){%>
    <TR class='DistinctRow'>
<%      }else{%>
    <TR>
<%      }%>
        <TH><%=rowCounter%>
        <TD><%=r.getReservation()%>
        <TD><%=r.getLastname()%>
        <TD><%=r.getFirstname()%>
        <TD><%=r.getStatus()%>
        <TD><%=r.getRoomType()%>
        <TD><%=r.getRoomNumber()%>
        <TD><%=r.getRoomRate()%>
        <TD><%=r.getQuantity()%>
        <TD><%=r.getArrival()%>
        <TD><%=r.getDeparture()%>
        <TD><%=r.getNights()%>
        <TD><%=r.getAdults()%>
        <TD><%=r.getChildren()%>
        <TD><%=r.getTotal()%>
<%    }%>
</TABLE>
</BODY>
</HTML>