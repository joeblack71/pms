
<%@ page contentType="text/html;charset=ISO-8859-1" %>
<%--<%@ page errorPage="errorPage.jsp" %>--%>
<%@ taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core" %>

<%@ page import="java.util.ArrayList" %>
<%@ page import="java.util.Iterator" %>
<%@ page import="java.text.SimpleDateFormat" %>

<%@ page import="com.mycom.booking.beans.*" %>
<%@ page import="com.mycom.booking.libraries.DateManager" %>

<jsp:useBean id="co" class="com.mycom.booking.beans.Company" scope='request' />

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.0 Transitional//EN">

<html>

<head>
    <meta http-equiv="Expires=-1" content="text/html; charset=iso-8859-1">
    <meta http-equiv="Content-Style-Type" content="text/css">
    <link rel='stylesheet' type='text/css' href="css/stylesheet.css">
    <!-- <style> span.Resalt { color: red } textarea { width: 323px } </style> -->
    <title>Customer Information</title>
    <!--<SCRIPT language='JavaScript' src="js/customerValidate.js"></SCRIPT>-->
    <script type='text/javascript' language='JavaScript'>
    <!--
    function loadDocument(){
        /*window.moveTo(0,0);
        window.resizeTo(screen.availWidth,screen.availHeight);*/
        document.frmcompany.rucNumber.select();
    }

    function validateSubmit() { return true; }

    function searchCompany(){
       URL = "companySearch.jsp";
       appeareance = "width=720,height=450,left=50,top=100,scrollbars=yes";
       // 'refsearch' nos permitira acceder a la ventana creada
       refserach = window.open(URL,"search",appeareance);
    }

    <!-- TODO: only for test-->
    function disableSaveButton(form) { return true; }
    function saveSource() { return true; }
    //-->
    </script>
</head>

