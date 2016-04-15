
package com.myco.central.reservations.web.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;

import com.myco.central.reservations.service.SpecialRateService;

public class SpecialRateController extends GenericController {
    SpecialRateService specialRateService;

	public SpecialRateService getSpecialRateService() {
		return specialRateService;
	}

	public void setSpecialRateService(SpecialRateService specialRateService) {
		this.specialRateService = specialRateService;
	}

	/** Lista de tarifas especiales de un determinado hotel */
	public ModelAndView specialRateselect(HttpServletRequest request, 
			HttpServletResponse response) throws Exception {
        ModelAndView modelAndView = new ModelAndView();

        //String idHotel = "1"; // TODO get session value
//        String idHotel   = request.getParameter("idHotel");
//        String idSpecialRate = request.getParameter("idSpecialRate");
//
//        try {
//	        listForm.setItems( specialRateService.select(idHotel, idSpecialRate, null) );
//		} catch (Exception ex) {
//			ex.printStackTrace();
//		}
        
		return modelAndView;
    }

    public ModelAndView specialRateEdit(HttpServletRequest request, 
    		HttpServletResponse response) throws Exception {
        ModelAndView modelAndView = new ModelAndView();

//        SpecialRate item = new SpecialRate();
//
//        //String idHotel = "1"; // TODO get session value
//        String idHotel = request.getParameter("idHotel");
//        String idSource = request.getParameter("idSpecialRate");
//
//		prepareForm(editForm);
//		item.setIdHotel(idHotel);
//		item.setIdSpecialRate(idSource);
//        try {
//	        editForm.setItem( specialRateService.search(item) );
//	        session.setAttribute("specialRate", editForm.search());
//		} catch (Exception ex) {
//			ex.printStackTrace();
//		}

        return modelAndView;
    }

    public ModelAndView specialRateUpdate(HttpServletRequest request, 
    		HttpServletResponse response) throws Exception {
        ModelAndView modelAndView = new ModelAndView();

//        SessionAttributes sesAttributes =
//        	(SessionAttributes)session.getAttribute(CentralModuleConstants.SESSION_ATTRIBUTES);
//
//        String idHotel = "1"; // TODO get session value
//        String idSource = request.getParameter("idspecialRate");
//
//		try {
//			idHotel = sesAttributes.getIdHotel();
//		} catch (Exception e) {
//			/*errmsg = "customerUpdate / Session invalida - Hotel Id.: " + idHotel;
//			log.info(errmsg);*/
//	        idHotel = "1"; //TODO remove
//		}
//
//        if ( idHotel != null && idSource != null ) {
//        	try {
//                if ( idSource.equals("") ) {
//	        		specialRateService.insert( editForm.search() );
//	        	} else {
//	        		specialRateService.update( editForm.search() );
//	        	}
//        	} catch(Exception e) {
//    			/*errmsg = "Error al registrar informacion del Cliente";
//        		log.info(errmsg);
//        		findForward = "success";*/
//        	}
//        } else {
//			/*errmsg = "Customer Id. error: "+idHotel+";"+idCustomer;
//    		log.info(errmsg);
//    		findForward = "success"; // TODO change to "error"*/
//        }               

        return modelAndView;
    }

    public ModelAndView _addRoomTypeRate(HttpServletRequest request, 
    		HttpServletResponse response) throws Exception {
        ModelAndView modelAndView = new ModelAndView();

//    	SpecialRate item = (SpecialRate)session.getAttribute("specialRate");
//    	Map<String, Object> newItem = new HashMap<String, Object>();
//
//    	String idHotel = request.getParameter("idHotel");
//    	String idSpecialRate = request.getParameter("idSpecialRate");
//    	String idPeriod = request.getParameter("idPeriod");
//    	String idRoomType = request.getParameter("idRoomType");
//    	String rateValue = request.getParameter("rateValue");
//
//    	log.info(idRoomType+"-"+idPeriod+"-"+rateValue);
//    	editForm.setItem(item);
//
//    	newItem.set("idRoomType", idRoomType);
//    	newItem.set("idPeriod", idPeriod);
//    	newItem.set("roomValue", rateValue);
//
//    	newItem.set("rtDescription", "Room Type 1");
//    	newItem.set("periodDescription", "");
//    	newItem.set("startDate", "");
//    	newItem.set("endDate", "");
//    	newItem.set("madeBy", "");
//    	newItem.set("madeOn", "");
//    	newItem.set("updatedBy", "");
//    	newItem.set("lastUpdate", "");
//
//   		item.getRates().add(newItem);

		return modelAndView;
    }
    
}
