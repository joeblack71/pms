
package com.myco.central.web.booking.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.multiaction.MultiActionController;

import com.myco.central.core.service.RoomService;

public class RoomController extends MultiActionController {

	Log log = LogFactory.getLog( getClass() );

	protected RoomService roomService;

	public void setRoomService(RoomService roomService) {
		this.roomService = roomService;
	}

	protected void onInit() {
	}

	public ModelAndView roomselect(HttpServletRequest request, 
			HttpServletResponse response) throws Exception {
        ModelAndView modelAndView = new ModelAndView();

//        List<Map<String, Object>> list = null;
//
//        String idHotel = "1"; // TODO get session value
//        //String criterion = request.getParameter("criterion");
//        String pattern = request.getParameter("pattern");
//        String status = "";
//
//        try {
//        	list = roomService.select(null);
//	        sForm.setItems(list);
//		} catch (Exception ex) {
//			ex.printStackTrace();
//		}
        
        return modelAndView;
    }

	public ModelAndView showRoomStatus(HttpServletRequest request, 
			HttpServletResponse response) throws Exception {
        ModelAndView modelAndView = new ModelAndView();
        //List<Map<String, Object>> list = null;

//        String idHotel = "1"; // TODO get session value
//        //String criterion = request.getParameter("criterion");
//        String pattern = request.getParameter("pattern");
//        String status = "I";
//
//        try {
//	        rsForm.setRooms( roomService.select(null) );
//		} catch (Exception ex) {
//			ex.printStackTrace();
//		}
        
        return modelAndView;
    }

    public ModelAndView sourceEdit(HttpServletRequest request, 
    		HttpServletResponse response) throws Exception {
        ModelAndView modelAndView = new ModelAndView();

//        Room item = new Room();
//
//        String idHotel = "1"; // TODO get session value
//        String idRoom = request.getParameter("idRoom");
//
//        item.setIdHotel(idHotel);
//        item.setIdRoom(idRoom);
//        try {
//	        rForm.setItem( roomService.search(item) );
//		} catch (Exception ex) {
//			ex.printStackTrace();
//		}

        return modelAndView;
    }

    public ModelAndView sourceUpdate(HttpServletRequest request,
    		HttpServletResponse response) throws Exception {

        ModelAndView modelAndView = new ModelAndView();

//        SessionAttributes sesAttributes =
//        	(SessionAttributes)session.getAttribute(CentralModuleConstants.SESSION_ATTRIBUTES);

//        String idHotel = "1"; // TODO get session value
//        String idRoom = request.getParameter("idRoom");
//
//		try {
//			idHotel = sesAttributes.getIdHotel();
//		} catch (Exception e) {
//			/*errmsg = "customerUpdate / Session invalida - Hotel Id.: " + idHotel;
//			log.info(errmsg);*/
//	        idHotel = "1"; //TODO remove
//		}
//
//        if ( idHotel != null && idRoom != null ) {
//        	try {
//                if ( idRoom.equals("") ) {
//	        		roomService.insert( rForm.search() );
//	        	} else {
//	        		roomService.update( rForm.search() );
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

		return modelAndView ;
    }

}
