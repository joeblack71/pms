
package com.myco.central.web.booking.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import com.myco.central.booking.service.ReservationManager;
import com.myco.central.web.controller.GenericController;

@Controller
@SessionAttributes({"reservationListForm"})
public class ReservationController extends GenericController {

    @SuppressWarnings("unused")
    private ReservationManager reservationManager;

    @RequestMapping(value="reservations/booking/new.htm", method=RequestMethod.GET)
    public ModelAndView loadForm (HttpServletRequest request,
            HttpServletResponse response) throws Exception {
        ModelAndView mav = new ModelAndView("ReservationEdit");
        ModelMap model = new ModelMap();

        mav.addAllObjects(model);

        //        HttpSession session = request.getSession();
        //        SessionAttributes satt = (SessionAttributes)session.getAttribute(CentralModuleConstants.SESSION_ATTRIBUTES);

        //        ReservationListForm listForm = new ReservationListForm();
        //        ReservationFilter filter = listForm.getFilter();
        //
        //        ReservationService reservationService = new ReservationServiceImpl();
        //        List<Reservation> list = null;
        //
        //        filter.setIdHotel("1"); //satt.getIdHotel(); // TODO Obtener valor desde var. de session
        //
        //        try {
        //            list = reservationService.select(filter);
        //            listForm.setReservations(list);
        //        } catch(Exception ex) {
        //        	ex.printStackTrace();
        //        }

        //        Reservation reservation = new Reservation();

        //        HashMap<String, Object> form = new HashMap<String, Object>();
        //
        //		form.put("item", reservation);

        //		modelAndView.addObject("ReservationForm", form);

        return mav;
    }

