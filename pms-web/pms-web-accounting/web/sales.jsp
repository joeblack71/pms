<%--
    <%@ page errorPage="errorPage.jsp" %>
--%>

<%@ page import="java.sql.*, java.util.ArrayList" %>
<%@ page import="beans.*" %>
<%@ page import="libraries.DateManager" %>

<jsp:useBean id='receipt' class="beans.Receipt" scope='request' />

<%  session.setAttribute("caller","sales.jsp");

    String receiptSerial = "001", issueDate = "", paymentDate = "";
    try {
        issueDate = DateManager.formatDate( receipt.getIssueDate() );
        paymentDate = DateManager.formatDate( receipt.getPaymentDate() );
    } catch(Exception e) { e.getMessage(); }
    
    receiptSerial = ( receipt.getReceiptSerial() == 0 ) ? "001" :
                      String.valueOf( receipt.getReceiptSerial() );
%>    
    
<%    // TODO: Probar uso de Tags customizados
    String[][] messages = {{"001","Número de comprobante incorrecto !!"},
                           {"002","Fecha de Emisión inválida !!"},
                           {"003","Monto ingresado es inválido !!"},
                           {"004","El comprobante requiere de un documento de Cliente valido !!"},
                           {"005","Formato de Fecha de cancelación invalido !!"},
                           {"006","Comprobante no registrado !!"},
                           {"100","La operación requerida se completo exitosamente !!"}
                          };
    String requestStatus = "", message = "";
    requestStatus = (String)request.getAttribute("requestStatus");
    if ( requestStatus != null ) {
        for ( int i=0,j=0; i < messages.length; i++,j++ ) {
            if ( requestStatus.equals( messages[i][0] ) )
                message = messages[i][1];
        }
    }
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
<SCRIPT type='text/javascript' language='JavaScript'>
<!--
function loadDocument() {
    document.frmrec.correlative.select();
}

function receiptSearch(receiptType) {
   URL = "receiptSearch.jsp?hotel=1&receiptType";
   appeareance = "width=660,height=450,left=50,top=100,scrollbars=yes,status=yes";
   // 'refsearch' nos permite acceder a la nueva "receipt_search.jsp"
   refsearch = window.open(URL,"search",appeareance);
}

function customerSearch(customerDoc) {
   URL = "customerSearch.jsp?";
   appeareance = "width=560,height=450,left=50,top=100,scrollbars=yes,status=yes";
   refsearch = window.open(URL,"search",appeareance);
}

// Todo: Validar en linea el ingreso del cliente
function getCustomerName(entityDoc){
   //alert(customerDoc);
   //document.frmrec.customerName.value = /* valor devuelto por funcion */;
   /*window.location.href="CompanyServlet?hotel=1&customerId=customerDoc";*/
}

function setTaxes(amount){
   /*var tax1_rate = 0.19, tax2_rate = 0.10;
   var tax1 = amount * tax1_rate;
   var tax2 = amount * tax2_rate;
   var total = tax1 + tax2 + parseInt(amount);*/

   /*form = document.frmrec;
   form.tax1.value = tax1;
   form.tax2.value = tax2;
   form.totalReceipt.value = total;*/
}

//-->
</SCRIPT>
</HEAD>

<%  java.text.DecimalFormat df = new java.text.DecimalFormat("#,###,##0.00");
    String selected=null, checked=null;
%>

    <BODY onLoad='loadDocument()'>
    <TABLE class='Form' align='center' border='0' cellspacing='0' cellpadding='2'>
      <FORM name='frmrec' action="ReceiptServlet" method="post"
              onSubmit='return validateSubmit()'>
      <CAPTION class='Form'>
          Registro de Ventas
          <DIV align='right'>
              <A href='salesReport.jsp'
                 style='color: white'>
               Ver Reporte</A>
           </DIV>
      <COLGROUP>
          <COL class='Large' align='left'>
          <COL><COL>
          
      <TFOOT class='Form'>
          <TR>
<%            if ( receipt.getUpdatedOn() != null ) { %>
              <TD colspan='3' align='right'>
                  Modificado:&nbsp;${receipt.updatedOn}&nbsp;<BR>&nbsp;
<%            } else { %>
              <TD colspan='3'>&nbsp;<BR><BR>
<%            }%>
              
      <TBODY>
      <TR><TD class='Padding' colspan='3'>&nbsp;

      <TR><TD><LABEL for='receiptType'>Tipo Comprobante</LABEL>
          <TD><INPUT type='hidden' name='hotel' value='1'> <!-- for hotels -->
              <SELECT name='receiptType' class='Large' tabindex='1'>
