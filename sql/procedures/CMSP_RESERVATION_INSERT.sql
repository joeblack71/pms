DELIMITER $$

DROP PROCEDURE IF EXISTS `hotel`.`CMSP_RESERVATION_INSERT`$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `CMSP_RESERVATION_INSERT`(
						OUT reservationId smallint(5),/* future use*/
						IN hotelId tinyint,
						IN reservationType varchar(01),
						IN arrival varchar(10),
						IN departure varchar(10),
						IN nights tinyint,
						IN adults tinyint,
						IN children tinyint,
						IN roomType varchar(02),
						IN quantityRooms tinyint,
						IN roomNumber varchar(04),
						
						IN vipCode tinyint,
						IN idSource smallint,
						IN roomRate decimal(10,2),
						IN totalRoom decimal(10,2),
						IN paymentDue varchar(10),
						IN paymentType tinyint,
						IN voucher integer,
						IN hotelInstructions varchar(120),
						IN guestInstructions varchar(120),
						IN madeBy varchar(03),
						IN updateBy varchar(03),
						IN reservationStatus varchar(01))
BEGIN
		DECLARE v_id_reservation smallint;

		SELECT MAX(RESVP_ID_RESERVATION) + 1 INTO v_id_reservation
		  FROM RESERVATION;

        INSERT INTO reservation(
			RESVP_ID_HOTEL, RESVC_RESERVATION_TYPE, RESVP_ID_RESERVATION,
			RESVC_ARRIVAL, RESVC_DEPARTURE, RESVC_NIGHTS,
			RESVC_ADULTS, RESVC_CHILDREN, RESVF_ID_ROOMTYPE, RESVC_QUANTITY,
			RESVF_ID_ROOM, RESVF_ID_SOURCE, RESVC_ROOM_RATE,
			RESVC_TOTAL_ROOM, RESVC_PAYMENT_DUE, RESVF_PAYMENT_TYPE, RESVC_STATUS,
			RESVC_HOTEL_INSTRUCTIONS, RESVC_GUEST_INSTRUCTIONS,
			RESVC_MADE_BY, RESVC_MADE_ON, RESVC_UPDATED_BY, RESVC_LAST_UPDATE )
		VALUES( hotelId, reservationType, v_id_reservation,
			STR_TO_DATE(arrival, '%d-%m-%Y'),
			STR_TO_DATE(departure, '%d-%m-%Y'), nights,
			adults, children, roomType, quantityRooms,
			roomNumber, idsource, roomRate,
			totalRoom, STR_TO_DATE(paymentDue, '%d-%m-%Y'),
			paymentType, reservationStatus,
			hotelInstructions, guestInstructions,
			madeBy, CURRENT_TIMESTAMP(), updateBy, CURRENT_TIMESTAMP() );

		set reservationId = v_id_reservation;
END$$

DELIMITER ;