
/* 'submit', controla el envio del formulario */
var submit = true;

/* Decide si se envia o no el formulario, segun
* el valor de 'submit'. Si submit = 'true', se envia */
function validateSubmit() {
    form = this.document.frmrec;
    return submit;
}

function showReceipt(form) {
    submit = validateReceipt(form);
}

/* Para anular un documento, solo se cambiara el estado a  "ANULADO"
   y luego sera grabado. */
/*
function cancelReceipt(form) {
    if ( validateReceipt(form) )
       submit = confirm("Confirma ANULACION de Comprobante ?");
}
*/

/* parseInt() devuelve un 'NaN' si el parametro correlative
 no contiene un numero valido. Considerar el sgte. ejemplo:
   var valor1 = parseInt(123AB);
   var valor2 = parseInt(1 2 3);
   luego:
   valor1 valdra 123 y
   valor2 valdra 1
 */
function validateReceipt(form) {
    var receiptIsOk = true;
    serial = parseInt(form.receiptSerial.value);
    correlative = parseInt(form.correlative.value);
    if ( isNaN(serial) || serial == 0 ) {
        alert("Receipt Serial is Invalid !!");
        document.frmrec.receiptSerial.select();
        resNumberIsOk = false;
    }
    if ( isNaN(correlative) || correlative == 0 ) {
        alert("Receipt number is Invalid !!");
        document.frmrec.correlative.select();
        resNumberIsOk = false;
    }
    return receiptIsOk;
}

function saveReceipt(form) { 
    var errorMessage = //"Los datos no están completos o tienen valores inválidos." +
                       " El comprobante NO FUE REGISTRADO !!";
    var isFormOk = validateForm(form);
    if ( isFormOk )
        submit = confirm("Confirma GRABAR comprobante ?");
    //else { alert(errorMessage) }
}

function validateForm(form) {
    var field, formOk=true, fieldname;

/* solo valida campos de ingreso de datos */
    for ( i=0; i < form.length; i++ ) {
        field = form.elements[i];
        if ( field.type == 'text' ) {
            if ( field.name == "customerDoc" ||
                 field.name == "filler" || field.name == "paymentDate" ||
                 field.name == "customerName")
                continue;
            if ( !isValidContent(field) ) {
                alert( getErrorMessage(field) );
                //alert( field.name )
                field.select();
                formOk = false;
                break;
            }
        } else continue;
    }

    return formOk;
}

function isValidContent(field) {
    var EMPTY = "";
    var validContent = true;

    if ( field.value == EMPTY )
        validContent = false;
    else {
        switch ( field.name ) {
            case "receiptSerial":
            case "correlative":
                 validContent = isInteger(field.value); break;
            case "issueDate":
            case "paymentDate":
                 validContent = isValidDate(field.value); break;
            /*case "customerDoc":
                 validContent = isString(field.value); break;
            */
            case "net":
               validContent = isFloat(field.value); break;
            default: break;
        }
    }

    //alert(validContent);
    // Future use
    /*if ( validContent) {
        if ( field.name == "issueDate" || field.name == "paymentDate")
            validContent = isValidDateRange();
    }*/

    return validContent;
}

function getErrorMessage(field) {
    var errMessage;

    switch ( field.name ) {
        case "receiptSerial":
             errMessage = "Numero de SERIE incorrecto !!"; break;
        case "correlative":
             errMessage = "Numero CORRELATIVO incorrecto !!"; break;
        case "issueDate":
             errMessage = "FECHA EMISION incorrecta !!"; break;
        case "paymentDate":
             errMessage = "FECHA CANCELACION incorrecta !!"; break;
        case "exchange":
           errMessage = "TIPO DE CAMBIO incorrecto !!"; break;
        case "customerDoc":
           errMessage = "DOCUMENTO DE CLIENTE incorrecto !!"; break;
        case "net":
           errMessage = "MONTO NETO incorrecto !!"; break;
    }

    return errMessage;
}

