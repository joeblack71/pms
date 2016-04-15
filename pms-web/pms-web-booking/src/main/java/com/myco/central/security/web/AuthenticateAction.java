package com.myco.central.security.web;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.myco.central.commons.model.User;
import com.myco.central.reservations.web.form.LoginForm;
import com.myco.central.security.service.AuthenticationService;
import com.myco.central.security.service.impl.AuthenticationServiceImpl;

public class AuthenticateAction {

	Log log = LogFactory.getLog(AuthenticateAction.class);
	
	public void authenticate(HttpServletRequest request, HttpServletResponse response)
	throws Exception {

		LoginForm loginForm = new LoginForm();
        HttpSession session = request.getSession();

        AuthenticationService authenticationService = new AuthenticationServiceImpl();

        User user = new User();

        String hotel    = loginForm.getIdHotel();
        String login    = loginForm.getUserName();
        String password = loginForm.getPassword();

        String forwardKey = "success";

        user.setIdHotel(hotel);
        user.setLogin(login);
        user.setPassword(password);

        if ( authenticationService.authenticateUser(user) ) {
            user.setOptions( authenticationService.getUserOptions( user.getId()) );

            session.setAttribute("user", user);
            session.setAttribute("userOptions", user.getOptions());
            session.setAttribute("hotel", new Short( user.getIdHotel() ));
        } else { 
        	forwardKey = "error";
        }
		
	}

}
