DELIMITER $$

DROP PROCEDURE IF EXISTS `hotel`.`CTRLPI_ROOMTYPE_STATUS`$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `CTRLPI_ROOMTYPE_STATUS`(
					   OUT p_result				varchar(06),
					    IN p_id_hotel			varchar(02),
						IN p_id_roomtype		varchar(02),
						IN p_status_date		varchar(20),
						IN p_total_rooms		int,
						IN p_available_rooms	int,
						IN p_tentative_rooms	int,
						IN p_confirmed_rooms	int,
						IN p_locked_rooms		int,
						IN p_maintenance_rooms	int,
						IN p_reservation_type	varchar(03) )
BEGIN
	DECLARE v_current_datetime datetime DEFAULT current_timestamp();
	DECLARE v_new_occupation_day	int	DEFAULT 0;
	DECLARE v_total_rooms			int	DEFAULT 0;
	DECLARE v_available_rooms		int	DEFAULT 0;
	DECLARE v_status_date		   date	DEFAULT STR_TO_DATE(p_status_date, '%d/%m/%Y');

	-- VERIFICA SI LA FECHA DE LA OCUPACION TIENE UN REGISTRO
	-- DE STATUS PARA EL TIPO DE HABITACION DE LA OCUPACION
	SELECT COUNT(*) INTO v_new_occupation_day
	  FROM HOTEL.CTRLT_ROOMTYPE_STATUS RTS
	 WHERE RTS.MAINP_ID_HOTEL    = p_id_hotel
	   AND RTS.RTSTP_ID_ROOMTYPE = p_id_roomtype
	   AND RTS.RTSTP_STATUS_DAY  = v_status_date;

	/*SET v_new_occupation_day = ( SELECT COUNT(*)
								  FROM HOTEL.CTRLT_ROOMTYPE_STATUS RTS
								 WHERE RTS.MAINP_ID_HOTEL = p_id_hotel
								   AND RTS.RTSTP_ID_ROOMTYPE = p_id_roomtype
								   AND RTS.RTSTP_STATUS_DAY = p_status_date );*/

	SELECT RTP.RTYPC_AVAILABLE_ROOMS INTO v_total_rooms
	  FROM HOTEL.CTRLT_ROOMTYPE RTP
	 WHERE RTP.MAINP_ID_HOTEL    = p_id_hotel
	   AND RTP.RTYPP_ID_ROOMTYPE = p_id_roomtype;

	SET v_available_rooms = v_total_rooms + p_available_rooms;

	IF ( SELECT v_new_occupation_day FROM DUAL ) = 0 THEN
	-- IF v_new_occupation_day = 0 THEN
		INSERT INTO CTRLT_ROOMTYPE_STATUS(
					MAINP_ID_HOTEL,
					RTSTP_ID_ROOMTYPE,
					RTSTP_STATUS_DAY,
					RTSTC_TOTAL_ROOMS,
					RTSTC_AVAILABLE_ROOMS, -- from room_type
					RTSTC_TENTATIVE_ROOMS,
					RTSTC_COMFIRMED_ROOMS,
					RTSTC_LOCKED_ROOMS,
					RTSTC_MAINTENANCE_ROOMS,
					RTSTC_RESERVATION_TYPE,
					RTSTC_LAST_UPDATE
					) VALUES (
					p_id_hotel,
					p_id_roomtype,
					v_status_date,
					v_total_rooms,
					v_available_rooms,
					p_tentative_rooms,
					p_confirmed_rooms,
					p_locked_rooms,
					p_maintenance_rooms,
					p_reservation_type,
					v_current_datetime );
	ELSE
		UPDATE CTRLT_ROOMTYPE_STATUS
		   SET  RTSTC_TOTAL_ROOMS		= v_total_rooms,
				RTSTC_AVAILABLE_ROOMS	= v_available_rooms,
				RTSTC_TENTATIVE_ROOMS	= RTSTC_TENTATIVE_ROOMS 	+ p_tentative_rooms,
				RTSTC_COMFIRMED_ROOMS	= RTSTC_COMFIRMED_ROOMS 	+ p_confirmed_rooms,
				RTSTC_LOCKED_ROOMS		= RTSTC_LOCKED_ROOMS		+ p_locked_rooms,
				RTSTC_MAINTENANCE_ROOMS = RTSTC_MAINTENANCE_ROOMS	+ p_maintenance_rooms,
				RTSTC_RESERVATION_TYPE	= p_reservation_type,
				RTSTC_LAST_UPDATE		= v_current_datetime
		 WHERE MAINP_ID_HOTEL	 = p_id_hotel
           AND RTSTP_ID_ROOMTYPE = p_id_roomtype
		   AND RTSTP_STATUS_DAY  = v_status_date;

	END IF;

	SET p_result = 0; -- 'OK'
END$$

DELIMITER ;