package com.myco.central.web.ui.client;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import com.myco.central.booking.dto.OccupationByTypeDto;
import com.myco.central.commons.utils.DateUtils;
import com.myco.central.model.BaseAuditable;
import com.myco.central.model.RoomType;

public class AvailabilityView {
	
	public String[][] chargeAvailabilityMatrix(LocalDate[] daysOcc,
			String[][] availability, List<RoomType> roomTypes, int[][] roomsOcc,
			int[] totalDayOcc) {

		for ( int i=1,j=0; j < daysOcc.length; i++, j++) // Charges occupation dates
			availability[0][i] = DateUtils.formatDate(daysOcc[j]);

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

	public void chargeRoomsByDays(List<OccupationByTypeDto> list, LocalDate[] daysOcc, int[][] roomsOcc,
			int[] totalDayOcc,
			List<RoomType> roomTypes) {

		List<OccupationByTypeDto> days = new ArrayList<>(list);

		for (OccupationByTypeDto od : days) {
			for (BaseAuditable roomType : roomTypes) {
				if (roomType.equals(od.getRoomType())) {
					chargeOccupationDay(daysOcc, roomsOcc, totalDayOcc, od);
					break;
				}
			}
		}
	}

	private void chargeOccupationDay(LocalDate[] daysOcc, int[][] roomsOcc, int[] totalDayOcc, OccupationByTypeDto od) {
		for( int j=0; j < daysOcc.length; j++ ) { // Iterates dates
			//TODO refactor
/*			if ( daysOcc[j].equals( od.getOccupiedDay() ) ) {
				roomsOcc[i][j] = od.getOccupiedRooms(); // TODO fix uncomment
				totalDayOcc[j] += od.getOccupiedRooms(); // Acumulates totals
				break;
			}
*/		}
	}

}
