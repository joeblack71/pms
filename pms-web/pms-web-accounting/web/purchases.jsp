<%--<%@ page errorPage="errorPage.jsp" %>--%>
<%--<%@ include file="valReservationForm.js" %>--%>

<%@ page import="java.sql.*,java.util.ArrayList" %>
<%@ page import="beans.*,dispatchers.*,libraries.*" %>

<jsp:useBean id='receipt' class="beans.Receipt" scope='request' />

<!-- TODO: Falta definir como se manejara los casos en los que el IGV, no
corresponda con el monto pagado del documento. e.g. Telefono (otros Cargos)
-->
<%  //session.setAttribute("transaction","purchase");
    session.setAttribute("caller","purchases.jsp");

    String receiptSerial = "001", issueDate = "", paymentDate = "";
    try {
        issueDate = DateManager.formatDate( receipt.getIssueDate() );
        paymentDate = DateManager.formatDate( receipt.getPaymentDate() );
    } catch(Exception e) { e.getMessage(); }
    receiptSerial = ( receipt.getReceiptSerial() == 0 ) ? "001" :
                          String.valueOf( receipt.getReceiptSerial() );
%>    
    
<%  // TODO: Probar uso de Tags customizados
    String[][] messages = {{"001","Número de comprobante incorrecto !!"},
                           {"002","Fecha de Emisión inválida !!"},
                           {"003","Monto ingresado es inválido !!"},
                           {"004","El comprobante requiere de un documento de Cliente valido !!"},
                           {"005","Formato de Fecha de cancelación invalido !!"},
                           {"006","Comprobante no registrado !!"},
                           {"100","La operación requerida se completo exitosamente !!"}
                          };
    String message = "";
    String requestStatus = (String)session.getAttribute("requestStatus");
    if ( requestStatus != null ) {
        for ( int i=0,j=0; i < messages.length; i++,j++ ) {
            if ( requestStatus.equals( messages[i][0] ) )
                message = messages[i][1];
        }
    }
%>    
    
<%  java.text.DecimalFormat df = new java.text.DecimalFormat("#,###,##0.00");
    String selected=null, checked=null;
%>

<%    // TODO: Probar uso de Tags customizados
    ArrayList lrt = (ArrayList)application.getAttribute("lrt"),
              lrs = (ArrayList)application.getAttribute("lrs"),
              lpt = (ArrayList)application.getAttribute("lpt");
%>

<HTML>

<HEAD>
    <META http-equiv="Expires=-1" content="text/html; charset=iso-8859-1">
    <META http-equiv="Content-Style-Type" content="text/css">
    <LINK rel='stylesheet' type='text/css' href="css/stylesheet.css">
    <TITLE>Registro de Comprobantes de Pago</TITLE>
    <SCRIPT language='JavaScript' src="js/validateForm.js"></SCRIPT>
    <STYLE>
        /*INPUT, INPUT.Button Large, SELECT { color: teal }*/
    </STYLE>

<SCRIPT type='text/javascript' language='JavaScript'>
<!--
function loadDocument(){
    document.frmrec.correlative.focus();
}

function searchReceipt(){
   URL = "receiptSearch.jsp?hotel=1";
   appeareance = "width=660,height=450,left=50,top=100,scrollbars=yes";
   // 'refsearch' nos permitira acceder a la ventana creada
   refsearch = window.open(URL,"search",appeareance);
}

function providerSearch(providerDoc){
   URL = "providerSearch.jsp?";
   appeareance = "width=500,height=350,left=50,top=100,scrollbars=yes,status=yes";
   refsearch = window.open(URL,"search",appeareance);
}

// Todo: Validar en linea el ingreso del cliente
function getProviderName(entityDoc){
   //alert(entityDoc);
   //document.frmrec.providerName.value = /* valor devuelto por funcion */;
   /*window.location.href="CompanyServlet?hotel=1&providerDoc=entityDoc";*/
}

function setTaxes(amount){
   /*var tax1_rate = 0.19, tax2_rate = 0.10;
   var tax1 = amount * tax1_rate;
   var tax2 = amount * tax2_rate;
   var total = tax1 + tax2 + parseInt(amount);

   form = document.frmrec;
   form.tax1.value = tax1;
   form.tax2.value = tax2;
   form.totalReceipt.value = total;*/
}

//-->
</SCRIPT>
</HEAD>

<BODY onLoad='loadDocument()'>
    <TABLE class='Form' align='center'
           style='border-color: teal'
           border='0' cellspacing='0' cellpadding='2'> <!--rules='groups'-->
      <FORM name='frmrec' action="ReceiptServlet" method="post"
              onSubmit='return validateSubmit()'>
      <CAPTION class='Form' style='background: teal'>
          Registro de Compras
          <DIV align='right'>
              <A href='purchasesReport.jsp'
                 style='color: white'>
               Ver Reporte</A>
           </DIV>
      <COLGROUP>
          <COL class='Large' align='left'>
          <COL><COL>
      <TFOOT class='Form' style='background: teal'>
          <TR>
