/**
 * 
 */
package com.myco.central.reservations.web.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;

import com.myco.central.reservations.domain.Reservation;

/**
 * @author Devel
 *
 */
public class OccupationController extends GenericController {

	/* (non-Javadoc)
	 * @see com.myco.central.reservations.service.OccupationManager#verifyAvailability(java.util.Map)
	 */
	public ModelAndView checkAvailability(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		ModelAndView modelAndView = new ModelAndView("");

		Reservation reservation = new Reservation();
		
		String oldArrival   = (String) request.getAttribute("arrival");
        String oldDeparture = (String) request.getAttribute("departure");
        String oldRoomType  = (String) request.getAttribute("roomType");
        String oldQuantity  = (String) request.getAttribute("quantity");

        boolean validFieldValues = true;
        boolean needAvailabilityCheck = true;
        boolean availableRooms = true;
        
            reservation.setArrival( request.getParameter("arrival") );
            reservation.setDeparture( request.getParameter("departure") );
            reservation.setAdults( request.getParameter("adults") );
            reservation.setRoomType( request.getParameter("roomType") );
            reservation.setIdSource( request.getParameter("sourceId") );
            reservation.setQuantity( request.getParameter("quantity") );
            
            if ( oldArrival != null && oldDeparture != null ) 
            {
                if ( oldArrival.equals( reservation.getArrival() ) 
                		&& oldDeparture.equals( reservation.getDeparture() ) 
                		&& oldRoomType.equals( reservation.getRoomType() ) 
                		&& oldQuantity == reservation.getQuantity() )
                {
                    needAvailabilityCheck = false;
                }
            }
        
//        if ( validFieldValues && needAvailabilityCheck ) {
//            AvailabilityQry aq = new AvailabilityQry();
//            
//            aq.setHotelId( reservation.getHotelId() );
//            aq.setStartDate( reservation.getArrival() );
//            aq.setEndDate( reservation.getDeparture() );
//            aq.setRoomType( reservation.getRoomType() );
//            aq.setQuantity( reservation.getQuantity() );
//            aq.setOldArrival(oldArrival);
//            aq.setOldDeparture(oldDeparture);
//            aq.setReservationRooms( reservation.getQuantity() );
//            aq.setRoomTypeAvailability( getRoomTypeRooms( reservation.getRoomType() ) );
//            
//            AvailabilityCtlr avctlr = new AvailabilityCtlr();
//            availableRooms = avctlr.isAvailability(aq);
//        }

        if ( !validFieldValues ) {
            System.out.println("\nField values are wrong.\n");
        }
        
        if ( !availableRooms ) {
            System.out.println("\nThere are not available rooms.\n");
        }
        
        return null;
	}

}
