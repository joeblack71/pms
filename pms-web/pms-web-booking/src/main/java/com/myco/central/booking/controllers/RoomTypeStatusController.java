
package com.myco.central.web.booking.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;

import com.myco.central.booking.service.RoomTypeStatusService;
import com.myco.central.core.service.RoomTypeService;
import com.myco.central.web.controller.GenericController;


public class RoomTypeStatusController extends GenericController {
	private RoomTypeStatusService roomTypeStatusService;

	public RoomTypeStatusService getRoomTypeStatusService() {
		return roomTypeStatusService;
	}

	public void setRoomTypeStatusService(RoomTypeStatusService roomTypeStatusService) {
		this.roomTypeStatusService = roomTypeStatusService;
	}

	public RoomTypeService getRoomTypeService() {
		return roomTypeService;
	}

	public void setRoomTypeService(RoomTypeService roomTypeService) {
		this.roomTypeService = roomTypeService;
	}

	private RoomTypeService roomTypeService;

	protected void onInit() {
	}

	public ModelAndView roomTypeAvailability(HttpServletRequest request, 
			HttpServletResponse response) throws Exception {
        ModelAndView modelAndView = new ModelAndView();
        
        // TODO: obtener el id del hotel desde sesion
//        String idHotel = (String)session.getAttribute("idhotel");
//        idHotel = "1";
//        
//        editForm.getFilter().setIdHotel(idHotel);
//        prepareForm(editForm);
		
		return modelAndView;
	}

	/**
     * Carga una lista con la ocupacion esperada para un periodo
     * determinado. Esta informacion es utilizada en la preparacion
     * de los cuadros de ocupacion y disponibilidad.
     * @param aq es un objeto <B>Availability</B>, cuyos atributos se utilizan
     * para consulta en BB.DD.
     */
	public ModelAndView showAvailability(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
        ModelAndView modelAndView = new ModelAndView();
        
//        Availability availability = new Availability();
//        AvailabilityFilter filter = editForm.getFilter();
//
//        String[][] matrix = null;
//
//        String button = request.getParameter("button");
//        if ( button != null && button.equals("Next") ) {
//        	filter.setStartDate(DateFormater.addDaysToDate(filter.getStartDate(),
//        			Short.parseShort( filter.getPeriod() )) );
//        }
//        
//		prepareForm(editForm);
//        try {
//	        matrix = availability.getOccupation(filter);
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//
//		request.setAttribute("matriz", matrix);

        return modelAndView;
    }

	public ModelAndView showFlashStatus(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
        ModelAndView modelAndView = new ModelAndView();

//		RoomTypeStatus roomTypeStatus = new RoomTypeStatus();
//
//		final String FLASH_STATUS_BEAN = "flashStatusBean";
//		final String ROOM_TYPE_LIST = "roomTypeList";
//
//		FlashStatusBean flashStatusBean = null;
//
//		//TODO poblar listas de hoteles, tipos y periodos
//		List<RoomType> roomTypeList = null;
//
//		roomTypeStatus.setIdHotel( filterForm.getIdHotel() );
//		roomTypeStatus.setIdRoomType( filterForm.getIdRoomType() );
//		roomTypeStatus.setStatusDay( filterForm.getStartDate() );
//
//		try {
//			roomTypeList = roomTypeService.select(null);
//			flashStatusBean = roomTypeStatusService.flashStatus(roomTypeStatus);
//
//			session.setAttribute(FLASH_STATUS_BEAN, flashStatusBean);
//			session.setAttribute(ROOM_TYPE_LIST, roomTypeList);
//		} catch (ServiceException ex) {
//			ex.printStackTrace();
//			sendErrorMessage(request, "mess.value", "testing");
//		}
//
//		log.debug("Fin");

		return modelAndView;
	}

	public ModelAndView forwardFlashStatus(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
        ModelAndView modelAndView = new ModelAndView();

//		RoomTypeStatus roomTypeStatus = new RoomTypeStatus();
//
//		//List<RoomTypeStatus> list = null;
//		final String FLASH_STATUS_BEAN = "flashStatusBean";
//		FlashStatusBean flashStatusBean = 
//				(FlashStatusBean)session.getAttribute(FLASH_STATUS_BEAN);
//
//		String idHotel = request.getParameter("idHotel");
//		String idRoomType = request.getParameter("idRoomType");
//		String statusDate = request.getParameter("statusDate");
//
//		roomTypeStatus.setIdHotel(idHotel);
//		roomTypeStatus.setIdRoomType(idRoomType);
//		roomTypeStatus.setStatusDay(statusDate);
//
//		try {
//			if ( flashStatusBean == null ) {
//				flashStatusBean = roomTypeStatusService.flashStatus(roomTypeStatus);
//				session.setAttribute(FLASH_STATUS_BEAN, flashStatusBean);
//			} else {
//				if ( flashStatusBean.isMoreInfo() ) {
//					flashStatusBean.forward(CentralModuleConstants.WEEK);
//				}
//			}
//		} catch (ServiceException ex) {
//			ex.printStackTrace();
//			sendErrorMessage(request, "mess.value", "testing");
//		}
//
//		log.debug("Fin");

		return modelAndView;
	}

}
