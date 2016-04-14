DELIMITER $$

DROP PROCEDURE IF EXISTS `hotel`.`CTRLPI_SEGMENT`$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `CTRLPI_SEGMENT`(
					   OUT p_id_segment		int,
					    IN p_id_hotel		varchar(02),
						IN p_id_source		varchar(06),
						IN p_description	varchar(50),
						IN p_made_by		varchar(03),
						IN p_status			varchar(01) )
BEGIN
	DECLARE v_current_date date DEFAULT current_date();

	INSERT INTO CTRLT_SEGMENT(
			MAINP_ID_HOTEL,
			SRCEF_ID_SOURCE,
			SEGMC_DESCRIPTION,
			SEGMC_MADE_BY,
			SEGMC_MADE_ON,
			SEGMC_UPDATED_BY,
			SEGMC_LAST_UPDATE,
			SEGMC_STATUS )
	VALUES( p_id_hotel,
			p_id_source,
			p_description,
			p_made_by,
			v_current_date,
			p_made_by,
			v_current_date,
			p_status );
	SET p_id_segment = LAST_INSERT_ID();
END$$

DELIMITER ;