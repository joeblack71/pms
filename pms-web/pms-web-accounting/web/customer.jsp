<%@ page errorPage="errorPage.jsp" %>

<%@ page import="java.util.ArrayList" %>
<%@ page import="java.text.SimpleDateFormat" %>
<%@ page import="beans.*,libraries.*" %>

<jsp:useBean id='company' class="beans.Company" scope='request'/>

<%  ArrayList countryList = null, docTypeList = null;
    if ( application.getAttribute("cl") != null )
        countryList = (ArrayList)application.getAttribute("cl");
    if ( application.getAttribute("dtl") != null )
        docTypeList = (ArrayList)application.getAttribute("dtl");
      
    if ( session.getAttribute("customer") != null )
        company = (Company)session.getAttribute("customer");

    String strCaption = null, selected = "";
 %>

<HTML>

<HEAD>
    <META http-equiv="Expires=-1" content="text/html; charset=iso-8859-1">
    <META http-equiv="Content-Style-Type" content="text/css">
    <LINK rel='stylesheet' type='text/css' href="css/stylesheet.css">
    <STYLE> SPAN.Resalt { color: red } </STYLE>
    <TITLE>Guest Information</TITLE>
    <!--<SCRIPT language='JavaScript' src="js/validateForm.js"></SCRIPT>-->
    <SCRIPT type='text/javascript' language='JavaScript'>
    <!--
    function loadDocument(){
        document.frmgst.lastname1.focus();
    }

    function searchCustomer(){
       URL = "guest_search.jsp?selHotel=1";
       appeareance = "width=500,height=350,left=50,top=100,scrollbars=yes";
       // 'refsearch' nos permitira acceder a la ventana creada
       refserach = window.open(URL,"search",appeareance);
    }

    //-->
    </SCRIPT>
</HEAD>

<BODY onLoad='loadDocument()'>
    <TABLE class='Form' align='center' border='0' cellspacing='6' cellpadding='0'> <!--rules='groups'-->
      <FORM name='frmgst' action="GuestServlet" method="post"
              onSubmit='return validateSubmit()'>
      <CAPTION class='Form'><BR><%= customer.getLastName1()+", "+customer.getFirstNames() %><BR>
                            <DIV align='right'> <%= customer.getNationality() %></DIV>
      <COLGROUP>
        <COL STYLE='text-align: left'><COL>
        
      <TR><TD class='Padding'>&nbsp;

      <TR><TH><LABEL for='guestid'>Guest Id</LABEL>

      <TR><TD><INPUT type='hidden' name='hotel' value="1">
              <INPUT type='text' name='customerid'
                     class='Large' id='customerid'
                     maxlength='5' value='<%= customer.getCustomerId() %>'>
              <INPUT type='button' name='search' class='LargeButton'
                     id='search' value='Search'
                     onClick="searchGuest()">

      <TR><TH><LABEL for='lastname1'><SPAN class='Resalt'>*</SPAN>Last Name(s)</LABEL>

      <TR><TD><INPUT type='text' name='lastname1' class='Large' id='lastname1'
                     value='<%= customer.getLastName1() %>' maxlength='15'>
                     <!--onKeyUp='disableSaveButton(document.frmgst)'>-->
              <INPUT type='text' name='lastname2' class='Large' id='lastname2'
                     value='<%= customer.getLastName2() %>' maxlength='15'>

      <TR><TH colspan='2'>
              <LABEL for='firstname'><SPAN class='Resalt'>*</SPAN>&nbsp;First Name(s)</LABEL>
<
      <TR><TD><INPUT type='text' name='firstnames' class='Large' id='firstname'
                     value='<%= customer.getFirstNames() %>' maxlength='15'
                     onKeyUp='disableSaveButton(document.frmgst)'>
              <SELECT name='nationality' class='Large'>
<%  if ( countryList != null ) {
        Country c = new Country();
        for ( int i=0; i < countryList.size(); i++ ) {
            c = (Country)countryList.get(i);
            selected =
             ( c.getCountryId() == customer.getNationality () ) ? "selected" : "";
 %>
                <OPTION value='<%= c.getCountryId() %>' <%= selected %>><%= c.getNationality() %>
<%      }
    } %>
              </SELECT>

      <TR><TH><LABEL for='firstname'><SPAN class='Resalt'>*</SPAN>Document Number and Type</LABEL>

      <TR><TD><INPUT type='text' name='documentNumber'
                     class='Large' id='phone1' maxlength='15'
                     value='<%= customer.getPhone1() %>' title='Phone number 1'>
              <SELECT name='documentType' class='Large'>
