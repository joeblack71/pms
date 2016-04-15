
<%@page errorPage="errorPage.jsp"%>

<%@page import="java.util.ArrayList,java.sql.*"%>
<%@page import="java.text.SimpleDateFormat"%>

<%@page import="beans.*,dispatchers.*"%>

<%--<jsp:useBean id='res' class="beans.detaccount" scope='request'/>--%>

<%  String billheader="Room number", selected = "";
    ArrayList rguest=null; // Huespedes alojados en la hbtn.
    if(session.getAttribute("rguest") != null)
      rguest = (ArrayList)session.getAttribute("rguest");
%>

<%! /*private String formatDate(java.sql.Date sqlDate){
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        String formattedDate = sdf.format(sqlDate.getTime());
        return formattedDate;
    }
    */
%>

<HTML>

<HEAD>
    <META http-equiv="Expires=-1" content="text/html; charset=iso-8859-1">
    <META http-equiv="Content-Style-Type" content="text/css">
    <LINK rel='stylesheet' type='text/css' href="stylesheet.css">
    <TITLE>Room Account</TITLE>
<SCRIPT language='JavaScript' src="validateForm.js">
</SCRIPT>

<SCRIPT type='text/javascript' language='JavaScript'>
<!--
/* submit, controla el envio o no del formulario */
var submit = true;
/* isButton permite identificar que boton fue pulsado */
var isShow = false;
var isSave = false;
var isDelete = false;

function validateSubmit() {
    return submit;
}

function loadDocument(){
    document.frmbill.roomNumber.select();
}

function resetFields() {
    var field, form = document.frmbill;

    for ( i=0; i < form.length; i++ ) {
      field = form.elements[i];
      if ( field.type == 'text' ) // solo limpia cajas de texto
         field.value = "";
    }
    form.arrival.focus();

}
//-->
</SCRIPT>
</HEAD>

<BODY onLoad='loadDocument()'>
<FORM name='frmbill' action="ServGuestBill"
      method="post" onSubmit='return validateSubmit()'>
  <TABLE border='1' align='CENTER'> <!--rules='groups' cellspacing=5-->
  <CAPTION align='left'><H4><%=billheader%>&nbsp;

    <TR><TH><LABEL for='roomNumber'>Room:</LABEL>
        <TD><INPUT type='hidden' name='hotel' value="1">
            <INPUT type='text' name='roomNumber' class='Medium'
                   id='roomNumber' value='0115' maxlength='4'>
            <INPUT type='button' name='search' class='Medium'
                   id='search' value='Search'
                   onClick="searchReservation()">

    <TR><TH class='Form'>
            <LABEL for='guests' class='Medium'>Guest/s:</LABEL>
        <TD><SELECT name='guests' class='Large' id='guests'>
              <OPTION value='Guests List' selected>ANTONIO DEL BUSTO
            </SELECT>
        <!--<TD><SELECT name='guest' class='Large' id='guest'>
<%          /*if ( guests != null ) {
              ResStatus s = new ResStatus();
              for ( int i=0; i < ls.size(); i++ ) {
                s = (ResStatus)ls.get(i);
                if ( s.getStatus().equals(res.getStatus()) )
                  selected="selected";
                else selected="";%>
              <OPTION value='<%=s.getStatus()%>' <%=selected%>> <%=s.getDescription()%>
<%            }
            }*/%>
            </SELECT>
        -->

    <TR><TH class='Form'>
            <LABEL for='roomRate' class='Medium'>Rate - Folio:</LABEL>
        <TD><INPUT type='text' name='roomRate' value='220.00'
                   class='Medium' id='roomRate'>
            <INPUT type='text' name='total' value='2980.00'
                   class='Medium' id='total'>

    <TR><TD colspan='2'>&nbsp;

    <TR><TD colspan='2' align='center'>
            <INPUT type='submit' name='show'   value="New Charge"
                   onClick='validateResNumber(document.frmbill.reservation.value)'>
            <INPUT type='submit' name='save'   value="Correct Charge"
                   onClick='saveReservation(document.frmbill.reservation.value)'>
            <INPUT type='submit' name='delete' value="Transfer Charge"
                   onClick='validateResNumber(document.frmbill.reservation.value)'>
            <INPUT type='button' name='clean'  value="Clean Form" onClick='resetFields()'>

  </TABLE>
</FORM>
<P>
<TABLE width='600' border='1' align='center'>
    <COLGROUP>
        <COL class='Tiny'>
    <COLGROUP>
        <COL span='2' class='Medium'>
        <COL class='Large'>
    <COLGROUP>
        <COL class='Tiny'>
    <COLGROUP>
        <COL class='Medium'>
  <THEAD>
    <TR>
        <TH>#
        <TH>Date
        <TH>Type
        <TH>Detail
        <TH>Operator
        <TH>Amount
  <TBODY>
<%    Connection con = ProveedorCon.getCon();
      String hotel=null, room=null, folio=null;
      int rowCounter=0;

      hotel = request.getParameter("hotel");
      room = request.getParameter("room");
      folio = request.getParameter("folio");
      //System.out.println(room+"-"+folio);

      DisGuestCharge dgch = new DisGuestCharge();
      dgch.setConnection(con);
      ArrayList list = dgch.chargeGuestCharges(hotel,room,folio);
      GuestCharge gch = new GuestCharge();
      while(rowCounter < list.size()){
        gch = (GuestCharge)list.get(rowCounter++);
        if(rowCounter % 2 == 0){%>
    <TR class='DistinctRow'>
<%      }else{%>
    <TR>
<%      }%>
        <TH><%=rowCounter%>
        <TD><%=gch.getDateCharge()%>
        <TD><%=gch.getAccount()%>
        <TD><%=gch.getQuantity()%>
        <TD><%=gch.getCashier()%>
        <TD><%=gch.getAmount()%>
<%    }%>
</TABLE>
</BODY>

</HTML>
