package com.myco.central.action;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.myco.central.dao.AppUserDAO;
//import com.myco.central.dao.LoginDAO;
import com.myco.central.form.LoginForm;
import com.myco.central.vo.AppUser;


public class AuthenticateAction extends Action {

	//TODO activar servicio
	Log log = LogFactory.getLog(AuthenticateAction.class);
	
	public ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
	throws Exception {

		LoginForm loginForm = (LoginForm)form;
        HttpSession session = request.getSession();
        List userOptions = null;

        AppUser u = new AppUser();
        AppUserDAO dao = new AppUserDAO();

        String hotel    = loginForm.getHotelId();
        String login    = loginForm.getUserName();
        String password = loginForm.getPassword();
        boolean registeredUser = false;

        String forwardKey = null;
        //TODO validar ingreso de datos en JSP
        u.setHotelId( Short.parseShort(hotel) );
        u.setLogin(login);
        u.setPassword(password);
        registeredUser = dao.validate(u);
        if ( registeredUser ) {
            userOptions = dao.chargeOptions(u);
            session.setAttribute("user",u);
            session.setAttribute("hotel",new Short( u.getHotelId() ));
            session.setAttribute("uoptions",userOptions);
            forwardKey = "success";
        } else { 
        	forwardKey = "error";
        }
		
		return mapping.findForward(forwardKey);
	}

}
