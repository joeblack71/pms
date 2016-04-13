/*
 * Reservation.java
 *
 * Created on December 18, 2006, 21:30 PM
 */

package com.mycom.booking.beans;

import java.sql.Date;
import java.util.Hashtable;
import java.util.Calendar;
import java.text.*;

import com.mycom.booking.beans.*;
import com.mycom.booking.controllers.CompanyCtlr;
import com.mycom.booking.controllers.RoomCtlr;
import com.mycom.booking.controllers.RoomTypeCtlr;
import com.mycom.booking.controllers.SpecialRateCtlr;
import com.mycom.booking.events.ReservationDataException;
import com.mycom.booking.libraries.DateManager;


/**
 *
 * @author  Johnny Olivas
 * @version
 */
public class Reservation {

    private short  hotelId;
    private int    reservation;
    private Date   arrival;
    private Date   departure;
    private short  nights;
    private short  adults;
    private short  children;
    private String roomType;
    private String packageCode;
    private short  quantity;
    private String roomNumber;
    private short  sourceId;
    private String sourceName;
    private float  roomRate;
    private float  total;
    private Date   paymentDue;
    private short  paymentType;
    private Hashtable guests; // testing
    private String instructions;
    private String madeBy;
    private String madeOn;
    private String updatedBy;
    private String updatedOn;
    private String status;

    private String lastname1;
    private String lastname2;
    private String firstname;
    private String middleName;
    /*  private String documentTypeGuest;
      private String documentNumberGuest;
    */

    /** Creates new Reservation */
    public Reservation() {
        String SPACES = "";

        this.nights      = 1;
        this.adults      = 1;
        this.quantity    = 1;
        this.status      = SPACES;
        this.sourceId    = 10000;
        this.sourceName  = SPACES;
        this.roomType    = SPACES;
        this.packageCode = SPACES;
        this.roomNumber  = SPACES;
        this.guests      = new Hashtable();
    }

    /** Hotel Destination **/
    public short getHotelId() {
        return hotelId;
    }
    public void setHotelId(short hotelId) {
        this.hotelId = hotelId;
    }

    /** Reservation number **/
    public int getReservation() {
        return reservation;
    }
    public void setReservation(String reservation) throws ReservationDataException {
        if ( reservation.equals("") )
            throw new ReservationDataException("Reservation number is blank !!.");
        this.reservation = Integer.parseInt(reservation);
    }

    /** Arrival Date **/
    public Date getArrival() {
        return arrival;
    }

    public String getFormattedArrival() {
        return DateManager.sqlDateToString(arrival);
    }

    public void setArrival(String arrival) throws ReservationDataException {
        if ( arrival.equals("") )
            throw new ReservationDataException("Arrival can not be empty.");
        Date newArrival = DateManager.sqlDateValueOf(arrival);
        if ( newArrival == null )
            throw new ReservationDataException("Invalid date format.");
        if ( this.departure != null && newArrival.after(this.departure) )
            throw new ReservationDataException("Arrival can not be after departure.");
        
        if ( this.reservation == 0 ) // New reservation
            this.arrival = newArrival;
        else {                       // Update reservation
            if ( !this.arrival.equals(newArrival) ) {
                this.arrival = newArrival;
                nightsUpdate();
            }
        }
    }

    public void setArrival(Date arrival) {
        this.arrival = arrival;
    }

    /** Departure Date **/
    public Date getDeparture() {
        return departure;
    }

    public String getFormattedDeparture() {
        return DateManager.sqlDateToString(departure);
    }

    public void setDeparture(String departure) throws ReservationDataException {
        if ( departure.equals("") )
            throw new ReservationDataException("Departure can not be empty.");
        Date newDeparture = DateManager.sqlDateValueOf(departure);
        if ( newDeparture == null )
            throw new ReservationDataException("Invalid date format.");
        if ( newDeparture.before(this.arrival) )
            throw new ReservationDataException("Departure can not be before arrival.");
        // New reservation or departure date changed.
        if ( this.reservation == 0 || !this.departure.equals(newDeparture) ) {
            this.departure = newDeparture;
            nightsUpdate();
        }
    }

    public void setDeparture(Date departure) {
        this.departure = departure;
    }

    private void nightsUpdate() {
        Calendar cal = Calendar.getInstance();
        long millis = this.departure.getTime() - this.arrival.getTime();
        this.nights = (short)(millis / 1000 / 60 / 60 / 24);
    }

