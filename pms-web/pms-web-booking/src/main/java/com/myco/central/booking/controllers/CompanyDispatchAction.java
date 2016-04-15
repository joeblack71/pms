
package com.myco.central.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.actions.MappingDispatchAction;

import com.myco.central.dao.CompanyDAO;
import com.myco.central.lists.Companies;

public class CompanyDispatchAction extends MappingDispatchAction {

	public ActionForward companyList(ActionMapping mapping, ActionForm form,
			HttpServletRequest request,HttpServletResponse response)
	throws ServletException, IOException {

		HttpSession session = request.getSession();
        String hotelId = (String)session.getAttribute("hotel");
        String field = request.getParameter("sampleField");
        String pattern = request.getParameter("sampleValue");

        CompanyDAO dao = new CompanyDAO();
        Companies cias = dao.getCompanies(pattern);
        request.setAttribute("companies",cias);
        
        return mapping.findForward("success");
    }

}