    /*	public ModelAndView handleRequest(HttpServletRequest request,
    		HttpServletResponse response) throws Exception {
		ModelAndView modelAndView = new ModelAndView("mainApp");

//		ServletWebRequest webRequest = new ServletWebRequest(request);

//		SessionAttributes sesatt = (SessionAttributes)session.getAttribute(CentralModuleConstants.SESSION_ATTRIBUTES);

//      Reservation filter = new Reservation();
//
//      Map<String, Object> guest = new HashMap<String, Object>();
//      Map<String, Object> reservationInfo = new HashMap<String, Object>();
//
//		//String idHotel = sesatt.getIdHotel();
//		String idHotel = webRequest.getParameter("idHotel");
//      String idReservation = webRequest.getParameter("idReservation");

		if (log.isDebugEnabled()) { log.debug("Inicio - Hello World App"); }

        // TODO AOP Control
//		UsuarioBean userSession = (UsuarioBean) WebUtils.getSessionAttribute(request, "usuarioBean");
//		if (userSession == null) {
//			return new ModelAndView("PagM", "beanM", "User is not registered");
//		}

//        try {
//            if ( idReservation != null ) {
//        		filter.setIdHotel(idHotel);
//                filter.setIdReservation(idReservation);
//
//                Reservation reservation = reservationService.search(filter);
//
//	            reservationInfo.put("reservation", reservation);
//
//	            guest.put("IdReservation",idReservation);
//	            List<Guest> guests = guestService.select(guest);
//
//	            reservationInfo.put("guests", guests);
//
//				modelAndView.addObject("reservationInfo", reservationInfo);
//            } else {
//    			modelAndView = new ModelAndView("ErrorPage", "message", "Invalid Reservation Id");
//            }
//		} catch (ServiceException e) {
//			modelAndView = new ModelAndView("ErrorPage", "message", e.getCause());
//        } catch(Exception e) {
//        	e.printStackTrace();
//			modelAndView = new ModelAndView("ErrorPage", "message", e.getCause());
//        }

//		reservationManager.saveReservation(null);

		if (log.isDebugEnabled()) { log.debug("Fin - Hello World App"); }

        return modelAndView;
    }
     */
    /*public ModelAndView reservationSearch (ActionMapping mapping,
			ActionForm form, HttpServletRequest request, HttpServletResponse response)
   	throws Exception {

        HttpSession session = request.getSession();
        SessionAttributes sessionAttributes
    		= (SessionAttributes)session.getAttribute(CentralModuleConstants.SESSION_ATTRIBUTES);

        List<Reservation> list = null;
        ReservationService reservationService = new ReservationServiceImpl();

        final String idHotel = sessionAttributes.getIdHotel();
        final String pattern = request.getParameter("patternValue");

        try {
            list =  reservationService.select(null);
            request.setAttribute("patternValue", pattern);
            request.setAttribute("reservationList", list);
        } catch(Exception ex) {
        	log.info("error reservation action");
        	ex.printStackTrace();
        }

        return modelAndView;
    }

    public ModelAndView reservationUpdate(ActionMapping mapping,
    		ActionForm form, HttpServletRequest request, HttpServletResponse response)
   	throws Exception {

		HttpSession session = request.getSession();
		ReservationForm editForm = (ReservationForm)form;

		ReservationService reservationService = new ReservationServiceImpl();
        //GuestServiceImpl daoRG = null;

        Reservation res = editForm.search();

        List<Guest> guests = (List)session.getAttribute("guests");

        try {
            //res.setIdHotel("1"); // TODO remove after testing
        	if ( StringUtils.isBlank( res.getIdHotel() ) ) {
        		throw new MissingDataException();
        	}
            res.setGuests(guests);
        	reservationService.saveReservationInfo(res);
        } catch(MissingDataException mde) {
        	log.error("Invalid Id Hotel", mde);
            return mapping.findForward("error");
        } catch(Exception ex) {
        	ex.printStackTrace();
        }

        return modelAndView;
    }

    public ModelAndView reservationDelete (ActionMapping mapping,
    		ActionForm form, HttpServletRequest request, HttpServletResponse response)
   	throws Exception {

        HttpSession session = request.getSession();

        ReservationService reservationService = new ReservationServiceImpl();
        Reservation res = new Reservation();

        String delete = request.getParameter("delete");

        boolean reservationIdOk = false;
        boolean reservationExist = false;
        boolean saveOk = false;

        try {
            res.setIdHotel( (String)session.getAttribute("hotel") );
            res.setIdReservation( request.getParameter("reservation") );
            reservationIdOk = true;
        } catch(Exception ex) { System.out.println("Error in reservation Id."); }

        // TODO: Move "isAvailability" method to Reservation bean.
        if ( isAvailability(request, res) ) {
            try {
                request.getRequestDispatcher("/SaveReservationAction")
                       .forward(request, response);
                saveOk = true;
            } catch (Exception ex) { }
        }

        if ( delete != null && reservationIdOk ) {
            if ( rctlr.validate(res) ) {
                rctlr.delete(res);
                res = new Reservation();
            }
        }

        return modelAndView;
    }


     * Este action vuelca la informacion ingresada por el usuario
     * en el formulario. Caso contrario cuando se trata de una nueva
     * reserva, al adicionar un huesped, la informacion registrada
     * se pierde luego de ejecutado el refresco de la pantalla de
     * reservas.

    public ModelAndView customerCall(
    		HttpServletRequest request,HttpServletResponse response)
    throws ServletException, IOException {

		//TODO cambiar nombre de atributo
    	request.setAttribute("disabled_insert", CentralModuleConstants.DISABLED_INSERT);
        return modelAndView;
    }

    public ModelAndView reservationAddGuest (ActionMapping mapping,
    		ActionForm form, HttpServletRequest request, HttpServletResponse response)
   	throws Exception {
    	CustomerForm cForm = (CustomerForm)form;
    	HttpSession session = request.getSession();

    	//Reservation res = (Reservation)session.getAttribute("activeRes"); // TODO delete
    	List<Guest> guests = (ArrayList<Guest>)session.getAttribute("guests");
    	//log.info("guests:"+guests.size()); //REMOVE

    	Customer cust = cForm.getCust();

    	Guest guest = new Guest();
		guest.setIdCustomer( cust.getIdCustomer() );
		guest.setCustomerDocument( cust.getDocumentNumber() );
		guest.setCustomerNames( cust.getLastName1() + ", " + cust.getFirstName() );
		guest.setNationality( String.valueOf( cust.getNationality() ) );

		try {
			if ( guests == null ) {
				guests = new ArrayList<Guest>();
				session.setAttribute("guests", guests);
			}
			// TODO controlar accion cuando la sesion expira
			guests.add(guest);
			//session.setAttribute("guestView", guest);
		} catch (Exception e) {
			log.info("No se pudo adicionar huesped en reservacion");
			e.printStackTrace();
		}
		return modelAndView;
    }

    public ModelAndView reservationRemoveGuest (ActionMapping mapping,
		ActionForm form, HttpServletRequest request, HttpServletResponse response)
   	throws Exception {

    	HttpSession session = request.getSession();
		//Reservation res = (Reservation)session.getAttribute("activeRes");
    	List<Guest> guests = (List<Guest>)session.getAttribute("guests");

    	String posItem = request.getParameter("posItem");
		//log.info("idCust: "+idCustomer);

		try {
			if ( guests.remove(posItem) ) { // TODO verify parameter
				log.info("Identificacion del husped es invalida (null)");
			}
			//log.info("Remove - guest.size(): " + res.getGuests().size()); //TODO remove
		} catch (Exception e) {
			log.info("No se pudo retirar huesped de reservacion");
			e.printStackTrace();
		}

		return modelAndView;
	}

    //TODO verificar uso
    public ModelAndView reloadGuests (ActionMapping mapping,
    		ActionForm form, HttpServletRequest request, HttpServletResponse response)
   	throws Exception {

    	return modelAndView;
    }

     *//** Ajax calls *//*
    public ModelAndView getRoomRate(ActionMapping mapping,
    		ActionForm form, HttpServletRequest request, HttpServletResponse response)
   	throws Exception {
    	SourceDaoJdbc dao = new SourceDaoJdbc();

    	String idHotel = request.getParameter("idHotel");
       	String roomType = request.getParameter("roomType");
       	String idSource = request.getParameter("idSource");
		String roomRate = null;

		//roomRate = dao.get
       	request.setAttribute("specialRateValue", "100.00");

    	return modelAndView;
    }

    //////////////////////
    /// Private interface
    //////////////////////

      *//**
      * Verifica la disponibilidad de habitaciones en la fecha requerida
      * en la reserva.
      *
      * @param request
      * @param res
      * @return
      *//*
    private boolean verifyReservationFields(HttpServletRequest request,
    		Reservation res) {
        Date   oldArrival   = Date.valueOf( res.getArrival() );
        Date   oldDeparture = Date.valueOf( res.getDeparture() );
        String oldRoomType  = res.getRoomType();
        short  oldQuantity  = Short.valueOf( res.getQuantity() );

        boolean validFieldValues = true;
        boolean needAvailabilityCheck = true;
        boolean availableRooms = true;
        try {
            res.setArrival( request.getParameter("arrival") );
            res.setDeparture( request.getParameter("departure") );
            res.setAdults( request.getParameter("adults") );
            res.setRoomType( request.getParameter("roomType") );
            res.setIdSource( request.getParameter("sourceId") );
            res.setQuantity( request.getParameter("quantity") );
            if ( oldArrival != null && oldDeparture != null ) {
                if ( oldArrival.equals( res.getArrival() ) &&
                     oldDeparture.equals( res.getDeparture() ) &&
                     oldRoomType.equals( res.getRoomType() ) &&
                     oldQuantity == Short.valueOf( res.getQuantity() ) ) {
                    needAvailabilityCheck = false;
                }
            }
        } //catch (ReservationDataException ex) { validFieldValues = false; }
        finally {}

        if ( validFieldValues && needAvailabilityCheck ) {
            Availability aq = new Availability();
            aq.setHotelId( res.getIdHotel() );
            try {
				aq.setStartDate( res.getArrival() );
			} catch (AvailabilityQueryException ex) {
				ex.printStackTrace();
			}
            aq.setEndDate( Date.valueOf( res.getDeparture() ) );
            aq.setRoomType( res.getRoomType() );
            try {
				aq.setQuantity( res.getQuantity() );
			} catch (AvailabilityQueryException ex) {
				ex.printStackTrace();
			}
            aq.setOldArrival(oldArrival);
            aq.setOldDeparture(oldDeparture);
            aq.setReservationRooms( Short.valueOf( res.getQuantity() ) );
            aq.setRoomTypeAvailability( getRoomTypeRooms( res.getRoomType() ) );
            //AvailabilityCtlr avctlr = new AvailabilityCtlr();
            availableRooms = isAvailability(aq);
        }

        if ( !validFieldValues )
            System.out.println("\nField values are wrong.\n");
        if ( !availableRooms )
            System.out.println("\nThere is not available rooms.\n");

        return validFieldValues && availableRooms;
    }

       *//**
       * Obtiene el numero de habitaciones disponibles para la venta en un
       * tipo especifico. El dato se extrae de <B>rtList</B>, que es un <U>ArrayList</U>
       * con informacion de los tipos disponibles, cargado al inicio de la
       * sesion del usuario.
       *
       * @param roomType Tipo de habitacion del cual se desea conocer el numero
       * de habitaciones disponibles para la venta.
       *//*
    private short getRoomTypeRooms(String roomType) {
        //ArrayList roomTypes = (ArrayList)getServletContext().getAttribute("roomTypes");
        short rtAvailableRooms = 0;
        RoomType rt = new RoomType();
        Iterator i = roomTypes.iterator();
        while ( i.hasNext() ) {
            rt = (RoomType)i.next();
            if ( roomType.equals( rt.getRoomType() ) )
                rtAvailableRooms = rt.getAvailableRooms();
        }

        return rtAvailableRooms;
    }

        *//**
        * Determina si en una fecha espec�fica, habr� disponibilidad.
        * <p> Extrae de la lista, la ocupaci�n esperada por dia y entonces
        * calcula el numero de habitaciones libres para la venta.
        *
        * <p>Si en alguno de los dias comprendidos por la reserva el numero
        * de habitaciones libres es menor que el requerido por la reserva,
        * el proceso se termina.
        * @param aq es un objeto <CODE>Availability</CODE> cuyos atributos son utilizados
        * para extraer informacion de la BB.DD. y realizar calculos para determinar
        * la disponibilidad de habitaciones.
        *
        * <p>Los atributos <B>oldArrival</B> y <B>oldDeparture</B> se utilizan,
        * cuando una reserva va a ser modificada, y permiten determinar si las
        * habitaciones bloqueadas por esta, deben considerarse como disponibles.
        *
        * @return <B>true</B> si hay habitaciones disponibles para la reserva;
        * en otro caso, devuelve <B>false</B>.
        *//*
    // TODO: Move "isAvailability" method to Reservation bean.
    private boolean isAvailability(Availability aq) {
        //int availableRooms = aq.getRoomTypeAvailability();
        int occupiedRooms = 0;
        int roomsFree = 0;
        int compArrival = -1;
        int compDeparture = 1;
        boolean dateIsAvailable = true;
        List<OccupationDay> list = null;

        AvailabilityDaoJdbc dao = new AvailabilityDaoJdbc();
        //dao.setAvailabilityQry(aq);
        String hotelId = String.valueOf( aq.getHotelId() );
        String roomType = aq.getRoomType();
        String startDate = String.valueOf( aq.getStartDate() );
        String endDate = String.valueOf( aq.getEndDate() );
        String status = aq.getStatus();
        try {
        list = dao.chargeOccupationOnStay(null);
        } catch(Exception ex) { ex.printStackTrace(); }

        OccupationDay od = null;
        Iterator<OccupationDay> it = list.iterator();
        while ( it.hasNext() ) {
            od = it.next();
            occupiedRooms = od.getOccupiedRooms();
            try {
                compArrival   = od.getOccupiedDay().compareTo( aq.getOldArrival() );
                compDeparture = od.getOccupiedDay().compareTo( aq.getOldDeparture() );
                if ( compArrival >= 0 && compDeparture <= 0 )
                    occupiedRooms = occupiedRooms - aq.getReservationRooms();
            } catch(NullPointerException ex) {}
            roomsFree = aq.getRoomTypeAvailability() - occupiedRooms;
            if ( roomsFree < aq.getQuantity() ) {
                dateIsAvailable = false; break;
            }
        }

        return dateIsAvailable;
    }

    private void prepareForm(ReservationForm form, HttpSession session) {
    	CommonsService commonsService = new CommonsServiceImpl();
    	ContextAttributes att
    		= (ContextAttributes)session.getServletContext().getAttribute(CentralModuleConstants.CONTEXT_ATTRIBUTES);

    	String idHotel = form.search().getIdHotel();
    	String roomType = form.search().getRoomType();

    	try {
        	form.setRoomTypeselect( commonsService.getRoomTypes(idHotel) );
			form.setRoomNumberselect( commonsService.getRoomNumbers(idHotel, roomType) );
			//form.setPaymentTypeselect( commonsService.getPaymentTypes( att.getPaymentAccounts() ) );
		} catch (Exception ex) {
			ex.printStackTrace();
		}
    }*/

    @Autowired
    public void setReservationManager(ReservationManager reservationManager) {
        this.reservationManager = reservationManager;
    }

}