    /** Stayed Nights **/
    public short getNights() {
        return nights;
    }
    
    public void setNights(short nights) {
        //TODO: Calculate nights
        this.nights = nights;
    }

    public void setNights(String nights) throws ReservationDataException {
        if ( nights.equals("") ) nights = "0";
        short newNights = Short.parseShort(nights);
        if ( this.nights != newNights )
            departureUpdate(newNights);
        this.nights = newNights;
        if ( this.roomRate != 0 ) setTotal();
    }

    private void departureUpdate(short n) {
        Calendar cal = Calendar.getInstance();
        cal.setTimeInMillis( this.getArrival().getTime() );
        cal.add(Calendar.DAY_OF_MONTH,n);
        this.departure = new Date( cal.getTimeInMillis() );
    }
    
    /** Room's Adults **/
    public short getAdults() {
        return adults;
    }

    public void setAdults(String adults) throws ReservationDataException {
        short gs = (short)this.guests.size();
        if ( this.guests == null ||  gs <= 0)
            throw new ReservationDataException("There are not registered guests. ");
        short newAdults;
        if ( adults.equals("") )
             newAdults = gs;
        else newAdults = Short.parseShort(adults);
        if ( newAdults < gs ) this.adults = gs;
    }

    public void setAdults(short adults) {
        this.adults = adults;
    }

    /** Room's Children **/
    public short getChildren() {
        return children;
    }

    public void setChildren(String children) throws ReservationDataException {
        if ( children.equals("") )
             this.children = 0;
        else this.children = Short.parseShort(children);
    }

    public void setChildren(short children) {
        this.children = children;
    }

    /** Room Type **/
    public String getRoomType() {
        return roomType;
    }
    public void setRoomType(String roomType) {
        String oldRoomType = this.roomType;
        //TODO: review
        //if ( !this.roomType.equals(oldRoomType) )
        //    setRoomRate( getSpecialRate(hotelId,roomType) );
        this.roomType = roomType;
    }

    /** Package code **/
    public String getPackageCode() {
        return packageCode;
    }
    public void setPackageCode(String packageCode) {
        this.packageCode = packageCode;
    }

    /** Rooms Quantity **/
    public short getQuantity() {
        return quantity;
    }
    public void setQuantity(short quantity){
        this.quantity = quantity;
    }

    public void setQuantity(String quantity) throws ReservationDataException {
        short q = Short.parseShort(quantity);
        if ( q == 0 ) throw new ReservationDataException("Invalid rooms quantity.");
        this.quantity = q;
    }

    /** Room Number **/
    public String getRoomNumber() {
        return roomNumber;
    }

    public void setRoomNumber(String roomNumber) {
        this.roomNumber = roomNumber;
    }

    /**
     * Validate and set the room number
     */
    public void valRoomNumber(String roomNumber) throws ReservationDataException {
        // TODO: validate the room number against ddbb table !!
        short r = Short.parseShort(roomNumber);
        if ( r < 0 || r > 9999 )
            throw new ReservationDataException("Invalid room number !!");
        if ( r >= 100 && r < 1000 && roomNumber.length() < 4 )
            roomNumber = "0" + roomNumber;
        this.roomNumber = roomNumber;
    }

    /** Sorce of Bussiness **/
    public short getSourceId() {
        return sourceId;
    }
    
    public void setSourceId(String sourceId) throws ReservationDataException {
        if ( sourceId.equals("") )
            throw new ReservationDataException("SourceId can not be empty.");
        this.sourceId = Short.parseShort(sourceId);
    }

    public void setSourceId(short sourceId) {
        this.sourceId = sourceId;
    }

    public String getSourceName() {
        return this.sourceName;
    }

    public void setSourceName(String sourceName) {
        this.sourceName = sourceName;
    }

    /** Room Rate **/
    public float getRoomRate() {
        return roomRate;
    }

    public void setRoomRate(String roomRate) throws ReservationDataException {
        NumberFormat nf = NumberFormat.getCurrencyInstance(java.util.Locale.US);
        String fs = roomRate.replace(',','.');
        float rr = 0.0f;
        try {
            if ( fs.contains("$") ) {
                rr = nf.parse(fs).floatValue();
            } else {
                if ( !fs.equals("") ) {
                    rr = Float.parseFloat(fs);
                }
            }
            if ( rr == 0.0f )
                rr = getAssignedRate();
            this.roomRate = rr;
            setTotal();
        } catch (ParseException ex) { 
            System.out.println(roomRate + " - Room rate value is wrong !!");
        }
    }

