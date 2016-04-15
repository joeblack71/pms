
package com.myco.central.action;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.actions.MappingDispatchAction;

import com.myco.central.dao.SpecialRateDAO;
import com.myco.central.vo.SpecialRate;

public class SourceDispatchAction extends MappingDispatchAction {

    public ActionForward sourcesList(ActionMapping mapping, ActionForm form,
    		HttpServletRequest request, HttpServletResponse response)
                   throws ServletException, IOException {

        //PrintWriter out = response.getWriter();
        HttpSession session = request.getSession();

        Short hotelId = (Short)session.getAttribute("hotel");

        //SourceCtlr sc = new SourceCtlr();
        
        String roomType = request.getParameter("roomType");
        String rateId   = request.getParameter("rateId");
        
        String show           = request.getParameter("show");
        String save           = request.getParameter("save");
        String delete         = request.getParameter("delete");

        SpecialRate rate = new SpecialRate();
        SpecialRateDAO ratectlr = new SpecialRateDAO();

        boolean rateExists = false;
        if ( roomType != null && rateId != null ) {
            rate.setHotelId( (short)1 );
            rate.setRoomType(roomType);
            try {
                rate.setRateId( Short.parseShort(rateId) );
            } catch (NumberFormatException ex) { ex.printStackTrace(); }
            //rateExists = ratectlr.search(rate);
        }
        
        if ( save != null ) {
            // TODO: Validar campos
            chargeRateValues(request, rate);
            boolean saveOK;
            if ( rateExists )
                 saveOK = ratectlr.update(rate);
            else saveOK = ratectlr.insert(rate);
        }

        request.setAttribute("rate",rate);
        RequestDispatcher dispatcher = request.getRequestDispatcher("/ratesManager.jsp");
        if ( dispatcher != null ) dispatcher.forward(request, response);
        
        return mapping.findForward("success");
    }

    private void chargeRateValues(HttpServletRequest request, SpecialRate rate) {
        String dh = request.getParameter("dowHighSeasonRate");
        String eh = request.getParameter("eowHighSeasonRate");
        String dl  = request.getParameter("dowLowSeasonRate");
        String el  = request.getParameter("eowLowSeasonRate");
        try {
            rate.setDowHighSeasonRate( Short.parseShort(dh) );
            rate.setEowHighSeasonRate( Short.parseShort(eh) );
            rate.setDowLowSeasonRate( Short.parseShort(dl) );
            rate.setEowLowSeasonRate( Short.parseShort(el) );
        } catch (NumberFormatException ex) {
            ex.printStackTrace();
        }
    }

}
