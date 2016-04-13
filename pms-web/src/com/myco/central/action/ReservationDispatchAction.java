
package com.myco.central.action;

import java.sql.Date;
import java.util.Iterator;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.actions.MappingDispatchAction;

import com.myco.central.dao.AvailabilityDAO;
import com.myco.central.dao.GuestDAO;
import com.myco.central.dao.ModuleContextDAO;
import com.myco.central.dao.ReservationDAO;
import com.myco.central.dao.RoomTypeDAO;
import com.myco.central.events.ReservationDataException;
import com.myco.central.form.ReservationForm;
import com.myco.central.vo.Availability;
import com.myco.central.vo.OccupationDay;
import com.myco.central.vo.PaymentType;
import com.myco.central.vo.Reservation;
import com.myco.central.vo.ReservationStatus;

public class ReservationDispatchAction extends MappingDispatchAction {

	Log log = LogFactory.getLog(ReservationDispatchAction.class);
	
	public ActionForward reservationList (ActionMapping mapping,
			ActionForm form,
			HttpServletRequest request,
			HttpServletResponse response) {

        HttpSession session = request.getSession();
        List<Reservation> reservations = null; 

        ReservationDAO dao = new ReservationDAO();
        String hotelId = (String)session.getAttribute("hotel");

        try {
            reservations =  dao.getReservationList(hotelId);
            request.setAttribute("reservationList", reservations);
        } catch(Exception ex) {
        	ex.printStackTrace();
        }

        return mapping.findForward("success");
    }
    
	public ActionForward reservationSearch (ActionMapping mapping,
			ActionForm form,
			HttpServletRequest request,
			HttpServletResponse response) {

		ReservationForm rForm = (ReservationForm)form;

        HttpSession session = request.getSession();

        ReservationDAO dao = new ReservationDAO();
        //ReservationGuestCtlr rgc = null;
        String hotelId = (String)session.getAttribute("hotel");
        String reservationId = request.getParameter("reservation");

        try {
            rForm.setItem( dao.getReservation(hotelId, reservationId) );
            /*if ( fieldName.equals("lastname") && pattern.length() > 0 )
                list = rdisp.chargeByLastName(hotelId, pattern);
            if ( fieldName.equals("arrival") && pattern.length() >= 6 )
                list = rdisp.chargeByArrival(hotelId, pattern);*/
        } catch(Exception ex) {
        	ex.printStackTrace();
        }

        return mapping.findForward("success");
    }
    
	@SuppressWarnings("unchecked")
	public ActionForward reservationShow (ActionMapping mapping,
			ActionForm form,
			HttpServletRequest request,
			HttpServletResponse response) {

        HttpSession session = request.getSession();
        ServletContext context = session.getServletContext();
        ReservationForm rForm = (ReservationForm)form;

        ReservationDAO dao = new ReservationDAO();
        GuestDAO gDao = new GuestDAO();
        RoomTypeDAO rtDao = new RoomTypeDAO();

        List<ReservationStatus> rsList
        	= (List<ReservationStatus>)context.getAttribute("reservationStatus");
        List<PaymentType> ptList 
        	= (List<PaymentType>)context.getAttribute("paymentTypes");

		String hotelId = (String)session.getAttribute("hotel");
        log.info("hotel:"+hotelId);

        String reservationId = request.getParameter("resNumber");
        log.info("res:"+reservationId);

        try {
            rForm.setItem( dao.getReservation(hotelId, reservationId) );
            
            //TODO testing with getReservationGuests()
            rForm.getItem().setGuests( gDao.chargeGuests(hotelId, reservationId));

            rForm.setReservationStatusList(rsList);
            rForm.setPaymentTypeList(ptList);
            
            rForm.setRoomTypeList( rtDao.getRoomTypes() );
        } catch(Exception ex) {
        	ex.printStackTrace();
        }

        return mapping.findForward("success");
    }
    
	public ActionForward reservationSave (ActionMapping mapping,
			ActionForm form,
			HttpServletRequest request,
			HttpServletResponse response) {
		
		HttpSession session = request.getSession();
		ReservationForm rForm = (ReservationForm)form; 
        ReservationDAO dao = new ReservationDAO();
        //GuestDAO daoRG = null;
        String hotelId = (String)session.getAttribute("hotel");
        String reservationId = request.getParameter("resNumber");
        log.info("resNumber:"+reservationId);

        try {
        	//TODO cargar valores de formulario en item
        	log.info("reservationId"+rForm.getItem().getReservation());
            if ( reservationId.equals("") )
            	dao.insert( rForm.getItem() );
            else dao.update( rForm.getItem() );
        } catch(Exception ex) { ex.printStackTrace(); }
            
        return mapping.findForward("success");
    }
    
