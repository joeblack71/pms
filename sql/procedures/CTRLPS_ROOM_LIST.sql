DELIMITER $$

DROP PROCEDURE IF EXISTS `hotel`.`CTRLPS_ROOM_LIST`$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `CTRLPS_ROOM_LIST`(
		IN p_id_hotel		varchar(02),
		IN p_id_room_type	varchar(03),
		IN p_status			varchar(02) )
BEGIN
	SELECT	MAINP_ID_HOTEL			MAINP_ID_HOTEL,
			ROOMP_ID_ROOM			ROOMP_ID_ROOM,
			RTYPF_ID_ROOM_TYPE		RTYPF_ID_ROOM_TYPE,
			ROOMC_ROOM_NUMBER		ROOM_NUMBER,
			ROOMC_LOCATION			LOCATION,
			ROOMC_DESCRIPTION		DESCRIPTION,
			ROOMC_ROOM_RATE			ROOM_RATE,
			ROOMC_MAX_BEDS			MAX_BEDS,
			ROOMC_CONNECTION		ROOM_CONNECTION,
			RESVC_ID_RESERVATION 	RESVC_ID_RESERVATION,
			ROOMC_HK_STATUS			HK_STATUS,
			ROOMC_STATUS			STATUS,
			ROOMC_MADE_BY			MADE_BY,
			ROOMC_MADE_ON			MADE_ON,
			ROOMC_UPDATED_BY		UPDATED_BY,
			ROOMC_LAST_UPDATE		LAST_UPDATE
	  FROM CTRLT_ROOM
	 WHERE p_id_hotel = MAINP_ID_HOTEL
	   AND ( p_id_room_type = ''
			 OR p_id_room_type = RTYPF_ID_ROOM_TYPE )
	   AND ( p_status = ''
			 OR p_status = ROOMC_STATUS );
END$$

DELIMITER ;