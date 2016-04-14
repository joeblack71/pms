DELIMITER $$

DROP PROCEDURE IF EXISTS `hotel`.`CTRLPI_RATE`$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `CTRLPI_RATE`(
					   OUT p_id_rate			int,
					    IN p_id_hotel			varchar(02),
						IN p_id_room_type		int,
						IN p_id_period			int,
						IN p_value				varchar(10),
						IN p_made_by			varchar(03),
						IN p_status				varchar(01) )
BEGIN
	DECLARE v_current_day date DEFAULT CURRENT_TIMESTAMP();
	INSERT INTO CTRLT_RATE(
			MAINP_ID_HOTEL,
			-- RATEP_ID_SPECIAL_RATE,
			RTYPF_ID_ROOM_TYPE,
			PERIF_ID_PERIOD,
			RATEC_VALUE,
			RATEC_MADE_BY,
			RATEC_MADE_ON,
			RATEC_UPDATED_BY,
			RATEC_LAST_UPDATE,
			RATEC_STATUS )
	VALUES( p_id_hotel,
			-- p_id_special_rate,
			p_id_room_type,
			p_id_period,
			p_value,
			p_made_by,
			v_current_day,
			p_made_by,
			v_current_day,
			p_status );
	SET p_id_rate = LAST_INSERT_ID();
END$$

DELIMITER ;