DELIMITER $$

DROP PROCEDURE IF EXISTS `hotel`.`CTRLPD_SEGMENT`$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `CTRLPD_SEGMENT`(
								 IN p_id_hotel		varchar(02),
								 IN p_id_segment	varchar(02) )
BEGIN
	UPDATE CTRLT_SEGMENT
	   SET SEGMC_STATUS = "*"
	 WHERE MAINP_ID_HOTEL  = p_id_hotel
	   AND SEGMP_ID_SEGMENT = p_id_segment;
END$$

DELIMITER ;