DELIMITER $$

DROP PROCEDURE IF EXISTS `hotel`.`CTRLPU_CITY`$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `CTRLPU_CITY`(
					    IN p_id_country		int,
						IN p_id_city		int,
						IN p_city_name		varchar(30),
						IN p_abbreviation	varchar(10) )
BEGIN
	UPDATE CTRLT_CITY
			SET CITYC_CITY_NAME = p_city_name,
				CITYC_ABBREVIATION = p_abbreviation
	 WHERE CTRYP_ID_COUNTRY = p_id_country
       AND CITYP_ID_CITY = p_id_city;
END$$

DELIMITER ;