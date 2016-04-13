<%@page contentType="text/html"%>
<%@page pageEncoding="UTF-8"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link type='text/css' rel="stylesheet" href="css/frmsearch.css">
        <title>Form Design</title>
        <script>
            <!--
            function addRedColor() { 
                document.search.value = "#FF0000";
            }
            function addGreenColor() {}
            function addBlueColor() {}
            function applyColor() {
                document.search.bgColor = "red";
            }
            //-->
        </script>
    </head>
    <body>
    <table name='tabla' border="1" cellpadding='6' cellspacing='0'>
        <caption>Form Color Values<caption>
        <tbody>
            <tr><td>
                <label>Table Background</label>
                <input name="redqty" maxlength="02" size="5">
                <input type="button" name="addred" value="+ Red"
                       onclick="addRedColor()">
                <input name="greenqty" maxlength="02" size="5">
                <input type="button" name="addred" value="+ Green"
                       onclick="addRedColor()">
                <input name="blueqty" maxlength="02" size="5">
                <input type="button" name="addred" value="+ Blue"
                       onclick="addRedColor()">
            <tr><td>
                <input type="button" name="change" value="Apply Color"
                       onclick="javascript:applyColor()">
    </table>

    <form name='search'>
    <table border="1" cellpadding='6' cellspacing='0'>
        <caption name='header'>Reservation Search<caption>
        <tbody>
            <tr><td>
                <select name="hotelId" disabled="readonly">
                        <option>Testing Hotel</option>
                </select>
                <select name="fieldName">
                    <option>Listado Diario de Reservas</option>
                    <option>Llegadas</option>
                    <option>Plazo de pago (llegada)</option>
                </select>
                <input type="text" name="pattern"
                       value="patt.." size="20">
                <input type="submit" name="send" value="Send Query">
    </table>
    </form>
    
    </body>
</html>
