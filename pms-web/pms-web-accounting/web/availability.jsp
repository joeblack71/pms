
<%@page contentType="text/html"%>
<%--<%@page errorPage="errorPage.jsp"%>--%>

<%@page import="beans.AvailabilityQry"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 //EN"
          "http://www.w3.org/TR/html4/strict.dtd">

<HTML>
<HEAD>
  <META http-equiv="Expires=-1" content="text/html; charset=iso-8859-1">
  <!--<META http-equiv="Content-Style-Type" content="text/css">
  <LINK rel='stylesheet' type='text/css' href="stylesheet.css">-->
  <TITLE>Disponibilidad de habitaciones</title>
<SCRIPT type='text/javascript' languaje='JavaScript'>
<!--
function loadDocument(){
    window.focus();
    document.frmFilter.startDate.select();
}

/*function sendForm(){
    document.frmFilter.show.click();
}*/

function openDetail(occday){
   URL = "resdetail.jsp?selHotel="+this.frmFilter.selHotel.value+
         "&occupationDay="+occday;
   characteristics = "status=yes,resizable=no,toolbar=no," +
                     "scrollbars=yes,width=700,height=350,left=50,top=100";
   //alert(URL);
   window.open(URL,"occupation",characteristics)
}
// -->
</SCRIPT>
</HEAD>

<%! public void jspInit(){}

    public void jspDestroy(){}
%>

<%! private java.sql.Date getSqlDate(){
      java.util.Calendar cal = java.util.Calendar.getInstance();
      java.sql.Date sqlDate = new java.sql.Date(cal.getTimeInMillis());
      return sqlDate;
    }

    private String getStringToday(java.sql.Date sqlStartDate){
      /*java.util.Calendar cal = java.util.Calendar.getInstance();
      java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat("ddMMyy");
      sdf.setCalendar(cal);*/
      java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat("ddMMyy");
      java.util.Date utilDate = new java.util.Date(sqlStartDate.getTime());
      String strDate = sdf.format(utilDate);
      return strDate;
    }
%>

<jsp:useBean id='aq' class="beans.AvailabilityQry" />

<%  java.sql.Date sqlStartDate=null;
    String strStartDate=null;

    //System.out.println("llego a 'availability.jsp'");
    if(session.getAttribute("aq") != null){
      //System.out.println("aq no es null ;)");
      aq = (AvailabilityQry)session.getAttribute("aq");
      strStartDate = getStringToday(aq.getStartDate());
    } else {
      //System.out.println("aq es null !! :(");
      sqlStartDate = getSqlDate();
      aq.setStartDate(sqlStartDate);
      strStartDate = getStringToday(sqlStartDate);
    }

    String[][] availability=null;
    if(session.getAttribute("matriz") != null) {
      //System.out.println("matriz no es null");
      availability = (String[][])session.getAttribute("matriz");
    }

    //System.out.println("3 "+availability.length);
%>

<BODY onload='loadDocument()'>
<BR>
<FORM method='post' name='frmFilter' action="CtrlAvailability">
  <TABLE class='Search'>
    <!--<CAPTION>Rango de Consulta</CAPTION>-->
    <TR>
      <TD><LABEL for='selHotel'>Hotel</LABEL>
          <INPUT type='hidden' name='selHotel' value='1'>
          <SELECT name='selHotel' id='hotel' disabled>
            <OPTGROUP label="Hotel">
              <OPTION value='1' selected>Mossone</OPTION>
              <OPTION value='2'>Ayacucho</OPTION>
              <OPTION value='3'>Nazca</OPTION>
              <OPTION value='4'>Tacna</OPTION>
              <OPTION value='5'>Moquegua</OPTION>
            </OPTGROUP>
          </SELECT>
      <TD><LABEL for='startDate'>Start</LABEL>
          <INPUT type='text' name='startDate' class='Medium'
                 id='startDate' value='<%=strStartDate%>'
                 maxlength='10'>
          <SELECT name='selPeriod'>
            <OPTGROUP label="Periodo">
              <OPTION value='W' selected>Semana</OPTION>
              <OPTION value='M'>Mes</OPTION>
              <OPTION value='Q'>Trimestre</OPTION>
              <OPTION value='S'>Semestre</OPTION>
              <OPTION value='Y'>Año</OPTION>
            </OPTGROUP>
          </SELECT>
          <INPUT type='submit' name='show' value='Show'>
          <INPUT type='submit' name='next' value='Next'>
  </TABLE>
</FORM>

<!--
<IFRAME name='ifrAvailability' scrolling="yes" FrameBorder="1"
        width="600" height="300">
</IFRAME>
-->
<%  if(availability != null) {
      //System.out.println("4 "+availability[0].length);
%>
<!--<TABLE border='1' rules='groups' cellspacing='1'>-->
<TABLE border='1'>
    <CAPTION align='left'><%="Start date: " + aq.getStartDate()%></CAPTION>
    <COLGROUP>
        <COL class='Medium'>
    <COLGROUP>
        <COL class='Medium' span='7'>
    <COLGROUP>
        <COL class='Medium'>
    <THEAD>
        <TR>
            <TH>Room Type
<%     for(int i=1; i < availability[0].length - 1; i++){%>
            <TH><A href="javascript:openDetail('<%=availability[0][i]%>')">
                <%=availability[0][i]%></A>
<%     }%>
            <TH>Total Period
    <TBODY>
        <TR><TD colspan=<%=availability[0].length%>>&nbsp;
<%     for(int i=1;i < availability.length - 1;i++){%>
        <TR><TH><%=availability[i][0]%>
<%       for(int j=1;j < availability[0].length;j++){%>
            <TD><%=availability[i][j]%>
<%       }%>
<%     }%>
    <TFOOT>
        <TR><TD colspan=<%=availability[0].length%>>&nbsp;
        <TR class='Total'>
            <TH>Total Rooms
<%     for(int i=1; i < availability[0].length; i++){%>
            <TD><%=availability[availability.length - 1][i]%>
<%     }%>
</TABLE>
<%  }%>

</BODY>
</HTML>