<%                if ( receipt.getUpdatedOn() != null ) {
%>
              <TD colspan='3' align='right'>
                  Modificado:&nbsp;<%= receipt.getUpdatedOn() %>&nbsp;<BR>&nbsp;
<%                } else { 
%>
              <TD colspan='3'>&nbsp;<BR><BR>
<%                } %>

      <!-- TODO: Agregegar campos para ingresar referencia de Notas Credito y Notas de Debito -->
      <TBODY>
      <TR><TD class='Padding' colspan='3'>&nbsp;

      <TR><TD><LABEL for='receiptType'>Tipo Comprobante</LABEL>
          <TD><INPUT type='hidden' name='hotel' value='1'> <!-- for hotels -->
              <SELECT name='receiptType' class='Large'>
<%            if ( lrt != null ) {
                  ReceiptType rt = new ReceiptType();
                  for ( int i=0; i < lrt.size(); i++ ) {
                      rt = (ReceiptType)lrt.get(i);
                      selected =
                       ( rt.getReceiptType() == receipt.getReceiptType() )?"selected":"";
%>
                <OPTION value='<%= rt.getReceiptType() %>' <%= selected %>>
                        <%= rt.getDescription() %>
<%                }
              } %>
              </SELECT>
          <TD><INPUT type='button' name='docsearch'
                     class='Button Large' id='docsearch'
                     value='Busqueda Comp.' onClick="searchReceipt()">

      <TR><TD><LABEL for='receiptSerial'>
                  <FONT color='red'>*</FONT>&nbsp;Serie
                  <SPAN style='color: silver'>||</SPAN>&nbsp;Correlativo
              </LABEL>
          <TD><INPUT type='text' name='receiptSerial'
                     class='Number Large' id='receiptSerial' maxlength='3'
                     value='${receipt.receiptSerial}'
                     title="Numero de Serie"
                     onKeyUp='disableSaveButton(document.frmrec)'>
          <TD><INPUT type='text' name='correlative'
                     class='Number Large' id='correlative' maxlength='10'
                     value='${receipt.correlative}'
                     title="Numero Correlativo"
                     onKeyUp='disableSaveButton(document.frmrec)'>

      <TR><TD colspan='3' align='center'>
<%          String color = "";
            if ( requestStatus != null )
                color = ( requestStatus.equals( "100" ) ) ? "green" : "red";
%>
              &nbsp;<span style='color: <%= color %>'><%= message %></span>

      <TR><TD><LABEL for='issueDate'>Emisi&oacute;n
                  <SPAN style='color: silver'>||</SPAN>&nbsp;Cancelaci&oacute;n
              </LABEL>
          <TD><INPUT type='text' name='issueDate'
                     class='Number Large' id='issueDate' maxlength='10'
                     value='<%= issueDate %>' maxlength='10'
                     title="Fecha de EMISIÓN del comprobante (DDMMAA)"
                     onKeyUp='disableSaveButton(document.frmrec)'>
          <TD><INPUT type='text' name='paymentDate'
                     class='Number Large' id='paymentDate' maxlength='10'
                     value='<%= paymentDate %>' maxlength='10'
                     title="Fecha de CANCELACIÓN del comprobante (DDMMAA)">

      <TR><TD><LABEL for='soles'>Moneda
                  <SPAN style='color: silver'>||</SPAN> Cambio
              </LABEL>
          <TD align='center'>
              <LABEL for='soles'>Soles</LABEL>
<%            checked = ( receipt.getMoney().equals("S") ||
                          receipt.getMoney().equals("") ) ? "checked" : "";
%>
              <INPUT type='radio' name='money' value='S'
                     class='Tiny' id='soles' style='border: none' <%= checked %>>
              <LABEL for='dolar'>Dolares</LABEL>
<%            checked = ( receipt.getMoney().equals("D") ) ? "checked" : "";
%>
              <INPUT type='radio' name='money' value='D'
                     class='Tiny' id='dolar' style='border: none' <%= checked %>>
          <TD><INPUT type='text' name='exchange'
                     class='Number Large' maxlength='5'
<%            df.applyPattern("##0.000");
%>
                     value='<%= df.format( receipt.getExchange() ) %>'
<%            df.applyPattern("#,###,##0.00");
%>
                     title="Tipo de cambio utilizado">

      <TR><TD><LABEL for='status'>Estado</LABEL>
          <TD><SELECT name='status' class='Large'>
