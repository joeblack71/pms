<%@ taglib uri="http://struts.apache.org/tags-logic" prefix="logic" %>
<%@ taglib uri="http://struts.apache.org/tags-bean"  prefix="bean" %>
<%@ taglib uri="http://struts.apache.org/tags-html"  prefix="html" %>

<%--@ taglib prefix="ria" uri="http://sweetdev-ria.ideotechnologies.com"%>

<%@ page import="com.ideo.sweetdevria.taglib.alert.AlertTag" %>

<ria:resourcesImport /--%>


<%--ria:alert id="accesoDenegado" type="<%= AlertTag.WARN %>" actionType="<%= AlertTag.CLOSE %>" modal="true">
	Lo Sentimos no tienes acceso a la opcion
</ria:alert>
 
<ria:alert id="error" type="<%= AlertTag.ERROR %>" actionType="<%= AlertTag.CLOSE %>" modal="true">
	<logic:messagesPresent property="errorGRed" message="true">
		<html:messages id="msg" property="errorGRed" message="true">
			<bean:write name="msg"/>	
		</html:messages>
	</logic:messagesPresent>
</ria:alert--%>


<logic:messagesPresent property="errors" message="true">
	<html:messages id="msg" property="errors" message="true">
		<script type="text/javascript">
			<%--SweetDevRia.$('error').show();--%>
			<bean:write name="msg" />
		</script>
	</html:messages>
</logic:messagesPresent>

