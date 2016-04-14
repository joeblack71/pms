DELIMITER $$

DROP PROCEDURE IF EXISTS `hotel`.`CTRLPU_SEGMENT`$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `CTRLPU_SEGMENT`(
					    IN p_id_hotel		int,
					    IN p_id_segment		varchar(02),
						IN p_id_source		varchar(06),
						IN p_description	varchar(50),
						IN p_updated_by		varchar(03),
						IN p_status			varchar(01) )
BEGIN
	DECLARE v_current_date date DEFAULT CURRENT_DATE();
	UPDATE CTRLT_SEGMENT
			SET SRCEF_ID_SOURCE	  = p_id_source,
				SEGMC_DESCRIPTION = p_description,
				SEGMC_UPDATED_BY  = p_updated_by,
				SEGMC_LAST_UPDATE = v_current_date,
				SEGMC_STATUS 	  = p_status
	 WHERE MAINP_ID_HOTEL = p_id_hotel AND SEGMP_ID_SEGMENT = p_id_segment;
END$$

DELIMITER ;