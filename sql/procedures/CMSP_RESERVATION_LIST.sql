DELIMITER $$

DROP PROCEDURE IF EXISTS `hotel`.`CMSP_RESERVATION_LIST`$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `CMSP_RESERVATION_LIST`(
					IN idHotel INT, IN param VARCHAR(255) )
BEGIN
	SELECT 	r.nIdHotel          idHotel,
			r.nIdReservation    idReservation,
			tReservationType    reservationTYpe,
			DATE_FORMAT(dArrival,'%d/%m/%Y')
								arrival,
			DATE_FORMAT(dDeparture,'%d/%m/%Y')
								departure,
			nNights             nights,
			nAdults             adults,
			nChildren           children,
			rt.tDescription     roomType,
			nQuantity           quantity,
			nIdRoom             roomNumber,
			tVipCode            vipCode,
			nIdSource           idSource,
			nRoomRate           roomRate,
			nTotalRoom          totalRoom,
			DATE_FORMAT(dPaymentDue,'%d/%m/%Y')
								paymentDue,
			nPaymentType        paymentType,
			tVoucher            voucher,
			tHotelInstructions  hotelInstructions,
			tGuestInstructions  guestInstructions,
			r.tMadeBy             madeBy,
			DATE_FORMAT(r.dMadeOn,'%d/%m/%Y')
								madeOn,
			tUpdatedBy          updateBy,
			DATE_FORMAT(dLastUpdate,'%d/%m/%Y')
								lastUpdate,
			r.tStatus             status
       FROM reservation r
            LEFT JOIN roomtype rt
                   ON r.nIdRoomType = rt.nIdRoomType
			LEFT JOIN reservation_guest  g
				   ON r.nIdHotel = g.nIdHotel
				  AND r.nIdReservation = g.nIdReservation
			LEFT JOIN customer  c
				   ON g.nIdHotel = c.nHotelRegistration
				  AND g.nIdCustomer = c.nIdCustomer
	 WHERE r.nIdHotel = idHotel AND c.tLastName1 LIKE concat(param,'%')
	 ORDER BY r.nIdReservation;
END$$

DELIMITER ;