<%@ taglib uri="http://struts.apache.org/tags-logic" prefix="logic" %>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean" %>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html" %>

<logic:messagesPresent property="errors" message="true">				
	<html:messages id="msg" property="errors" message="true">
		<script type="text/javascript">
			alert("<bean:write name="msg"/>");
		</script>
	</html:messages>				
</logic:messagesPresent>
