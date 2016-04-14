DELIMITER $$

DROP PROCEDURE IF EXISTS `hotel`.`CTRLPI_ROOM`$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `CTRLPI_ROOM`(
					   OUT p_id_room			int,
					    IN p_id_hotel			varchar(02),
						IN p_room_type			varchar(02),
						IN p_room_number		varchar(04),
						IN p_room_location		varchar(50),
						IN p_description		varchar(50),
						IN p_room_rate			varchar(10),
						IN p_max_beds			varchar(02),
						IN p_connection			varchar(04),
						IN p_id_reservation		varchar(06),
						IN p_hk_status			varchar(01),
						IN p_status				varchar(01),
						IN p_made_by			varchar(03) )
BEGIN
	DECLARE v_current_date date DEFAULT CURRENT_DATE();
	INSERT INTO CTRLT_ROOM(
			MAINP_ID_HOTEL,
			RTYPF_ID_ROOM_TYPE,
			ROOMC_ROOM_NUMBER,
			ROOMC_LOCATION,
			ROOMC_DESCRIPTION,
			ROOMC_ROOM_RATE,
			ROOMC_MAX_BEDS,
			ROOMC_CONNECTION,
			RESVC_ID_RESERVATION,
			ROOMC_HK_STATUS,
			ROOMC_STATUS,
			ROOMC_MADE_BY,
			ROOMC_MADE_ON,
			ROOMC_UPDATED_BY,
			ROOMC_LAST_UPDATE )
	VALUES( p_id_hotel,
			p_room_type,
			p_room_number,
			p_room_location,
			p_description,
			p_room_rate,
			p_max_beds,
			p_connection,
			p_id_reservation,
			p_hk_status,
			p_status,
			p_made_by,
			v_current_date,
			p_made_by,
			v_current_date);
	set p_id_room = LAST_INSERT_ID();
END$$

DELIMITER ;