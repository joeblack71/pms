
<!-- strict.dtd afect presentation
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 //EN"
          "http://www.w3.org/tr/html4/strict.dtd">
-->
<html>
<head>
    <meta http-equiv="Expires=-1" content="text/html; charset=iso-8859-1">
    <meta http-equiv="Content-Script-Type" content="text/javascript">
    <meta http-equiv="Content-Style-Type" content="text/css">
    <!--<link rel='stylesheet' type='text/css' href='css/stylesheet.css'>-->
    <title>Control de acceso de usuarios</title>
    <style>
        body {
            background: #AAA; color: white;
        }
        a:link, a:visited, a:active { color: white }
        span#brand, span#trade { 
            font-size:   2em;
            font-weight: bold;
            font-style:  italic;
            color:       salmon;
            width: 320px; background: #000; 
        }
        span#trade { font-size: 0.8em; }
        div#brand { width: 320px; background: #000; }
        div#message { font: normal 10pt Verdana; width: 280px }
        table { 
            width:         320px;
            border-right:  2px solid black;
            border-bottom: 2px solid black;
            background:    #87CEFA; /* lightskyblue */
            color:         #FFF; /* white */
        }
        caption {
            padding:      8px;
            border-right: 2px solid black;
            background:   #1E90FF; /* dodgerblue */
            color:        #F5F5F5; /* whitesmoke */
            text-align:   left;
            font:         1.2em verdana;
        }
        td#buttons { padding: 0px; }
        label { 
            margin-left: 30px;
            width:       80px;
            color:       inherit;
            font-size:   1.1em;
        }
        input.Text { width: 160px; margin-right: 30px; }
        input.Button { width: 80px; }
        select { width: 160px; }
    </style>
    <script language='JavaScript'>
        <!--
        function loadDocument(){
          document.access.login.select();
        }
        // -->
    </script>
</head>
<body onLoad='loadDocument()'>
    <br><br><br>
    <img alt="Central Of Reservations" src="images/brand.gif">
    
    <!--
    <label id="brand">
        <span id="brand">Central</span><span id="trade">&nbsp;&trade;</span>
    </label>
    -->
    <br><br><br><br>

    <form name='LoginForm' method='post' action="Authenticate.do">
    <table cellpadding='2' cellspacing='0' border="0">
        <caption>Access Control</caption>

        <tfoot>
            <tr><td colspan='2' id="last">&nbsp;

        <tbody>
            <tr><td colspan='2'>&nbsp;

            <tr><td><label for='login'>User:</label>
                <td><input type='text' id='login' value="${LoginForm.userName}"
                           class="Text" name='userName'>

            <tr><td><label for='password'>Password:</label>
                <td><input type='password' id='password'
                           class="Text" name='password'>

            <tr><td><label for='hotelId'>Hotel:</label>
                <td><select name='hotelId' id="hotelId">
                        <option value='1'>Hotel Unidad 1</option>
                        <option value='2'>Hotel Unidad 2</option>
                    </select>

            <tr><td colspan='2'>&nbsp;

            <tr id="last"><td>&nbsp;
                <td id="buttons">
                    <input type='submit' class='Button' value='Login'>
                    <input type='reset'  class='Button' value="Reset">
    </table>
    </form>

    <div id="message" align="justify"><br>
        <p>Esta pantalla controla el acceso de usuarios al sistema.
        Si no cuenta con un usuario, pongase en contacto con el administrador
        del sistema <i><a href='mailto:jolivas@viabcp.com'>postmaster</a></i>.
        <p><em>&copy; Hotel Software Factory</em>
    </div>

</body>
</html>