
package com.myco.central.lists;

import java.util.ArrayList;

import com.myco.central.vo.Reservation;

public class ReservationList extends ArrayList {

    public ReservationList() {
        super();
    }

    public Reservation getReservation(int i){
        return( (Reservation)get(i) );
    }
    
}