    public void setRoomRate(float roomRate) {
        this.roomRate = roomRate;
    }

    private float getAssignedRate() {
        float ar = 0.0f;
        if ( sourceId == 0 || sourceId == 10000 ) {// 10000 -> PARTICULAR
            if ( roomNumber.equals("") )
                ar = getRoomTypeRate();
            else
                ar = getRoomRackRate();
        } else {
            ar = getSourceRate();
            if ( ar == 0.0f )
                ar = getRoomTypeRate();
        }
        return ar;
    }
    
    private float getRoomTypeRate() {
        RoomType rt = new RoomType();
        rt.setHotelId(this.hotelId);
        rt.setRoomType(this.roomType);
        RoomTypeCtlr rtc = new RoomTypeCtlr();
        rtc.search(rt);
        return rt.getRackRate();
    }
    
    private float getRoomRackRate() {
        Room r = new Room();
        r.setHotelId(this.hotelId);
        r.setRoomType(this.roomType);
        r.setRoomNumber(this.roomNumber);
        RoomCtlr rc = new RoomCtlr();
        rc.search(r);
        return r.getRoomRate();
    }

    private float getSourceRate() {
        RoomRate rr = new RoomRate();
        rr.setHotelId( this.hotelId );
        rr.setRoomType(this.roomType);
        rr.setRateId( this.sourceId );
        SpecialRateCtlr rrc = new SpecialRateCtlr();
        rrc.search(rr);
        return rr.getEowHighSeasonRate();
    }

    /** Room Total Stayed **/
    public float getTotal() {
        return total;
    }

    public void setTotal() {
        this.total = roomRate * nights * quantity;
    }

    public void setTotal(float total) {
        this.total = total;
    }

    public Date getPaymentDue() {
        return paymentDue;
    }

    public void setPaymentDue(String paymentDue) {
        this.paymentDue = DateManager.sqlDateValueOf(paymentDue);
    }

    public void setPaymentDue(Date paymentDue) {
        this.paymentDue = paymentDue;
    }

    public short getPaymentType() {
        return paymentType;
    }

    public void setPaymentType(String paymentType) {
        this.paymentType = Short.parseShort(paymentType);
    }

    public void setPaymentType(short paymentType) {
        this.paymentType = paymentType;
    }

    public String getInstructions() {
        return instructions;
    }
    public void setInstructions(String instructions) {
        this.instructions = instructions;
    }

    public String getMadeBy() {
        return madeBy;
    }
    public void setMadeBy(String madeBy) {
        this.madeBy = madeBy;
    }

    /** Return date when reservation was 'made'
     */
    public String getMadeOn() {
        return madeOn;
    }
    public void setMadeOn(String madeOn) {
        this.madeOn = madeOn;
    }

    public String getUpdatedBy() {
        return updatedBy;
    }
    public void setUpdatedBy(String updatedBy) {
        this.updatedBy = updatedBy;
    }

    /** Return date when reservation was 'updated'
     */
    public String getUpdatedOn() {
        return updatedOn;
    }
    public void setUpdatedOn(String updatedOn) {
        this.updatedOn = updatedOn;
    }

    public Hashtable getGuests() {
        return this.guests;
    }

    public void setGuests(Hashtable guests) {
        this.guests = guests;
    }

    /** Reservation Status**/
    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getFirstname() {
        return firstname;
    }
    
    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getMiddlename() {
        return middleName;
    }
    
    public void setMiddlename(String middleName) {
        this.middleName = middleName;
    }

    public String getLastname1() {
        return lastname1;
    }
    
    public void setLastname1(String lastname1) {
        this.lastname1 = lastname1;
    }

    public String getLastname2() {
        return lastname2;
    }
    
    public void setLastname2(String lastname2) {
        this.lastname2 = lastname2;
    }

    /*public String getDocumentTypeGuest() {
        return documentTypeGuest;
    }
    
    public void setDocumentTypeGuest(String documentTypeGuest) {
        this.documentTypeGuest = documentTypeGuest;
    }

    public String getDocumentNumberGuest() {
        return documentNumberGuest;
    }
    
    public void setDocumentNumberGuest(String documentNumberGuest) {
        this.documentNumberGuest = documentNumberGuest;
    }
     */

    // TODO: Create a class for send messages. Use inheritence
    private void isEmpty(String field) throws ReservationDataException {
        if ( field.equals("") )
             throw new ReservationDataException("Field is empty");
    }

}
