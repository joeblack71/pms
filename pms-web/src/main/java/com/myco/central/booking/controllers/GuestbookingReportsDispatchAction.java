
package com.myco.central.action;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.actions.MappingDispatchAction;

import com.myco.central.dao.ReservationDAO;

public class GuestbookingReportsDispatchAction extends MappingDispatchAction {

	public ActionForward guestbookingReport(ActionMapping mapping, ActionForm form,
			HttpServletRequest request,HttpServletResponse response)
	throws ServletException, IOException {

        String hotelId = (String)request.getParameter("sampleField");
        int field = 1;
        //String pattern = form.getPattern();
        
        ReservationDAO dao = new ReservationDAO();
        ArrayList list = dao.getReportByPattern(field,"A");
        request.setAttribute("list",list);
        
        return mapping.findForward("success");
    }

}
