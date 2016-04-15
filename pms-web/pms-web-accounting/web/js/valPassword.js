/* Valida ingreso de password */

function validatePwd()
{
    var invalid   = ' ';
    var minLength = 4;
    var Access = document.access.Access.value;
    var pwd = document.access.password.value;

    if (Access == '' || pwd == '') {
    	alert("Complete los campos !!");
    	return false;
    }

    if (document.access.pass.value.length < minLength) {
    	//alert('Tu clave debe tener como minimo seis (' + minLength + ') caracteres');
    	return false;
    }

    if (document.access.pass.value.indexOf(invalid) > -1) {
    	//alert("Los espacios no estan permitidos");
    	return false;
    }
}