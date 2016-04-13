package com.myco.central.form;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.beanutils.DynaBean;
import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionMapping;

import com.myco.central.vo.PaymentType;
import com.myco.central.vo.Reservation;
import com.myco.central.vo.ReservationStatus;
import com.myco.central.vo.Room;
import com.myco.central.vo.RoomType;

public class ReservationForm extends ActionForm {
	private static final long serialVersionUID = 1L;
	
	private Reservation item;
	
	private List<ReservationStatus> reservationStatusList;
	private List<RoomType> roomTypeList;
	private List<Room> roomNumberList;
	private List<PaymentType> paymentTypeList;

	public ReservationForm() {
		this.item = new Reservation();
	}
	
	public Reservation getItem() {
		return item;
	}

	public void setItem(Reservation item) {
		this.item = item;
	}
	
	public List<RoomType> getRoomTypeList() {
		return roomTypeList;
	}

	public void setRoomTypeList(List<RoomType> roomTypeList) {
		this.roomTypeList = roomTypeList;
	}

	public List<Room> getRoomNumberList() {
		return roomNumberList;
	}

	public void setRoomNumberList(List<Room> roomNumberList) {
		this.roomNumberList = roomNumberList;
	}

	public List<ReservationStatus> getReservationStatusList() {
		return reservationStatusList;
	}

	public void setReservationStatusList(
			List<ReservationStatus> reservationStatusList) {
		this.reservationStatusList = reservationStatusList;
	}

	public List<PaymentType> getPaymentTypeList() {
		return paymentTypeList;
	}

	public void setPaymentTypeList(List<PaymentType> paymentTypeList) {
		this.paymentTypeList = paymentTypeList;
	}

	/**
     * Validamos las propiedades que se han establecido para esta petición HTTP,
     * y devolvemos un objeto <code>ActionErrors</code> que encapsula cualquier
     * error de validación que encontremos. Si no se encuentran errores, devolvemos
     * <code>null</code> o un objeto <code>ActionErrors</code> sin mensajes de error.
     **/
    public ActionErrors validate(ActionMapping mapping, HttpServletRequest request) {
        ActionErrors errors = new ActionErrors();
        
        if ( getItem() == null ) {
            //errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("global.required", "email"));
            //errors.add("email", new ActionMessage("global.required") );
        }
        
        return errors;
    }
    
	public void reset(ActionMapping arg0, HttpServletRequest arg1) {
	}

}
