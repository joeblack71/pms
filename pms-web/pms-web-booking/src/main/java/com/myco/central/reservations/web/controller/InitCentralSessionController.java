/*
 * InitCentralSessionAction.java
 *
 * Created on 17 de mayo de 2007, 11:17
 */

package com.myco.central.reservations.web.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.multiaction.MultiActionController;

import com.myco.central.commons.dao.UtilitiesDao;
import com.myco.central.commons.dao.jdbc.UtilitiesDaoJdbc;
import com.myco.central.constants.CentralModuleConstants;
import com.myco.central.reservations.domain.RoomType;
import com.myco.central.util.SessionAttributes;

/**
 *
 * @author Developer
 * @version
 */
public class InitCentralSessionController extends MultiActionController {
	Log log = LogFactory.getLog( getClass() );
    
	public ModelAndView execute(HttpServletRequest request, 
			HttpServletResponse response) throws Exception {

        ModelAndView modelAndView = new ModelAndView();

        HttpSession session = request.getSession();
//        ServletContext context = session.getServletContext();

//        ContextAttributes ctxAttributes
//        				= (ContextAttributes)context.getAttribute(CentralModuleConstants.CONTEXT_ATTRIBUTES);
        SessionAttributes sesAttributes = new SessionAttributes();

        UtilitiesDao uDao = new UtilitiesDaoJdbc(); 

        List<RoomType> sesRoomTypes = new ArrayList<RoomType>();

        List<Map<String, Object>> rateList = null;

        String idHotel = request.getParameter("hotel");
        idHotel = "1"; //TODO verify

        try {
        	rateList = uDao.getRateselect();
		} catch (Exception e) {
			log.info("No se puede obtener tarifas");
		}
		sesAttributes.setIdHotel(idHotel);
        sesAttributes.setIdUser("999"); // TODO: put user id
        sesAttributes.setUserInitials("USR"); // TODO: put user initials
        sesAttributes.setRoomTypes(sesRoomTypes);
        sesAttributes.setRateselect(rateList);

        session.setAttribute(CentralModuleConstants.SESSION_ATTRIBUTES, sesAttributes);

//        log.info("requestURL: "+request.getRequestURL());
//        log.info("servletPath: "+request.getServletPath());
//        log.info("contextPath: "+request.getContextPath());
//        log.info("pathTranslated: "+request.getPathTranslated());
//        log.info("pathInfo: "+request.getPathInfo());

		return modelAndView;
    }
    
}
