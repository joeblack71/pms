
<%@page contentType="text/html"%>

<%@page import="java.sql.*, java.util.*"%>
<%@page import="beans.*, dispatchers.*, libraries.*"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 //EN"
          "http://www.w3.org/TR/html4/strict.dtd">

<HTML>
<HEAD>
  <META http-equiv="Expires=-1" content="text/html; charset=iso-8859-1">
  <META http-equiv="Content-Style-Type" content="text/css">
  <LINK rel='stylesheet' type='text/css' href="css/stylesheet.css">
  <TITLE>Detalle del comprobante</title>
<SCRIPT type='text/javascript' languaje='JavaScript'>
<!--
function loadDocument(){
    window.focus();
    document.frmdetail.pattern.select();
}

function sendForm(){
    document.frmdetail.show.click();
}

function getCustomer(receiptType,receiptSerial,correlative) {
   //alert(correlative);
   window.opener.frmrec.receiptType.value = receiptType;
   window.opener.frmrec.receiptSerial.value = receiptSerial;
   window.opener.frmrec.correlative.value = correlative;
   window.opener.frmrec.show.click();
   window.opener.focus();
   window.close();
}
// -->
</SCRIPT>
</HEAD>

<%  ArrayList litems=null,lritems=null;
    if ( session.getAttribute("litems") != null )
        litems = (ArrayList)session.getAttribute("litems");
    if ( session.getAttribute("lritems") != null )
        lritems = (ArrayList)session.getAttribute("lritems");
%>

<BODY onload='loadDocument()'>
    <FORM method='post' name='frmdetail' action="ReceiptDetailServlet" >
    <TABLE>
        <CAPTION class='Form'>Carga Detalle</CAPTION>
        <TR><TD><!--<LABEL for='hotel'>Hotel</LABEL>-->
                <INPUT type='hidden' name='hotel' value='1'>
                <LABEL for='itemId'>Item</LABEL>
            <TD><SELECT name='items'>
<%      if ( litems != null ) {
            Item it = new Item();
            for (int i=0; i < litems.size(); i++) {
                it = (Item)litems.get(i); %>
                    <OPTION value='<%=it.getItemId()%>'>
                            <%=it.getDescription()%>
                    </OPTION>
<%          }
        } %>
                </SELECT>
            <TD><LABEL for='quantity'>Cantidad</LABEL>
                <INPUT type='text' name='quantity'
                       class='Small' id='quantity' value='' maxlength='2'>
            <TD><LABEL for='price'>Precio</LABEL>
                <INPUT type='text' name='price'
                       class='Small' id='price' value='' maxlength='2'>
            <TD><INPUT type='submit' name='Adicionar' value='Adicionar'>
                <INPUT type='submit' name='Eliminar'  value='Eliminar'>
    </TABLE>
    </FORM>

<TABLE width='480' rules="groups">
    <COLGROUP>
        <COL class='Medium'>
    <COLGROUP>
        <COL class='Small'><COL class='Small'><COL class='Medium'><COL>
    <THEAD>
        <TR class='Header'>
            <TH>Emision
            <TH>Tipo
            <TH>Serie
            <TH>Correlativo
            <TH>Cliente
    <TBODY>
<%      if ( lritems != null ) {
            ReceiptDetail rd = new ReceiptDetail();
            String chargeDate=null, chargeDescription=null,
                   quantity=null, price=null,
                   totalCharge=null, operator=null;
            for (int i=0; i < lritems.size(); i++) {
                rd = (ReceiptDetail)lritems.get(i);
                chargeDate        = rd.getChargeDate();
                //chargeDescription = rd.getChargeDescription();
                quantity          = String.valueOf( rd.getQuantity() );
                price             = String.valueOf( rd.getPrice() );
                totalCharge       = String.valueOf( rd.getTotalCharge() );
                operator          = rd.getOperatorInitials();
                if ( i % 2 == 0 ) {%>
        <TR class='DistinctRow'>
<%              } else { %>
        <TR>
<%              }%>
            <TD><%=chargeDate%>
            <TD><%=quantity%>
            <TD><%=price%>
            <TD><%=totalCharge%>
            <TD><%=operator%>
<%          }
        } %>
</TABLE>
</BODY>
<!-- Example about correct way for open a secondary window (popup)
<A href="pop.html" target="ventana"
 onclick="pop(this.src,this.target,'scrollbars=yes'); return false;">
 Abrir Ventana
</A>
-->

</HTML>