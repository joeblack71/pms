package com.myco.central.reservations.web.form;

import java.util.List;

import com.myco.central.reservations.domain.Reservation;
import com.myco.central.reservations.web.vo.ReservationFilter;

public class ReservationListForm {
	private static final long serialVersionUID = 1L;
	
	private ReservationFilter filter;
	private List<Reservation> reservations;

	public ReservationListForm() {
		this.filter = new ReservationFilter();
	}
	
	public ReservationFilter getFilter() {
		return filter;
	}

	public void setFilter(ReservationFilter filter) {
		this.filter = filter;
	}

	public List<Reservation> getReservations() {
		return reservations;
	}

	public void setReservations(List<Reservation> reservations) {
		this.reservations = reservations;
	}

	//@Override
	/*public void reset(ActionMapping arg0, HttpServletRequest arg1) {
		/*this.field = null;
		this.pattern = null;
	}*/

	//@Override
	/*public ActionErrors validate(ActionMapping arg0, HttpServletRequest arg1) {
	        ActionErrors errors = new ActionErrors();
	        
	        if ( getIdHotel() == null ) {
	            //errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("global.required", "email"));
	            //errors.add("email", new ActionMessage("global.required") );
	        }
	        
	        return errors;
	}*/

}
