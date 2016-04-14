DELIMITER $$

DROP PROCEDURE IF EXISTS `hotel`.`CTRLPU_SOURCE_TYPE`$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `CTRLPU_SOURCE_TYPE`(
					    IN p_id_source_type	varchar(02),
					    IN p_description	varchar(20),
						IN p_abbreviation	varchar(06),
						IN p_status			varchar(01),
						IN p_updated_by		varchar(03) )
BEGIN
	DECLARE v_current_date date DEFAULT current_date();

	UPDATE CTRLT_SOURCE_TYPE
	   SET	SRCTC_DESCRIPTION  = p_description,
			SRCTC_ABBREVIATION = p_abbreviation,
			SRCTC_STATUS	   = p_status,
			SRCTC_UPDATED_BY   = p_updated_by,
			SRCTC_LAST_UPDATE  = v_current_date
     WHERE p_id_source_type = SRCTP_ID_SOURCE_TYPE;

END$$

DELIMITER ;