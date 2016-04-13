/*
 * InitCentralModuleServlet.java
 *
 * Created on 17 de mayo de 2007, 11:17
 */

package com.myco.central.action;

import java.io.IOException;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.myco.central.dao.ModuleContextDAO;
import com.myco.central.vo.ModuleContext;

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
    public void init() throws ServletException {
    	ServletContext context = getServletContext();

    	String[] hotels = {"hoteles","Apart Hotel El Doral"};
        int[]    years  = {0,2007,2006,2005,2004,2003,2002,2001,2000,1999}; // TODO: Debe empezar con el año de operacion de la empresa
        String[] months = {"Meses","Enero","Febrero","Marzo","Abril","Mayo","Junio","Julio","Agosto","Setiembre","Octubre","Noviembre","Diciembre"};
        int[]    days   = {0,1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20,21,22,23,24,25,26,27,28,29,30,31};
        int[]    sales  = {0,1000,5000,10000,20000};

        context.setAttribute("years",years);
        context.setAttribute("months",months);
        context.setAttribute("days",days);
        context.setAttribute("sales",sales);

        ModuleContext mc = new ModuleContext(); 
        ModuleContextDAO dao = new ModuleContextDAO();
        dao.setMc(mc);
        try {
			dao.chargeGenericListModule();
			context.setAttribute("reservationStatus", mc.getReservationStatusList() );
	        context.setAttribute("countries", mc.getCountryList() );
	        context.setAttribute("cities", mc.getCityList() );
	        context.setAttribute("segments", mc.getSegmentList() );
	        context.setAttribute("paymentTypes", mc.getPaymentTypeList() );
	        context.setAttribute("documentTypes", mc.getDocumentTypeList() );
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
    
    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
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
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        processRequest(request, response);
    }
    
    /** Returns a short description of the servlet.
     */
    public String getServletInfo() {
        return "Short description";
    }
    // </editor-fold>
}
