<%@ taglib uri="http://struts.apache.org/tags-tiles" prefix="tiles" %>

<%--tiles:insert attribute="taglibs" /--%> <!-- NO HACE DISPONIBLE LAS LIBRERIAS -->

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN"
	"http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=iso-8859-1" />
    <title><tiles:getAsString name="title" /></title>

    <!--tiles:getAsString name="jstlDefs" /-->

	<link rel="stylesheet" type="text/css" href="../../css/stylesheet.css" />

    <tiles:insert attribute="cssLib" />
    <tiles:getAsString name="cssDefs" />

    <style type="text/css">
    	body { margin: 0px;	}
    </style>

    <tiles:insert attribute="jsLib" />
    <tiles:getAsString name="jsDefs" />

    <script type="text/javascript" language="javascript">
    <!--
        // HELP
        // Los mensajes responden a la pregunta qué es, o qué hace
        // Si se trata de una sola oración o frase, no es necesario terminar con un punto.

        function setHelp(msg) {
            document.getElementById('helpBox').innerHTML = msg;
            window.status = msg;
            return true;
        }

        // WARNING
        /*function setWarning(msg) {
            $('warningBox').innerHTML = msg;
            if (!msg) {
                Effect.Fade('warningBox', {duration: 0});
            } else {
                Effect.Appear('warningBox', {duration: 0});
            }
        }*/

    //-->
    </script>
</head>

<body>
	<table class="FormContainer" align="center">
		<caption>
		 	<tiles:getAsString name="formCaption" />
		</caption>
		<thead>
			<tr><td>
				<tiles:getAsString name="formHead" />
				<tiles:getAsString name="toolbar" />
			</td></tr>
		</thead>
		<tbody>
			<tr><td>
		    	<tiles:getAsString name="formBody" />
		    </td></tr>
		</tbody>
		<tfoot class="formFoot">
			<tr><td>
		    	<tiles:getAsString name="formFoot" />
		    </td></tr>
		</tfoot>
	</table>

    <%--jsp:include page="/messages_alert.jsp" flush="true"/--%>
</body>

</html>

