/*
 * InitCentralSessionAction.java
 *
 * Created on 17 de mayo de 2007, 11:17
 */

package com.myco.central.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

/**
 *
 * @author Developer
 * @version
 */
public class InitCentralSessionAction extends Action {
    
	public ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
	throws Exception {

        HttpSession session = request.getSession();
        
        /*RoomTypeDAO rtDao = new RoomTypeDAO();
        SourceDAO sDao = new SourceDAO();*/

        //session.setAttribute("rates", mc.getRoomtypeRates());
        //session.setAttribute("specialRates", mc.getSpecialRateList() );
        //session.setAttribute("roomTypes", rtDao.getSourceList() );
        session.setAttribute("hotel","1");
        
        return mapping.findForward("success");

    }
    
}
