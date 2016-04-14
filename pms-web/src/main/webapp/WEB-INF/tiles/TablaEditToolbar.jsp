<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:if test="${estado=='AC'}">
    <a href="javascript:saveItem()" title="Guardar"
     onmouseover="return saveItemHelp()" onmouseout="defaultHelp()">
        <img src="images/tick.png" width="16" height="16" border="0" alt="Guardar"/>
        Guardar
    </a>
    <a href="javascript:reset()" title="Restaurar"
    onmouseover="return resetHelp()" onmouseout="defaultHelp()">
        <img src="images/arrow_undo.png" width="16" height="16" border="0" alt="Restaurar"/>
        Restaurar
    </a>
</c:if>
<a href="javascript:cancel()" title="Finalizar"
onmouseover="return cancelHelp()" onmouseout="defaultHelp()">
    <img src="images/cancel.png" width="16" height="16" border="0" alt="Finalizar"/>
    Finalizar
</a>
