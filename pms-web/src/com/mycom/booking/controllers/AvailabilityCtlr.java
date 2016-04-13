
package com.mycom.booking.controllers;

import java.sql.*;
import java.util.ArrayList;
import java.util.Iterator;

import com.mycom.booking.beans.AvailabilityQry;
import com.mycom.booking.beans.OccupationDay;
import com.mycom.booking.dispatchers.AvailabilityDisp;
import com.mycom.booking.dispatchers.ConProvider;
import com.mycom.booking.lists.OccupationByDays;


/**
 * Control de disponibilidad de habitaciones
 * 
 */
public class AvailabilityCtlr {

    private static AvailabilityQry aq;
    private static OccupationByDays obd;
    
    /**
     * Creates new AvailabilityCtlr
     */
    public AvailabilityCtlr() {}

    public void setAvailabilityQry(AvailabilityQry aq) {
        this.aq = aq;
    }
    
    public void setOccupationList(OccupationByDays obd) {
        this.obd = obd;
    }
    
    /**
     * Carga una lista con la ocupacion esperada para un periodo
     * determinado. Esta informacion es utilizada en la preparacion
     * de los cuadros de ocupacion y disponibilidad.
     * @param aq es un objeto <B>AvailabilityQry</B>, cuyos atributos se utilizan
     * para consulta en BB.DD.
     */
    public static void chargeOccupationByType(AvailabilityQry aq) {
        Connection c = ConProvider.getConnection();
        AvailabilityDisp da = new AvailabilityDisp();
        da.setConnection(c);
        da.setAvailabilityQry(aq);
        da.chargeOccupationByType(obd);
        try { c.close();
        } catch (Exception e) {}
    }

    /**
     * Determina si en una fecha específica, habrá disponibilidad.
     * <p> Extrae de la lista, la ocupación esperada por dia y entonces
     * calcula el numero de habitaciones libres para la venta.
     * 
     * <p>Si en alguno de los dias comprendidos por la reserva el numero
     * de habitaciones libres es menor que el requerido por la reserva,
     * el proceso se termina.
     * @param aq es un objeto <CODE>AvailabilityQry</CODE> cuyos atributos son utilizados
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
    public static boolean isAvailability(AvailabilityQry aq) {
        //int availableRooms = aq.getRoomTypeAvailability();
        int occupiedRooms = 0;
        int roomsFree = 0;
        int compArrival = -1;
        int compDeparture = 1;
        boolean dateIsAvailable = true;

        chargeOccupationOnStay(aq);
        OccupationDay od = null;
        Iterator it = obd.iterator();
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

    /**
     * Carga una lista con la ocupacion esperada para cada dia
     * comprendido entre la fecha de llegada y salida de una reserva.
     * 
     * @param aq Este objeto, contiene informacion utilizada en la consulta de
     * disponibilidad de habitaciones. La informacion contenida en este
     * caso es la sgte.: startDate, endDate, quantity, roomType, etc.
     */
    public static void chargeOccupationOnStay(AvailabilityQry aq) {
        Connection c = ConProvider.getConnection();
        AvailabilityDisp da = new AvailabilityDisp();
        da.setConnection(c);
        da.setAvailabilityQry(aq);
        //obd = new OccupationByDays();
        da.chargeOccupationOnStay(obd);
        try { c.close();
        } catch (Exception e) {}
    }

}
