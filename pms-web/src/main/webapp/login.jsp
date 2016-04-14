
<!-- strict.dtd afect presentation
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 //EN"
          "http://www.w3.org/tr/html4/strict.dtd">
-->
<html>
<head>
<meta http-equiv="Expires=-1" content="text/html; charset=iso-8859-1">
<meta http-equiv="Content-Script-Type" content="text/javascript">
<meta http-equiv="Content-Style-Type" content="text/css">
<link rel='stylesheet' type='text/css' href='css/login.css'>
<title>Control de acceso de usuarios</title>
<script language='JavaScript' type="text/javascript">
    <!--
    function validateForm(form) {
    	var result = true;

		result = result & validateNotEmpty(form.login);
		//result = result & validateNotEmpty(form.password);//TODO remove
    	
    	if (result) {
    		return true;
    	} else {
    		return false;
    	}
    }

	function validateNotEmpty(textfield) {
		var result = true;

		if (!textfield.value) {
		    textfield.style.backgroundColor = 'yellow';
		    result = false;
		} else {
		    textfield.style.backgroundColor = 'white';
		    result = true;
		}
		
		return result;
	}

    function defaultFocus() {
    	var form = document.getElementById('loginForm');
    	
    	form.login.select();
    }

    window.onload = function() {
    	defaultFocus();
    }
    // -->
</script>
</head>

<body>
<br /><br /><br />
<!--img alt="Central Of Reservations" src="images/brand.gif"-->

<!--span id="brand">Central</span><span id="trade">&nbsp;&trade;</span-->

<br /><br /><br /><br />
<form name='loginForm' id='loginForm' method='post'
	 action="login.do" onsubmit="return validateForm(this);">
<table class="LoginForm">
	<caption>Access Control</caption>

	<tbody>
		<tr>
			<td colspan='2'>&nbsp;</td></tr>
		<tr>
			<td class="right">
				<label for='login'>User&nbsp;</label></td>
			<td><input type='text' name='userName' id='login' value="test"
					class="" size="8" maxlength="8" onkeyup="" />
			</td></tr>
		<tr>
			<td class="right">
				<label for='password'>Password:</label></td>
			<td><input type='password' name='password' id='password'
					class="Text" onkeyup="" /></td></tr>
		<tr>
			<td class="right">
				<label for='idHotel'>Hotel:</label></td>
			<td><select name='idHotel' id="idHotel">
					<option value='1'>Hotel Unidad 1</option>
					<option value='2'>Hotel Unidad 2</option>
				</select></td></tr>
		<tr>
			<td colspan='2'>&nbsp;</td></tr>
		<tr id="last">
			<td>&nbsp;</td>
			<td id="buttons">
				<input type='submit' class='Button' value='Login'>
				<input type='reset' class='Button' value="Reset"></td></tr>
	</tbody>

	<tfoot>
		<tr>
			<td colspan='2' id="last">&nbsp;</td></tr>
	</tfoot>

</table>
</form>

<div class="message" align="justify">
	<p>Esta pantalla controla el acceso de usuarios al sistema. Si no
	cuenta con un usuario, pongase en contacto con el administrador del
	sistema <a href='mailto:jolivas@viabcp.com'>postmaster</a>.</p>
</div>

<div class="trade">
	&copy; Copyright 2007 by MyCo Solutions
</div>
</body>
</html>