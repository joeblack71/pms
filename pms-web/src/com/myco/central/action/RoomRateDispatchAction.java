
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

import com.myco.central.dao.SpecialRateDAO;
import com.myco.central.lists.RoomTypeRates;
import com.myco.central.vo.SpecialRate;

public class RoomRateDispatchAction extends MappingDispatchAction {

    public ActionForward roomRateList(ActionMapping mapping, ActionForm form,
    		HttpServletRequest request, HttpServletResponse response)
                   throws ServletException, IOException {

    	HttpSession session = request.getSession();
        String hotelId = (String)session.getAttribute("hotel");
        String roomType = request.getParameter("roomType");
        String rateId   = request.getParameter("rateId");

        //SourceDAO sc = new SourceDAO();
        RoomTypeRates rates = new RoomTypeRates();
        SpecialRateDAO dao = new SpecialRateDAO();
        rates = dao.getRoomRates(hotelId);
        request.setAttribute("rates",rates);
        
        return mapping.findForward("success");
    }

    public ActionForward showRoomRate(ActionMapping mapping, ActionForm form,
    		HttpServletRequest request, HttpServletResponse response)
                   throws ServletException, IOException {

    	HttpSession session = request.getSession();
        String hotelId = (String)session.getAttribute("hotel");
        String roomType = request.getParameter("roomType");
        String rateId   = request.getParameter("rateId");

        //SourceDAO sc = new SourceDAO();
        SpecialRate rate = new SpecialRate();
        SpecialRateDAO dao = new SpecialRateDAO();
        rate = dao.search(hotelId, roomType, rateId);
        request.setAttribute("rate",rate);
        
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
