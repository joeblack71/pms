/**
 *
 */
package com.myco.central.web.booking.controller;

import java.text.SimpleDateFormat;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.ModelAndView;

import com.myco.central.booking.dto.AvailabilityFilterDto;
import com.myco.central.booking.service.BookingService;
import com.myco.central.web.booking.mapper.RequestParamsToAvailabilityFilter;
import com.myco.central.web.controller.GenericController;

/**
 * @author Devel
 *
 */
public class OccupationController extends GenericController {
	private static final Log LOGGER = LogFactory.getLog(OccupationController.class);
	private static final SimpleDateFormat SDF = new SimpleDateFormat("yyyy-MM-dd");

	@Autowired
	private BookingService service;

    public ModelAndView checkAvailability(HttpServletRequest request,
            HttpServletResponse response) throws Exception {
		ModelAndView mav = new ModelAndView("");

		RequestParamsToAvailabilityFilter mapper = new RequestParamsToAvailabilityFilter();
		AvailabilityFilterDto filterDto = new AvailabilityFilterDto();
		mapper.mapRequestParamsToFilter(request, filterDto);

		if (!service.checkRoomAvailability(filterDto)) {
			showNoAvailableRoomsMessage();
		}

		return mav;
	}

	private void showNoAvailableRoomsMessage() {
		// TODO Auto-generated method stub
	}

}
