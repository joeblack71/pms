/*
 * Creado el 16/06/2008
 *
 * TODO Para cambiar la plantilla de este archivo generado, vaya a
 * Ventana - Preferencias - Java - Estilo de codigo - Plantillas de codigo
 */

package com.myco.central.reservations.web.controller;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.web.servlet.mvc.multiaction.MultiActionController;

/**
 * @author jolivas
 *
 */
public class GenericController extends MultiActionController {
	
	protected Log log = LogFactory.getLog( getClass() );
	
//	protected ActionMessages messages = new ActionMessages();
//	
//	protected ActionErrors errors = new ActionErrors();
	
	protected String message = "";

	protected String messageError = "";
	
	public GenericController() {
		//log = Logger.getLogger(this.getClass());
	}

	public void sendSuccessfulMessage(HttpServletRequest request, String key) {
//		ActionMessages messages = new ActionMessages();
//		messages.add(ActionMessages.GLOBAL_MESSAGE, new ActionMessage(key));
//		saveMessages(request, messages);
	}

	public void sendSuccessfulMessage(HttpServletRequest request, String key, String param) {
//		ActionMessages messages = new ActionMessages();
//		messages.add(ActionMessages.GLOBAL_MESSAGE, new ActionMessage(key, param));
//		saveMessages(request, messages);
	}

	public void sendSuccessfulMessage(HttpServletRequest request, String key, Object[] params) {
//		ActionMessages messages = new ActionMessages();
//		messages.add(ActionMessages.GLOBAL_MESSAGE, new ActionMessage(key, params));
//		saveMessages(request, messages);
	}

	public void sendErrorMessage(HttpServletRequest request, String key) {
//		ActionErrors errors = new ActionErrors();
//		errors.add(ActionMessages.GLOBAL_MESSAGE, new ActionMessage(key));
//		saveErrors(request, errors);
	}

	public void sendErrorMessage(HttpServletRequest request, String key, String param) {
//		ActionErrors errors = new ActionErrors();
//		errors.add(ActionMessages.GLOBAL_MESSAGE, new ActionMessage(key, param));
//		saveErrors(request, errors);
	}

	public void sendErrorMessage(HttpServletRequest request, String key, Object[] params) {
//		ActionErrors errors = new ActionErrors(); 
//		errors.add(ActionMessages.GLOBAL_MESSAGE, new ActionMessage(key, params));
//		saveErrors(request, errors);
	}

}