DELIMITER $$

DROP PROCEDURE IF EXISTS `hotel`.`CMSP_RESERVATION_GET`$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `CMSP_RESERVATION_GET`(
			IN p_idHotel varchar(01),
			IN p_idReservation varchar(06) )
BEGIN
	SELECT RESVP_ID_HOTEL		idHotel,
		RESVP_ID_RESERVATION	idNumber,
		RESVC_RESERVATION_TYPE	reservationType,
		DATE_FORMAT(RESVC_ARRIVAL,'%d/%m/%Y')
								arrival,
		DATE_FORMAT(RESVC_DEPARTURE,'%d/%m/%Y')
								departure,
		RESVC_NIGHTS 			nights,
		RESVC_ADULTS 			adults,
		RESVC_CHILDREN 			children,
		RESVF_ID_ROOMTYPE 		roomType,
		RESVC_QUANTITY 			roomsQuantity,
		RESVF_ID_ROOM		 	roomNumber,
		RESVC_VIP_CODE 			vipCode,
		RESVF_ID_SOURCE			idSource,
		RESVC_ROOM_RATE 		roomRate,
		RESVC_TOTAL_ROOM 		totalStay , /* Total a pagar x alojamiento */
		case when DATE_FORMAT(RESVC_PAYMENT_DUE,'%d/%m/%Y') = 0 then '' else RESVC_PAYMENT_DUE end
								paymentDue,
		RESVF_PAYMENT_TYPE		paymentType,
		RESVC_VOUCHER			voucherNumber,
		RESVC_HOTEL_INSTRUCTIONS	hotelInstructions,
		RESVC_GUEST_INSTRUCTIONS	guestInstructions,
		RESVC_MADE_BY				madeBy,
		DATE_FORMAT(RESVC_MADE_ON,'%d/%m/%Y')
								madeOn,
		RESVC_UPDATED_BY 		updateBy,
		DATE_FORMAT(RESVC_LAST_UPDATE,'%d/%m/%Y')
								lastUpdate,
		RESVC_STATUS			reservationStatus
	  FROM reservation
	 WHERE RESVP_ID_HOTEL = p_idHotel
	   AND RESVP_ID_RESERVATION = p_idReservation;
    END$$

DELIMITER ;