<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<a href="javascript:createItem()" title="Crear"
 onmouseover="return createItemHelp()" onmouseout="defaultHelp()">
    <img src="images/tick.png" width="16" height="16" border="0" alt="Crear"/>
    Crear
</a>
<a href="javascript:reset()" title="Restaurar"
onmouseover="return resetHelp()" onmouseout="defaultHelp()">
    <img src="images/arrow_undo.png" width="16" height="16" border="0" alt="Restaurar"/>
    Restaurar
</a>
<a href="javascript:cancel()" title="Finalizar"
onmouseover="return cancelHelp()" onmouseout="defaultHelp()">
    <img src="images/cancel.png" width="16" height="16" border="0" alt="Finalizar"/>
    Finalizar
</a>
