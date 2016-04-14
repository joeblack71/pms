DELIMITER $$

DROP PROCEDURE IF EXISTS `hotel`.`CTRLPI_RESERVATION`$$

CREATE DEFINER=`root`@`localhost`

PROCEDURE `CTRLPI_RESERVATION`(OUT p_id_reservation 	int,
								IN p_id_hotel 			varchar(02),
								IN p_reservation_type 	varchar(01),
								IN p_arrival 			varchar(10),
								IN p_departure 			varchar(10),
								IN p_nights 			varchar(03),
								IN p_adults 			varchar(03),
								IN p_children 			varchar(03),
								IN p_id_roomtype 		varchar(02),
								IN p_quantity_rooms 	varchar(03),
								IN p_room_number 		varchar(04),
								IN p_vip_code 			varchar(01),
								IN p_id_source 			varchar(06),
								IN p_room_rate 			varchar(12),
								IN p_total_room 		varchar(12),
								IN p_payment_due 		varchar(10),
								IN p_payment_type 		varchar(03),
								IN p_voucher 			varchar(06),
								IN p_hotel_instructions varchar(120),
								IN p_guest_instructions varchar(120),
								IN p_made_by 			varchar(03),
								IN p_update_by 			varchar(03),
								IN p_reservation_status varchar(01) )
BEGIN
		DECLARE v_current_date datetime DEFAULT CURRENT_TIMESTAMP();

        INSERT INTO CTRLT_RESERVATION(
			MAINP_ID_HOTEL,
			RESVP_ID_RESERVATION, -- Autoincremented
			RESVC_RESERVATION_TYPE,
			RESVC_ARRIVAL,
			RESVC_DEPARTURE,
			RESVC_NIGHTS,
			RESVC_ADULTS,
			RESVC_CHILDREN,
			RTYPF_ID_ROOMTYPE,
			RESVC_QUANTITY,
			ROOMF_ID_ROOM,
			SRCEF_ID_SOURCE,
			RESVC_ROOM_RATE,
			RESVC_TOTAL_ROOM,
			RESVC_PAYMENT_DUE,
			RESVF_PAYMENT_TYPE,
			RESVC_STATUS,
			RESVC_HOTEL_INSTRUCTIONS,
			RESVC_GUEST_INSTRUCTIONS,
			RESVC_MADE_BY,
			RESVC_MADE_ON,
			RESVC_UPDATED_BY,
			RESVC_LAST_UPDATE )
		VALUES(
			p_id_hotel,
			null, -- Autoincremented
			p_reservation_type,
			STR_TO_DATE(p_arrival, '%d/%m/%Y'),
			STR_TO_DATE(p_departure, '%d/%m/%Y'),
			p_nights,
			p_adults,
			p_children,
			p_id_roomtype,
			p_quantity_rooms,
			p_room_number,
			p_id_source,
			p_room_rate,
			p_total_room,
			STR_TO_DATE(p_payment_due, '%d/%m/%Y'),
			p_payment_type,
			p_reservation_status,
			p_hotel_instructions,
			p_guest_instructions,
			p_made_by,
			v_current_date,
			p_made_by,
			v_current_date );

		SET p_id_reservation = LAST_INSERT_ID();
END$$

DELIMITER ;