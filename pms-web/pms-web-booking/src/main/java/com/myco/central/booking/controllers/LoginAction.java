package com.myco.central.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.myco.central.dao.LoginDAO;
import com.myco.central.form.LoginForm;

public class LoginAction extends Action {
	
	Log log = LogFactory.getLog(LoginAction.class);
	
	public ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {

		/*LoginForm lform = (LoginForm)form;
		String user = lform.getUserName();
		String pass = lform.getClaveAcceso();*/
		
		/*LoginDAO dao = new LoginDAO();
		log.info(user+""+""+pass);*/
		return mapping.findForward("success");
	}

}
