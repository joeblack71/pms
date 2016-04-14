
<%@ page contentType="text/html" %>

<%@ taglib uri="http://struts.apache.org/tags-tiles" prefix="tiles" %>

<tiles:insert attribute="taglibs"/>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN"
	"http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=iso-8859-1" />

    <title><tiles:getAsString name="title"/></title>

    <tiles:insert attribute="cssLib" />

    <tiles:insert attribute="jsLib" />

    <tiles:getAsString name="jstlDefs"/>

    <tiles:getAsString name="cssDefs" />

    <tiles:getAsString name="jsDefs" />

    <style type="text/css">
		.header {
		    color: #000066;
		    background-color: #EFEBD6;
		    font-size: 12pt;
		    text-align: left;
		    padding: 3px;
		    border-width: 0px;
		}
	
	    .toolbar {
	        text-align: right;
	        padding-top: 2px;
	        padding-right: 5px;
	        margin-bottom: 20px;
	        position: absolute;
	        right: 10px;
	        top: 0px;
	    }
    </style>

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
        function setWarning(msg) {
            $('warningBox').innerHTML = msg;
            if (!msg) {
                Effect.Fade('warningBox', {duration: 0});
            } else {
                Effect.Appear('warningBox', {duration: 0});
            }
        }

    //-->
    </script>
</head>
<body>
    <!--script type="text/javascript"
    	src="${pageContext.request.contextPath}/js/tooltip/wz_tooltip.js"></script-->
    <!--script type="text/javascript"
    	src="${pageContext.request.contextPath}/js/tooltip/tip_balloon.js"></script-->
    <script type="text/javascript"
    	src="${pageContext.request.contextPath}/js/utils.js"></script>

    <div id="topDialog">
        <div class="header">
            <tiles:getAsString name="header"/>
        </div>
    </div>

    <div id="main">
        <div class="toolbar">
            <tiles:getAsString name="toolbar"/>
        </div>

        <center>
            <tiles:getAsString name="body"/>
        </center>
    </div>

    <div class="sign">
        <tiles:insert attribute="appFooter"/>
    </div>

    <jsp:include page="/pages/reservations/messages_alert.jsp" flush="true"/>
</body>
</html>

