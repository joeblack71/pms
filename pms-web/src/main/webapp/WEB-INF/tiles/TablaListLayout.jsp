<%@ taglib uri="http://struts.apache.org/tags-tiles" prefix="tiles" %>
<tiles:insert attribute="taglibs"/>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=iso-8859-1" />
    <title><tiles:getAsString name="title"/></title>
    <link rel="stylesheet" type="text/css" href="../../styles/styles.css" />
    <link rel="stylesheet" type="text/css" href="../../styles/scrolltable.css" />

    <tiles:insert attribute="jsLib"/>
    <tiles:insert attribute="menubar"/>
    <tiles:getAsString name="jstlDefs"/>
    <tiles:getAsString name="jsDefs"/>

    <script type="text/javascript" language="javascript">
    <!--
        /////////////
        // SIMILAR //
        /////////////

        function editItem(key) {
            form = $('updateForm');
            if (confirm('Editar ' + key)) {
                form.key.value = key;
                form.action = '<tiles:getAsString name="casePrefix"/>Edit.do';
                form.submit();
            }
        }

        function newItem() {
            form = $('updateForm');
            form.action = '<tiles:getAsString name="casePrefix"/>New.do';
            form.submit();
        }

        function deactivateItem() {
            var key = getCheckedOfRadio($('listForm').key);
            if (key) {
                form = $('updateForm');
                if (confirm('Se desactivará el registro seleccionado.\nEsta operación no se podrá deshacer.\n\t ' + key)) {
                    form.key.value = key;
                    form.action = '<tiles:getAsString name="casePrefix"/>Deactivate.do';
                    form.submit();
                }
            } else {
                alert('Ningún registro seleccionado');
            }
        }

        function cancel() {
            window.location.href = 'TablasHome.do';
        }

        // HELP
        // Los mensajes responden a la pregunta qué es, o qué hace
        // Si se trata de una sola oración o frase, no es necesario terminar con un punto.

        function setHelp(msg) {
            $('helpBox').innerHTML = msg;
            window.status = msg;
            return true;
        }

        function defaultHelp() {
            return setHelp('Lista de registros');
        }

        function newItemHelp() {
            return setHelp('Crea un nuevo registro');
        }

        function deactivateItemHelp() {
            return setHelp('Desactiva el registro seleccionado');
        }

        function editItemHelp() {
            return setHelp('Edita el registro');
        }

        function cancelHelp() {
            return setHelp('Finaliza la edición de la tabla');
        }

        function selectHelp() {
            return setHelp('Selecciona el registro');
        }

        function searchHelp() {
            return setHelp('Busca los registros que cumplan el criterio');
        }

        function searchResetHelp() {
            return setHelp('Limpia el formulario de búsqueda');
        }

        // WARNING
        function setWarning(msg) {
            $('warningBox').innerHTML = msg;
            if (!msg) {
                Effect.Fade('warningBox', {duration: 0});
            } else {
                Effect.Appear('warningBox', {duration: 0});
            }
        }

        function defaultWarning() {
            setWarning('');
        }

        // INIT

        function init() {
            defaultHelp();
            defaultWarning();
        }

    //-->
    </script>
</head>
<body onload="init()">
    <div id="top">
        <div class="appheader">
            <tiles:insert attribute="appHeader"/>
        </div>
        <div class="header">
            <a href="javascript:cancel()" alt="<tiles:getAsString name="moduleTitle"/>"
     onmouseover="return setHelp('<tiles:getAsString name="moduleTitle"/>')" onmouseout="defaultHelp()">
                <tiles:getAsString name="moduleTitle"/>
            </a>
            | <b><tiles:getAsString name="title" /></b>
        </div>
    </div>
    <div id="main">

        <div class="toolbar">
            <tiles:insert attribute="toolbar"/>
        </div>

        <center>
            <div id="helpBox" class="helpBox"></div>
            <div id="warningBox" class="warningBox" style="display:none"></div>

            <form id="updateForm" name="updateForm" method="post">
                <input type="hidden" name="key"/>
                <input type="hidden" name="lastQueryString" value="${pageContext.request.queryString}"/>
            </form>

            <tiles:getAsString name="search"/>
            <tiles:getAsString name="list"/>
        </center>

    </div>

    <div class="sign">
        <tiles:insert attribute="appFooter"/>
    </div>
</body>
</html>

