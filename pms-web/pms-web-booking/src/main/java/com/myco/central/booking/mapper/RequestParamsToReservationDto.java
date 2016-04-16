package com.myco.central.web.booking.mapper;

import java.text.ParseException;

import javax.servlet.http.HttpServletRequest;

import com.myco.central.booking.dto.ReservationDto;
import com.myco.central.commons.utils.DateUtils;

public class RequestParamsToReservationDto {

	public void mapRequestParamsToReservationDto(HttpServletRequest request, ReservationDto reservation)
			throws ParseException {
		reservation.setArrival(DateUtils.parseDate(request.getParameter("arrival")));
		reservation.setDeparture(DateUtils.parseDate(request.getParameter("departure")));
		reservation.setAdults(request.getParameter("adults"));
		reservation.setRoomType(request.getParameter("roomType"));
		reservation.setSourceId(request.getParameter("sourceId"));
		reservation.setQuantity(request.getParameter("quantity"));
	}

}
