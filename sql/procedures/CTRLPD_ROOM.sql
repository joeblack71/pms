DELIMITER $$

DROP PROCEDURE IF EXISTS `hotel`.`CTRLPD_ROOM`$$

CREATE DEFINER=`root`@`localhost`

PROCEDURE `CTRLPD_ROOM`( IN p_id_hotel  varchar(02),
						 IN p_id_room 	varchar(04) )
BEGIN
	UPDATE CTRLT_ROOM
	   SET ROOMC_STATUS = "*"
	 WHERE MAINP_ID_HOTEL  = p_id_hotel
	   AND ROOMP_ID_ROOM = p_id_room;
END$$

DELIMITER ;