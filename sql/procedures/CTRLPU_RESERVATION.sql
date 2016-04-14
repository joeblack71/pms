DELIMITER $$

DROP PROCEDURE IF EXISTS `hotel`.`CTRLPU_RESERVATION`$$

CREATE DEFINER=`root`@`localhost`

-- Params: 21
PROCEDURE `CTRLPU_RESERVATION`( IN p_id_hotel 			varchar(02),
								IN p_id_reservation 	varchar(05),
								IN p_arrival 			varchar(10),
								IN p_departure 			varchar(10),
								IN p_nights 			varchar(03),
								IN p_adults 			varchar(03),
								IN p_children 			varchar(03),
								IN p_id_roomtype 		varchar(02),
								IN p_quantity_rooms 	varchar(03),
								IN p_id_room 			varchar(04),
								IN p_id_source 			varchar(06),
								IN p_room_rate 			varchar(12),
								IN p_total_room 		varchar(12),
								IN p_payment_due 		varchar(10),
								IN p_payment_type 		varchar(02),
								IN p_voucher 			varchar(06),
								IN p_vip_code 			varchar(01),
								IN p_hotel_instructions varchar(120),
								IN p_guest_instructions varchar(120),
								IN p_status 			varchar(01),
								IN p_updated_by 		varchar(03) )
BEGIN

		DECLARE foo int default 0;
		DECLARE v_current_date date DEFAULT CURRENT_TIMESTAMP();
		/* El handler controla el flujo luego de un bug de mysql */
		DECLARE GUEST_INSTRUCTIONS_BUG CONDITION FOR SQLSTATE '21S01'; -- ER_WRONG_VALUE_COUNT 21S01
		DECLARE CONTINUE HANDLER FOR GUEST_INSTRUCTIONS_BUG SET foo = 1; 
		/* End conditions manage */

        UPDATE CTRLT_RESERVATION
		   SET	RESVC_ARRIVAL      		 = STR_TO_DATE(p_arrival,'%d/%m/%Y'),
				RESVC_DEPARTURE    		 = STR_TO_DATE(p_departure,'%d/%m/%Y'),
				RESVC_NIGHTS       		 = p_nights,
				RESVC_ADULTS       		 = p_adults,
				RESVC_CHILDREN     		 = p_children,
				RTYPF_ID_ROOMTYPE  		 = p_id_roomtype,
				RESVC_QUANTITY     		 = p_quantity_rooms,
				ROOMF_ID_ROOM      		 = p_id_room,
				SRCEF_ID_SOURCE    		 = p_id_source,
				RESVC_ROOM_RATE    		 = p_room_rate,
				RESVC_TOTAL_ROOM   		 = p_total_room,
				RESVC_PAYMENT_DUE  		 = STR_TO_DATE(p_payment_due,'%d/%m/%Y'),
				RESVF_PAYMENT_TYPE 		 = p_payment_type,
				RESVC_VOUCHER			 = p_voucher,
				RESVC_VIP_CODE			 = p_vip_code,
				RESVC_HOTEL_INSTRUCTIONS = p_hotel_instructions,
				RESVC_GUEST_INSTRUCTIONS = p_guest_instructions, -- Genera bug mysql
				RESVC_STATUS			 = p_status,
				RESVC_UPDATED_BY   		 = p_updated_by,
				RESVC_LAST_UPDATE  		 = v_current_date
		 WHERE MAINP_ID_HOTEL = p_id_hotel
		   AND RESVP_ID_RESERVATION = p_id_reservation;

END$$

DELIMITER ;