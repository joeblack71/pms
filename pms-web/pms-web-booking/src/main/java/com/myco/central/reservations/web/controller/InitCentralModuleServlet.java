package com.myco.central.reservations.web.controller;


import java.io.IOException;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.myco.central.commons.service.ModuleService;
import com.myco.central.commons.service.impl.ModuleServiceImpl;
import com.myco.central.constants.CentralModuleConstants;
import com.myco.central.util.ContextAttributes;

/**
 *
 * @author Developer
 * @version
 */
public class InitCentralModuleServlet extends HttpServlet {

	Log log = LogFactory.getLog(InitCentralModuleServlet.class);
	private static final long serialVersionUID = 1L;
    
    /** Initializes the servlet.
    */
    @Override
	public void init() throws ServletException {
    	ServletContext context = getServletConfig().getServletContext();

    	ContextAttributes contextAttributes = null;
        ModuleService moduleService = new ModuleServiceImpl();

        try {
        	contextAttributes = moduleService.getContextAttributes() ;
			context.setAttribute(CentralModuleConstants.CONTEXT_ATTRIBUTES, contextAttributes);
		} catch (Exception e) {
			e.printStackTrace();
		}

		log.info("Initializing Central Module attributes");
    }

    /** Processes requests for both HTTP <code>GET</code> and <code>POST</code> methods.
     * @param request servlet request
     * @param response servlet response
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
    }
    
    /** Handles the HTTP <code>GET</code> method.
     * @param request servlet request
     * @param response servlet response
     */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        processRequest(request, response);
    }
    
    /** Handles the HTTP <code>POST</code> method.
     * @param request servlet request
     * @param response servlet response
     */
    @Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        processRequest(request, response);
    }
    
    /** Returns a short description of the servlet.
     */
    @Override
	public String getServletInfo() {
        return "Short description";
    }
}
