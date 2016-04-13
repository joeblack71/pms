
<%@ page contentType="text/html;charset=ISO-8859-1" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--<%@ page errorPage="errorPage.jsp" %>--%>

<%@ page import="java.util.ArrayList" %>
<%@ page import="java.util.Iterator" %>
<%@ page import="java.text.SimpleDateFormat" %>

<%@ page import="com.mycom.booking.beans.*" %>
<%@ page import="com.mycom.booking.libraries.DateManager" %>

<jsp:useBean id="cust" class="com.mycom.booking.beans.Customer" scope="request" />

<% request.setAttribute("res", (Reservation)request.getAttribute("res") ); %>

<!--
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 //EN"
          "http://www.w3.org/tr/html4/strict.dtd">
-->
<html>
<head>
    <meta http-equiv="Expires=-1" content="text/html; charset=iso-8859-1">
    <meta http-equiv="Content-Style-Type" content="text/css">
    <link rel="stylesheet" type="text/css" href="css/stylesheet.css">
    <style> span.Resalt { color: red } </style>
    <title>Customer Information</title>
    <!--<script language="JavaScript" src="js/customerValidate.js"></script>-->
    <script type="text/javascript" language="JavaScript">
    <!--
    function loadDocument(){
        document.frmgst.documentNumber.select();
    }

    function validateSubmit() {
        return true;
    }

    function searchGuest(){
       URL = "customerSearch.jsp?selHotel=1";
       appeareance = "width=720,height=450,left=50,top=100,scrollbars=yes";
       // "refsearch" nos permitira acceder a la ventana creada
       refserach = window.open(URL,"search",appeareance);
    }

    function addGuest() {
        //guestId = frmres.guestname.value;
        window.location.href = "GuestReservationServlet?add=addGuest&guestId=" + guestId;
    }

    <!-- TODO: only for test-->
    function disableSaveButton(form) {
        return true;
    }
    function saveGuest() {
        return true;
    }
    //-->
    </script>
</head>

