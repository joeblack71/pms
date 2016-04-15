/*********************************************************
** TRIM
*************************************************/
function str_trim(){
	var x=this;
	var _start,_end;			
		
	for(i=0;i<x.length && x.charAt(i)==' ';i++);
	_start = i;
	
	if(_start==x.length)return '';
	
	for(i=x.length-1;i>=0 && x.charAt(i)==' ';i--);	
	_end=i+1;
	return x.substring(_start,_end);
}


String.prototype.trim=str_trim;

/******************************************************
** AJAX
*******************************************************/
        
        function remakeSelect(select) {
            var s = new Array();
            var len = select.options.length;
            var msg = '';
            for (i=0; i<len; i++) {
                s[i].text = select.options[i].text;
                s[i].value = select.options[i].value;
            }
            for (i=len-1; i>0; i--) {
                select.options[i] = null;
            }
            var optgroups = select.childNodes;
            for (i=len-1; i>0; i--) {
                select.removeChild(optgroups[i]);
            }
            for (i=0; i<len; i++) {
                opt = document.createElement('option');
                opt.appendChild(document.createTextNode(s[i].text));
                opt.setAttribute('value', s[i].value);
                select.appendChild(opt);
            }
        }
        
        /**
         * Establece los options al select.
         * Contiene un rodeo que previene el bug IE que trunca el primer option.
         * En IE el seteo de innerHTML no es hecho correctamente.
         * Este truco consiste en agregar un item ficticio al inicio que se eliminará luego.
         * Luego se reconstruye el select usando métodos DOM, si no se observa que el select no queda bien referenciado.
         */
        function setInnerHTMLForSelect(select, html) {
            if (document.all) {
                html = '<option>dummy</option>' + html;
            }
            select.innerHTML = html;
            if (document.all) {
                select.outerHTML = select.outerHTML;
            }
            select = $(select.id);
            remakeSelect(select);
        }
        
        
        function validateEmail(textfield) {
        	textfield.value=textfield.value.trim();
            var result = true;
            var re = /\w{1,}[@][\w\-]{1,}([.]([\w\-]{1,})){1,3}$/;
            if (!re.test(textfield.value) && validateNotEmpty(textfield)) {
                textfield.style.backgroundColor = 'yellow';
                result = false;
            } else {
                textfield.style.backgroundColor = 'white';
                result = true;
            }
            return result;
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
        
        
	function validaLongitudTextArea(maxLong,textAreaItem,e){
		//textAreaItem.value = textAreaItem.value.trim(); 
		var text = textAreaItem.value;
		var tecla = (document.all) ? e.keyCode : e.which;
		//alert(tecla);
		if(tecla == 0 || tecla == 8){
			return true;
		}
		if(text.length >= maxLong){
			//alert("El texto no debe contener mas de "+maxLong+" caracteres");
			return false;
		}
		return true;
	}