<%            if ( lrs != null ) {
                  ReceiptStatus rs = new ReceiptStatus();
                  for ( int i=0; i < lrs.size(); i++ ) {
                      rs = (ReceiptStatus)lrs.get(i);
                      selected =
                       ( rs.getReceiptStatus().equals(receipt.getStatus()) )?"selected":"";
%>
                <OPTION value='<%= rs.getReceiptStatus() %>' <%= selected %>>
                    <%= rs.getDescription() %>
<%                }
              } %>
              </SELECT>
          <TD><INPUT type='text' name='padding' class='Large' disabled>

      <TR><TD class='Padding' colspan='3'>&nbsp;

      <TR><TH><LABEL for='entityDoc'>Proveedor(RUC)</LABEL>
          <TD><INPUT type='text' name='entityDoc'
                     class='Large' id='entityDoc' maxlength='15'
                     value='${receipt.entityId}'
                     title="Numero de identificacion del Proveedor"
                     onChange=''>
          <TD><INPUT type='button' name='custsearch'
                     class='Button Large' id='custsearch'
                     value='Busqueda Proveedor'
                     onClick="entitySearch(this.value)">

      <TR><TD><LABEL>Nombre
          <TH colspan='2' align='left'>
              <INPUT type='text' name='entityName'
                     class='XLarge' id='entityName'
                     style='width: 327; padding: 2px 0px;'
                     value='${receipt.entityName}' ReadOnly>

      <TR><TD class='Padding' colspan='3'>&nbsp;

      <TR><TH><LABEL for='net'><SPAN color='red'>*</SPAN>&nbsp;Venta Neta</LABEL>
          <TD><INPUT type='text' name='net'
                     class='Number Large' id='net' maxlength='10'
                     value='<%= df.format( receipt.getNet() ) %>'
                     title="Total sin impuestos"
                     onKeyUp='disableSaveButton(document.frmrec)'>
          <TD><INPUT type='button' name='detailReceipt'
                     class='Button Large' id='detailReceipt'
                     value='Detalle'
                     onClick="detailReceipt()">

      <TR><TD><LABEL for='tax1'>IGV&nbsp;(19%)</LABEL>
          <TD><INPUT type='text' name='tax1' disabled
                     class='Number Large' id='tax1'
                     value='<%= df.format( receipt.getTax1() ) %>'>
<%                checked = ( receipt.isExempt() ) ? "checked" : "";
%>
          <TD align='right'>
              <LABEL for='exempt'>Exonerado</LABEL>
              <INPUT type='checkbox' name='exempt'
                     id='exempt' style='border: none' <%= checked %> >

                     <TR><TD><LABEL for='tax2'>Servicios</LABEL>
                  <SPAN style='color: silver'>||</SPAN>&nbsp;Tasa(%)
              </LABEL>
          <TD><INPUT type='text' name='tax2' disabled
                     class='Number Large' id='tax2'
                     value='<%= df.format( receipt.getService() ) %>'>
          <TD><INPUT type='text' name='servicePercent'
                     style='width: 80px; text-align: right'
                     title='Ingrese porcentaje de servicio'
                     value='<%= df.format( receipt.getServicePercent() ) %>'>
<%                checked = ( receipt.isApplyService() ) ? "checked" : "";
%>
              <LABEL for='applyService'>&nbsp;&nbsp;&nbsp;Aplica</LABEL>
              <INPUT type='checkbox' name='applyService'
                     id='applyService' style='border: none' <%= checked %> >

      <TR><TH><LABEL>Total Comprobante</LABEL>
          <TD><INPUT type='text' name='totalReceipt' ReadOnly
                     class='Number Large' id='totalReceipt' style='font-weight: bold'
                     value='<%= df.format( receipt.getReceiptTotal() ) %>'
                     title="Valor total venta">
          <!-- Todo: validar multiples formas de pago -->
          <TD><SELECT name='paymentType' class='Large'>
<%            if ( lpt != null ) {
                  PaymentType pt = new PaymentType();
                  for ( int i=0; i < lpt.size(); i++ ) {
                      pt = (PaymentType)lpt.get(i);
                      selected =
                       ( pt.getPaymentType() == receipt.getPaymentType() )?"selected":"";
%>
                <OPTION value='<%= pt.getPaymentType() %>' <%= selected %>>
                    <%= pt.getDescription() %>
<%                }
              } %>
              </SELECT>

      <!--
      <TR><TH colspan='3'>
          <LABEL for='comments'>Comments</LABEL>

      <TR><TD colspan='3'>
          <TEXTAREA name='requests' id='requests' rows='4' cols='40'
                    style='color: blue; width: 325px'><%-- <%= receipt.getRequests() %> --%></TEXTAREA>
      -->

      <TR><TD class='Padding' colspan='3'>&nbsp;

      <TR style='height: 24px'><TD  class='Padding' colspan='3' align='center'>
              <INPUT type='submit' name='show'
                     class='Button Large' style='font-weight: bold'
                     value="Mostrar"
                     onClick='showReceipt(document.frmrec)'>
              <INPUT type='submit' name='save'
                     class='Button Large' style='font-weight: bold'
                     value="Grabar"
                     onClick='saveReceipt(document.frmrec)'>
              <INPUT type='button' name='reset'
                     class='Button Large' style='font-weight: bold'
                     value="Nuevo"
                     onClick='resetFields(document.frmrec)'>
              <!--       
              <INPUT type='submit' name='cancel'
                     class='MediumButton' value="Anular">
                     onClick='deleteReceipt(document.frmrec)'>
              -->
              <!--<INPUT type='submit' name='exit' value="Exit"
                     onClick='window.close()'>-->

      <!--               
      <TR><TD class='Padding' colspan='3'>&nbsp;
      -->

    </TABLE>
  </FORM>
</BODY>

</HTML>