<body onLoad="loadDocument()">
    <form name="frmgst" action="CustomerServlet" method="post"
          onSubmit="return validateSubmit()">
    <table class="Form" align="center" border="1"
           cellspacing="0" cellpadding="2">
    <caption class="Form">
        <div align="right">NATIONALITY&nbsp;</div>
        &nbsp;${cust.lastname1},&nbsp;${cust.firstname}
    <colgroup>
        <col id="leftLabel">
    </colgroup>
    <colgroup>
        <col id="rightLabel">
    </colgroup>


    <thead class="Form" style="background: peachpuff">
        <tr><td colspan="2">
                <input type="submit" name="show"
                       class="Button" value="Sh.">
                       <!--onClick="showGuest(document.frmgst.documentNumber.value)">-->
                <input type="submit" name="save"
                       class="Button" value="Sv."
                       onClick="saveGuest(document.frmgst.documentNumber.value)">
                <input type="submit" name="addGuest"
                       class="Button" value="Add">
                       <!-- onClick="addCustomer(document.frmgst)"> -->
                <input type="button" name="search"
                       class="Button" id="search" value="Sch"
                       onClick="searchGuest()">
                <!--
                <input type="submit" name="delete"
                       Class="MediumButton" value="Delete"
                       onClick="deleteGuest(document.frmgst.cust.value)">
                <input type="submit" name="exit" value="Exit"
                       onClick="window.close()">
                <input type="button" name="srclook" value="Look Source"
                       class="Button Large" id="srclook">
                -->

    
    <tfoot class="Form">
        <tr><td colspan="2">&nbsp;

    <tbody>
        <tr><td colspan="2">&nbsp;

        <tr><td><label for="documentNumber">Document</label>
            <td><label for="documentType">Type</label>
        
        <tr><td><input type="text" name="documentNumber"
                       class="Box Large" id="documentNumber" maxlength="11"
                       value="${cust.documentNumber}">
            <td><select name="documentType" class="Large">
                        <c:forEach var="item" items="${docTypes}">
                            <c:if test="${item.documentType eq cust.documentType}">
                                <c:set var="selected" value="selected" />
                            </c:if>
                    <option value="${item.documentType} ${selected}">${item.description}
                        </c:forEach>
                </select>
        
        <tr><td><label for="lastname1"><span class="Resalt">*&nbsp;</span>Last Name (pat)</label>
            <td><label for="lastname1"><span class="Resalt">*&nbsp;</span>Last Name (mat)</label>

        <tr><td><input type="text" name="lastname1"
                       class="Box Large" id="lastname1"
                       value="${cust.lastname1}" maxlength="15"
                       onKeyUp="disableSaveButton(document.frmgst)">
            <td><input type="text" name="lastname2"
                       class="Box Large" id="lastname2"
                       value="${cust.lastname2}" maxlength="15">

        <tr><td><label for="firstname"><span class="Resalt">*&nbsp;</span>First Name(s)</label>
            <td><label for="firstname"><span class="Resalt">*&nbsp;</span>Nationality</label>

        <tr><td><input type="text" name="firstname"
                       class="Box Large" id="firstname"
                       value="${cust.firstname}" maxlength="15"
                       onKeyUp="disableSaveButton(document.frmgst)">
            <td><select name="nationality" class="Large">
                        <c:forEach var="item" items="${countries}">
                            <c:if test="${item.countryId eq cust.countryId}">
                                <c:set var="selected" value="selected" />
                            </c:if>
                    <option value="${item.countryId} ${selected}">${item.nationality}
                        </c:forEach>
                </select>

        <tr><td colspan="2">
                <label for="address1">Address</label>
        
        <tr><td colspan="2">
        <textarea name="address1"
                  class="Box XLarge" id="address1"
                  value="${cust.address1}" title="Address 1"
                  rows="2" style="width: 508px"></textarea>

        <tr><td><label for="city">City</label>
            <td><label for="country">Country</label>
        
        <tr><td><input type="text" name="city"
                       class="Box Large" id="city" maxlength="10"
                       value="${cust.city}">
            <td colspan="2">
                <select name="country" class="Large">
                        <c:forEach var="item" items="${countries}">
                            <c:if test="${item.countryId eq cust.countryId}">
                                <c:set var="selected" value="selected" />
                            </c:if>
                    <option value="${item.countryId} ${selected}">${item.countryName}
                        </c:forEach>

        <tr><td colspan="2">
                <label for="email">E-mail</label>

        <tr><td colspan="2">
                <input type="text" name="email"
                       class="Box XLarge" id="email"
                       value="${cust.email}" title="Electronic Mail (e-mail)"
                       maxlength="50">

        <tr><td><label for="phone1">Phones 1</label>
            <td><label for="phone1">Phones 2</label>

        <tr><td><input type="text" name="phone1"
                       class="Box Large" id="phone1"
                       value="${cust.phone1}" title="Phone number 1"
                       maxlength="15">
            <td><input type="text" name="phone2"
                       class="Box Large" id="phone2"
                       value="${cust.phone2}" title="Phone number 2"
                       maxlength="15">

        <tr><td><label for="source">Source of Bussiness</label>
            <td><label for="source">Commercial name</label>
        
        <tr><td><input type="text"   name="source"
                       value="${cust.source}"
                       class="Box XLarge" id="source">
            <td><input type="text" name="commercialName" readonly
                       class="Box Large" id="commercialName"
                       value="" title="Commercial name of source"
                       maxlength="15">

        <tr><td><label for="contact">Contact Name</label>
            <td><label for="contact">Contact Phone</label>
        
        <tr><td><input type="text" name="contact"
                       class="Box XLarge" id="contact"
                       value="${cust.contact}" title="Customer contact"
                       maxlength="50">
            <td><input type="text" name="contactPhone" readonly
                       class="Box Large" id="contactPhone"
                       value="" title="Customer contact phone"
                       maxlength="10">

        <tr><td colspan="2">
                <label for="instructions">Comments</label>

        <tr><td colspan="2">
            <textarea id="instructions" 
                    name="instructions" rows="3">${cust.requests}</textarea>

        <tr><td colspan="2">&nbsp;
    </table>
  </form>
</body>
</html>
