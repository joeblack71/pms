DELIMITER $$

DROP PROCEDURE IF EXISTS `hotel`.`CMSP_RESERVATION_UPDATE`$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `CMSP_RESERVATION_UPDATE`(
						IN p_idHotel tinyint(01),
						IN p_idReservation smallint(05),
						IN p_arrival varchar(10),
						IN p_departure varchar(10),
						IN p_nights varchar(03),
						IN p_adults varchar(02),
						IN p_children varchar(02),
						IN p_roomType varchar(02),
						IN p_quantityRooms varchar(02),
						IN p_roomNumber varchar(04),
						IN p_idSource varchar(06),
						IN p_roomRate decimal(10,2),
						IN p_totalRoom decimal(10,2),
						IN p_paymentDue varchar(10),
						IN p_paymentType varchar(02),
						IN p_resStatus varchar(01),
						IN p_hotelInstructions varchar(120),
						IN p_guestInstructions varchar(120),
						IN p_updateBy varchar(03) )
BEGIN
        UPDATE reservation
		   SET	RESVC_ARRIVAL      = STR_TO_DATE(p_arrival,'%d/%m/%Y'),
				RESVC_DEPARTURE    = STR_TO_DATE(p_departure,'%d/%m/%Y'),
				RESVC_NIGHTS       = p_nights,
				RESVC_ADULTS       = p_adults,
				RESVC_CHILDREN     = p_children,
				RESVF_ID_ROOMTYPE  = p_roomType,
				RESVC_QUANTITY     = p_quantityRooms,
				RESVF_ID_ROOM      = p_roomNumber,
				RESVF_ID_SOURCE    = p_idSource,
				RESVC_ROOM_RATE    = p_roomRate,
				RESVC_TOTAL_ROOM   = p_totalRoom,
				RESVC_PAYMENT_DUE  = STR_TO_DATE(p_paymentDue,'%d/%m/%Y'),
				RESVF_PAYMENT_TYPE = p_paymentType,
				RESVC_STATUS       = p_resStatus,
				RESVC_HOTEL_INSTRUCTIONS = p_hotelInstructions,
				RESVC_GUEST_INSTRUCTIONS = p_guestInstructions,
				RESVC_UPDATED_BY   = p_updateBy,
				RESVC_LAST_UPDATE  = CURDATE()
		 WHERE RESVP_ID_HOTEL = p_idHotel
		   AND RESVP_ID_RESERVATION = p_idReservation;
END$$

DELIMITER ;