<%  if ( docTypeList != null ) {
        DocumentType dt = new DocumentType();
        for ( int i=0; i < docTypeList.size(); i++ ) {
            dt = (DocumentType)docTypeList.get(i);
            selected =
             ( dt.getDocumentType() == customer.getDocumentType() ) ? "selected" : "";
 %>
                <OPTION value='<%= dt.getDocumentType() %>'><%= dt.getDescription() %>
<%      }
    } %>
              </SELECT>


      <TR><TH><LABEL for='address1'><SPAN class='Resalt'>*</SPAN>Address</LABEL>

      <TR><TD><INPUT type='text' name='address1'
                     class='XLarge' id='address1' style='width: 325px'
                     value='<%= customer.getAddress1() %>' title='Address 1'
                     maxlength='50'>
                     
      <TR><TD><INPUT type='text' name='address2'
                     class='XLarge' id='address2' style='width: 325px'
                     value='<%= customer.getAddress2() %>' title='Address 2'
                     maxlength='50'>

      <TR><TH><LABEL for='country'>City & Country of Residence</LABEL>

      <TR><TD><INPUT type='text' name='city' class='Large' id='city'
                     maxlength='10' value=''
                     onChange='<%= customer.getCity() %>' >
              <SELECT name='country' class='Large'>
<%  if ( countryList != null ) {
        Country c = new Country();
        for ( int i=0; i < countryList.size(); i++ ) {
            c = (Country)countryList.get(i);
            selected =
             ( c.getCountryId() == customer.getCountryId() ) ? "selected" : "";
 %>
                <OPTION value='<%= c.getCountryId() %>' <%= selected %>><%= c.getCountryName() %>
<%      }
    } %>
              </SELECT>

      <TR><TH><LABEL for='phone1'>Phones / E-mail</LABEL>

      <TR><TD><INPUT type='text' name='phone1' class='Large' id='phone1'
                     value='<%= customer.getPhone1() %>' title='Phone number 1'
                     maxlength='15'>
              <INPUT type='text' name='phone2' class='Large' id='phone2'
                     value='<%= customer.getPhone2() %>' title='Phone number 2'
                     maxlength='15'>

      <!--<TR><TH><LABEL for='email'>E-mail</LABEL>-->

      <TR><TD><INPUT type='text' name='email'
                 class='XLarge' id='phone1' style='width: 325px'
                 value='<%= customer.getEmail() %>' title='Electronic Mail (e-mail)'
                 maxlength='50'>

      <TR><TH><LABEL for='source'>Source of Bussiness / Contact</LABEL>

      <TR><TD><INPUT type='text'   name='source'
                     value='<%= customer.getSource() %>'
                     class='Large' id='source'>
              <INPUT type='button' name='srclook' value='Look Source'
                     class='LargeButton' id='srclook'>

      <TR><TD><INPUT type='text' name='contact'
                     class='XLarge' id='contact' style='width: 325px'
                     value='<%= customer.getContact() %>' title='Guest contact'
                     maxlength='50'>

      <TR><TH><LABEL for='contact'>Requests for Guest</LABEL>

      <TR><TD><TEXTAREA name='requests' id='requests' rows='4' cols='40'
                        style='color: blue; width: 325px'><%= customer.getRequests() %></TEXTAREA>

      <TR><TD class='Padding'>&nbsp;

      <TR><TD  class='Padding' align='center'>
              <INPUT type='submit' name='show' Class='MediumButton' value="Show"
                     onClick='showGuest(document.frmgst.customer.value)'>
              <INPUT type='submit' name='save' Class='MediumButton' value="Save"
                     onClick='saveGuest(document.frmgst.customer.value)'>
              <INPUT type='submit' name='delete' Class='MediumButton' value="Delete"
                     onClick='deleteGuest(document.frmgst.customer.value)'>
              <INPUT type='button' name='reset' Class='MediumButton' value="New"
                     onClick='resetFields(document.frmgst)'>
              <!--<INPUT type='submit' name='exit' value="Exit"
                     onClick='window.close()'>-->

    </TABLE>
  </FORM>
</BODY>

</HTML>
