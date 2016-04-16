package com.myco.central.web;

import java.util.logging.Logger;

import com.myco.central.model.User;
import com.myco.central.service.IAuthenticationService;
import com.myco.central.service.impl.AuthenticationServiceImpl;

public class AuthenticateAction {

//	Logger log = LogFactory.getLog(AuthenticateAction.class);
	
	public void authenticate(HttpServletRequest request, HttpServletResponse response)
	throws Exception {

		LoginForm loginForm = new LoginForm();
        HttpSession session = request.getSession();

        IAuthenticationService authenticationService = new AuthenticationServiceImpl();

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