<%            if ( lrt != null ) {
                  ReceiptType rt = new ReceiptType();
                  for ( int i=0; i < lrt.size(); i++ ) {
                      rt = (ReceiptType)lrt.get(i);
                      selected =
                       ( rt.getReceiptType() == receipt.getReceiptType() )?"selected":"";
%>
                <OPTION value='<%= rt.getReceiptType() %>' <%= selected %>>
                        <%= rt.getDescription()%>
<%                }
              } %>
              </SELECT>
          <TD><INPUT type='button' name='docsearch'
                     class='Button Large' id='docsearch' tabindex='2'
                     value='Busq. Comprobante' onClick="receiptSearch()">

      <TR><TD><LABEL for='receiptSerial'>
                  <FONT color='red'>*</FONT>&nbsp;Serie
                  <SPAN style='color: silver'>||</SPAN>&nbsp;Correlativo
              </LABEL>
          <TD><INPUT type='text' name='receiptSerial'
                     class='Number Large' id='receiptSerial'
                     tabindex='3' maxlength='3'
                     value='<%= receiptSerial %>'
                     title="Numero de Serie"
                     onKeyUp='disableSaveButton(document.frmrec)'>
          <TD><INPUT type='text' name='correlative'
                     class='Number Large Remark' id='correlative'
                     tabindex='4' maxlength='6'
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
                     class='Number Large Remark' id='issueDate'
                     tabindex='5' maxlength='10'
                     value='<%= issueDate %>' maxlength='10'
                     title="Fecha de EMISIÓN (DDMMAA)"
                     onKeyUp='disableSaveButton(document.frmrec)'>
          <TD><INPUT type='text' name='paymentDate'
                     class='Number Large' id='paymentDate'
                     tabindex='6' maxlength='10'
                     value='<%= paymentDate %>' maxlength='10'
                     title="Fecha de CANCELACIÓN (DDMMAA)"
                     onKeyUp='disableSaveButton(document.frmrec)'>

      <TR><TD><LABEL for='soles'>Moneda
                  <FONT style='color: silver'>||</FONT> Cambio
              </LABEL>
          <TD align='center'>
              <LABEL for='soles'>Soles</LABEL>
<%            checked = ( receipt.getMoney().equals("S") ||
                          receipt.getMoney().equals("") ) ? "checked" : ""; %>
              <INPUT type='radio' name='money' value='S'
                     class='Tiny NoBorder' id='soles' <%= checked %> tabindex='7' >
              <LABEL for='dolar'>Dolares</LABEL>
<%            checked = ( receipt.getMoney().equals("D") ) ? "checked" : ""; %>
              <INPUT type='radio' name='money' value='D'
                     class='Tiny NoBorder' id='dolar' <%= checked %> tabindex='7'>
<%            df.applyPattern("##0.000"); %>
          <TD><INPUT type='text' name='exchange'
                     class='Number Large' maxlength='5' tabindex='9'
                     value='<%= df.format( receipt.getExchange() )%>'
                     title="Tipo de cambio utilizado">
<%            df.applyPattern("#,###,##0.00"); %>

      <TR><TD><LABEL for='status'>Estado</LABEL>
          <TD><SELECT name='status' class='Large' tabindex='10'>
