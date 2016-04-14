DELIMITER $$

DROP PROCEDURE IF EXISTS `hotel`.`CTRLPS_RATE_LIST`$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `CTRLPS_RATE_LIST`(
					IN p_id_hotel varchar(02) )
BEGIN
	SELECT	MAINP_ID_HOTEL			ID_HOTEL,
			RATEP_ID_SPECIAL_RATE	ID_SPECIAL_RATE,
			RTYPF_ID_ROOM_TYPE		ID_ROOM_TYPE,
			PERIF_ID_PERIOD			ID_PERIOD,
			RATEC_VALUE				VALUE,
			RATEC_MADE_BY			MADE_BY,
			RATEC_MADE_ON			MADE_ON,
			RATEC_UPDATED_BY 		UPDATED_BY,
			RATEC_LAST_UPDATE 		LAST_UPDATE,
			RATEC_STATUS 			STATUS
	  FROM CTRLT_RATE
	 WHERE p_id_hotel = MAINP_ID_HOTEL
	   AND RATEC_STATUS = 'A';
END$$

DELIMITER ;