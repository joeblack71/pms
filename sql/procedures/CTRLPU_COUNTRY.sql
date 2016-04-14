DELIMITER $$

DROP PROCEDURE IF EXISTS `hotel`.`CTRLPU_COUNTRY`$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `CTRLPU_COUNTRY`(
					    IN p_id_country		int,
						IN p_country_name	varchar(20),
						IN p_abbreviation	varchar(06),
						IN p_nationality	varchar(20) )
BEGIN
	UPDATE CTRLT_COUNTRY
			SET CTRYC_COUNTRY_NAME = p_country_name,
				CTRYC_ABBREVIATION = p_abbreviation,
				CTRYC_NATIONALITY  = p_nationality
	 WHERE CTRYP_ID_COUNTRY = p_id_country;
END$$

DELIMITER ;