<%            if ( lrs != null ) {
                  ReceiptStatus rs = new ReceiptStatus();
                  for ( int i=0; i < lrs.size(); i++ ) {
                      rs = (ReceiptStatus)lrs.get(i);
                      selected =
                       ( rs.getReceiptStatus().equals(receipt.getStatus()) ) ? "selected" : "";
%>
                <OPTION value='<%= rs.getReceiptStatus()%>' <%= selected %>>
                    <%= rs.getDescription() %>
<%                }
              } %>
              </SELECT>
          <TD><INPUT type='text' name='filler' value='' disabled
                     class='Large' style='background: whitesmoke'>

      <TR><TD class='Padding' colspan='3'>&nbsp;

      <TR><TD><LABEL for='entityDoc'>Documento de Cliente</LABEL>
          <TD><INPUT type='text' name='entityDoc'
                     class='Large' id='entityDoc'
                     tabindex='11' maxlength='15'
                     value='${receipt.entityId}'
                     title="Numero de identificacion del Cliente"
                     onChange=''>
          <TD><INPUT type='button' name='custsearch'
                     class='Button Large' id='custsearch'
                     tabindex='12' value='Busqueda Cliente'
                     onClick="customerSearch(frmrec.entityDoc.value)">

      <TR><TD><LABEL>Nombre</LABEL>
          <TH colspan='2'>
              <INPUT type='text' name='customerName'  readonly
                     class='XLarge' id='customerName'
                     style='width: 326; font-weight: bold'
                     value='${receipt.entityName}'>

      <TR><TD class='Padding' colspan='3'>&nbsp;

      <TR><TD><LABEL for='net'><FONT color='red'>*</FONT>&nbsp;Venta Neta</LABEL>
          <TD><INPUT type='text' name='net'
                     class='Number Large' id='net'
                     tabindex='13' maxlength='10'
                     value='<%= df.format( receipt.getNet() ) %>'
                     title="Total sin impuestos"
                     onKeyUp='disableSaveButton(document.frmrec)'>
          <TD><INPUT type='button' name='detailReceipt' disabled
                     class='Button Large' id='detailReceipt'
                     value=''
                     onClick="detailReceipt()">

      <TR><TD><LABEL for='tax1'>IGV&nbsp;(19%)</LABEL>
          <TD><INPUT type='text' name='tax1' readonly
                     class='Number Large' id='tax1'
                     value='<%= df.format( receipt.getTax1() ) %>'>
          <% checked = (receipt.isExempt()) ? "checked" : ""; %>
          <TD align='right'>
              <LABEL for='exempt'>Exonerado</LABEL>
              <INPUT type='checkbox' name='exempt'
                     id='exempt' tabindex='14'
                     style='border: none' <%= checked %> >

      <TR><TD><LABEL for='service'>Servicios&nbsp;(10%)</LABEL>
          <TD><INPUT type='text' name='service' readonly
                     class='Number Large' id='service'
                     value='<%= df.format( receipt.getService() ) %>'>
          <% checked = ( receipt.isApplyService() ) ? "checked" : ""; %>
          <TD align='right'>
              <LABEL for='applyService'>Aplica Servicios</LABEL>
              <INPUT type='checkbox' name='applyService' <%= checked %>
                     id='applyService' style='border: none' tabindex='15'>

      <TR><TH><LABEL>Total Comprobante</LABEL>
          <TD><INPUT type='text' name='totalReceipt' readonly
                     class='Number Large' id='totalReceipt'
                     style='background: lightcyan; font-weight: bold'
                     value='<%= df.format( receipt.getReceiptTotal() ) %>'
                     title="Valor total venta">
          <!-- Todo: validar multiples formas de pago -->
          <TD><SELECT name='paymentType' class='Large' tabindex='16'>
<%            if ( lpt != null ) {
                  PaymentType pt = new PaymentType();
                  for ( int i=0; i < lpt.size(); i++ ) {
                      pt = (PaymentType)lpt.get(i);
                      selected =
                       ( pt.getPaymentType() == receipt.getPaymentType() )?"selected":"";
%>
                <OPTION value='<%= pt.getPaymentType() %>' <%= selected %>>
                    <%= pt.getDescription()%>
<%                }
              } %>
              </SELECT>

      <!--
      <TR><TH colspan='3'>
          <LABEL for='comments'>Comments</LABEL>
          <TEXTAREA name='comments' id='requests' rows='4' cols='40'
                    style='color: blue; width: 325px'><%-- ${receipt.comments} --%>
          </TEXTAREA>
      -->

      <TR><TD colspan='3'>&nbsp;

      <TR style='height: 24px'><TD colspan='3' align='center'>
              <INPUT type='submit' name='show'
                     class='Button Large' style='font-weight: bold'
                     value="Mostrar" tabindex='17
                     onClick='showReceipt(document.frmrec)''>
              <INPUT type='submit' name='save'
                     class='Button Large' style='font-weight: bold'
                     value="Grabar" tabindex='18'
                     onClick='saveReceipt(document.frmrec)'>
              <INPUT type='submit' name='new'
                     class='Button Large' value="Nuevo"
                     tabindex='19' style='font-weight: bold'
                     onClick='resetFields(document.frmrec)'>
              <!--
              <INPUT type='submit' name='cancel'
                     class='MediumButton' value="Anular" tabindex='19'
                     onClick='cancelReceipt(document.frmrec)'>
              -->

      <!--<TR><TD colspan='3'>&nbsp;-->

    </TABLE>
  </FORM>
</BODY>

</HTML>
