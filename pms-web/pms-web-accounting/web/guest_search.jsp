
<%@page contentType="text/html"%>

<%@page import="java.sql.*, java.util.*"%>
<%@page import="beans.*, dispatchers.*"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 //EN"
          "http://www.w3.org/TR/html4/strict.dtd">

<HTML>
<HEAD>
  <META http-equiv="Expires=-1" content="text/html; charset=iso-8859-1">
  <!--<META http-equiv="Content-Style-Type" content="text/css">
  <LINK rel='stylesheet' type='text/css' href="stylesheet.css">-->
  <TITLE>Busqueda de Reservas</title>
<SCRIPT type='text/javascript' languaje='JavaScript'>
<!--
function loadDocument(){
    window.focus();
    document.frmsearch.lastname.select();
}

function sendForm(){
    document.frmsearch.show.click();
}

function getReservation(reservation){
   //alert(reservation);
   window.opener.frmres.reservation.value = reservation;
   window.opener.frmres.show.click();
   window.opener.focus();
   window.close();
}
// -->
</SCRIPT>
</HEAD>

<%! public void jspInit(){}

    public void jspDestroy(){}
    
    private String getSqlFormat(String arrival) {
       java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat("ddMMyy");
       java.util.Date utilDate = null;
       try {
         utilDate = sdf.parse(arrival);
       } catch (Exception e) {}
       sdf.applyPattern("yyyy-MM-dd");
       String sqlFormat = sdf.format(utilDate);
       return sqlFormat;
    }
%>

<%--<jsp:useBean id='aq' class="beans.AvailabilityQry" />--%>

<%  /*if(session.getAttribute("aq") != null)
      aq = (AvailabilityQry)session.getAttribute("aq");*/
%>

<BODY onload='loadDocument()'>
<FORM method='post' action="reservsearch.jsp" name='frmsearch' id='frmsearch'>
  <TABLE class='Search'>
    <!--<CAPTION>Rango de Consulta</CAPTION>-->
    <TR>
      <TD><!--<LABEL for='hotel'>Hotel</LABEL>-->
          <INPUT type='hidden' name='hotel' value='1'>
          <!--
          <SELECT name='selhotel' id='hotel' disabled>
            <OPTGROUP label="Hotel">
              <OPTION value='1' selected>Mossone</OPTION>
              <OPTION value='2'>Ayacucho</OPTION>
              <OPTION value='3'>Nazca</OPTION>
              <OPTION value='4'>Tacna</OPTION>
              <OPTION value='5'>Moquegua</OPTION>
            </OPTGROUP>
          </SELECT>
          -->
          <LABEL for='arrival'>Arrival</LABEL>
          <INPUT type='text' name='arrival'
                 class='Medium' id='arrival' value='' maxlength='10'>
          <LABEL for='lastname'>Lastname</LABEL>
          <INPUT type='text' name='lastname'
                 class='Medium' id='lastname' value='' maxlength='15'>
          <INPUT type='submit' name='show' value='Show'>
  </TABLE>
</FORM>

<%  String hotel = request.getParameter("hotel");
    String arrival = request.getParameter("arrival");
    String lastname = request.getParameter("lastname");
    //System.out.println("search: "+hotel+"-"+lastname);

    if(hotel != null && arrival != null && lastname != null){
%>
<TABLE rules="groups">
    <COLGROUP>
        <COL width='50' class='Small'>
    <COLGROUP>
        <COL width='150' class='Large'>
    <COLGROUP>
        <COL width='150' class='Large'>
    <COLGROUP>
        <COL width='100' class='Medium'>
  <THEAD>
    <TR>
        <TH>Reserva
        <TH>Apellido
        <TH>Nombre
        <TH>Llegada
  <TBODY>
<%    Connection con = ProveedorCon.getCon();
      DisReservation dr = new DisReservation();
      dr.setConnection(con);
      ArrayList list = null;
      if ( lastname.length() > 0 ) {
         list = dr.chargeByLastname(hotel,lastname);
      } else {
        if ( arrival.length() >= 6 ) {
           arrival = getSqlFormat(arrival);
           list = dr.chargeByArrival(hotel,arrival);
        }
      }

      Reservation r = new Reservation();
      int rowCounter=0;
      while(rowCounter < list.size()){
        r = (Reservation)list.get(rowCounter++);
        if(rowCounter % 2 == 0){%>
    <TR class='DistinctRow'>
<%      }else{%>
    <TR>
<%      }%>
        <TD><A href='javascript:getReservation(<%=r.getReservation()%>)'>
               <%=r.getReservation()%></A>
        <TD><%=r.getLastname()%>
        <TD><%=r.getFirstname()%>
        <TD><%=r.getArrival()%>
<%    }%>
</TABLE>
<%  }%>
</BODY>
<!-- Example about correct way for open a secondary window (popup)
<A href="pop.html" target="ventana"
 onclick="pop(this.src,this.target,'scrollbars=yes'); return false;">
 Abrir Ventana
</A>

-->

</HTML>