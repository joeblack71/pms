
package com.myco.central.reservations.service.impl;

import java.util.Calendar;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.myco.central.commons.exceptions.DaoException;
import com.myco.central.commons.exceptions.ServiceException;
import com.myco.central.commons.service.impl.GenericServiceImpl;
import com.myco.central.constants.CentralModuleConstants;
import com.myco.central.reservations.dao.OccupationDao;
import com.myco.central.reservations.dao.RoomTypeDao;
import com.myco.central.reservations.domain.OccupationDay;
import com.myco.central.reservations.domain.RoomType;
import com.myco.central.reservations.service.OccupationService;
import com.myco.central.util.AppConstants;
import com.myco.central.util.DateUtils;

public class OccupationServiceImpl extends GenericServiceImpl implements OccupationService {
	
	Log log = LogFactory.getLog(OccupationServiceImpl.class);
	
	@SuppressWarnings("unused")
	private RoomTypeDao roomTypeDao;

	private OccupationDao occupationDao;

	public OccupationServiceImpl() {}

    public List<OccupationDay> chargeOccupationByType(Map<String, Object> params)
		throws Exception {
    	List<OccupationDay> list = null;

    	try {
    		occupationDao.chargeOccupationByType(params);
        } catch (Exception e){ e.printStackTrace(); }
        
        return list;
    }

    //TODO enviar parametros a traves de Availability
    public List<OccupationDay> chargeOccupationOnStay(Map<String, Object> params)
    	throws Exception {
    	List<OccupationDay> list = null;
        
        try {
        	occupationDao.chargeOccupationOnStay(params);
        
        } catch (Exception e) { e.printStackTrace(); }
        
        return list;
    }

	public List<Map<String, Object>> flashStatus(Map<String, Object> params) throws ServiceException {
		List<Map<String, Object>> list = null;

		try {
			list = occupationDao.getFlashStatus(params);
			
		} catch (DaoException ex) {
			log.error("Error en Availability service", ex);
		}

		return list;
	}

    public String[][] getOccupation(Map<String, Object> params) {
        List<OccupationDay> list = null;
        List<RoomType> roomTypes = null;
        
		Date[] daysOcc = null;
        String[][] availability = null;
        
		int[] totalDayOcc = null;
        int[][] roomsOcc = null;
        
        Calendar cal = Calendar.getInstance();
        
        Date sqlStartDate = null;

		try {
        	roomTypes = roomTypeDao.select(params);

    		daysOcc = DateUtils.getPeriodDays((String) params.get("Period"));
    		
            totalDayOcc = new int[daysOcc.length + 1];
            
            roomsOcc = new int[roomTypes.size()][daysOcc.length + 1];
            
            availability = new String[roomTypes.size() + 2][daysOcc.length + 2];
            
            sqlStartDate = DateUtils.sqlDateValueOf((String) params.get("StartDate"));

            params.put("EndDate", ( DateUtils.addDaysToDate((String) params.get("StartDate"),
            		Short.parseShort((String) params.get("Period")) ) ) );

            list = occupationDao.chargeOccupationByType(params);

            params.put("EndDate", ( DateUtils.addDaysToDate((String) params.get("StartDate"),
            		Short.parseShort((String) params.get("Period")) ) ) );


            cal.setTimeInMillis( sqlStartDate.getTime() );

            for ( int i=0; i < daysOcc.length; i++ ) { // Charges header
	            daysOcc[i] = new java.sql.Date( cal.getTimeInMillis() );
	            cal.add(Calendar.DAY_OF_MONTH, 1);
	        }

	        chargeRoomsByDays(list, daysOcc, roomsOcc, totalDayOcc, roomTypes);
	        
	        for ( int i=0; i < roomsOcc.length; i++ ) { // Totalize types
	            for ( int j=0; j < roomsOcc[0].length - 1; j++ ) 
	                roomsOcc[i][roomsOcc[0].length - 1] += roomsOcc[i][j];
	        }
	        
	        for ( int i=0; i < totalDayOcc.length - 1; i++ ) // Totalize days
	            totalDayOcc[totalDayOcc.length - 1] += totalDayOcc[i];
	        
	        availability = chargeAvailabilityMatrix(daysOcc, availability,
	        		roomTypes, roomsOcc, totalDayOcc);
		} catch (Exception ex) {
			ex.printStackTrace();
		}
        
		return availability;
     }

    public void chargeRoomsByDays(List<OccupationDay> list,
    		Date[] daysOcc, int[][] roomsOcc, int[] totalDayOcc,
    		List<RoomType> roomTypes) {
        
    	Iterator<OccupationDay> days = list.iterator();
        
        OccupationDay od = new OccupationDay();
        
        while ( days.hasNext() ) {
            od = days.next();
            for ( int i=0; i < roomTypes.size(); i++ ) { // Iterates types
                if ( (roomTypes.get(i)).getRoomType().equals( od.getRoomType() ) ) {
                    for( int j=0; j < daysOcc.length; j++ ) { // Iterates dates
                        if ( daysOcc[j].equals( od.getOccupiedDay() ) ) {
                            roomsOcc[i][j] = od.getOccupiedRooms();
                            totalDayOcc[j] += od.getOccupiedRooms(); // Acumulates totals
                            break;
                        }
                    }
                    break;
                }
            }
        }
    }

    /**
     * @param daysOcc 
     */
    public String[][] chargeAvailabilityMatrix(Date[] daysOcc,
    		String[][] availability, List<RoomType> roomTypes, int[][] roomsOcc,
    		int[] totalDayOcc) {
    	
        for ( int i=1,j=0; j < daysOcc.length; i++, j++) // Charges occupation dates
            availability[0][i] = DateUtils.sqlDateToString( daysOcc[j].getTime() );

//        for ( int i=1,j=0; j < roomTypes.size(); i++, j++ ) // Charges room types
//            availability[i][0] = roomTypes.search(j).getRoomType();

        for ( int i=1,k=0; k < roomsOcc.length; i++,k++ ) { // Charges occupied rooms
            for ( int j=1,l=0; l < roomsOcc[0].length; j++,l++ )
                availability[i][j] = String.valueOf( roomsOcc[k][l] );
        }

        for ( int i=1,j=0; j < totalDayOcc.length; i++,j++ ) // Charges total occupied rooms
            availability[availability.length - 1][i] = String.valueOf( totalDayOcc[j] );
        
        return availability;
    }

	/* 
	 * Dependencies Injection 
	 */

    public void setRoomTypeDao(RoomTypeDao roomTypeDao) {
		this.roomTypeDao = roomTypeDao;
	}

	public void setOccupationDao(OccupationDao occupationDao) {
		this.occupationDao = occupationDao;
	}

}