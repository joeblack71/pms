DELIMITER $$

DROP PROCEDURE IF EXISTS `hotel`.`CTRLPI_COUNTRY`$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `CTRLPI_COUNTRY`(
					   OUT p_id_country		int,
					    IN p_country_name	varchar(20),
						IN p_abbreviation	varchar(06),
						IN p_nationality	varchar(20) )
BEGIN
	DECLARE v_current_date date DEFAULT CURRENT_TIMESTAMP();
	INSERT INTO CTRLT_COUNTRY(
			CTRYC_COUNTRY_NAME,
			CTRYC_ABBREVIATION,
			CTRYC_NATIONALITY )
	VALUES( p_country_name,
			p_abbreviation,
			p_nationality );
	SET p_id_country = LAST_INSERT_ID();
END$$

DELIMITER ;