DELIMITER $$

DROP PROCEDURE IF EXISTS `hotel`.`CTRLPD_RATE`$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `CTRLPD_RATE`(
								 IN p_id_hotel varchar(02),
								 IN p_id_rate  varchar(04) )
BEGIN
	DELETE FROM CTRLT_RATE
	 WHERE MAINP_ID_HOTEL  = p_id_hotel
	   AND RATEP_ID_SPECIAL_RATE = p_id_rate;
END$$

DELIMITER ;