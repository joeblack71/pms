
/* 'submit', controla el envio del formulario */
var submit = true;

function validateSubmit() {
    return submit;
}

function showReservation(reservation) {
    submit = validateResNumber(reservation);
}

function deleteReservation(reservation) {
    if (validateResNumber(reservation))
       submit = confirm("Confirma ELIMINAR Reserva ?");
}

/* parseInt() devuelve un 'NaN' si el parametro reservation
 no contiene un numero valido. Considerar el sgte. ejemplo:
   var valor1 = parseInt(123AB);
   var valor2 = parseInt(1 2 3);
 luego de esto, 'valor1' sera igual a 123 y
                'valor2' sera igual a 1.
 */
function validateResNumber(reservation) {
    var resNumberIsOk = true;
    reservation = parseInt(reservation);
    if ( isNaN(reservation) || reservation == 0 ) {
        alert("Reservation number is Invalid !!");
        document.frmres.reservation.select();
        resNumberIsOk = false;
    }
    return resNumberIsOk;
}

function saveReservation(reservation) { // Todo: validar 'reservation'
    var isFormOk = validateForm(document.frmres);
    if ( isFormOk )
        submit = confirm("Confirma GRABAR Reserva ?");
}

function validateForm(form) {
    var field, formOk=true, fieldname;

    for(i=0; i < form.length; i++){
      field = form.elements[i];
      if ( field.name == "reservation")
        continue;
 /* solo valida campos de ingreso de datos*/
      if ( field.type == 'text') {
        if ( !isValidContent(field)) {
          alert(getErrorMessage(field));
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
    var validContent=true;

    if ( field.value == EMPTY)
      validContent=false;
    else {
      switch(field.name){
        case "nights":
        case "adults":
        case "children":
        case "quantity":
             validContent = isInteger(field.value); break;
        case "arrival":
        case "departure":
             validContent = isValidDate(field.value); break;
        case "roomNumber":
        case "lastname":
        case "motherln":
        case "firstname":
        case "document":
             validContent = isString(field.value); break;
        case "roomRate":
        case "total":
             validContent = isFloat(field.value); break;
        default: break;
      }
    }

    if ( validContent) {
      if ( field.name == "arrival" || field.name == "departure")
        validContent = isValidDateRange();
    }

    return validContent;
}

function getErrorMessage(field) {
    var errMessage;

    switch(field.name){
      case "nights":
           errMessage = "Numero de NOCHES incorrecto !!"; break;
      case "adults":
           errMessage = "Numero de ADULTOS incorrecto !!"; break;
      case "children":
           errMessage = "Numero de NI�OS incorrecto !!"; break;
      case "quantity":
           errMessage = "CANTIDAD de Habitaciones es incorrecta !!"; break;
      case "arrival":
           errMessage = "Campo FECHA LLEGADA incorrecto !!"; break;
      case "departure":
           errMessage = "Campo FECHA SALIDA incorrecto !!"; break;
      case "roomNumber":
           errMessage = "Campo NUMERO HABITACION es incorrecto !!"; break;
      case "lastname":
           errMessage = "Campo APELLIDO PATERNO es incorrecto !!"; break;
      case "motherln":
           errMessage = "Campo APELLIDO MATERNO es incorrecto !!"; break;
      case "firstname":
           errMessage = "Campo NOMBRES es incorrecto !!"; break;
      case "document":
           errMessage = "Campo DOCUMENTO es incorrecto !!"; break;
      case "roomRate":
           errMessage = "Campo TARIFA es incorrecto !!"; break;
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

function isValidDate(value) {
    var isValidDate = true;
    var day, month, year;

    if ( value.length < 6 || value.length > 10 )
      isValidDate = false;
    else {
      day = value.substring(0,2);
      switch (value.length) {
        case  6: month = value.substring(2,4);
                 year = value.substring(4,6); break;
        case 10: month = value.substring(3,5);
                 year = value.substring(6,10);
      }
    }

    if ( isValidDate) {
      if ( isValidDay(day) && isValidMonth(month) && isValidYear(year))
        isValidDate = true;
      else isValidDate = false;
    }

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
    if ((form.arrival.value != "") &&
        (form.departure.value != "") &&
        (form.roomType != ""))
    { form.save.disabled = false; }
    else {
    form.save.disabled = true; }
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

    if ( confirm('Se borrar�n todos los datos del formulario') ) {
        for ( i=0; i < form.length; i++ ) {
          field = form.elements[i];
          if ( field.type == 'text' )
             field.value = "";
        }
        form.arrival.focus();
    }
}

function cleanForm() { /* Todo: no funciona el 'reset()'. Revisar. */
    if ( confirm('Se borrar�n todos los datos del formulario') )
        document.frmres.reset();
    else return false;
}
