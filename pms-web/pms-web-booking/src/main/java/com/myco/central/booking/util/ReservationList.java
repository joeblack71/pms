
package com.mycom.booking.lists;

import java.util.ArrayList;

import com.mycom.booking.beans.Reservation;


public class ReservationList extends ArrayList {

    public ReservationList() {
        super();
    }

    public Reservation getReservation(int i){
        return( (Reservation)get(i) );
    }
    
}