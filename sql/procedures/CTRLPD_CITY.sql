DELIMITER $$

DROP PROCEDURE IF EXISTS `hotel`.`CTRLPD_CITY`$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `CTRLPD_CITY`(
								 IN p_id_country int,
								 IN p_id_city int )
BEGIN
	DELETE FROM CTRLT_CITY
	 WHERE CTRYP_ID_COUNTRY = p_id_country
       AND CITYP_ID_CITY = p_id_city;
END$$

DELIMITER ;