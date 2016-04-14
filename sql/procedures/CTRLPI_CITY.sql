DELIMITER $$

DROP PROCEDURE IF EXISTS `hotel`.`CTRLPI_CITY`$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `CTRLPI_CITY`(
					   OUT p_id_city		int,
					    IN p_id_country		varchar(20),
						IN p_city_name		varchar(06),
						IN p_abbreviation	varchar(20) )
BEGIN
	INSERT INTO CTRLT_CITY(
			CTRYP_ID_COUNTRY,
			CITYC_CITY_NAME,
			CITYC_ABBREVIATION )
	VALUES( p_id_country,
			p_city_name,
			p_abbreviation );
	SET p_id_city = LAST_INSERT_ID();
END$$

DELIMITER ;