	public ActionForward deleteReservation (ActionMapping mapping,
			ActionForm form,
			HttpServletRequest request,
			HttpServletResponse response) {
		
        /*HttpSession session = request.getSession();

        String delete = request.getParameter("delete");

        ReservationDAO rctlr = new ReservationDAO();
        ReservationGuestCtlr rgc = null;

        boolean reservationIdOk = false;
        boolean reservationExist = false;
        try {
            res.setHotelId( ( (Short)session.getAttribute("hotel") ).shortValue() );
            res.setReservation( request.getParameter("reservation") );
            reservationIdOk = true;
        } catch(Exception ex) { System.out.println("Error in reservation Id."); }
            
        boolean saveOk = false;
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
        }*/

        return mapping.findForward("success");
    }
    
	/**
	 * Verifica la disponibilidad de habitaciones en la fecha requerida
	 * en la reserva.
	 * 
	 * @param request
	 * @param res
	 * @return
	 */
    private boolean verifyReservationFields(HttpServletRequest request, Reservation res) {
        Date   oldArrival   = res.getArrival();
        Date   oldDeparture = res.getDeparture();
        String oldRoomType  = res.getRoomType();
        short  oldQuantity  = res.getQuantity();

        boolean validFieldValues = true;
        boolean needAvailabilityCheck = true;
        boolean availableRooms = true;
        try {
            res.setArrival( request.getParameter("arrival") );
            res.setDeparture( request.getParameter("departure") );
            res.setAdults( request.getParameter("adults") );
            res.setRoomType( request.getParameter("roomType") );
            res.setSourceId( request.getParameter("sourceId") );
            res.setQuantity( request.getParameter("quantity") );
            if ( oldArrival != null && oldDeparture != null ) {
                if ( oldArrival.equals( res.getArrival() ) &&
                     oldDeparture.equals( res.getDeparture() ) &&
                     oldRoomType.equals( res.getRoomType() ) &&
                     oldQuantity == res.getQuantity() )
                    needAvailabilityCheck = false;
            }
        } catch (ReservationDataException ex) { validFieldValues = false; }
        
        if ( validFieldValues && needAvailabilityCheck ) {
            Availability aq = new Availability();
            aq.setHotelId( res.getHotelId() );
            aq.setStartDate( res.getArrival() );
            aq.setEndDate( res.getDeparture() );
            aq.setRoomType( res.getRoomType() );
            aq.setQuantity( res.getQuantity() );
            aq.setOldArrival(oldArrival);
            aq.setOldDeparture(oldDeparture);
            aq.setReservationRooms( res.getQuantity() );
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
    
    /** 
     * Obtiene el numero de habitaciones disponibles para la venta en un
     * tipo especifico. El dato se extrae de <B>rtList</B>, que es un <U>ArrayList</U>
     * con informacion de los tipos disponibles, cargado al inicio de la
     * sesion del usuario.
     *
     * @param roomType Tipo de habitacion del cual se desea conocer el numero
     * de habitaciones disponibles para la venta.
     */
    private short getRoomTypeRooms(String roomType) {
        //ArrayList roomTypes = (ArrayList)getServletContext().getAttribute("roomTypes");
        short rtAvailableRooms = 0;
        /*RoomType rt = new RoomType();
        Iterator i = roomTypes.iterator();
        while ( i.hasNext() ) {
            rt = (RoomType)i.next();
            if ( roomType.equals( rt.getRoomType() ) )
                rtAvailableRooms = rt.getAvailableRooms();
        }
        */
        return rtAvailableRooms;
    }

    /**
     * Determina si en una fecha específica, habrá disponibilidad.
     * <p> Extrae de la lista, la ocupación esperada por dia y entonces
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
     */
    // TODO: Move "isAvailability" method to Reservation bean.
    private boolean isAvailability(Availability aq) {
        //int availableRooms = aq.getRoomTypeAvailability();
        int occupiedRooms = 0;
        int roomsFree = 0;
        int compArrival = -1;
        int compDeparture = 1;
        boolean dateIsAvailable = true;
        List<OccupationDay> list = null;

        AvailabilityDAO dao = new AvailabilityDAO();
        //dao.setAvailabilityQry(aq);
        String hotelId = String.valueOf( aq.getHotelId() );
        String roomType = aq.getRoomType();
        String startDate = String.valueOf( aq.getStartDate() );
        String endDate = String.valueOf( aq.getEndDate() );
        String status = aq.getStatus();
        try {
        list = dao.chargeOccupationOnStay(hotelId,roomType,startDate,endDate,status);
        } catch(Exception ex) { ex.printStackTrace(); }
        
        OccupationDay od = null;
        Iterator<OccupationDay> it = list.iterator();
        while ( it.hasNext() ) {
            od = (OccupationDay)it.next();
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

}