function isString(value){
    var isString = true;
    value = parseInt(value);
    if ( isNaN(value)) // no es un numero (no valida espacios en blanco)
      isString = true;
    return isString;
}

function isInteger(value){
    var isInteger = true;
    value = parseInt(value);
    if ( isNaN(value)) // no es un numero
      isInteger = false;
    return isInteger;
}

function isFloat(value){
    var isFloat = true;
    value = parseFloat(value);
    if ( isNaN(value)) // no es un numero
      isFloat = false;
    return isFloat;
}
/* TODO: revisar funcion substring */
function isValidDate(value) {
    var isValidDate = true;
    var day, month, year;

    if ( value.length < 6 || value.length > 10 )
      isValidDate = false;
    /*else {
      day = value.substring(0,2);
      switch (value.length) {
        case  6: day   = value.substring(2,1);
                 month = value.substring(2,3);
                 year = value.substring(2,5); break;
        case  8: day   = value.substring(2,1);
                 month = value.substring(2,3);
                 year  = value.substring(4,5); break;
        case 10: day   = value.substring(2,1);
                 month = value.substring(3,4);
                 year = value.substring(6,7);
      }
    }*/

    /*if ( isValidDate) {
      if ( isValidDay(day) && isValidMonth(month) && isValidYear(year))
        isValidDate = true;
      else isValidDate = false;
    }*/

    return isValidDate;
}

function isValidDay(day) {
    var isValidDay = true;
    if ( !isInteger(day)) // no es entero
      isValidDay = false;
    if ( day < 1 || day > 31 )
      isValidDay = false;
    return isValidDay;
}

function isValidMonth(month) {
    var isValidMonth = true;
    if ( !isInteger(month)) // no es entero
      isValidMonth = false;
    if ( month < 1 || month > 12 )
      isValidMonth = false;
    return isValidMonth;
}

function isValidYear(year) {
    var isValidYear = true;
    if ( !isInteger(year)) // no es entero
      isValidYear = false;
    if ( year.length == 2)
      year = parseInt(year) + 2000;
    if ( year < 2007 || year > 2009 ) // Todo: validacion real
      isValidYear = false;
    return isValidYear;
}

function isValidDateRange(){
    return true;
}

/* valida que el campo no este vacio y no tenga solo espacios en blanco */
function valida(F) {
    if ( hasBlank(F.campo.value) ) {
      alert("Introduzca un cadena de texto.")
      return false
    } else {
      return true;
    }
}

/* comprueba si la cadena contiene espacios en blanco */
function hasBlank(value) {
    var hasBlank = false;
    for(i=0; i < value.length; i++) {
      if ( value.charAt(i) == " ") {
         hasBlank = true; break;
      }
    }
    return hasBlank;
}

function showTotal(form){
    form.total.value = form.roomRate.value * form.nights.value;
}

function disableSaveButton(form) {
    if ( (form.receiptSerial.value != "") &&
         (form.correlative.value != "") &&
         (form.issueDate != "") )
        form.save.disabled = false;
    else
        form.save.disabled = true;
}

/* se activa con evento: onkeypress(event, document.form)
*/
function iSubmitEnter(evento, form) {
	var iAscii;

	if (oEvento.keyCode)
		iAscii = oEvento.keyCode;
	else if (oEvento.which)
		iAscii = oEvento.which;
	else
		return false;

	if (iAscii == 13) oFormulario.submit();

	return true;
}

function resetFields(form) {
    var field;

    if ( confirm('Se borrarán todos los datos del formulario') ) {
        /*for ( i=0; i < form.length; i++ ) {
          field = form.elements[i];
          if ( field.type == 'text' )
             field.value = "";
        }*/
        form.correlative.focus();
    }
}

function cleanForm() { /* TODO: no funciona el 'reset()'. Revisar. */
    if ( confirm('Se borrarán todos los datos del formulario') )
        document.frmrec.reset();
    else return false;
}

/* Valida el ingreso de solo numeros
<input type=text name=txtPostalCode
       onKeypress="if (event.keyCode < 45 || event.keyCode > 57)
                      event.returnValue = false;">
*/