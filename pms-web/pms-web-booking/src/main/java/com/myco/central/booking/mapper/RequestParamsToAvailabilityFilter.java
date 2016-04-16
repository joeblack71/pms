package com.myco.central.web.booking.mapper;

import java.text.ParseException;

import javax.servlet.http.HttpServletRequest;

import com.myco.central.booking.dto.AvailabilityFilterDto;
import com.myco.central.commons.utils.DateUtils;

public class RequestParamsToAvailabilityFilter {

	public void mapRequestParamsToFilter(HttpServletRequest request, AvailabilityFilterDto filterDto)
			throws ParseException {
		filterDto.setHotelId(Long.valueOf(request.getParameter("hotelId")));
		filterDto.setStartDate(DateUtils.parseDate(request.getParameter("arrival")));
		filterDto.setEndDate(DateUtils.parseDate(request.getParameter("departure")));
		filterDto.setRoomType(request.getParameter("roomType"));
	}

}
