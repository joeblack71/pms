DELIMITER $$

DROP PROCEDURE IF EXISTS `hotel`.`CTRLPD_ROOMTYPE`$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `CTRLPD_ROOMTYPE`(
								 IN p_id_hotel		varchar(02),
								 IN p_id_roomtype	varchar(02) )
BEGIN
	UPDATE HOTEL.CTRLT_ROOMTYPE
	   SET RTYPC_STATUS = "*"
	 WHERE MAINP_ID_HOTEL	 = p_id_hotel
	   AND RTYPP_ID_ROOMTYPE = p_id_roomtype;
END$$

DELIMITER ;