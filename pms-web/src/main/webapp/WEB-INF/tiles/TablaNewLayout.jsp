<%@ taglib uri="http://struts.apache.org/tags-tiles" prefix="tiles" %>
<tiles:insert attribute="taglibs"/>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=iso-8859-1" />
    <title><tiles:getAsString name="title"/> - Nuevo</title>
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

        function createItem() {
            var form = $('newForm');
            if (validateNewForm()) {
                if (confirm('Se creará el registro')) {
                    form.action = '<tiles:getAsString name="casePrefix"/>Create.do';
                    form.submit();
                }
            } else {
                alert('Por favor revise los datos del formulario');
            }
        }

        function reset() {
            $('newForm').reset();
        }

        function cancel() {
            window.location.href = '<tiles:getAsString name="casePrefix"/>.do?${param.lastQueryString}'
        }

        function gotoTablas() {
            window.location.href = 'Tablas.jsp'
        }

        // HELP
        // Los mensajes responden a la pregunta qué es, o qué hace
        // Si se trata de una sola oración o frase, no terminar con un punto.

        function setHelp(msg) {
            $('helpBox').innerHTML = msg;
            window.status = msg;
            return true;
        }

        function defaultHelp() {
            return setHelp('Puede modificar los valores de los campos');
        }

        function createItemHelp() {
            return setHelp('Crea el registro');
        }

        function resetHelp() {
            return setHelp('Restaura los valores del formulario');
        }

        function cancelHelp() {
            return setHelp('Finaliza la edición');
        }

        function estadoHelp() {
            return setHelp('Estado. Un registro desactivado no se puede volver a activar.');
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
            <a href="javascript:gotoTablas()" title="<tiles:getAsString name="moduleTitle"/>"
     onmouseover="return setHelp('<tiles:getAsString name="moduleTitle"/>')" onmouseout="defaultHelp()">
                <tiles:getAsString name="moduleTitle"/>
            </a>
            |
            <a href="javascript:cancel()" title="<tiles:getAsString name="title"/>"
     onmouseover="return setHelp('<tiles:getAsString name="title"/>')" onmouseout="defaultHelp()">
                <tiles:getAsString name="title"/>
            </a>
            |
            <b>Nuevo</b>
        </div>
    </div>
    <div id="main">

        <div class="toolbar">
            <tiles:insert attribute="toolbar"/>
        </div>

        <center>
            <tiles:getAsString name="new"/>
            <div id="helpBox" class="helpBox"></div>
            <div id="warningBox" class="warningBox" style="display:none"></div>
        </center>

    </div>

    <div class="sign">
        <tiles:insert attribute="appFooter"/>
    </div>

</body>
</html>

