DELIMITER $$

DROP PROCEDURE IF EXISTS `hotel`.`CTRLPI_SOURCE_TYPE`$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `CTRLPI_SOURCE_TYPE`(
					   OUT p_id_source_type	int,
					    IN p_description	varchar(20),
						IN p_abbreviation	varchar(06),
						IN p_made_by		varchar(20) )
BEGIN
	DECLARE v_current_date date DEFAULT current_date();
	DECLARE v_status varchar(01) DEFAULT 'A';

	INSERT INTO CTRLT_SOURCE_TYPE(
			SRCTC_DESCRIPTION,
			SRCTC_ABBREVIATION,
			SRCTC_STATUS,
			SRCTC_MADE_BY,
			SRCTC_MADE_ON,
			SRCTC_UPDATED_BY,
			SRCTC_LAST_UPDATE )
	VALUES( p_description,
			p_abbreviation,
			v_status,
			p_made_by,
			v_current_date,
			p_made_by,
			v_current_date );

	SET p_id_source_type = LAST_INSERT_ID();
END$$

DELIMITER ;