<body onLoad='loadDocument()' style="background: whitesmoke;">
    <form name='frmcompany' action="CompanyServlet" method="post"
          onSubmit='return validateSubmit()'>
    <table class="Form" align="center" cellpadding="2" border="1" style="width: 760px">
        <caption class='Form'>SOURCE REGISTER<br><br>
        <!--<div align='right'>
            <img src='images/factory1.jpg'>&nbsp;
        </div>-->
        </caption>
        <colgroup>
            <col id="leftLabel">
        </colgroup>
        <colgroup>
            <col id="rightLabel">
        </colgroup>

        <thead style='background: PapayaWhip;'>
            <tr><td colspan='2'>&nbsp;
                <!-- TODO: AL ENVIAR EL FORMULARIO TODOS LOS SUBMIT CONTIENEN VALORES -->
                <button type='button' name='new' value='new'
                        style='height: 24px; width: 32' onclick='cleanForm()'>
                    <img alt='New Source' src='images/nuevo04.jpg'>
                </button>
                <input type='submit' name='show' value="Show">
                       <!--onClick='showGuest(document.frmcompany.documentNumber.value)'>-->
                <!--
                <button type='submit' name='show' value='show' class='Bar'
                        onclick='showReservation(document.frmcompany.reservation.value)'>
                    <img alt='Show Reservation' src=''>
                </button>
                -->
                <button type='button' name='search' value='search'
                        style='height: 24px; width: 32' onclick='searchCompany()'>
                    <img alt='Search Source' src='images/lupa01.jpg'>
                </button>
                <input type='submit' name='save'
                       value="Save"
                       onClick='saveSource(document.frmcompany.rucNumber.value)'>
                <!--
                <button type='submit' name='save' value='save' class='Bar'
                        onclick='saveReservation(document.frmcompany.reservation.value)'>
                    <img alt='Save Reservation' src='images/save.gif'>
                </button>
                <input type='submit' name='delete'
                       Class='MediumButton' value="Delete"
                       onClick='deleteGuest(document.frmcompany.co.value)'>
                <input type='submit' name='exit' value="Exit"
                       onClick='window.close()'>
                -->


    <tfoot class='Form'>
        <tr><td colspan='2'>&nbsp;
        
    <tbody>
        <tr><td colspan='2'>&nbsp;

        <tr><td><label for='rucNumber'>RUC Number</label>
            <td><label for='companyId'>Company Id.</label>
        <tr><td><input type='text' name='rucNumber'
                       class='Box Large' id='rucNumber' maxlength='11'
                       value='${co.rucNumber}'>
            <td><input type='text' name='companyId' READONLY
                       class='Box Large' id='companyId' maxlength='11'
                       value='${co.companyId}'>

        <!--<tr><td colspan='2'>&nbsp;-->

        <tr><td><label for='firmName'>
                    <span class='Resalt'>*&nbsp;</span>Firm Name
                </label>
            <td><label for='commercialName'>
                    Commercial Name
                </label>
                       
        <tr><td><input type='text' name='firmName'
                       class='Box XLarge' id='firmName'
                       value='${co.firmName}' maxlength='50'
                       onKeyUp='disableSaveButton(document.frmcompany)'>
            <td>    <input type='text' name='commercialName'
                       class='Box XLarge' id='commercialName'
                       value='${co.commercialName}' maxlength='50'>

        <!--<tr><td colspan='2'>&nbsp;-->

        <tr><td><label for=''>Segment</label>
            <td><label for=''>Source</label>
            
        <tr><td><select name='segment' class='Large'>
                        <c:forEach var="segment" items="${segments}">
                            <c:set var="selected" value="" />
                            <c:if test="${co.segment == segment.elementId}">
                                <c:set var="selected" value="selected" />
                            </c:if>
                    <option value='${segment.elementId}' ${selected}>${segment.description}
                        </c:forEach>
                </select>
            <td><select name='source' class='XLarge'>
                        <c:forEach var="source" items="${sources}">
                            <c:set var="selected" value="" />
                            <c:if test="${co.sourceId == source.elementId}">
                                <c:set var="selected" value="selected" />
                            </c:if>
                    <option value='${source.elementId}' ${selected}>${source.description}
                        </c:forEach>
                </select>

        <tr><td><label for=''>Special Rate</label>
            <td><label for=''>Unused:</label>
            
        <tr><td><select name='specialRate' class='Large'>
                        <c:forEach var="rate" items="${spRates}">
                            <c:set var="selected" value="" />
                            <c:if test="${co.specialRate == rate.elementId}">
                                <c:set var="selected" value="selected" />
                            </c:if>
                    <option value='${rate.elementId}' ${selected}>${rate.description}
                        </c:forEach>
                </select>
            <td><input type='text' name='' DISABLED
                       class='Box Large' maxlength='11'
                       style='background: whitesmoke'
                       value=''>

        <tr><td><label for='contact'>Contact Name</label>
            <td><label for='emailContact'>Email Contact</label>
                       
        <tr><td><input type='text' name='emailContact'
                       class='Box XLarge' id='emailContact'
                       value='${co.emailContact}' maxlength='50'>
            <td><input type='text' name='contact'
                       class='Box XLarge' id='firmName'
                       value='${co.contact}' maxlength='50'
                       onKeyUp='disableSaveButton(document.frmcompany)'>

        <!--<tr><td colspan='2'>&nbsp;-->

        <tr><td><label for='district'>District</label>
            <td><label for='zipCode'>Zip Code</label>
            
        <tr><td><input type='text' name='district'
                       class='Box Large' maxlength='30'
                       value='${co.district}'>
            <td><input type='text' name='zipCode'
                       class='Box Large' id='firmName'
                       value='${co.zipCode}' maxlength='5'
                       onKeyUp='disableSaveButton(document.frmcompany)'>

        <tr><td><label for='city'>City</label>
            <td><label for='country'>Country</label>

        <tr><td><select name='city' class='Large'>
                        <c:forEach var="city" items="${cities}">
                            <c:set var="selected" value="" />
                            <c:if test="${co.city == city.elementId}">
                                <c:set var="selected" value="selected" />
                            </c:if>
                    <option value='${city.elementId}' ${selected}>${city.description}
                        </c:forEach>
                </select>
            <td><select name='country' class='Large'>
                        <c:forEach var="country" items="${countries}">
                            <c:set var="selected" value="" />
                            <c:if test="${co.country == country.countryId}">
                                <c:set var="selected" value="selected" />
                            </c:if>
                    <option value='${country.countryId}' ${selected}>${country.countryName}
                        </c:forEach>
                </select>

        <tr><td><label for='phone1'>Phone 1</label>
            <td><label for='phone2'>Phone 2</label>

        <tr><td><input type='text' name='phone1'
                       class='Box Large' id='phone1' maxlength='11'
                       value='${co.phone1}'>
            <td><input type='text' name='phone2'
                       class='Box Large' id='phone1' maxlength='11'
                       value='${co.phone2}'>

        <tr><td colspan="2"><label for='address'>
                    <span class='Resalt'>*&nbsp;</span>Address
                </label>

        <tr><td colspan="2">
            <textarea name='address' id='address' rows='2' cols='60'
                          style='color: blue; width: 680px'>${co.address}</textarea>

        <tr><td colspan='2'>&nbsp;

    </table>
  </form>
</body>

</html>
